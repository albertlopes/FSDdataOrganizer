package Xbox360.FSD.DataHandler.DAO;

import Xbox360.FSD.DataHandler.Objects.ContentItems;
import Xbox360.FSD.DataHandler.Objects.Favorites;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class FavoritesDAO extends Favorites {

    private Statement statement;
    private ResultSet resultSet;
    private ConnectionFactory connecttion;

    public FavoritesDAO(String url) {
        connecttion = new ConnectionFactory(url);
    }

    public ArrayList get() {

        statement = connecttion.getStatement();

        String query = "select FavoriteId,FavoriteContentId from Favorites";
        ArrayList<Favorites> favorites = new ArrayList();

        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                Favorites item = new Favorites();
                item.setFavoritesId(resultSet.getInt("FavoriteId"));
                item.setContentItemId(resultSet.getInt("FavoriteContentId"));
                favorites.add(item);

            }

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
        return favorites;
    }

    public void update(ArrayList<ContentItems> items, ArrayList<Favorites> favorites) {
        statement = connecttion.getStatement();

        for (ContentItems item : items) {
            for (Favorites favorite : favorites) {
                if (item.getContentItemId() == favorite.getContentItemId()) {
                    item.setFavorites(favorite.getFavoritesId());
                }
            }
        }

        for (ContentItems item : items) {
            ArrayList<Integer> fav = item.getFavorites();
            if (!fav.isEmpty()) {
                for (Integer integer : fav) {
                    try {
                        statement.executeUpdate(
                                "UPDATE favorites set FavoriteContentId = "
                                + (item.getContentItemIdOrdered())
                                + " WHERE FavoriteId = "
                                + integer);
                    } catch (SQLException ex) {
                        System.out.println("QUERY ERROR: ");
                        System.out.println(ex);
                    }
                }
            }
        }

        connecttion.closeConnection();
    }

    public void clean() {

        statement = connecttion.getStatement();

        String clean = "delete from favorites;";
        try {
            statement.executeUpdate(clean);

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
    }
}
