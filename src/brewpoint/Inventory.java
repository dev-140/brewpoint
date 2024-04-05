package brewpoint;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class Inventory extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) { 
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inventory frame = new Inventory();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }); 
    }

    /**
     * Create the frame.
     */
    public Inventory() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1120, 574);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 71, 1084, 453);
        contentPane.add(scrollPane);

        // Create the table
        table = new JTable();
        scrollPane.setViewportView(table);
        
        lblNewLabel = new JLabel("8AM BREW POINT INVENTORY");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel.setBounds(10, 11, 374, 49);
        contentPane.add(lblNewLabel);

        // Populate the table with data from the database
        populateTable();
        
        // Add action listener to detect changes in the table
        table.getModel().addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == 1) { // Check if the changed column is the quantity column
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                String itemName = (String) model.getValueAt(row, 0);
                String quantityStr = (String) model.getValueAt(row, 1); // Retrieve quantity as string
                int quantity = Integer.parseInt(quantityStr); // Convert string to integer
                updateQuantity(itemName, quantity);
            }
        });
    }

    private void populateTable() {
        try {
            // Establish database connection
            Connection con = DBUtil.getDBConnection();
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }

            // Create SQL statement
            String sql = "SELECT * FROM inventory";

            // Execute SQL query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Get column names
            String[] columnNames = {"Item_name", "Quantity"};
            
            // Create DefaultTableModel to hold data
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            // Populate table model with data from ResultSet
            while (rs.next()) {
                String itemName = rs.getString("item_name");
                int quantity = rs.getInt("quantity");
                model.addRow(new Object[]{itemName, quantity});
            }

            // Set table model to JTable
            table.setModel(model);

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while populating table.");
            e.printStackTrace();
        }
    }
    
    private void updateQuantity(String itemName, int quantity) {
        try {
            // Establish database connection
            Connection con = DBUtil.getDBConnection();
            if (con == null) {
                System.out.println("Database connection is not available.");
                return;
            }

            // Create SQL statement for updating quantity
            String sql = "UPDATE inventory SET quantity = ? WHERE item_name = ?";

            // Prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, quantity);
            stmt.setString(2, itemName);

            // Execute the update
            stmt.executeUpdate();

            // Close resources
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while updating quantity.");
            e.printStackTrace();
        }
    }

}

