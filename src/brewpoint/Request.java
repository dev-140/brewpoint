package brewpoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Request {
	public static ArrayList<String[]> orderList = new ArrayList<>();
	
	public static String prodName;
	public static int prod_ID;
	public static double unit_price;
	public static String unit_size;
	public static String powder;
	public static String addons;
	public static int quantity;
	public static int addonsTotprice = 9;
    public static boolean updateDb = false;
    public static boolean updateDb1 = false;
    public static boolean updateDb2 = false;
    public static boolean updateDb3 = false;
    public static boolean updateDb4 = false;
	
	public static void addItem() {		
		if(Main.step1 && Main.step2 && Main.step3) {
            if (addons != "no addons") {
                addonsTotprice *= quantity;
            } else {
                addonsTotprice = 0;
            }
            
            
             String[] order = new String[]{powder, addons, String.valueOf(quantity)};
             orderList.add(order);
            
            if (Main.step1 && Main.step2 && Main.step3) {
                Main.orderListModel.addElement(prodName + " " + unit_size + " " + addons + " " + " QTY: " + quantity + " - P" + ((unit_price*quantity)+addonsTotprice)+"");
            }
            
            double totalPrice = 0.0;
    
            for (int i = 0; i < Main.orderListModel.size(); i++) {
                String element = Main.orderListModel.getElementAt(i);
                String priceString = element.substring(element.lastIndexOf("P") + 1);
                double price = Double.parseDouble(priceString);
                totalPrice += price;
                
                Main.totalPrice = Double.parseDouble(totalPrice+"");
            }
            
            Main.total_pricelbl.setText(totalPrice+"");
            Main.slider.setValue(1);
            addonsTotprice = 9;
        } else {
            System.out.println("Unable to checkout");
        }
	}
	
	public static void updateDB() {
        for (String[] order : orderList) {
		    String powder = order[0];
		    String addons = order[1];
		    int quantity = Integer.parseInt(order[2]);

            isQuantityAvailable1(powder, quantity);
            isQuantityAvailable2(addons, quantity);
            isQuantityAvailable3("cup", quantity);
            isQuantityAvailable4("sugar", quantity);
            isQuantityAvailable5("straw", quantity);
		}

        if(updateDb && updateDb1 && updateDb2 && updateDb3 && updateDb4)
		for (String[] order : orderList) {
		    String powder = order[0];
		    String addons = order[1];
		    int quantity = Integer.parseInt(order[2]);

		    updateDatabaseInventory(powder, quantity);
		    updateDatabaseInventory1(addons, quantity);
		    updateDatabaseInventory2("cup", quantity);
		    updateDatabaseInventory3("sugar", quantity);
		    updateDatabaseInventory4("straw", quantity);
		}
	}
	
	private static void updateDatabaseInventory(String itemName, int quantity) {
        try (Connection con = DBUtil.getDBConnection()) {
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }
            
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Item not found in inventory. " + itemName);
                        updateDb = false;
                        return;
                    }
                    
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                        updateDb = true;
                    }
                } else {
                    System.out.println("Error: Item not found in inventory. " + itemName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating database inventory.");
            e.printStackTrace();
        }
    }
	
	private static void updateDatabaseInventory1(String itemName, int quantity) {
        try (Connection con = DBUtil.getDBConnection()) {
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }
            
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Ordered quantity exceeds available quantity.");
                        updateDb1 = false;
                        return;
                    }
                    
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                        updateDb1 = true;
                    }
                } else {
                    System.out.println("Error: Item not found in inventory. " + itemName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating database inventory.");
            e.printStackTrace();
        }
    }
	
	private static void updateDatabaseInventory2(String itemName, int quantity) {
        try (Connection con = DBUtil.getDBConnection()) {
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }
            
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Item not found in inventory. " + itemName);
                        updateDb2 = false;
                        return;
                    }
                    
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                        updateDb2 = true;
                    }
                } else {
                    System.out.println("Error: Item not found in inventory. " + itemName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating database inventory.");
            e.printStackTrace();
        }
    }
	
	private static void updateDatabaseInventory3(String itemName, int quantity) {
        try (Connection con = DBUtil.getDBConnection()) {
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }

            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Calculate new quantity after subtracting ordered quantity
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Item not found in inventory. " + itemName);
                        updateDb3 = false;
                        return;
                    }
                    
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                        updateDb3 = true;
                    }
                } else {
                    System.out.println("Error: Item not found in inventory." + itemName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating database inventory.");
            e.printStackTrace();
        }
    }
	
	private static void updateDatabaseInventory4(String itemName, int quantity) {
        try (Connection con = DBUtil.getDBConnection()) {
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }
            
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Item not found in inventory. " + itemName);
                        updateDb4 = false;
                        return;
                    }
                    
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                        updateDb4 = true;
                    }
                } else {
                    System.out.println("Error: Item not found in inventory. " + itemName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating database inventory.");
            e.printStackTrace();
        }
    }
	
	public static void insertSalesData(DefaultListModel<String> orderList, double totalPrice) {
	    try (Connection con = DBUtil.getDBConnection()) {
	        if (con == null) {
	            System.out.println("Database connection is not available.");
	            return;
	        }

	        StringBuilder itemNamesBuilder = new StringBuilder();
	        for (int i = 0; i < orderList.size(); i++) {
	            String order = orderList.getElementAt(i);
	            String itemName = order.split(" - ")[0];
	            itemNamesBuilder.append(itemName);
	            if (i < orderList.size() - 1) {
	                itemNamesBuilder.append(", ");
	            }
	        }
	        String itemNames = itemNamesBuilder.toString();

	        // SQL query to insert sales data
	        String insertQuery = "INSERT INTO SALES_TABLE (item, total_price, \"date\", total_sales) VALUES (?, ?, SYSDATE, ?)";

	        try (PreparedStatement stmt = con.prepareStatement(insertQuery)) {
	            stmt.setString(1, itemNames);
	            stmt.setDouble(2, totalPrice);
	            stmt.setDouble(3, 0.0);
	            stmt.executeUpdate();

	            System.out.println("Sales data inserted successfully.");
	            updateTotalSales(con);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error inserting sales data: " + e.getMessage());
	    }
	}

	private static void updateTotalSales(Connection con) {
	    try {
	        String updateQuery = "UPDATE SALES_TABLE SET total_sales = (SELECT SUM(total_price) FROM SALES_TABLE)";

	        try (PreparedStatement stmt = con.prepareStatement(updateQuery)) {
	            stmt.executeUpdate();

	            System.out.println("Total sales updated successfully.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error updating total sales: " + e.getMessage());
	    }
	}

    // check quantity
    private static boolean isQuantityAvailable(String itemName, int quantity) {
        try (Connection con = DBUtil.getDBConnection()) {
            if (con == null) {
                System.out.println("Database connection is not available.");
                return false;
            }
            
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Ordered quantity exceeds available quantity.");
                        JOptionPane.showMessageDialog(null, itemName + " quantity exceeds available quantity");
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    System.out.println("Error: Item not found in inventory. " + itemName);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching data from database.");
            e.printStackTrace();
            return false;
        }
    }
    
    private static boolean isQuantityAvailable1(String itemName, int quantity) {
        updateDb = isQuantityAvailable(itemName, quantity);
        return isQuantityAvailable(itemName, quantity);
    }
    
    private static boolean isQuantityAvailable2(String itemName, int quantity) {
        updateDb1 = isQuantityAvailable(itemName, quantity);
        return isQuantityAvailable(itemName, quantity);
    }
    
    private static boolean isQuantityAvailable3(String itemName, int quantity) {
        updateDb2 = isQuantityAvailable(itemName, quantity);
        return isQuantityAvailable(itemName, quantity);
    }
    
    private static boolean isQuantityAvailable4(String itemName, int quantity) {
        updateDb3 = isQuantityAvailable(itemName, quantity);
        return isQuantityAvailable(itemName, quantity);
    }
    
    private static boolean isQuantityAvailable5(String itemName, int quantity) {
        updateDb4 = isQuantityAvailable(itemName, quantity);
        return isQuantityAvailable(itemName, quantity);
    }
}

