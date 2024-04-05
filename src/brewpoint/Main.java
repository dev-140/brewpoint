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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JList;



public class Main extends JFrame {
	// panels
	static JPanel coffee_panel = new JPanel();
	static JPanel milk_panel = new JPanel();
	static JPanel fruit_panel = new JPanel();
	static JPanel frappe_panel = new JPanel();
	static JPanel addon_panel = new JPanel();
	static JPanel order_panel = new JPanel();
	
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
		coffee_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		coffee_panel.setVisible(false);
		milk_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		milk_panel.setVisible(false);
		frappe_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frappe_panel.setVisible(false);
		fruit_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		fruit_panel.setVisible(false);
		addon_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		addon_panel.setVisible(false);
		order_panel.setVisible(false);
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
		coffee_btn.addActionListener(e -> {
		    showPanel(coffee_panel);
		    addon_panel.setVisible(true);
			order_panel.setVisible(true);
		});
		coffee_btn.setForeground(new Color(0, 0, 0));
		coffee_btn.setFont(new Font("Arial", Font.BOLD, 10));
		coffee_btn.setBackground(new Color(192, 192, 192));
		coffee_btn.setBorderPainted(false); // Remove the outline
		coffee_btn.setBounds(10, 53, 89, 45);
		contentPane.add(coffee_btn);
		coffee_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton milktea_btn = new JButton("MILKTEA");
		milktea_btn.addActionListener(e -> {
			showPanel(milk_panel);
			addon_panel.setVisible(true);
			order_panel.setVisible(true);
		});
		milktea_btn.setForeground(Color.BLACK);
		milktea_btn.setFont(new Font("Arial", Font.BOLD, 10));
		milktea_btn.setBorderPainted(false);
		milktea_btn.setBackground(Color.LIGHT_GRAY);
		milktea_btn.setBounds(109, 53, 89, 45);
		contentPane.add(milktea_btn);
		milktea_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton fruittea_btn = new JButton("FRUIT TEA");
		fruittea_btn.addActionListener(e -> {
			showPanel(fruit_panel);
			addon_panel.setVisible(true);
			order_panel.setVisible(true);
		});
		fruittea_btn.setForeground(Color.BLACK);
		fruittea_btn.setFont(new Font("Arial", Font.BOLD, 10));
		fruittea_btn.setBorderPainted(false);
		fruittea_btn.setBackground(Color.LIGHT_GRAY);
		fruittea_btn.setBounds(208, 53, 89, 45);
		contentPane.add(fruittea_btn);
		fruittea_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton frappe_btn = new JButton("FRAPPE");
		frappe_btn.addActionListener(e -> { 	
			showPanel(frappe_panel);
			addon_panel.setVisible(true);
			order_panel.setVisible(true);
		});
		frappe_btn.setForeground(Color.BLACK);
		frappe_btn.setFont(new Font("Arial", Font.BOLD, 10));
		frappe_btn.setBorderPainted(false);
		frappe_btn.setBackground(Color.LIGHT_GRAY);
		frappe_btn.setBounds(307, 53, 123, 45);
		contentPane.add(frappe_btn);
		frappe_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton inventory_btn = new JButton("INVENTORY");
		inventory_btn.setForeground(Color.BLACK);
		inventory_btn.setFont(new Font("Arial", Font.BOLD, 10));
		inventory_btn.setBorderPainted(false);
		inventory_btn.setBackground(Color.LIGHT_GRAY);
		inventory_btn.setBounds(10, 109, 131, 45);
		contentPane.add(inventory_btn);
		inventory_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton sales_btn = new JButton("SALES");
		sales_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sales_btn.setForeground(Color.BLACK);
		sales_btn.setFont(new Font("Arial", Font.BOLD, 10));
		sales_btn.setBorderPainted(false);
		sales_btn.setBackground(Color.LIGHT_GRAY);
		sales_btn.setBounds(151, 109, 146, 45);
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
		
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------- coffee options btn ---------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->

