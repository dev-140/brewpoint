package com.wipro.sales.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import brewpoint.DBUtil;

public class Products {
    
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Get database connection using DBUtil
            conn = DBUtil.getDBConnection();

            // SQL select statement to fetch product by PRODUCT_ID
            String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";

            // Prepare the statement
            pstmt = conn.prepareStatement(sql);

            // Set the value for the parameter
            pstmt.setInt(1, 1);

            // Execute the query
            rs = pstmt.executeQuery();

            // Check if the product exists
            if (rs.next()) {
                int productId = rs.getInt("PRODUCT_ID");
                String productType = rs.getString("PRODUCT_TYPE");
                String productName = rs.getString("PRODUCT_NAME");
                String productSize = rs.getString("PRODUCT_SIZE");
                double unitPrice = rs.getDouble("UNIT_PRICE");

                // Display the fetched product details
                System.out.println("Product ID: " + productId);
                System.out.println("Product Type: " + productType);
                System.out.println("Product Name: " + productName);
                System.out.println("Product Size: " + productSize);
                System.out.println("Unit Price: " + unitPrice);
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet, PreparedStatement, and Connection
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getProductNameById(int productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String productName = null;

        try {
            conn = DBUtil.getDBConnection();

            String sql = "SELECT PRODUCT_NAME FROM PRODUCT WHERE PRODUCT_ID = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, productId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                productName = rs.getString("PRODUCT_NAME");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productName;
    }
    
    public static double getProductPrice(int productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        double productPrice = 0.0;

        try {
            conn = DBUtil.getDBConnection();

            String sql = "SELECT UNIT_PRICE FROM PRODUCT WHERE PRODUCT_ID = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, productId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                productPrice = rs.getDouble("UNIT_PRICE");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productPrice;
    }

}
