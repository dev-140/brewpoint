package brewpoint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Size extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static double small, medium, large;

	/**
	 * Launch the application.
	 */
	static Size frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Size();
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
	public Size() {
		setTitle("Size");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECT SIZE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(155, 11, 131, 28);
		contentPane.add(lblNewLabel);
		
		JLabel smallP = new JLabel(small+"");
		smallP.setHorizontalAlignment(SwingConstants.CENTER);
		smallP.setBounds(56, 157, 46, 14);
		contentPane.add(smallP);
		
		JLabel midP = new JLabel(medium+"");
		midP.setHorizontalAlignment(SwingConstants.CENTER);
		midP.setBounds(189, 157, 46, 14);
		contentPane.add(midP);
		
		JLabel largeP = new JLabel(large+"");
		largeP.setHorizontalAlignment(SwingConstants.CENTER);
		largeP.setBounds(337, 157, 46, 14);
		contentPane.add(largeP);
		
		JButton smallBtn = new JButton("SMALL");
		smallBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Request.unit_price = small;
				Request.unit_size = "Small";
				Main.step2 = true;
				frame.dispose();
			}
		});
		smallBtn.setBackground(new Color(192, 192, 192));
		smallBtn.setBounds(33, 123, 89, 23);
		contentPane.add(smallBtn);
		
		JButton midBtn = new JButton("MEDIUM");
		midBtn.setBackground(new Color(192, 192, 192));
		midBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Request.unit_price = medium;
				Request.unit_size = "Medium";
				Main.step2 = true;
				frame.dispose();
			}
		});
		midBtn.setBounds(167, 122, 89, 23);
		contentPane.add(midBtn);
		
		JButton largeBtn = new JButton("LARGE");
		largeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Request.unit_price = large;
				Request.unit_size = "Large";
				Main.step2 = true;
				frame.dispose();
			}
		});
		largeBtn.setBackground(new Color(192, 192, 192));
		largeBtn.setBounds(310, 123, 89, 23);
		contentPane.add(largeBtn);
	}
}