		JButton C_original_btn = new JButton("ORIGINAL");
		C_original_btn.setForeground(Color.BLACK);
		C_original_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_original_btn.setBorderPainted(false);
		C_original_btn.setBackground(Color.LIGHT_GRAY);
		C_original_btn.setBounds(161, 66, 150, 45);
		coffee_panel.add(C_original_btn);
		
		JButton C_hazelnut_btn = new JButton("HAZELNUT");
		C_hazelnut_btn.setForeground(Color.BLACK);
		C_hazelnut_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_hazelnut_btn.setBorderPainted(false);
		C_hazelnut_btn.setBackground(Color.LIGHT_GRAY);
		C_hazelnut_btn.setBounds(161, 119, 150, 45);
		coffee_panel.add(C_hazelnut_btn);
		
		JButton C_machiato_btn = new JButton("MACHIATO");
		C_machiato_btn.setForeground(Color.BLACK);
		C_machiato_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_machiato_btn.setBorderPainted(false);
		C_machiato_btn.setBackground(Color.LIGHT_GRAY);
		C_machiato_btn.setBounds(161, 175, 150, 45);
		coffee_panel.add(C_machiato_btn);
		
		JButton C_americano_btn = new JButton("AMERICANO");
		C_americano_btn.setForeground(Color.BLACK);
		C_americano_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_americano_btn.setBorderPainted(false);
		C_americano_btn.setBackground(Color.LIGHT_GRAY);
		C_americano_btn.setBounds(321, 66, 150, 45);
		coffee_panel.add(C_americano_btn);
		
		JButton C_mocha_btn = new JButton("MOCHA");
		C_mocha_btn.setForeground(Color.BLACK);
		C_mocha_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_mocha_btn.setBorderPainted(false);
		C_mocha_btn.setBackground(Color.LIGHT_GRAY);
		C_mocha_btn.setBounds(321, 119, 150, 45);
		coffee_panel.add(C_mocha_btn);
		
		JButton C_vanilla_btn = new JButton("VANILLA");
		C_vanilla_btn.setForeground(Color.BLACK);
		C_vanilla_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_vanilla_btn.setBorderPainted(false);
		C_vanilla_btn.setBackground(Color.LIGHT_GRAY);
		C_vanilla_btn.setBounds(321, 175, 150, 45);
		coffee_panel.add(C_vanilla_btn);
		
		milk_panel.setBounds(440, 24, 601, 440);
		contentPane.add(milk_panel);
		milk_panel.setLayout(null);
		
		JLabel lblMilk = new JLabel("MILK TEA");
		lblMilk.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilk.setFont(new Font("Arial", Font.BOLD, 20));
		lblMilk.setBounds(229, 11, 176, 45);
		milk_panel.add(lblMilk);
		
		JButton M_original_btn = new JButton("ORIGINAL");
		M_original_btn.setForeground(Color.BLACK);
		M_original_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_original_btn.setBorderPainted(false);
		M_original_btn.setBackground(Color.LIGHT_GRAY);
		M_original_btn.setBounds(109, 65, 195, 45);
		milk_panel.add(M_original_btn);
		
		JButton M_hokkaido_btn = new JButton("HOKKAIDO");
		M_hokkaido_btn.setForeground(Color.BLACK);
		M_hokkaido_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_hokkaido_btn.setBorderPainted(false);
		M_hokkaido_btn.setBackground(Color.LIGHT_GRAY);
		M_hokkaido_btn.setBounds(109, 121, 195, 45);
		milk_panel.add(M_hokkaido_btn);
		
		JButton M_okinawa_btn = new JButton("OKINAWA");
		M_okinawa_btn.setForeground(Color.BLACK);
		M_okinawa_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_okinawa_btn.setBorderPainted(false);
		M_okinawa_btn.setBackground(Color.LIGHT_GRAY);
		M_okinawa_btn.setBounds(109, 177, 195, 45);
		milk_panel.add(M_okinawa_btn);
		
