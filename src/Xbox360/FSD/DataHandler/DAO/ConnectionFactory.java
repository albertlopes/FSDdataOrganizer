package Xbox360.FSD.DataHandler.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Albert_Dark
 */
public class ConnectionFactory {

    private Statement statement;
    private Connection connection;
    private String url;

    public ConnectionFactory(String url) {
        this.url = "jdbc:sqlite:" + url;
    }

    public Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("DRIVER ERROR: ");
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println("CONNECTION ERROR: ");
            System.out.println(ex);
        }
        return connection;
    }

    public Statement getStatement() {
        try {
            statement = getConnection().createStatement();
        } catch (SQLException ex) {
            System.out.println("STATEMENT ERROR: ");
            System.out.println(ex);
        }
        return statement;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("CONNECTION ERROR: ");
            System.out.println(ex);
        }
    }
}
