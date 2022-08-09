package jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Howdy, I've created this to help you with your JDBC connections and statements
 */
public class ConnectionDemo {
    static String username = "zcuser";
    static String password = "zcpass";
    static String dbUrl = "jdbc:mysql://localhost:3306/zcdata";
    static Logger demoLog =  Logger.getLogger("demoJDBC");



    public static void main(String[] argv) {
        demoLog.log(Level.INFO, "somestuff");
        System.out.println("-------- MySQL JDBC ConnectionFactory Demo ------------");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("SQL ConnectionFactory to database established!");

            //Statement example, with get[Whatever]:
            /*
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from players");
            rs.first();
            System.out.println(rs.getString(2));
            System.out.println(rs.getString("last_name"));
            /**/

            // Read-only example:
            /*
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select * from players");
            //Printing the contents of the table
            System.out.println("Contents of the table: ");
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }
            System.out.println();
            //Moving the pointer to the starting point in the ResultSet
            rs.beforeFirst();
            //Adding 'Jr.' to the last name
            while(rs.next()) {
                //Retrieve by column name
                String newLast = rs.getString("last_name") + ", Jr.";
                rs.updateString( "last_name", newLast );
                rs.updateRow();
            }

            /**/

            //UPDATE example:
            /*
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from players");
            //Printing the contents of the table
            System.out.println("Contents of the table: ");
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }
            System.out.println();
            //Moving the pointer to the starting point in the ResultSet
            rs.beforeFirst();
            //Adding 'Jr.' to the last name
            while(rs.next()) {
                //Retrieve by column name
                String newLast = rs.getString("last_name") + ", Jr.";
                rs.updateString( "last_name", newLast );
                //rs.updateRow();
                //break;
            }
            System.out.println();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }
            /**/

            //Prepared Statement Example
            /*
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM players WHERE id > ?");
            pstmt.setInt(1, 4);
            ResultSet rs = pstmt.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }

            /**/


        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ConnectionFactory Failed! Check output console");
            return;
        }
        finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("ConnectionFactory closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