		JButton M_winM_btn = new JButton("WINTER MELON");
		M_winM_btn.setForeground(Color.BLACK);
		M_winM_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_winM_btn.setBorderPainted(false);
		M_winM_btn.setBackground(Color.LIGHT_GRAY);
		M_winM_btn.setBounds(314, 65, 195, 45);
		milk_panel.add(M_winM_btn);
		
		JButton M_taro_btn = new JButton("TARO");
		M_taro_btn.setForeground(Color.BLACK);
		M_taro_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_taro_btn.setBorderPainted(false);
		M_taro_btn.setBackground(Color.LIGHT_GRAY);
		M_taro_btn.setBounds(314, 121, 195, 45);
		milk_panel.add(M_taro_btn);
		
		JButton M_ccake_btn = new JButton("CHEESE CAKE");
		M_ccake_btn.setForeground(Color.BLACK);
		M_ccake_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_ccake_btn.setBorderPainted(false);
		M_ccake_btn.setBackground(Color.LIGHT_GRAY);
		M_ccake_btn.setBounds(314, 177, 195, 45);
		milk_panel.add(M_ccake_btn);
		
		JButton M_choco_btn = new JButton("CHOCOLATE");
		M_choco_btn.setForeground(Color.BLACK);
		M_choco_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_choco_btn.setBorderPainted(false);
		M_choco_btn.setBackground(Color.LIGHT_GRAY);
		M_choco_btn.setBounds(109, 233, 195, 45);
		milk_panel.add(M_choco_btn);
		
		JButton M_straw_btn = new JButton("STRAWBERRY");
		M_straw_btn.setForeground(Color.BLACK);
		M_straw_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_straw_btn.setBorderPainted(false);
		M_straw_btn.setBackground(Color.LIGHT_GRAY);
		M_straw_btn.setBounds(314, 233, 195, 45);
		milk_panel.add(M_straw_btn);
		
		JButton M_ccream_btn = new JButton("COOKIES & CREAM");
		M_ccream_btn.setForeground(Color.BLACK);
		M_ccream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_ccream_btn.setBorderPainted(false);
		M_ccream_btn.setBackground(Color.LIGHT_GRAY);
		M_ccream_btn.setBounds(109, 289, 195, 45);
		milk_panel.add(M_ccream_btn);
		
		fruit_panel.setBounds(440, 24, 601, 440);
		contentPane.add(fruit_panel);
		fruit_panel.setLayout(null);
		
		JLabel lblfruit = new JLabel("FRUIT TEA");
		lblfruit.setHorizontalAlignment(SwingConstants.CENTER);
		lblfruit.setFont(new Font("Arial", Font.BOLD, 20));
		lblfruit.setBounds(229, 11, 176, 45);
		fruit_panel.add(lblfruit);
		
		JButton F_straw_btn = new JButton("STRAWBERRY");
		F_straw_btn.setForeground(Color.BLACK);
		F_straw_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_straw_btn.setBorderPainted(false);
		F_straw_btn.setBackground(Color.LIGHT_GRAY);
		F_straw_btn.setBounds(153, 67, 161, 45);
		fruit_panel.add(F_straw_btn);
		
		JButton F_lychee_btn = new JButton("LYCHEE");
		F_lychee_btn.setForeground(Color.BLACK);
		F_lychee_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_lychee_btn.setBorderPainted(false);
		F_lychee_btn.setBackground(Color.LIGHT_GRAY);
		F_lychee_btn.setBounds(327, 67, 161, 45);
		fruit_panel.add(F_lychee_btn);
		
		JButton F_watermelon_btn = new JButton("WATERMELON");
		F_watermelon_btn.setForeground(Color.BLACK);
		F_watermelon_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_watermelon_btn.setBorderPainted(false);
		F_watermelon_btn.setBackground(Color.LIGHT_GRAY);
		F_watermelon_btn.setBounds(327, 123, 161, 45);
		fruit_panel.add(F_watermelon_btn);
		
