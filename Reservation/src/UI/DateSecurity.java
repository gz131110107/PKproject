package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import org.hibernate.cfg.Configuration;

import Control.DateControl;
import Factory.HibernateSessionFactory;

import java.awt.Font;
import java.io.File;

public class DateSecurity extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField hotel_13;
	private int Result;

	/**
	 * Create the dialog.
	 */
	public DateSecurity() {
		setBounds(100, 100, 468, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(139, 88, 194, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("\u6240\u9009\u8DEF\u5F84");
		lblNewLabel.setBounds(51, 91, 54, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u636E\u5E93\u5907\u4EFD");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(161, 23, 134, 15);
		contentPanel.add(lblNewLabel_1);
		{
			final JButton okButton = new JButton("\u786E\u5B9A");
			okButton.setBounds(338, 205, 67, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				private String pwd;

				public void actionPerformed(ActionEvent e) {
					 Configuration config = HibernateSessionFactory.getConfiguration();  
		    	     String binPath = config.getProperty("C:/Program Files/MySQL/MySQL Server 5.6/bin");  
		    	     String userName = config.getProperty("root");  
		    	     String pwd = config.getProperty("123456"); 
		    	     Control.DateControl bak = new Control.DateControl(binPath,userName, pwd);
		    	       Result = Control.DateControl.backup(textField.getText(),"hotel_13");
		    	       //bak.backup("D:/newdata.sql", "host_13"); 
		    	       //logonResult=Service.Loginservice.getUserRoll(usrNameField.getText()); 
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				textField.setText(file.getAbsolutePath() + "\\back.sql");
				}
			}
		});
		btnNewButton.setBounds(347, 88, 41, 21);
		contentPanel.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}