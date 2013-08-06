package Xbox360.FSD.DataHandler.DAO;

import Xbox360.FSD.DataHandler.Objects.ContentItems;
import Xbox360.FSD.DataHandler.Objects.UserRatings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class UserRatingsDAO extends UserRatings {

    private Statement statement;
    private ResultSet resultSet;
    private ConnectionFactory connecttion;

    public UserRatingsDAO(String url) {
        connecttion = new ConnectionFactory(url);
    }

    public ArrayList get() {

        statement = connecttion.getStatement();

        String query = "select UserRatingId,UserRatingContentId from userratings";
        ArrayList<UserRatings> favorites = new ArrayList();

        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                UserRatings item = new UserRatings();
                item.setUserRatingId(resultSet.getInt("UserRatingId"));
                item.setContentItemId(resultSet.getInt("UserRatingContentId"));
                favorites.add(item);

            }

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
        return favorites;
    }

    public void update(ArrayList<ContentItems> items, ArrayList<UserRatings> userRatings) {
        statement = connecttion.getStatement();

        for (ContentItems item : items) {
            for (UserRatings rating : userRatings) {
                if (item.getContentItemId() == rating.getContentItemId()) {
                    item.setUserRatings(rating.getUserRatingId());
                }
            }
        }

        for (ContentItems item : items) {
            ArrayList<Integer> fav = item.getUserRatings();
            if (!fav.isEmpty()) {
                for (Integer integer : fav) {
                    try {
                        statement.executeUpdate(
                                "UPDATE userratings set UserRatingContentId = "
                                + (item.getContentItemIdOrdered())
                                + " WHERE UserRatingId = "
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

        String clean = "delete from userRatings;";
        try {
            statement.executeUpdate(clean);

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
    }
}
