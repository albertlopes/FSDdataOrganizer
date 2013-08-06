package Xbox360.FSD.DataHandler.DAO;

import Xbox360.FSD.DataHandler.Objects.ContentItems;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class ContentItemsDAO extends ContentItems {

    private Statement statement;
    private ResultSet resultSet;
    private ConnectionFactory connecttion;

    public ContentItemsDAO(String url) {
        connecttion = new ConnectionFactory(url);
    }

    public ArrayList get() {

        statement = connecttion.getStatement();

        String query = "select ContentItemId,ContentItemName from contentItems order by ContentItemTab,ContentItemName;";
        ArrayList<ContentItems> items = new ArrayList();

        try {

            resultSet = statement.executeQuery(query);
            int counter = 1;
            while (resultSet.next()) {

                ContentItems item = new ContentItems();

                item.setContentItemIdOrdered(counter);
                item.setContentItemId(resultSet.getInt("ContentItemId"));
                item.setContentItemName(resultSet.getString("ContentItemName"));
                items.add(item);
                counter++;
            }

        } catch (SQLException ex) {
            System.out.println("QUERY ERROR: ");
            System.out.println(ex);
        }
        connecttion.closeConnection();
        return items;
    }

    public void update(ArrayList<ContentItems> items) {

        int size = items.size() + 10000;

        statement = connecttion.getStatement();

        for (ContentItems item : items) {

            try {
                statement.executeUpdate(
                        "UPDATE ContentItems set ContentItemId = "
                        + (item.getContentItemIdOrdered() + size)
                        + " WHERE ContentItemId = "
                        + item.getContentItemId());
            } catch (SQLException ex) {

                System.out.println("UPDATE ERROR ON: " + item.getContentItemId());
                System.out.println(ex);
            }

        }

        for (ContentItems item : items) {

            try {
                statement.executeUpdate(
                        "UPDATE ContentItems set ContentItemId = "
                        + item.getContentItemIdOrdered()
                        + ", ContentItemName = '" + item.getContentItemName()
                        + "' WHERE ContentItemId = "
                        + (item.getContentItemIdOrdered() + size));
            } catch (SQLException ex) {

                System.out.println("QUERY ERROR ON: ");
                System.out.println(ex);
            }
        }

        connecttion.closeConnection();
    }

    public void list() {
        ArrayList<ContentItems> items = get();
        for (ContentItems item : items) {
            System.out.println("ID: " + item.getContentItemId() + " . Name: " + item.getContentItemName());

        }
    }

    public void capitalize() {

        ArrayList<ContentItems> items = get();
        statement = connecttion.getStatement();

        for (ContentItems item : items) {
            try {
                statement.executeUpdate(
                        "UPDATE ContentItems set ContentItemName = '"
                        + org.apache.commons.lang3.text.WordUtils.capitalizeFully(item.getContentItemName())
                        + "' WHERE ContentItemId = "
                        + (item.getContentItemId()));
            } catch (SQLException ex) {
                System.out.println("QUERY ERROR ON: ");
                System.out.println(ex);
            }
        }
        connecttion.closeConnection();
    }
}
