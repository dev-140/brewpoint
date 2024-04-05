package brewpoint;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Sales extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sales frame = new Sales();
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
    public Sales() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 936, 517);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create the table model with column names
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Total Price");
        model.addColumn("Date");
        model.addColumn("Total Sales");

        // Populate data into the table model
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM SALES_TABLE");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String item = rs.getString("item");
                double totalPrice = rs.getDouble("total_price");
                String date = rs.getString("date");
                double totalSales = rs.getDouble("total_sales");
                model.addRow(new Object[]{item, totalPrice, date, totalSales});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create the table with the table model
        table = new JTable(model);
        table.setBounds(10, 11, 564, 339);

        // Hide Total Sales column by setting its column width to 0
        table.getColumnModel().getColumn(3).setMaxWidth(0);
        table.getColumnModel().getColumn(3).setMinWidth(0);
        table.getColumnModel().getColumn(3).setPreferredWidth(0);
        table.getColumnModel().getColumn(3).setWidth(0);

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 900, 402);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("TOTAL SALES:");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel.setBounds(303, 424, 155, 38);
        contentPane.add(lblNewLabel);

        JLabel total_salesLBL = new JLabel("0");
        total_salesLBL.setFont(new Font("Arial", Font.BOLD, 20));
        total_salesLBL.setBounds(462, 424, 216, 38);
        contentPane.add(total_salesLBL);

        // Set the text for the total sales label
        double totalSales = calculateTotalSales(model);
        total_salesLBL.setText(String.valueOf(totalSales));
    }

    private double calculateTotalSales(DefaultTableModel model) {
        double totalSales = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalSales = (double) model.getValueAt(i, 3);
        }
        return totalSales;
    }
}

