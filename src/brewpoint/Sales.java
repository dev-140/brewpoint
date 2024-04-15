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
        setBounds(100, 100, 1000, 553);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Total Price");
        model.addColumn("Date");
        model.addColumn("Total Sales");

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

        table = new JTable(model);
        table.setBounds(10, 11, 564, 339);
        table.getColumnModel().getColumn(3).setMaxWidth(0);
        table.getColumnModel().getColumn(3).setMinWidth(0);
        table.getColumnModel().getColumn(3).setPreferredWidth(0);
        table.getColumnModel().getColumn(3).setWidth(0);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 964, 402);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("TOTAL SALES:");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel.setBounds(339, 424, 155, 38);
        contentPane.add(lblNewLabel);

        JLabel total_salesLBL = new JLabel("0");
        total_salesLBL.setFont(new Font("Arial", Font.BOLD, 20));
        total_salesLBL.setBounds(498, 424, 216, 38);
        contentPane.add(total_salesLBL);

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

