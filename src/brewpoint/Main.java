package brewpoint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Main extends JFrame {
	// panels
	static JPanel coffee_panel = new JPanel();
	static JPanel milk_panel = new JPanel();
	static JPanel fruit_panel = new JPanel();
	static JPanel frappe_panel = new JPanel();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	
	public static void hidePanel() {
		coffee_panel.setVisible(false);
		milk_panel.setVisible(false);
		frappe_panel.setVisible(false);
		fruit_panel.setVisible(false);
	}
	
	public static void showPanel(JPanel panelActive) {
		hidePanel();
		panelActive.setVisible(true);
	}
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		hidePanel();
		
		JLabel header = new JLabel("8 AM BrewPoint");
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setBounds(10, 0, 176, 45);
		contentPane.add(header);
		
		JButton coffee_btn = new JButton("COFFEE");
		coffee_btn.addActionListener(e -> showPanel(coffee_panel));
		coffee_btn.setForeground(new Color(0, 0, 0));
		coffee_btn.setFont(new Font("Arial", Font.BOLD, 10));
		coffee_btn.setBackground(new Color(192, 192, 192));
		coffee_btn.setBorderPainted(false); // Remove the outline
		coffee_btn.setBounds(10, 53, 89, 45);
		contentPane.add(coffee_btn);
		coffee_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton milktea_btn = new JButton("MILKTEA");
		milktea_btn.addActionListener(e -> showPanel(milk_panel));
		milktea_btn.setForeground(Color.BLACK);
		milktea_btn.setFont(new Font("Arial", Font.BOLD, 10));
		milktea_btn.setBorderPainted(false);
		milktea_btn.setBackground(Color.LIGHT_GRAY);
		milktea_btn.setBounds(109, 53, 89, 45);
		contentPane.add(milktea_btn);
		milktea_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton fruittea_btn = new JButton("FRUIT TEA");
		fruittea_btn.addActionListener(e -> showPanel(fruit_panel));
		fruittea_btn.setForeground(Color.BLACK);
		fruittea_btn.setFont(new Font("Arial", Font.BOLD, 10));
		fruittea_btn.setBorderPainted(false);
		fruittea_btn.setBackground(Color.LIGHT_GRAY);
		fruittea_btn.setBounds(208, 53, 89, 45);
		contentPane.add(fruittea_btn);
		fruittea_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton frappe_btn = new JButton("FRAPPE");
		frappe_btn.addActionListener(e -> showPanel(frappe_panel));
		frappe_btn.setForeground(Color.BLACK);
		frappe_btn.setFont(new Font("Arial", Font.BOLD, 10));
		frappe_btn.setBorderPainted(false);
		frappe_btn.setBackground(Color.LIGHT_GRAY);
		frappe_btn.setBounds(307, 53, 89, 45);
		contentPane.add(frappe_btn);
		frappe_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton inventory_btn = new JButton("INVENTORY");
		inventory_btn.setForeground(Color.BLACK);
		inventory_btn.setFont(new Font("Arial", Font.BOLD, 10));
		inventory_btn.setBorderPainted(false);
		inventory_btn.setBackground(Color.LIGHT_GRAY);
		inventory_btn.setBounds(10, 109, 110, 45);
		contentPane.add(inventory_btn);
		inventory_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton sales_btn = new JButton("SALES");
		sales_btn.setForeground(Color.BLACK);
		sales_btn.setFont(new Font("Arial", Font.BOLD, 10));
		sales_btn.setBorderPainted(false);
		sales_btn.setBackground(Color.LIGHT_GRAY);
		sales_btn.setBounds(130, 109, 110, 45);
		contentPane.add(sales_btn);
		sales_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		coffee_panel.setBounds(440, 24, 601, 440);
		contentPane.add(coffee_panel);
		coffee_panel.setLayout(null);
		
		JLabel lblCoffee = new JLabel("COFFEE");
		lblCoffee.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoffee.setFont(new Font("Arial", Font.BOLD, 20));
		lblCoffee.setBounds(229, 11, 176, 45);
		coffee_panel.add(lblCoffee);
		
		// coffee options btn
		JButton original_btn = new JButton("ORIGINAL");
		original_btn.setForeground(Color.BLACK);
		original_btn.setFont(new Font("Arial", Font.BOLD, 10));
		original_btn.setBorderPainted(false);
		original_btn.setBackground(Color.LIGHT_GRAY);
		original_btn.setBounds(10, 58, 150, 45);
		coffee_panel.add(original_btn);
		
		JButton hazelnut_btn = new JButton("HAZELNUT");
		hazelnut_btn.setForeground(Color.BLACK);
		hazelnut_btn.setFont(new Font("Arial", Font.BOLD, 10));
		hazelnut_btn.setBorderPainted(false);
		hazelnut_btn.setBackground(Color.LIGHT_GRAY);
		hazelnut_btn.setBounds(10, 111, 150, 45);
		coffee_panel.add(hazelnut_btn);
		
		JButton machiato_btn = new JButton("MACHIATO");
		machiato_btn.setForeground(Color.BLACK);
		machiato_btn.setFont(new Font("Arial", Font.BOLD, 10));
		machiato_btn.setBorderPainted(false);
		machiato_btn.setBackground(Color.LIGHT_GRAY);
		machiato_btn.setBounds(10, 167, 150, 45);
		coffee_panel.add(machiato_btn);
		
		JButton americano_btn = new JButton("AMERICANO");
		americano_btn.setForeground(Color.BLACK);
		americano_btn.setFont(new Font("Arial", Font.BOLD, 10));
		americano_btn.setBorderPainted(false);
		americano_btn.setBackground(Color.LIGHT_GRAY);
		americano_btn.setBounds(170, 58, 150, 45);
		coffee_panel.add(americano_btn);
		
		JButton mocha_btn = new JButton("MOCHA");
		mocha_btn.setForeground(Color.BLACK);
		mocha_btn.setFont(new Font("Arial", Font.BOLD, 10));
		mocha_btn.setBorderPainted(false);
		mocha_btn.setBackground(Color.LIGHT_GRAY);
		mocha_btn.setBounds(170, 111, 150, 45);
		coffee_panel.add(mocha_btn);
		
		JButton vanilla_btn = new JButton("VANILLA");
		vanilla_btn.setForeground(Color.BLACK);
		vanilla_btn.setFont(new Font("Arial", Font.BOLD, 10));
		vanilla_btn.setBorderPainted(false);
		vanilla_btn.setBackground(Color.LIGHT_GRAY);
		vanilla_btn.setBounds(170, 167, 150, 45);
		coffee_panel.add(vanilla_btn);
		
		milk_panel.setBounds(440, 24, 601, 440);
		contentPane.add(milk_panel);
		milk_panel.setLayout(null);
		
		JLabel lblMilk = new JLabel("MILK TEA");
		lblMilk.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilk.setFont(new Font("Arial", Font.BOLD, 20));
		lblMilk.setBounds(229, 11, 176, 45);
		milk_panel.add(lblMilk);
		
		fruit_panel.setBounds(440, 24, 601, 440);
		contentPane.add(fruit_panel);
		fruit_panel.setLayout(null);
		
		JLabel lblfruit = new JLabel("FRUIT TEA");
		lblfruit.setHorizontalAlignment(SwingConstants.CENTER);
		lblfruit.setFont(new Font("Arial", Font.BOLD, 20));
		lblfruit.setBounds(229, 11, 176, 45);
		fruit_panel.add(lblfruit);
		
		frappe_panel.setBounds(440, 24, 601, 440);
		contentPane.add(frappe_panel);
		frappe_panel.setLayout(null);
		
		JLabel lblFrappe = new JLabel("FRAPPE");
		lblFrappe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrappe.setFont(new Font("Arial", Font.BOLD, 20));
		lblFrappe.setBounds(229, 11, 176, 45);
		frappe_panel.add(lblFrappe);

	}
}