		JButton F_blue_btn = new JButton("BLUEBERRY");
		F_blue_btn.setForeground(Color.BLACK);
		F_blue_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_blue_btn.setBorderPainted(false);
		F_blue_btn.setBackground(Color.LIGHT_GRAY);
		F_blue_btn.setBounds(153, 123, 161, 45);
		fruit_panel.add(F_blue_btn);
		
		JButton F_orange_btn = new JButton("ORRANGE");
		F_orange_btn.setForeground(Color.BLACK);
		F_orange_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_orange_btn.setBorderPainted(false);
		F_orange_btn.setBackground(Color.LIGHT_GRAY);
		F_orange_btn.setBounds(327, 179, 161, 45);
		fruit_panel.add(F_orange_btn);
		
		JButton F_mango_btn = new JButton("MANGO");
		F_mango_btn.setForeground(Color.BLACK);
		F_mango_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_mango_btn.setBorderPainted(false);
		F_mango_btn.setBackground(Color.LIGHT_GRAY);
		F_mango_btn.setBounds(153, 179, 161, 45);
		fruit_panel.add(F_mango_btn);
		
		JButton F_gapple_btn = new JButton("GREEN APPLE");
		F_gapple_btn.setForeground(Color.BLACK);
		F_gapple_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_gapple_btn.setBorderPainted(false);
		F_gapple_btn.setBackground(Color.LIGHT_GRAY);
		F_gapple_btn.setBounds(327, 236, 161, 45);
		fruit_panel.add(F_gapple_btn);
		
		JButton F_grape_btn = new JButton("GRAPES");
		F_grape_btn.setForeground(Color.BLACK);
		F_grape_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_grape_btn.setBorderPainted(false);
		F_grape_btn.setBackground(Color.LIGHT_GRAY);
		F_grape_btn.setBounds(153, 236, 161, 45);
		fruit_panel.add(F_grape_btn);
		
		JButton F_kiwi_btn = new JButton("KIWI");
		F_kiwi_btn.setForeground(Color.BLACK);
		F_kiwi_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_kiwi_btn.setBorderPainted(false);
		F_kiwi_btn.setBackground(Color.LIGHT_GRAY);
		F_kiwi_btn.setBounds(327, 292, 161, 45);
		fruit_panel.add(F_kiwi_btn);
		
		JButton F_melon_btn = new JButton("MELON");
		F_melon_btn.setForeground(Color.BLACK);
		F_melon_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_melon_btn.setBorderPainted(false);
		F_melon_btn.setBackground(Color.LIGHT_GRAY);
		F_melon_btn.setBounds(153, 292, 161, 45);
		fruit_panel.add(F_melon_btn);
		
		frappe_panel.setBounds(440, 24, 601, 440);
		contentPane.add(frappe_panel);
		frappe_panel.setLayout(null);
		
		JLabel lblFrappe = new JLabel("FRAPPE");
		lblFrappe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrappe.setFont(new Font("Arial", Font.BOLD, 20));
		lblFrappe.setBounds(229, 11, 176, 45);
		frappe_panel.add(lblFrappe);
		
		JButton FP_cjava_btn = new JButton("CHOCO JAVA");
		FP_cjava_btn.setForeground(Color.BLACK);
		FP_cjava_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_cjava_btn.setBorderPainted(false);
		FP_cjava_btn.setBackground(Color.LIGHT_GRAY);
		FP_cjava_btn.setBounds(146, 82, 147, 45);
		frappe_panel.add(FP_cjava_btn);
		
		JButton FP_strawcream_btn = new JButton("STRAWBERRY CREAM");
		FP_strawcream_btn.setForeground(Color.BLACK);
		FP_strawcream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_strawcream_btn.setBorderPainted(false);
		FP_strawcream_btn.setBackground(Color.LIGHT_GRAY);
		FP_strawcream_btn.setBounds(334, 82, 147, 45);
		frappe_panel.add(FP_strawcream_btn);
		
