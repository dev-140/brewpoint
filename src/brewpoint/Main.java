package brewpoint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JList;
import javax.swing.JSlider;



public class Main extends JFrame {
	// panels
	static JPanel coffee_panel = new JPanel();
	static JPanel milk_panel = new JPanel();
	static JPanel fruit_panel = new JPanel();
	static JPanel frappe_panel = new JPanel();
	static JPanel addon_panel = new JPanel();
	static JPanel order_panel = new JPanel();
	static JPanel size_panel = new JPanel();
	static DefaultListModel<String> orderListModel = new DefaultListModel<>();
	static boolean step1 = false;
	static boolean step2 = false;
	static boolean step3 = false;
	static JSlider slider = new JSlider();
	static JPanel qty_panel = new JPanel();
	static JLabel total_pricelbl = new JLabel("0");
	JList<String> orderList = new JList<>(orderListModel);
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static double totalPrice;

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
		size_panel.setVisible(false);
		qty_panel.setVisible(false);
	}
	
	public static void showPanel(JPanel panelActive) {
		hidePanel();
		panelActive.setVisible(true);
	}
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

//		hidePanel();
		
		showPanel(coffee_panel);
	    addon_panel.setVisible(true);
		order_panel.setVisible(true);
		size_panel.setVisible(true);
		qty_panel.setVisible(true);
		
		JLabel header = new JLabel("8 AM BrewPoint");
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setBounds(10, 0, 176, 45);
		contentPane.add(header);
		
		JButton coffee_btn = new JButton("COFFEE");
		coffee_btn.addActionListener(e -> {
		    showPanel(coffee_panel);
		    addon_panel.setVisible(true);
			order_panel.setVisible(true);
			size_panel.setVisible(true);
			qty_panel.setVisible(true);
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
			size_panel.setVisible(true);
			qty_panel.setVisible(true);
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
			size_panel.setVisible(true);
			qty_panel.setVisible(true);
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
			size_panel.setVisible(true);
			qty_panel.setVisible(true);
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
		inventory_btn.setBounds(10, 109, 188, 45);
		contentPane.add(inventory_btn);
		inventory_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		inventory_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory inventoryFrame = new Inventory();
                inventoryFrame.setVisible(true);
			}
		});
		
		JButton sales_btn = new JButton("SALES");
		sales_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales salesFrame = new Sales();
				salesFrame.setVisible(true);
			}
		});
		sales_btn.setForeground(Color.BLACK);
		sales_btn.setFont(new Font("Arial", Font.BOLD, 10));
		sales_btn.setBorderPainted(false);
		sales_btn.setBackground(Color.LIGHT_GRAY);
		sales_btn.setBounds(208, 109, 222, 45);
		contentPane.add(sales_btn);
		sales_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		coffee_panel.setBounds(440, 24, 601, 344);
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
		C_original_btn.addActionListener(e -> {
			Request.prodName = "original blend";
			Request.powder = "coffee original powder";
			step1 = true;
		});
		
		JButton C_hazelnut_btn = new JButton("HAZELNUT");
		C_hazelnut_btn.setForeground(Color.BLACK);
		C_hazelnut_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_hazelnut_btn.setBorderPainted(false);
		C_hazelnut_btn.setBackground(Color.LIGHT_GRAY);
		C_hazelnut_btn.setBounds(161, 119, 150, 45);
		coffee_panel.add(C_hazelnut_btn);
		C_hazelnut_btn.addActionListener(e -> {
			Request.prodName = "hazelnut espresso";
			Request.powder = "coffee hazelnut powder";
			step1 = true;
		});
		
		JButton C_machiato_btn = new JButton("MACHIATO");
		C_machiato_btn.setForeground(Color.BLACK);
		C_machiato_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_machiato_btn.setBorderPainted(false);
		C_machiato_btn.setBackground(Color.LIGHT_GRAY);
		C_machiato_btn.setBounds(161, 175, 150, 45);
		coffee_panel.add(C_machiato_btn);
		C_machiato_btn.addActionListener(e -> {
			Request.prodName = "caramel machiato";
			Request.powder = "coffee machiato powder";
			step1 = true;
		});
		
		JButton C_americano_btn = new JButton("AMERICANO");
		C_americano_btn.setForeground(Color.BLACK);
		C_americano_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_americano_btn.setBorderPainted(false);
		C_americano_btn.setBackground(Color.LIGHT_GRAY);
		C_americano_btn.setBounds(321, 66, 150, 45);
		coffee_panel.add(C_americano_btn);
		C_americano_btn.addActionListener(e -> {
			Request.prodName = "cafe americano";
			Request.powder = "coffee americano powder";
			step1 = true;
		});
		
		JButton C_mocha_btn = new JButton("MOCHA");
		C_mocha_btn.setForeground(Color.BLACK);
		C_mocha_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_mocha_btn.setBorderPainted(false);
		C_mocha_btn.setBackground(Color.LIGHT_GRAY);
		C_mocha_btn.setBounds(321, 119, 150, 45);
		coffee_panel.add(C_mocha_btn);
		C_mocha_btn.addActionListener(e -> {
			Request.prodName = "mocha latte";
			Request.powder = "coffee mocha powder";
			step1 = true;
		});
		
		JButton C_vanilla_btn = new JButton("VANILLA");
		C_vanilla_btn.setForeground(Color.BLACK);
		C_vanilla_btn.setFont(new Font("Arial", Font.BOLD, 10));
		C_vanilla_btn.setBorderPainted(false);
		C_vanilla_btn.setBackground(Color.LIGHT_GRAY);
		C_vanilla_btn.setBounds(321, 175, 150, 45);
		coffee_panel.add(C_vanilla_btn);
		C_vanilla_btn.addActionListener(e -> {
			Request.prodName = "french vannila";
			Request.powder = "coffee vanilla powder";
			step1 = true;
		});
		
		milk_panel.setBounds(440, 24, 601, 344);
		contentPane.add(milk_panel);
		milk_panel.setLayout(null);
		
		JLabel lblMilk = new JLabel("MILK TEA");
		lblMilk.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilk.setFont(new Font("Arial", Font.BOLD, 20));
		lblMilk.setBounds(229, 11, 176, 45);
		milk_panel.add(lblMilk);
		
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------- milktea options btn --------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		JButton M_original_btn = new JButton("ORIGINAL");
		M_original_btn.setForeground(Color.BLACK);
		M_original_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_original_btn.setBorderPainted(false);
		M_original_btn.setBackground(Color.LIGHT_GRAY);
		M_original_btn.setBounds(109, 65, 195, 45);
		milk_panel.add(M_original_btn);
		M_original_btn.addActionListener(e -> {
		    Request.prodName = "original milktea";
		    Request.powder = "milk original powder";
		    step1 = true;
		});

		JButton M_hokkaido_btn = new JButton("HOKKAIDO");
		M_hokkaido_btn.setForeground(Color.BLACK);
		M_hokkaido_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_hokkaido_btn.setBorderPainted(false);
		M_hokkaido_btn.setBackground(Color.LIGHT_GRAY);
		M_hokkaido_btn.setBounds(109, 121, 195, 45);
		milk_panel.add(M_hokkaido_btn);
		M_hokkaido_btn.addActionListener(e -> {
		    Request.prodName = "hokkaido milktea";
		    Request.powder = "milk hokkaido powder";
		    step1 = true;
		});

		JButton M_okinawa_btn = new JButton("OKINAWA");
		M_okinawa_btn.setForeground(Color.BLACK);
		M_okinawa_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_okinawa_btn.setBorderPainted(false);
		M_okinawa_btn.setBackground(Color.LIGHT_GRAY);
		M_okinawa_btn.setBounds(109, 177, 195, 45);
		milk_panel.add(M_okinawa_btn);
		M_okinawa_btn.addActionListener(e -> {
		    Request.prodName = "okinawa milktea";
		    Request.powder = "milk okinawa powder";
		    step1 = true;
		});

		JButton M_winM_btn = new JButton("WINTER MELON");
		M_winM_btn.setForeground(Color.BLACK);
		M_winM_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_winM_btn.setBorderPainted(false);
		M_winM_btn.setBackground(Color.LIGHT_GRAY);
		M_winM_btn.setBounds(314, 65, 195, 45);
		milk_panel.add(M_winM_btn);
		M_winM_btn.addActionListener(e -> {
		    Request.prodName = "wintermelon milktea";
		    Request.powder = "milk wintermelon powder";
		    step1 = true;
		});

		JButton M_taro_btn = new JButton("TARO");
		M_taro_btn.setForeground(Color.BLACK);
		M_taro_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_taro_btn.setBorderPainted(false);
		M_taro_btn.setBackground(Color.LIGHT_GRAY);
		M_taro_btn.setBounds(314, 121, 195, 45);
		milk_panel.add(M_taro_btn);
		M_taro_btn.addActionListener(e -> {
		    Request.prodName = "taro milktea";
		    Request.powder = "milk taro powder";
		    step1 = true;
		});

		JButton M_ccake_btn = new JButton("CHEESE CAKE");
		M_ccake_btn.setForeground(Color.BLACK);
		M_ccake_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_ccake_btn.setBorderPainted(false);
		M_ccake_btn.setBackground(Color.LIGHT_GRAY);
		M_ccake_btn.setBounds(314, 177, 195, 45);
		milk_panel.add(M_ccake_btn);
		M_ccake_btn.addActionListener(e -> {
		    Request.prodName = "cheesecake milktea";
		    Request.powder = "milk cheesecake powder";
		    step1 = true;
		});

		JButton M_choco_btn = new JButton("CHOCOLATE");
		M_choco_btn.setForeground(Color.BLACK);
		M_choco_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_choco_btn.setBorderPainted(false);
		M_choco_btn.setBackground(Color.LIGHT_GRAY);
		M_choco_btn.setBounds(109, 233, 195, 45);
		milk_panel.add(M_choco_btn);
		M_choco_btn.addActionListener(e -> {
		    Request.prodName = "chocolate milktea";
		    Request.powder = "milk chocolate powder";
		    step1 = true;
		});

		JButton M_straw_btn = new JButton("STRAWBERRY");
		M_straw_btn.setForeground(Color.BLACK);
		M_straw_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_straw_btn.setBorderPainted(false);
		M_straw_btn.setBackground(Color.LIGHT_GRAY);
		M_straw_btn.setBounds(314, 233, 195, 45);
		milk_panel.add(M_straw_btn);
		M_straw_btn.addActionListener(e -> {
		    Request.prodName = "strawberry milktea";
		    Request.powder = "milk strawberry powder";
		    step1 = true;
		});

		JButton M_ccream_btn = new JButton("COOKIES & CREAM");
		M_ccream_btn.setForeground(Color.BLACK);
		M_ccream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		M_ccream_btn.setBorderPainted(false);
		M_ccream_btn.setBackground(Color.LIGHT_GRAY);
		M_ccream_btn.setBounds(109, 289, 195, 45);
		milk_panel.add(M_ccream_btn);
		M_ccream_btn.addActionListener(e -> {
		    Request.prodName = "cookies n cream milktea";
		    Request.powder = "milk cookies n cream powder";
		    step1 = true;
		});

		
		fruit_panel.setBounds(440, 24, 601, 344);
		contentPane.add(fruit_panel);
		fruit_panel.setLayout(null);
		
		JLabel lblfruit = new JLabel("FRUIT TEA");
		lblfruit.setHorizontalAlignment(SwingConstants.CENTER);
		lblfruit.setFont(new Font("Arial", Font.BOLD, 20));
		lblfruit.setBounds(229, 11, 176, 45);
		fruit_panel.add(lblfruit);
		
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------- fruit tea options btn ------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		
		JButton F_straw_btn = new JButton("STRAWBERRY");
		F_straw_btn.setForeground(Color.BLACK);
		F_straw_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_straw_btn.setBorderPainted(false);
		F_straw_btn.setBackground(Color.LIGHT_GRAY);
		F_straw_btn.setBounds(153, 67, 161, 45);
		fruit_panel.add(F_straw_btn);
		F_straw_btn.addActionListener(e -> {
		    Request.prodName = "strawberry fruit tea";
		    Request.powder = "fruit strawberry powder";
		    step1 = true;
		});

		JButton F_lychee_btn = new JButton("LYCHEE");
		F_lychee_btn.setForeground(Color.BLACK);
		F_lychee_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_lychee_btn.setBorderPainted(false);
		F_lychee_btn.setBackground(Color.LIGHT_GRAY);
		F_lychee_btn.setBounds(327, 67, 161, 45);
		fruit_panel.add(F_lychee_btn);
		F_lychee_btn.addActionListener(e -> {
		    Request.prodName = "lychee fruit tea";
		    Request.powder = "fruit lychee powder";
		    step1 = true;
		});

		JButton F_watermelon_btn = new JButton("WATERMELON");
		F_watermelon_btn.setForeground(Color.BLACK);
		F_watermelon_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_watermelon_btn.setBorderPainted(false);
		F_watermelon_btn.setBackground(Color.LIGHT_GRAY);
		F_watermelon_btn.setBounds(327, 123, 161, 45);
		fruit_panel.add(F_watermelon_btn);
		F_watermelon_btn.addActionListener(e -> {
		    Request.prodName = "watermelon fruit tea";
		    Request.powder = "fruit wintermerlon powder";
		    step1 = true;
		});

		JButton F_blue_btn = new JButton("BLUEBERRY");
		F_blue_btn.setForeground(Color.BLACK);
		F_blue_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_blue_btn.setBorderPainted(false);
		F_blue_btn.setBackground(Color.LIGHT_GRAY);
		F_blue_btn.setBounds(153, 123, 161, 45);
		fruit_panel.add(F_blue_btn);
		F_blue_btn.addActionListener(e -> {
		    Request.prodName = "blueberry fruit tea";
		    Request.powder = "fruit blueberry powder";
		    step1 = true;
		});

		JButton F_orange_btn = new JButton("ORANGE");
		F_orange_btn.setForeground(Color.BLACK);
		F_orange_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_orange_btn.setBorderPainted(false);
		F_orange_btn.setBackground(Color.LIGHT_GRAY);
		F_orange_btn.setBounds(327, 179, 161, 45);
		fruit_panel.add(F_orange_btn);
		F_orange_btn.addActionListener(e -> {
		    Request.prodName = "orange fruit tea";
		    Request.powder = "fruit orange powder";
		    step1 = true;
		});

		JButton F_mango_btn = new JButton("MANGO");
		F_mango_btn.setForeground(Color.BLACK);
		F_mango_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_mango_btn.setBorderPainted(false);
		F_mango_btn.setBackground(Color.LIGHT_GRAY);
		F_mango_btn.setBounds(153, 179, 161, 45);
		fruit_panel.add(F_mango_btn);
		F_mango_btn.addActionListener(e -> {
		    Request.prodName = "mango fruit tea";
		    Request.powder = "fruit mango powder";
		    step1 = true;
		});

		JButton F_gapple_btn = new JButton("GREEN APPLE");
		F_gapple_btn.setForeground(Color.BLACK);
		F_gapple_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_gapple_btn.setBorderPainted(false);
		F_gapple_btn.setBackground(Color.LIGHT_GRAY);
		F_gapple_btn.setBounds(327, 236, 161, 45);
		fruit_panel.add(F_gapple_btn);
		F_gapple_btn.addActionListener(e -> {
		    Request.prodName = "green apple fruit tea";
		    Request.powder = "fruit green apple powder";
		    step1 = true;
		});

		JButton F_grape_btn = new JButton("GRAPES");
		F_grape_btn.setForeground(Color.BLACK);
		F_grape_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_grape_btn.setBorderPainted(false);
		F_grape_btn.setBackground(Color.LIGHT_GRAY);
		F_grape_btn.setBounds(153, 236, 161, 45);
		fruit_panel.add(F_grape_btn);
		F_grape_btn.addActionListener(e -> {
		    Request.prodName = "grapes fruit tea";
		    Request.powder = "fruit grapes powder";
		    step1 = true;
		});

		JButton F_kiwi_btn = new JButton("KIWI");
		F_kiwi_btn.setForeground(Color.BLACK);
		F_kiwi_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_kiwi_btn.setBorderPainted(false);
		F_kiwi_btn.setBackground(Color.LIGHT_GRAY);
		F_kiwi_btn.setBounds(327, 292, 161, 45);
		fruit_panel.add(F_kiwi_btn);
		F_kiwi_btn.addActionListener(e -> {
		    Request.prodName = "kiwi fruit tea";
		    Request.powder = "fruit kiwi powder";
		    step1 = true;
		});

		JButton F_melon_btn = new JButton("MELON");
		F_melon_btn.setForeground(Color.BLACK);
		F_melon_btn.setFont(new Font("Arial", Font.BOLD, 10));
		F_melon_btn.setBorderPainted(false);
		F_melon_btn.setBackground(Color.LIGHT_GRAY);
		F_melon_btn.setBounds(153, 292, 161, 45);
		fruit_panel.add(F_melon_btn);
		F_melon_btn.addActionListener(e -> {
		    Request.prodName = "melon fruit tea";
		    Request.powder = "fruit melon powder";
		    step1 = true;
		});

		
		frappe_panel.setBounds(440, 24, 601, 344);
		contentPane.add(frappe_panel);
		frappe_panel.setLayout(null);
		
		JLabel lblFrappe = new JLabel("FRAPPE");
		lblFrappe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrappe.setFont(new Font("Arial", Font.BOLD, 20));
		lblFrappe.setBounds(229, 11, 176, 45);
		frappe_panel.add(lblFrappe);
		
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------- frappe options btn ---------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		
		JButton FP_cjava_btn = new JButton("CHOCO JAVA");
		FP_cjava_btn.setForeground(Color.BLACK);
		FP_cjava_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_cjava_btn.setBorderPainted(false);
		FP_cjava_btn.setBackground(Color.LIGHT_GRAY);
		FP_cjava_btn.setBounds(146, 82, 147, 37);
		frappe_panel.add(FP_cjava_btn);
		FP_cjava_btn.addActionListener(e -> {
		    Request.prodName = "choco java frappe";
		    Request.powder = "frappe c choco java powder";
		    step1 = true;
		});

		JButton FP_strawcream_btn = new JButton("STRAWBERRY CREAM");
		FP_strawcream_btn.setForeground(Color.BLACK);
		FP_strawcream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_strawcream_btn.setBorderPainted(false);
		FP_strawcream_btn.setBackground(Color.LIGHT_GRAY);
		FP_strawcream_btn.setBounds(334, 82, 147, 37);
		frappe_panel.add(FP_strawcream_btn);
		FP_strawcream_btn.addActionListener(e -> {
		    Request.prodName = "strawberry cream frappe";
		    Request.powder = "frappe nc strawberry cream powder";
		    step1 = true;
		});

		JButton FP_ccake_btn = new JButton("CHEESECAKE CREAM");
		FP_ccake_btn.setForeground(Color.BLACK);
		FP_ccake_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_ccake_btn.setBorderPainted(false);
		FP_ccake_btn.setBackground(Color.LIGHT_GRAY);
		FP_ccake_btn.setBounds(334, 125, 147, 37);
		frappe_panel.add(FP_ccake_btn);
		FP_ccake_btn.addActionListener(e -> {
		    Request.prodName = "cheesecake cream frappe";
		    Request.powder = "frappe nc cheescake cream powder";
		    step1 = true;
		});

		JButton FP_chazel_btn = new JButton("CHOCO HAZELNUT");
		FP_chazel_btn.setForeground(Color.BLACK);
		FP_chazel_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_chazel_btn.setBorderPainted(false);
		FP_chazel_btn.setBackground(Color.LIGHT_GRAY);
		FP_chazel_btn.setBounds(146, 125, 147, 37);
		frappe_panel.add(FP_chazel_btn);
		FP_chazel_btn.addActionListener(e -> {
		    Request.prodName = "choco hazelnut frappe";
		    Request.powder = "frappe c choco hazelnut powder";
		    step1 = true;
		});

		JButton FP_chococream_btn = new JButton("CHOCOLATE CREAM");
		FP_chococream_btn.setForeground(Color.BLACK);
		FP_chococream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_chococream_btn.setBorderPainted(false);
		FP_chococream_btn.setBackground(Color.LIGHT_GRAY);
		FP_chococream_btn.setBounds(334, 167, 147, 37);
		frappe_panel.add(FP_chococream_btn);
		FP_chococream_btn.addActionListener(e -> {
		    Request.prodName = "chocolate cream frappe";
		    Request.powder = "frappe nc chocolate cream powder";
		    step1 = true;
		});

		JButton FP_vcream_btn = new JButton("VANILLA CARAMEL");
		FP_vcream_btn.setForeground(Color.BLACK);
		FP_vcream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_vcream_btn.setBorderPainted(false);
		FP_vcream_btn.setBackground(Color.LIGHT_GRAY);
		FP_vcream_btn.setBounds(146, 167, 147, 37);
		frappe_panel.add(FP_vcream_btn);
		FP_vcream_btn.addActionListener(e -> {
		    Request.prodName = "vanilla caramel frappe";
		    Request.powder = "frappe c vanilla caramel powder";
		    step1 = true;
		});

		JButton FP_scaramel_btn = new JButton("SALTED CARAMEL");
		FP_scaramel_btn.setForeground(Color.BLACK);
		FP_scaramel_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_scaramel_btn.setBorderPainted(false);
		FP_scaramel_btn.setBackground(Color.LIGHT_GRAY);
		FP_scaramel_btn.setBounds(146, 209, 147, 37);
		frappe_panel.add(FP_scaramel_btn);
		FP_scaramel_btn.addActionListener(e -> {
		    Request.prodName = "salted caramel frappe";
		    Request.powder = "frappe c salted caramel powder";
		    step1 = true;
		});

		JButton FP_cookiecream_btn = new JButton("COOKIES & CREAM");
		FP_cookiecream_btn.setForeground(Color.BLACK);
		FP_cookiecream_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_cookiecream_btn.setBorderPainted(false);
		FP_cookiecream_btn.setBackground(Color.LIGHT_GRAY);
		FP_cookiecream_btn.setBounds(334, 209, 147, 37);
		frappe_panel.add(FP_cookiecream_btn);
		FP_cookiecream_btn.addActionListener(e -> {
		    Request.prodName = "cookies & cream frappe";
		    Request.powder = "frappe nc cookies n cream powder";
		    step1 = true;
		});

		JButton FP_gtea_btn = new JButton("GREEN TEA CREAM");
		FP_gtea_btn.setForeground(Color.BLACK);
		FP_gtea_btn.setFont(new Font("Arial", Font.BOLD, 10));
		FP_gtea_btn.setBorderPainted(false);
		FP_gtea_btn.setBackground(Color.LIGHT_GRAY);
		FP_gtea_btn.setBounds(146, 251, 147, 37);
		frappe_panel.add(FP_gtea_btn);
		FP_gtea_btn.addActionListener(e -> {
		    Request.prodName = "green tea cream frappe";
		    Request.powder = "frappe c green tea cream powder";
		    step1 = true;
		});

		JButton FP_taro = new JButton("TARO");
		FP_taro.setForeground(Color.BLACK);
		FP_taro.setFont(new Font("Arial", Font.BOLD, 10));
		FP_taro.setBorderPainted(false);
		FP_taro.setBackground(Color.LIGHT_GRAY);
		FP_taro.setBounds(334, 251, 147, 37);
		frappe_panel.add(FP_taro);
		FP_taro.addActionListener(e -> {
		    Request.prodName = "taro frappe";
		    Request.powder = "frappe nc taro powder";
		    step1 = true;
		});
		
		JLabel lblNewLabel = new JLabel("COFFEE BASED");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(174, 57, 85, 14);
		frappe_panel.add(lblNewLabel);
		
		JLabel lblNonCoffee = new JLabel("NON COFFEE");
		lblNonCoffee.setBounds(370, 57, 75, 14);
		frappe_panel.add(lblNonCoffee);
		
		addon_panel.setBounds(440, 516, 601, 73);
		contentPane.add(addon_panel);
		addon_panel.setLayout(null);
		
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------- addons options btn ---------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		
		JButton AD_pearl = new JButton("PEARL");
		AD_pearl.setForeground(Color.BLACK);
		AD_pearl.setFont(new Font("Arial", Font.BOLD, 10));
		AD_pearl.setBorderPainted(false);
		AD_pearl.setBackground(Color.LIGHT_GRAY);
		AD_pearl.setBounds(97, 17, 77, 45);
		addon_panel.add(AD_pearl);
		AD_pearl.addActionListener(e -> {
		    Request.addons = "pearl";
		    step3 = true;
		    Request.quantity = slider.getValue();
		    Request.addItem();
		});
		
		JButton AD_oreo = new JButton("OREO");
		AD_oreo.setForeground(Color.BLACK);
		AD_oreo.setFont(new Font("Arial", Font.BOLD, 10));
		AD_oreo.setBorderPainted(false);
		AD_oreo.setBackground(Color.LIGHT_GRAY);
		AD_oreo.setBounds(184, 17, 71, 45);
		addon_panel.add(AD_oreo);
		AD_oreo.addActionListener(e -> {
		    Request.addons = "oreo";
		    step3 = true;
		    Request.quantity = slider.getValue();
		    Request.addItem();
		});
		
		JButton AD_nata = new JButton("NATA");
		AD_nata.setForeground(Color.BLACK);
		AD_nata.setFont(new Font("Arial", Font.BOLD, 10));
		AD_nata.setBorderPainted(false);
		AD_nata.setBackground(Color.LIGHT_GRAY);
		AD_nata.setBounds(265, 17, 63, 45);
		addon_panel.add(AD_nata);
		AD_nata.addActionListener(e -> {
		    Request.addons = "nata";
		    step3 = true;
		    Request.quantity = slider.getValue();
		    Request.addItem();
		});
		
		JButton AD_cjelly = new JButton("COFFEE JELLY");
		AD_cjelly.setForeground(Color.BLACK);
		AD_cjelly.setFont(new Font("Arial", Font.BOLD, 10));
		AD_cjelly.setBorderPainted(false);
		AD_cjelly.setBackground(Color.LIGHT_GRAY);
		AD_cjelly.setBounds(338, 17, 112, 45);
		addon_panel.add(AD_cjelly);
		AD_cjelly.addActionListener(e -> {
		    Request.addons = "coffee jelly";
		    step3 = true;
		    Request.quantity = slider.getValue();
		    Request.addItem();
		});
		
		JButton AD_fjelly = new JButton("FRUIT JELLY");
		AD_fjelly.setForeground(Color.BLACK);
		AD_fjelly.setFont(new Font("Arial", Font.BOLD, 10));
		AD_fjelly.setBorderPainted(false);
		AD_fjelly.setBackground(Color.LIGHT_GRAY);
		AD_fjelly.setBounds(460, 17, 131, 45);
		addon_panel.add(AD_fjelly);
		AD_fjelly.addActionListener(e -> {
		    Request.addons = "fruit jelly";
		    step3 = true;
		    Request.quantity = slider.getValue();
		    Request.addItem();
		});
		
		JButton AD_none = new JButton("NONE");
		AD_none.setForeground(Color.BLACK);
		AD_none.setFont(new Font("Arial", Font.BOLD, 10));
		AD_none.setBorderPainted(false);
		AD_none.setBackground(Color.LIGHT_GRAY);
		AD_none.setBounds(10, 17, 77, 45);
		addon_panel.add(AD_none);
		AD_none.addActionListener(e -> {
		    Request.addons = "no addons";
		    step3 = true;
		    Request.quantity = slider.getValue();
		    Request.addItem();
		});
		
		order_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        order_panel.setBackground(new Color(255, 255, 255));
        order_panel.setBounds(10, 165, 416, 380);
        contentPane.add(order_panel);
        order_panel.setLayout(null);

        JLabel orderlbl = new JLabel("ORDER");
        orderlbl.setBounds(10, 11, 82, 24);
        orderlbl.setFont(new Font("Arial", Font.BOLD, 20));
        order_panel.add(orderlbl);

        
        orderList.setBounds(10, 46, 396, 249);
        order_panel.add(orderList);

        JScrollPane scrollPane = new JScrollPane(orderList);
        scrollPane.setBounds(10, 46, 396, 249);
        order_panel.add(scrollPane);

