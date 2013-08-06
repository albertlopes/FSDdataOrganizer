package Xbox360.FSD.DataHandler.DAO;

import Xbox360.FSD.DataHandler.Objects.ContentItems;
import Xbox360.FSD.DataHandler.Objects.RecentlyPlayed;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class RecentlyPlayedDAO extends RecentlyPlayed {

    private Statement statement;
    private ResultSet resultSet;
    private ConnectionFactory connecttion;

    public RecentlyPlayedDAO(String url) {
        connecttion = new ConnectionFactory(url);
    }

    public ArrayList get() {

        statement = connecttion.getStatement();

        String query = "select RecentlyPlayedTitleId,RecentlyPlayedTitleContentId from recentlyplayedtitles "
                + "where RecentlyPlayedTitleGamerProfile not like ''";
        ArrayList<RecentlyPlayed> assets = new ArrayList();

        try {

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                RecentlyPlayed item = new RecentlyPlayed();
                item.setRecentlyPlayedTitleContentId(resultSet.getInt("RecentlyPlayedTitleContentId"));
                item.setRecentlyPlayedTitleId(resultSet.getInt("RecentlyPlayedTitleId"));
                assets.add(item);

            }

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
        return assets;
    }

    public void update(ArrayList<ContentItems> items, ArrayList<RecentlyPlayed> recentPlayeds) {
        statement = connecttion.getStatement();

        try {
            statement.executeUpdate("delete from  recentlyplayedtitles where RecentlyPlayedTitleGamerProfile like ''");
        } catch (SQLException ex) {
            System.out.println("1 QUERY ERROR: ");
            System.out.println(ex);
        }

        for (ContentItems item : items) {
            for (RecentlyPlayed recent : recentPlayeds) {
                if (item.getContentItemId() == recent.getContentItemId()) {
                    item.setRecentPlayed(recent.getRecentlyPlayedTitleId());
                }
            }
        }

        for (ContentItems item : items) {
            ArrayList<Integer> re = item.getRecentPlayed();
            if (!re.isEmpty()) {
                for (Integer integer : re) {
                    try {
                        statement.executeUpdate(
                                "UPDATE recentlyplayedtitles set RecentlyPlayedTitleContentId = "
                                + (item.getContentItemIdOrdered() + 10000)
                                + " WHERE RecentlyPlayedTitleId = "
                                + integer);
                    } catch (SQLException ex) {
                        System.out.println("QUERY ERROR: " + integer);
                        System.out.println(ex);
                    }
                }
            }
        }

        try {
            statement.executeUpdate("delete from recentlyplayedtitles where RecentlyPlayedTitleContentId < 10000");
        } catch (SQLException ex) {
            System.out.println("1 QUERY ERROR: ");
            System.out.println(ex);
        }

        for (ContentItems item : items) {
            ArrayList<Integer> re = item.getRecentPlayed();
            if (!re.isEmpty()) {
                for (Integer integer : re) {
                    try {
                        statement.executeUpdate(
                                "UPDATE recentlyplayedtitles set RecentlyPlayedTitleContentId = "
                                + (item.getContentItemIdOrdered())
                                + " WHERE RecentlyPlayedTitleId = "
                                + integer);
                    } catch (SQLException ex) {
                        System.out.println("QUERY ERROR: " + integer);
                        System.out.println(ex);
                    }
                }
            }
        }

        connecttion.closeConnection();
    }

    public void clean() {

        statement = connecttion.getStatement();

        String clean = "delete from recentlyplayedtitles;";
        try {
            statement.executeUpdate(clean);

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
    }
}
