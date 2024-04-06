package brewpoint;

import java.sql.*;

public class DBUtil {
    private static Connection con;

    public static Connection getDBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");
            return con;
        } catch (Exception e) {
            System.out.println("Connection could not be established");
            e.printStackTrace();
            return null;
        }
    }

    public static void printProductsTable() {
        try {
            // Establish database connection
            Connection con = getDBConnection();
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }

            // Create SQL statement
            String sql = "SELECT * FROM inventory";

            // Execute SQL query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Print column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print table data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while printing products table.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Print products table
        printProductsTable();
    }
}