//        orderList.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2) {
//                    int selectedIndex = orderList.getSelectedIndex();
//                    if (selectedIndex != -1) {
//                        orderListModel.remove(selectedIndex);
//                        Request.orderList.remove(selectedIndex);
//                    }
//                }
//            }
//        });

		
		JButton checkout_btn = new JButton("CHECKOUT");
		checkout_btn.setForeground(Color.BLACK);
		checkout_btn.setFont(new Font("Arial", Font.BOLD, 10));
		checkout_btn.setBorderPainted(false);
		checkout_btn.setBackground(Color.LIGHT_GRAY);
		checkout_btn.setBounds(303, 324, 89, 45);
		order_panel.add(checkout_btn);
		checkout_btn.addActionListener(e -> {
			
			Request.insertSalesData(orderListModel, totalPrice);

			orderListModel.clear();
			Request.updateDB();
			Request.orderList.clear();
			total_pricelbl.setText("0");
		});
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotal.setBounds(10, 322, 82, 42);
		order_panel.add(lblTotal);
		
		JButton clear_btn = new JButton("CLEAR");
		clear_btn.setForeground(Color.BLACK);
		clear_btn.setFont(new Font("Arial", Font.BOLD, 10));
		clear_btn.setBorderPainted(false);
		clear_btn.setBackground(Color.LIGHT_GRAY);
		clear_btn.setBounds(204, 324, 89, 45);
		order_panel.add(clear_btn);
		
		total_pricelbl.setFont(new Font("Arial", Font.PLAIN, 16));
		total_pricelbl.setBounds(94, 322, 82, 42);
		order_panel.add(total_pricelbl);
		clear_btn.addActionListener(e -> {
			orderListModel.clear();
			Request.orderList.clear();
			total_pricelbl.setText(0+"");
		});
		
		size_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		size_panel.setBackground(new Color(240, 240, 240));
		size_panel.setBounds(440, 379, 601, 57);
		contentPane.add(size_panel);
		size_panel.setLayout(null);
		
		JLabel sizzelb = new JLabel("SIZE");
		sizzelb.setFont(new Font("Arial", Font.BOLD, 17));
		sizzelb.setHorizontalAlignment(SwingConstants.CENTER);
		sizzelb.setBounds(10, 11, 64, 35);
		size_panel.add(sizzelb);
		
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------- size options btn ------------------------------------------------------------------------------------------------------>
		// --------------------------------------------------------------------------------------------------------------------------------->
		// --------------------------------------------------------------------------------------------------------------------------------->
		
		JButton small_btn = new JButton("SMALL");
		small_btn.addActionListener(e -> {
			Request.unit_size = "small";
			step2 = true;
		});
		small_btn.setForeground(Color.BLACK);
		small_btn.setFont(new Font("Arial", Font.BOLD, 10));
		small_btn.setBorderPainted(false);
		small_btn.setBackground(Color.LIGHT_GRAY);
		small_btn.setBounds(87, 13, 112, 35);
		size_panel.add(small_btn);
		
		JButton mid_btn = new JButton("MEDIUM");
		mid_btn.setForeground(Color.BLACK);
		mid_btn.setFont(new Font("Arial", Font.BOLD, 10));
		mid_btn.setBorderPainted(false);
		mid_btn.setBackground(Color.LIGHT_GRAY);
		mid_btn.setBounds(209, 11, 112, 35);
		size_panel.add(mid_btn);
		mid_btn.addActionListener(e -> {
			Request.unit_size = "medium";
			step2 = true;
		});
		
		JButton large_btn = new JButton("LARGE");
		large_btn.setForeground(Color.BLACK);
		large_btn.setFont(new Font("Arial", Font.BOLD, 10));
		large_btn.setBorderPainted(false);
		large_btn.setBackground(Color.LIGHT_GRAY);
		large_btn.setBounds(331, 11, 112, 35);
		size_panel.add(large_btn);
		
		qty_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		qty_panel.setBounds(440, 447, 601, 58);
		contentPane.add(qty_panel);
		qty_panel.setLayout(null);
		
		JLabel qtylbl = new JLabel("QTY");
		qtylbl.setBounds(10, 11, 35, 36);
		qtylbl.setHorizontalAlignment(SwingConstants.CENTER);
		qtylbl.setFont(new Font("Arial", Font.BOLD, 17));
		qty_panel.add(qtylbl);
		
		
		slider.setMaximum(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setValue(1);
		slider.setMinimum(1);
		slider.setBounds(55, 20, 474, 36);
		qty_panel.add(slider);
		
		JLabel valueLabel = new JLabel("1");
		valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		valueLabel.setFont(new Font("Arial", Font.BOLD, 17));
		valueLabel.setBounds(544, 11, 35, 36);
		qty_panel.add(valueLabel);
		large_btn.addActionListener(e -> {
			Request.unit_size = "large";
			step2 = true;
		});
		
		slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                valueLabel.setText(String.valueOf(value));
            }
        });
		
	}
}
