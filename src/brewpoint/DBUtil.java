package brewpoint;

import java.sql.*;

public class DBUtil {
    private static Connection con;

    public static Connection getDBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ora1");
            return con;
        } catch (Exception e) {
            System.out.println("Connection could not be established");
            e.printStackTrace();
            return null;
        }
    }

    public static void printProductsTable() {
        try {
            Connection con = getDBConnection();
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }

            String sql = "SELECT * FROM inventory";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while printing products table.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printProductsTable();
    }
}