		JButton FP_ccake_btn = new JButton("CHEESECAKE CREAM");
		FP_ccake_btn.setForeground(Color.BLACK);
		FP_ccake_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_ccake_btn.setBorderPainted(false);
		FP_ccake_btn.setBackground(Color.LIGHT_GRAY);
		FP_ccake_btn.setBounds(334, 134, 147, 45);
		frappe_panel.add(FP_ccake_btn);
		
		JButton FP_chazel_btn = new JButton("CHOCO HAZELNUT");
		FP_chazel_btn.setForeground(Color.BLACK);
		FP_chazel_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_chazel_btn.setBorderPainted(false);
		FP_chazel_btn.setBackground(Color.LIGHT_GRAY);
		FP_chazel_btn.setBounds(146, 134, 147, 45);
		frappe_panel.add(FP_chazel_btn);
		
		JButton FP_chococream_btn = new JButton("CHOCOLATE CREAM");
		FP_chococream_btn.setForeground(Color.BLACK);
		FP_chococream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_chococream_btn.setBorderPainted(false);
		FP_chococream_btn.setBackground(Color.LIGHT_GRAY);
		FP_chococream_btn.setBounds(334, 190, 147, 45);
		frappe_panel.add(FP_chococream_btn);
		
		JButton FP_vcream_btn = new JButton("VANILLA CARAMEL");
		FP_vcream_btn.setForeground(Color.BLACK);
		FP_vcream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_vcream_btn.setBorderPainted(false);
		FP_vcream_btn.setBackground(Color.LIGHT_GRAY);
		FP_vcream_btn.setBounds(146, 190, 147, 45);
		frappe_panel.add(FP_vcream_btn);
		
		JButton FP_scaramel_btn = new JButton("SALTED CARAMEL");
		FP_scaramel_btn.setForeground(Color.BLACK);
		FP_scaramel_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_scaramel_btn.setBorderPainted(false);
		FP_scaramel_btn.setBackground(Color.LIGHT_GRAY);
		FP_scaramel_btn.setBounds(146, 246, 147, 45);
		frappe_panel.add(FP_scaramel_btn);
		
		JButton FP_cookiecream_btn = new JButton("COOKIES & CREAM");
		FP_cookiecream_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		FP_cookiecream_btn.setForeground(Color.BLACK);
		FP_cookiecream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_cookiecream_btn.setBorderPainted(false);
		FP_cookiecream_btn.setBackground(Color.LIGHT_GRAY);
		FP_cookiecream_btn.setBounds(334, 246, 147, 45);
		frappe_panel.add(FP_cookiecream_btn);
		
		JButton FP_gtea_btn = new JButton("GREEN TEA CREAM");
		FP_gtea_btn.setForeground(Color.BLACK);
		FP_gtea_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_gtea_btn.setBorderPainted(false);
		FP_gtea_btn.setBackground(Color.LIGHT_GRAY);
		FP_gtea_btn.setBounds(146, 302, 147, 45);
		frappe_panel.add(FP_gtea_btn);
		
		JButton FP_taro = new JButton("TARO");
		FP_taro.setForeground(Color.BLACK);
		FP_taro.setFont(new Font("Arial", Font.BOLD, 10));
		FP_taro.setBorderPainted(false);
		FP_taro.setBackground(Color.LIGHT_GRAY);
		FP_taro.setBounds(334, 302, 147, 45);
		frappe_panel.add(FP_taro);
		
		JLabel lblNewLabel = new JLabel("COFFEE BASED");
		lblNewLabel.setBounds(181, 57, 75, 14);
		frappe_panel.add(lblNewLabel);
		
		JLabel lblNonCoffee = new JLabel("NON COFFEE");
		lblNonCoffee.setBounds(370, 57, 75, 14);
		frappe_panel.add(lblNonCoffee);
		
		addon_panel.setBounds(440, 472, 601, 73);
		contentPane.add(addon_panel);
		addon_panel.setLayout(null);
		
