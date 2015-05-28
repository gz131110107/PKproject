package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;



import Control.ReservationControl;
import Control.TableControl;
import Model.Table;
import Model.Reservation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ReservationSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable jtable;
	private JButton button;
	private JLabel jlabel;
	private JComboBox  comboBox;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ReservationSearch(JTable table,JLabel templabel) {
		jlabel = templabel;
		setLocationRelativeTo(null);
        jtable = table;
		setTitle("\u67E5\u8BE2\u9884\u8BA2\u4FE1\u606F");
		
		setBounds(100, 100, 468, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		comboBox = new JComboBox();
		comboBox.setBounds(174, 74, 129, 21);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int option = comboBox.getSelectedIndex();
				switch(option)
				{
				case 0:
					textField.setEnabled(true);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					break;
				case 1:
					textField.setEnabled(false);
					textField_1.setEnabled(true);
					textField_2.setEnabled(false);
					break;
				case 2:
					textField.setEnabled(false);
					textField_1.setEnabled(false);
					textField_2.setEnabled(true);
					break;
				default:
					break;
						
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"按预订姓名", "预订电话", "预订桌位"}));
		contentPane.add(comboBox);

		
		textField = new JTextField();
		textField.setBounds(174, 139, 143, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 190, 143, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	
		
		JLabel lblNewLabel = new JLabel("\u67E5\u627E\u6761\u4EF6\uFF1A");
		lblNewLabel.setBounds(81, 77, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label.setBounds(81, 193, 54, 15);
		contentPane.add(label);
		
		JLabel lblid = new JLabel("\u9884\u8BA2\u4EBA\uFF1A");
		lblid.setBounds(81, 142, 54, 15);
		contentPane.add(lblid);
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		lblNewLabel_1.setBounds(81, 249, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = comboBox.getSelectedIndex();
				List list;
				switch(option)
				{
				case -1:
				case 0:
					if(textField.getText().equals(""))
					{
						JOptionPane.showConfirmDialog(null, "预订姓名不能为空","提示:", JOptionPane.CLOSED_OPTION);
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
					
					Reservation reservation = (Reservation) ReservationControl.getcontrol().findByName(name).get(0);
					
					if(reservation==null)
					{
						JOptionPane.showConfirmDialog(null, "你所查找的会员信息不存在","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					list = new ArrayList();
					list.add(reservation);
					showSearchResult(list,jtable,jlabel);
					break;
				
				case 1:
					if(textField_1.getText().equals(""))
					{
						JOptionPane.showConfirmDialog(null, "预订电话不能为空","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					try
					{
						if(textField_1.getText().length()!=11)
							throw new Exception();
						
					}
					catch(Exception b)
					{
						JOptionPane.showConfirmDialog(null, "请输入11位手机号","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					String telnum = textField_1.getText();
					list = ReservationControl.getcontrol().findByTelnum(telnum);
					if(list.size()==0)
					{
						JOptionPane.showConfirmDialog(null, "你所查找的预订信息不存在","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					showSearchResult(list,jtable,jlabel);
					break;
				case 2:
					if(textField_2.getText().equals(""))
					{
						JOptionPane.showConfirmDialog(null, "房间号不能为空","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					try
					{
						if(textField_2.getText().length()<0||textField_2.getText().length()>100)
							throw new Exception();
						
					}
					catch(Exception b)
					{
						JOptionPane.showConfirmDialog(null, "请输入正确的房间号","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					String tablenum = textField_2.getText();
					list = ReservationControl.getcontrol().findByTablenum(tablenum);
						if(list.size()==0)
						{
							JOptionPane.showConfirmDialog(null, "你所查找的预订信息不存在","提示:", JOptionPane.CLOSED_OPTION);
							return;
						}
						showSearchResult(list,jtable,jlabel);
						break;
				default:
					break;
						
				}
				dispose();
				
			}
			
		});
		btnNewButton.setBounds(111, 324, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(258, 324, 93, 23);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 246, 143, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
	
	public void showSearchResult(List list,JTable table,JLabel label)
	{
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    Reservation reservation=null;
	    String [] record = new  String[4];
	    for(int i=0;i<list.size();i++)
	    {
	    	reservation = (Reservation)list.get(i);
	    	record[0]=reservation.getName();
	    	record[1]=reservation.getTelnumber();
	    	record[2]=reservation.getTablenum();
	    	record[3]=reservation.getRetime();
	    	tableModel.addRow(record);
	    	
	    }
	    table.invalidate();
	    label.setText("查找结果");
	}
	
	

}
