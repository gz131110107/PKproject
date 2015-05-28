package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import Control.ReservationControl;
import Model.Reservation;
import Control.TableControl;
import Model.Table;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddReservation extends JFrame {

	private JPanel contentPane;
	private JTable jtable;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private int tableNum =0;
	private List list;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddReservation(JTable table) {
		
		this.jtable = table;
		setTitle("添加预订");
		setLocationRelativeTo(null);
		setBounds(100, 100, 458, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(57, 72, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		lblNewLabel_3.setBounds(57, 170, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 118, 66, 21);
		contentPane.add(comboBox);
		
		tableNum = Integer
				.valueOf(TableControl.getcontrol().fIndTableByFlag(0).size());
		list = TableControl.getcontrol().fIndTableByFlag(0);
		for (int i = 0; i < tableNum; i++)
		{
			Table table_1=(Table)list.get(i);
			comboBox.addItem(table_1.getTid());
		} 
		
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(276, 320, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "预订人姓名不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				try
				{
					if(textField.getText().length()>20)
						throw new Exception();
					
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "预订人姓名应少于10个汉字或20个英文字符","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				String name = textField.getText();
				
				
				
				String tablenum=comboBox.getSelectedItem().toString();
				
				
				Table table_2=TableControl.getcontrol().findById(comboBox.getSelectedItem().toString());

				table_2.setReFlag(1);
			
				TableControl.getcontrol().update(table_2);
			
				
				
				String tel;
				if(textField_2.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "预订电话不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				try
				{
					if(textField_2.getText().length()!=11)
						throw new Exception();
					Long.parseLong(textField_2.getText());
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "手机号码只能为11位数字","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				tel=textField_2.getText();
				
				
				
				if(textField_3.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "预订时间不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				/*try
				{
					if(textField_3.getText().length()==0)
						throw new Exception();
					Long.parseLong(textField_3.getText());
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "请填写详细时间","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}*/
				String time=textField_3.getText();
				
				
				
				Reservation reservation =new Reservation(name,tel,tablenum,time);
				
				if(!ReservationControl.getcontrol().save(reservation))
				{
					JOptionPane.showConfirmDialog(null, "您要添加的预订已存在,请重新输入。","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				    
				JOptionPane.showConfirmDialog(null, "添加成功","提示:", JOptionPane.CLOSED_OPTION);
				ReservationManage.showallvips(jtable);
				dispose();
			}
	
		});
		btnNewButton.setBounds(109, 320, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblVipid = new JLabel("\u9884\u8BA2\u684C\u53F7");
		lblVipid.setBounds(57, 121, 54, 15);
		contentPane.add(lblVipid);
		
		JLabel lblNewLabel_4 = new JLabel("\u9884\u5B9A\u65F6\u95F4");
		lblNewLabel_4.setBounds(57, 220, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(150, 69, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 167, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 217, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
	}

}