		JButton AD_pearl = new JButton("PEARL");
		AD_pearl.setForeground(Color.BLACK);
		AD_pearl.setFont(new Font("Arial", Font.BOLD, 10));
		AD_pearl.setBorderPainted(false);
		AD_pearl.setBackground(Color.LIGHT_GRAY);
		AD_pearl.setBounds(97, 17, 77, 45);
		addon_panel.add(AD_pearl);
		
		JButton AD_oreo = new JButton("OREO");
		AD_oreo.setForeground(Color.BLACK);
		AD_oreo.setFont(new Font("Arial", Font.BOLD, 10));
		AD_oreo.setBorderPainted(false);
		AD_oreo.setBackground(Color.LIGHT_GRAY);
		AD_oreo.setBounds(184, 17, 71, 45);
		addon_panel.add(AD_oreo);
		
		JButton AD_nata = new JButton("NATA");
		AD_nata.setForeground(Color.BLACK);
		AD_nata.setFont(new Font("Arial", Font.BOLD, 10));
		AD_nata.setBorderPainted(false);
		AD_nata.setBackground(Color.LIGHT_GRAY);
		AD_nata.setBounds(265, 17, 63, 45);
		addon_panel.add(AD_nata);
		
		JButton AD_cjelly = new JButton("COFFEE JELLY");
		AD_cjelly.setForeground(Color.BLACK);
		AD_cjelly.setFont(new Font("Arial", Font.BOLD, 10));
		AD_cjelly.setBorderPainted(false);
		AD_cjelly.setBackground(Color.LIGHT_GRAY);
		AD_cjelly.setBounds(338, 17, 112, 45);
		addon_panel.add(AD_cjelly);
		
		JButton AD_fjelly = new JButton("FRUIT JELLY");
		AD_fjelly.setForeground(Color.BLACK);
		AD_fjelly.setFont(new Font("Arial", Font.BOLD, 10));
		AD_fjelly.setBorderPainted(false);
		AD_fjelly.setBackground(Color.LIGHT_GRAY);
		AD_fjelly.setBounds(460, 17, 131, 45);
		addon_panel.add(AD_fjelly);
		
		JButton AD_none = new JButton("NONE");
		AD_none.setForeground(Color.BLACK);
		AD_none.setFont(new Font("Arial", Font.BOLD, 10));
		AD_none.setBorderPainted(false);
		AD_none.setBackground(Color.LIGHT_GRAY);
		AD_none.setBounds(10, 17, 77, 45);
		addon_panel.add(AD_none);
		
		order_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		order_panel.setBackground(new Color(255, 255, 255));
		order_panel.setBounds(10, 165, 416, 380);
		contentPane.add(order_panel);
		order_panel.setLayout(null);
		
		JLabel orderlbl = new JLabel("ORDER");
		orderlbl.setBounds(10, 11, 82, 24);
		orderlbl.setFont(new Font("Arial", Font.BOLD, 20));
		order_panel.add(orderlbl);
		
		JList list = new JList();
		list.setBounds(10, 46, 396, 249);
		order_panel.add(list);
		
		JButton checkout_btn = new JButton("CHECKOUT");
		checkout_btn.setForeground(Color.BLACK);
		checkout_btn.setFont(new Font("Arial", Font.BOLD, 10));
		checkout_btn.setBorderPainted(false);
		checkout_btn.setBackground(Color.LIGHT_GRAY);
		checkout_btn.setBounds(303, 324, 89, 45);
		order_panel.add(checkout_btn);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotal.setBounds(10, 322, 82, 42);
		order_panel.add(lblTotal);
		
		JButton restock_btn = new JButton("RESTOCK");
		restock_btn.setForeground(Color.BLACK);
		restock_btn.setFont(new Font("Arial", Font.BOLD, 10));
		restock_btn.setBorderPainted(false);
		restock_btn.setBackground(Color.LIGHT_GRAY);
		restock_btn.setBounds(307, 109, 120, 45);
		contentPane.add(restock_btn);

	}
}
