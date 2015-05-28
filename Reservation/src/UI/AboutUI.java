package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AboutUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AboutUI() {
		setTitle("\u5173\u4E8E\u7CFB\u7EDF");
		setBounds(100, 100, 562, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel.setBounds(141, 141, 292, 59);
		contentPane.add(lblNewLabel);
	}
}
