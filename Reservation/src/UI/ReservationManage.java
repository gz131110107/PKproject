package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JLabel;

import Control.ReservationControl;
import Control.TableControl;
import Model.Table;
import Model.Reservation;


public class ReservationManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel Label;


	/**
	 * Create the frame.
	 */
	public ReservationManage() {

		setTitle("会员管理");
		setBounds(100, 100, 875, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(197, 59, 627, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"预订人", "联系方式", "预订桌位", "预订到达时间"
			}
		));
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		showallvips(table);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u9884\u8BA2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					AddReservation frame = new AddReservation(table);
					frame.setVisible(true);
					
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(36, 62, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改信息");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				int rows = table.getSelectedRowCount();
				if(rows==0)
				{
					JOptionPane.showConfirmDialog(null, "请选择要修改的会员信息","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
                if(rows>1)
                {
                	JOptionPane.showConfirmDialog(null, "一次只能修改一位会员的信息","提示:", JOptionPane.CLOSED_OPTION);
					return;
                }
                int row  = table.getSelectedRow();
                
                Reservation reservation = (Reservation) ReservationControl.getcontrol().findByTablenum((String)tableModel.getValueAt(row,2)).get(0);

                try {
                	ModifyVReservation frame = new ModifyVReservation(table,reservation);
                	frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(36, 123, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u53D6\u6D88\u9884\u8BA2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				int rows = table.getSelectedRowCount();
				if(rows==0)
				{
					JOptionPane.showConfirmDialog(null, "请选择要删除的预订信息","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
                if(rows>1)
                {
                	JOptionPane.showConfirmDialog(null, "一次只能删除一位预订的信息","提示:", JOptionPane.CLOSED_OPTION);
					return;
                }
                int res= JOptionPane.showConfirmDialog(null,"确定要删除该预订信息吗?","确认删除",JOptionPane.YES_NO_OPTION,
                	     JOptionPane.WARNING_MESSAGE);
                if(res==JOptionPane.OK_OPTION)
                {
                    int row  = table.getSelectedRow();
                    
                   Reservation reservation = (Reservation) ReservationControl.getcontrol().findByTablenum(tableModel.getValueAt(row,2).toString()).get(0);
                   Table table_4 = TableControl.getcontrol().findById(reservation.getTablenum());
                   table_4.setReFlag(0);
                   ReservationControl.getcontrol().delete(reservation);
                   showallvips(table);
                }
				
				
			}
		});
		btnNewButton_2.setBounds(36, 178, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("查找预订");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReservationSearch search = new ReservationSearch(table,Label);
				search.setVisible(true);
				
				
			}
		});
		btnNewButton_3.setBounds(36, 234, 93, 23);
		contentPane.add(btnNewButton_3);
		Label = new JLabel("全部预订");
		Label.setBounds(197, 20, 79, 15);
		contentPane.add(Label);
		
		
		JButton btnNewButton_4 = new JButton("显示全部");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Label.setText("全部会员信息");
				showallvips(table);
			}
		});
		btnNewButton_4.setBounds(36, 289, 93, 23);
		contentPane.add(btnNewButton_4);
		
		
		
	}
	public static void showallvips(JTable table)
	{
		List list=ReservationControl.getcontrol().findAll();
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    Reservation reservation=null;
	    String [] record = new  String[4];
	    for(int i=0;i<list.size();i++)
	    {
	    	reservation = (Reservation) list.get(i);
	    	record[0]=reservation.getName();
	    	record[1]=reservation.getTelnumber();
	    	record[2]=reservation.getTablenum();
	    	record[3]=reservation.getRetime();
	    	
	    	tableModel.addRow(record);
	    	
	    }
	    table.invalidate();
	}
}
