package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Label;
import java.awt.Button;

import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

import java.awt.Panel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JLabel;









import Control.ConsumeControl;
import Control.MenuControl;
import Model.Consume;
import Model.Menu;
import Model.Reservation;
import Model.Table;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class ConsumeUI extends JFrame {

	private Consume consume;
	private JPanel contentPane;
	private JTable table;
	private JTable table_3;
	static DefaultTableModel tableModel;

	private Table tableeat;
	private Reservation reservation;

	List list = MenuControl.getcontrol().findAll();
	
	/**
	 * Create the frame.
	 */
	public ConsumeUI(Table T, Reservation r) {
		setTitle("\u70B9\u9910");

		this.tableeat = T;
		this.reservation = r;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 255));
		panel_3.setBackground(new Color(240, 230, 140));
		panel_3.setBounds(10, 10, 381, 418);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 120, 381, 298);
		panel_3.add(tabbedPane);
		tabbedPane.setBackground(new Color(85, 107, 47));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 61, 139));
		panel.setForeground(Color.RED);
		tabbedPane.addTab("热菜", null, panel, null);
		tabbedPane.setBackgroundAt(0, new Color(50, 205, 50));
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setBounds(0, 0, 376, 272);
		panel.add(scrollPane);

		table = new JTable(tableModel) {
			/**
											 * 
											 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}// 表格不允许被编辑

		};
		table.setBackground(Color.WHITE);

		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"\u7F16\u53F7", "\u540D\u79F0", "\u5355\u4EF7" }) {
			Class[] columnTypes = new Class[] { String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JLabel lblNewLabel_1 = new JLabel("菜品清单");
		lblNewLabel_1.setBounds(135, 0, 93, 37);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JLabel label = new JLabel("顾客姓名：");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setBounds(10, 37, 93, 37);
		panel_3.add(label);

		JLabel label_Name = new JLabel(reservation.getName());
		label_Name.setForeground(Color.BLUE);
		label_Name.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_Name.setBounds(89, 37, 93, 37);
		panel_3.add(label_Name);

		JLabel label_1 = new JLabel("联系方式：");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(10, 73, 93, 37);
		panel_3.add(label_1);

		JLabel label_ID = new JLabel(reservation.getTelnumber());
		label_ID.setForeground(Color.BLUE);
		label_ID.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_ID.setBounds(89, 73, 224, 37);

		panel_3.add(label_ID);

		// JButton btnNewButton = new JButton("读取数据库");
		// btnNewButton.setBounds(156, 77, 215, 39);
		// panel_3.add(btnNewButton);

		DefaultTableModel table0 = (DefaultTableModel) table.getModel();
		Menu menu = new  Menu();
		for (int i = 0; i < list.size(); i++) {

			menu = (Menu) list.get(i);



				table0.addRow(new Object[] { menu.getMid(),
						menu.getMname(), menu.getMprice().toString() });

		}

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(238, 232, 170));
		panel_4.setBounds(401, 10, 385, 418);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();

		scrollPane_3.setBounds(0, 41, 385, 294);
		panel_4.add(scrollPane_3);

		table_3 = new JTable(tableModel) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}// 表格不允许被编辑

		};

		table_3.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"菜品编号", "\u540D\u79F0", "\u5355\u4EF7", "\u6570\u91CF"}) {
			Class[] columnTypes = new Class[] { String.class, String.class,
					String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_3.setViewportView(table_3);

		JLabel lblNewLabel = new JLabel("菜单");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(204, 0, 71, 31);
		panel_4.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("确定");

		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_2.setBackground(new Color(175, 238, 238));
		btnNewButton_2.setBounds(58, 360, 93, 31);
		panel_4.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1.setBackground(new Color(175, 238, 238));
		btnNewButton_1.setBounds(247, 360, 93, 31);
		panel_4.add(btnNewButton_1);

		JLabel label_room = new JLabel("第"+tableeat.getTid()+"号桌");
		label_room.setForeground(Color.BLUE);
		label_room.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_room.setBounds(90, 0, 104, 31);
		panel_4.add(label_room);

		table.addMouseListener(new MouseAdapter() { // 双击table0添加一行到table3

			public void mouseClicked(MouseEvent e) {

				String[] s = new String[3];

				DefaultTableModel table3 = (DefaultTableModel) table_3
						.getModel();
				if (e.getClickCount() > 1) {

					int rowI = table.rowAtPoint(e.getPoint());// 得到table的行号
					table3.addRow(new Object[] {
							table.getModel().getValueAt(rowI, 0),
							table.getModel().getValueAt(rowI, 1),
							table.getModel().getValueAt(rowI, 2)

							, "1", table.getModel().getValueAt(rowI, 2) });

					System.out.println("双击鼠标 "
							+ table.getModel().getValueAt(rowI, 0));
				}
				// System.out.println();

			}
		});

		table_3.addMouseListener(new MouseAdapter() { // 双击删除一行
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() > 1) {

					DefaultTableModel table3 = (DefaultTableModel) table_3
							.getModel();

					int rowI = table_3.rowAtPoint(e.getPoint());// 得到table的行号

					table3.removeRow(rowI);

				}

			}
		});

		btnNewButton_2.addActionListener(new ActionListener() { // 点击确定
					@SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent e) {

						DefaultTableModel table3 = (DefaultTableModel) table_3
								.getModel();
						int rowCount = table3.getRowCount();

						Date date = new Date();
						SimpleDateFormat df1 = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						String time = df1.format(date);
						Timestamp ts2 = Timestamp.valueOf(time);
						int menuID;
						Menu menu = null;
						for (int i = 0; i < rowCount; i++) {
							menuID = (int) table3.getValueAt(i, 0);
							menu = MenuControl.getcontrol().findById(menuID);
							Consume cs = new Consume(reservation.getName(),menu.getMname(), menu.getMprice());
							ConsumeControl.getcontrol().save(cs);
						}
 
						JOptionPane j=new JOptionPane();
						if (rowCount > 0) {
							j.showMessageDialog(null, "点单成功！", "提示:",
									JOptionPane.CLOSED_OPTION);
						}
						else
						{
				
							j.showMessageDialog(null, "请选择菜品！", "提示:",
									JOptionPane.CLOSED_OPTION);
						
						}
						
						

						table3.getDataVector().clear(); // 清除表格数据
						table_3.updateUI();// 刷新表格
					}
				});

		btnNewButton_1.addActionListener(new ActionListener() {// 点击取消
					public void actionPerformed(ActionEvent e) {

						dispose();
					}
				});
		setLocationRelativeTo(null);
	}
}