package Xbox360.FSD.DataHandler.DAO;

import Xbox360.FSD.DataHandler.Objects.Assets;
import Xbox360.FSD.DataHandler.Objects.ContentItems;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class AssetsDAO extends Assets {

    private Statement statement;
    private ResultSet resultSet;
    private ConnectionFactory connecttion;

    public AssetsDAO(String url) {
        connecttion = new ConnectionFactory(url);
    }

    public ArrayList get() {

        statement = connecttion.getStatement();

        String query = "select AssetId,AssetContentId from assets";
        ArrayList<Assets> assets = new ArrayList();

        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                Assets item = new Assets();
                item.setAssetId(resultSet.getInt("AssetId"));
                item.setAssetContentId(resultSet.getInt("AssetContentId"));
                assets.add(item);

            }

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
        return assets;
    }

    public void update(ArrayList<ContentItems> items, ArrayList<Assets> assets) {
        statement = connecttion.getStatement();

        for (ContentItems item : items) {
            for (Assets asset : assets) {
                if (item.getContentItemId() == asset.getAssetContentId()) {
                    item.setAssets(asset.getAssetId());
                }
            }
        }

        for (ContentItems item : items) {
            ArrayList<Integer> as = item.getAssets();
            if (!as.isEmpty()) {
                for (Integer integer : as) {
                    try {
                        statement.executeUpdate(
                                "UPDATE Assets set AssetContentId = "
                                + (item.getContentItemIdOrdered())
                                + " WHERE AssetId = "
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

        String clean = "delete from 'Assets';";
        try {
            statement.executeUpdate(clean);

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
    }
}
