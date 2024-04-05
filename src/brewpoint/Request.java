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

public class Request {
	public static ArrayList<String[]> orderList = new ArrayList<>();
	
	public static String prodName;
	public static int prod_ID;
	public static int unit_price;
	public static String unit_size;
	public static String powder;
	public static String addons;
	public static int quantity;
	public static int addonsTotprice = 9;
	
	public static void addItem() {
		if (unit_size == "small") {
			unit_price = 29;
		} else if (unit_size == "medium") {
			unit_price = 39;
		} else if (unit_size == "large") {
			unit_price = 49;
		}
		
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
		Main.step1 = false;
		Main.step2 = false;
		Main.step3 = false;
		addonsTotprice = 9;
		
	}
	
	public static void updateDB() {
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
	
//	updateDatabaseInventory(prodname, quantity);
	private static void updateDatabaseInventory(String itemName, int quantity) {
        try (Connection con = DBUtil.getDBConnection()) {
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }
            
            // Retrieve current quantity from database
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Calculate new quantity after subtracting ordered quantity
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Ordered quantity exceeds available quantity.");
                        return;
                    }
                    
                    // Update database with new quantity
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                    }
                } else {
                    System.out.println("Error: Item not found in inventory.");
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
            
            // Retrieve current quantity from database
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Calculate new quantity after subtracting ordered quantity
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Ordered quantity exceeds available quantity.");
                        return;
                    }
                    
                    // Update database with new quantity
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                    }
                } else {
                    System.out.println("Error: Item not found in inventory.");
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
            
            // Retrieve current quantity from database
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Calculate new quantity after subtracting ordered quantity
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Ordered quantity exceeds available quantity.");
                        return;
                    }
                    
                    // Update database with new quantity
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                    }
                } else {
                    System.out.println("Error: Item not found in inventory.");
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
            
            // Retrieve current quantity from database
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Calculate new quantity after subtracting ordered quantity
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Ordered quantity exceeds available quantity.");
                        return;
                    }
                    
                    // Update database with new quantity
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                    }
                } else {
                    System.out.println("Error: Item not found in inventory.");
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
            
            // Retrieve current quantity from database
            String sql = "SELECT quantity FROM inventory WHERE item_name = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, itemName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Calculate new quantity after subtracting ordered quantity
                    int newQuantity = currentQuantity - quantity;
                    if (newQuantity < 0) {
                        System.out.println("Error: Ordered quantity exceeds available quantity.");
                        return;
                    }
                    
                    // Update database with new quantity
                    sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";
                    try (PreparedStatement updateStmt = con.prepareStatement(sql)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setString(2, itemName);
                        updateStmt.executeUpdate();
                        System.out.println("Inventory updated for item: " + itemName);
                    }
                } else {
                    System.out.println("Error: Item not found in inventory.");
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

	        // Concatenate all item names into a single string
	        StringBuilder itemNamesBuilder = new StringBuilder();
	        for (int i = 0; i < orderList.size(); i++) {
	            String order = orderList.getElementAt(i);
	            String itemName = order.split(" - ")[0];
	            itemNamesBuilder.append(itemName);
	            if (i < orderList.size() - 1) {
	                itemNamesBuilder.append(", "); // Add comma between item names
	            }
	        }
	        String itemNames = itemNamesBuilder.toString();

	        // SQL query to insert sales data
	        String insertQuery = "INSERT INTO SALES_TABLE (item, total_price, \"date\", total_sales) VALUES (?, ?, SYSDATE, ?)";

	        try (PreparedStatement stmt = con.prepareStatement(insertQuery)) {
	            // Set parameters for the prepared statement
	            stmt.setString(1, itemNames);
	            stmt.setDouble(2, totalPrice);
	            stmt.setDouble(3, 0.0); // Set total_sales to 0 as default

	            // Execute the query to insert sales data
	            stmt.executeUpdate();

	            System.out.println("Sales data inserted successfully.");
	            
	            // Recalculate and update the total sales 
	            updateTotalSales(con);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error inserting sales data: " + e.getMessage());
	    }
	}

	private static void updateTotalSales(Connection con) {
	    try {
	        // SQL query to recalculate total sales
	        String updateQuery = "UPDATE SALES_TABLE SET total_sales = (SELECT SUM(total_price) FROM SALES_TABLE)";

	        try (PreparedStatement stmt = con.prepareStatement(updateQuery)) {
	            // Execute the update query
	            stmt.executeUpdate();

	            System.out.println("Total sales updated successfully.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error updating total sales: " + e.getMessage());
	    }
	}




}

