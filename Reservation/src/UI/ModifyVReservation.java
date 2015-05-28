package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.ConsumeControl;
import Control.ReservationControl;
import Control.TableControl;
import Model.Consume;
import Model.Table;
import Model.Reservation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ModifyVReservation extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private Reservation reservationinfo;
	
	private JTable jtable;
	private int tableNum =0;
	private List list;
	private String RetableNum;
	private String Oldname;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ModifyVReservation(JTable table,Reservation reservation) {
		setTitle("\u4FEE\u6539\u9884\u8BA2\u4FE1\u606F");
		jtable=table;
		reservationinfo= reservation;
		Oldname=reservationinfo.getName();
		RetableNum = reservationinfo.getTablenum();
		
		setBounds(100, 100, 452, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 69, 81, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 161, 98, 21);
		contentPane.add(comboBox);
		setLocationRelativeTo(null);
		
		tableNum = Integer
				.valueOf(TableControl.getcontrol().fIndTableByFlag(0).size());
		list = TableControl.getcontrol().fIndTableByFlag(0);
		for (int i = 0; i < tableNum; i++)
		{
			Table table_1=(Table)list.get(i);
			comboBox.addItem(table_1.getTid());
		} 
		comboBox.addItem(RetableNum);
		
		comboBox.setSelectedItem(RetableNum);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 100, 193, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblVipid = new JLabel("\u9910\u684C\u53F7");
		lblVipid.setBounds(57, 164, 54, 15);
		contentPane.add(lblVipid);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 208, 98, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("\u9884\u5B9A\u65F6\u95F4");
		label.setBounds(57, 211, 54, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(57, 72, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		lblNewLabel_3.setBounds(57, 108, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(269, 305, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_1.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "预订姓名不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				try
				{
					if(textField_2.getText().length()>20)
						throw new Exception();
					
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "预订者姓名应少于10个汉字或20个英文字符","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				
				reservationinfo.setName(textField_1.getText());
				
				
				
				if(textField_2.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "预订电话不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				try
				{
					if(textField_2.getText().length()==0)
						throw new Exception();
					Long.parseLong(textField_2.getText());
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "手机号码只能为11位数字","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				reservationinfo.setTelnumber(textField_2.getText());
				
				
				
				if(textField_4.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "预定时间不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				/*try
				{
					if(textField_4.getText().length()==0)
						throw new Exception();
					Long.parseLong(textField_4.getText());
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "填写准确时间","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}*/
				reservationinfo.setRetime(textField_4.getText());
				List list=ConsumeControl.getcontrol().findByCName(Oldname);
				for(int k =0;k<list.size();k++)
				{
					 Consume consumeinfo=(Consume) list.get(k);
					 consumeinfo.setCname(textField_1.getText());
					 ConsumeControl.getcontrol().update(consumeinfo);
					 System.out.println(Oldname);
				}
				if(!RetableNum.equals(comboBox.getSelectedItem())){
				reservationinfo.setTablenum(comboBox.getSelectedItem().toString());
				Table table_2=TableControl.getcontrol().findById(comboBox.getSelectedItem().toString());
				Table table_3=TableControl.getcontrol().findById(RetableNum);
				table_2.setReFlag(1);
				table_3.setReFlag(0);
				TableControl.getcontrol().update(table_2);
				TableControl.getcontrol().update(table_3);
				
			
				
				}
				if(!ReservationControl.getcontrol().update(reservationinfo))
				{
					JOptionPane.showConfirmDialog(null, "您要修改的预订信息有误,请重新输入。","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				    
				JOptionPane.showConfirmDialog(null, "修改成功","提示:", JOptionPane.CLOSED_OPTION);
				ReservationManage.showallvips(jtable);
				dispose();
				
				
			}
		});
		btnNewButton.setBounds(93, 305, 93, 23);
		contentPane.add(btnNewButton);
		textField_1.setText(reservationinfo.getName());
		
		
		textField_2.setText(reservationinfo.getTelnumber());
		textField_4.setText(reservationinfo.getRetime());
		
		
	}
}
