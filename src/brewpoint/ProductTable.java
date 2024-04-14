package brewpoint;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductTable extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton backBtn;
    static ProductTable frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ProductTable();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProductTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 619);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Define column names
        String[] columnNames = {"Product ID", "Product Type", "Product Name", "Product Size", "Unit Price"};

        // Fetch product data from Oracle database
        Object[][] data = fetchProductData();

        // Create the table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 4; // Allow editing of Product Name and Unit Price columns
            }
        };

        // Create the table
        table = new JTable(model);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 1164, 499);
        contentPane.add(scrollPane);

        // Add button to update the database
        JButton updateButton = new JButton("Update Database");
        updateButton.setBackground(new Color(192, 192, 192));
        updateButton.setBounds(10, 521, 150, 30);
        updateButton.addActionListener(e -> {
            updateDatabase();
            refreshTable();
        });
        contentPane.add(updateButton);
        
        backBtn = new JButton("Back to main menu");
        backBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			Main.setText();
    			Main.main(null);
    			frame.dispose();
        	}
        });
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.setBounds(170, 521, 150, 30);
        contentPane.add(backBtn);
    }

    private Object[][] fetchProductData() {
        Object[][] data = null;

        try (Connection conn = DBUtil.getDBConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT")) {

            // Get ResultSet metadata
            int columns = rs.getMetaData().getColumnCount();

            // Get row count
            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            data = new Object[rows][columns];

            // Populate data array
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j < columns; j++) {
                    data[i][j] = rs.getObject(j + 1);
                }
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private void updateDatabase() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        try (Connection conn = DBUtil.getDBConnection();
             Statement stmt = conn.createStatement()) {

            for (int i = 0; i < rowCount; i++) {
                int productId = ((BigDecimal) model.getValueAt(i, 0)).intValue();
                String updatedProductName = (String) model.getValueAt(i, 2);
                BigDecimal updatedUnitPrice = new BigDecimal(model.getValueAt(i, 4).toString());

                String sql = String.format("UPDATE PRODUCT SET PRODUCT_NAME='%s', UNIT_PRICE=%.2f WHERE PRODUCT_ID=%d",
                        updatedProductName, updatedUnitPrice.doubleValue(), productId);

                stmt.executeUpdate(sql);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(fetchProductData(), new String[]{"Product ID", "Product Type", "Product Name", "Product Size", "Unit Price"});
    }
}
