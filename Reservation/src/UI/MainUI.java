package UI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;




import Control.ConsumeControl;
import Control.ReservationControl;
import Control.TableControl;
import Model.Table;
import Model.Reservation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Timer;
import java.util.TimerTask;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private int standardNum;
	private int compartmentNum;
	private int x, px, bx, ox;
	private int y, py, by, oy;
	private String tableNum, firstRoomNum, lastRoomNum;
	private Timer timer;
	String tablenum ;
	Table tableeat;
	Reservation reservation;
	
	private String order[][];
	private String ConsumeTotal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true); 
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
           
         javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setFont(new Font("Andalus", Font.PLAIN, 14));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u9910\u9986\u9884\u8BA2\u7CFB\u7EDF");
		
		JFrame.setDefaultLookAndFeelDecorated(true); 
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
           
         javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		standardNum = Integer
				.valueOf(TableControl.getcontrol().fIndTableByType(0).size());
		compartmentNum = Integer
				.valueOf(TableControl.getcontrol().fIndTableByType(1).size());
		
	
		setBounds(100, 100, 943, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(620, 148, 270, 341);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 165, 270, 176);
		panel_1.add(scrollPane_3);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"消费单号", "消费顾客", "\u83DC\u54C1\u540D", "\u83DC\u54C1\u5355\u4EF7"
			}
		));
		scrollPane_3.setViewportView(table_1);
		
		final JLabel lblNewLabel = new JLabel("桌位号：");
		lblNewLabel.setBounds(28, 23, 63, 15);
		panel_1.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("预订人：");
		lblNewLabel_1.setBounds(28, 48, 63, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("联系方式：");
		lblNewLabel_2.setBounds(28, 73, 73, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("到达时间：");
		lblNewLabel_3.setBounds(28, 98, 73, 15);
		panel_1.add(lblNewLabel_3);
		
		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(113, 23, 70, 15);
		panel_1.add(lblNewLabel_4);
		
		final JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(111, 48, 72, 15);
		panel_1.add(lblNewLabel_5);
		
		final JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(111, 73, 112, 15);
		panel_1.add(lblNewLabel_6);
		
		final JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(111, 98, 126, 15);
		panel_1.add(lblNewLabel_7);
		
		JLabel label = new JLabel("\u6D88\u8D39\u91D1\u989D\uFF1A");
		label.setBounds(28, 123, 73, 15);
		panel_1.add(label);
		
		final JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(113, 123, 70, 15);
		panel_1.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 36, 881, 90);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("预订管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*if(tableeat==null)
		    	{
		    		JOptionPane.showConfirmDialog(null, "请选择要增加消费的房间","提示:", JOptionPane.CLOSED_OPTION);
				    return;
		    	}
		    	if(reservation==null)
		    	{	
		    		JOptionPane.showConfirmDialog(null, "您选择的房间无人入住,不能增加消费","提示:", JOptionPane.CLOSED_OPTION);
				    return;
		    	}*/
		    	ReservationManage consumeGUI = new ReservationManage();
		    	consumeGUI.setVisible(true);
				
				
				
			}
			
		});
		btnNewButton.setBounds(31, 21, 93, 42);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("订餐管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tableNum==null||tableeat==null)
		    	{
		    		JOptionPane.showConfirmDialog(null, "请选择要增加点单的桌位","提示:", JOptionPane.CLOSED_OPTION);
				    return;
		    	}
		    	if(reservation==null)
		    	{	
		    		JOptionPane.showConfirmDialog(null, "您选择的桌位无人预订,不能点单","提示:", JOptionPane.CLOSED_OPTION);
				    return;
		    	}
		    	ConsumeUI consumeGUI = new ConsumeUI(tableeat,reservation);
		    	consumeGUI.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(147, 21, 93, 42);
		panel_2.add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(46, 148, 548, 341);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("   大厅    ", null, scrollPane, null);
		
		final JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		
		
		
		final JButton btnNewButtonStandard[] = new JButton[standardNum];
		
		int tempStandardNum = standardNum / 4 + 1;
		if ((tempStandardNum - 1) * 4 == standardNum)
			tempStandardNum--;
		for (int i = 0; i < tempStandardNum; i++)
			for (int j = 0; j < 4; j++) {
				final Table table = new Table( ((Model.Table) TableControl.getcontrol().fIndTableByType(0).get(i * 4 + j)).getTid(),  
						((Model.Table) TableControl.getcontrol().fIndTableByType(0).get(i * 4 + j)).getType(),
						((Model.Table) TableControl.getcontrol().fIndTableByType(0).get(i * 4 + j)).getCount(),
						((Model.Table) TableControl.getcontrol().fIndTableByType(0).get(i * 4 + j)).getReFlag()
						   );
				btnNewButtonStandard[i * 4 + j] = new JButton(table.getTid());
				btnNewButtonStandard[i * 4 + j].setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
				btnNewButtonStandard[i * 4 + j] 
						.setVerticalAlignment(SwingConstants.TOP);
				btnNewButtonStandard[i * 4 + j].setBounds(30 + 120 * j,
						30 + 120 * i, 100, 100);
				btnNewButtonStandard[i * 4 + j].setContentAreaFilled(false);
				btnNewButtonStandard[i * 4 + j]
						.setMargin(new Insets(0, 0, 0, 0));
				btnNewButtonStandard[i * 4 + j].setFocusPainted(false);
				btnNewButtonStandard[i * 4 + j]
						.setVerticalTextPosition(JButton.BOTTOM);
				btnNewButtonStandard[i * 4 + j]
						.setHorizontalTextPosition(JButton.CENTER);
				btnNewButtonStandard[i * 4 + j].setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));

				btnNewButtonStandard[i * 4 + j].setIcon(new ImageIcon(
						MainUI.class.getResource("/Image/icon01.png")));
				
				btnNewButtonStandard[i * 4 + j]
						.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								if (e.getClickCount() == 1) {
									tableeat=null;
									reservation=null;
									ConsumeTotal = "0";
									int consumeprice = 0;
									int consumetotal=0;
									
									tableNum = ((JButton) e.getSource())
											.getText();
									lblNewLabel_4.setText(((JButton) e.getSource())
											.getText());
									tableeat = TableControl.getcontrol().findById(tableNum);
									if(new Table(((JButton) e
											.getSource()).getText(),  TableControl.getcontrol().findById( ((JButton) e
											.getSource()).getText() ).getType() , TableControl.getcontrol().findById( ((JButton) e
													.getSource()).getText() ).getCount() ,TableControl.getcontrol().findById( ((JButton) e
															.getSource()).getText() ).getReFlag()).getReFlag()==1)
									{
										tablenum = ((JButton)e.getSource()).getText();
										
										reservation = (Reservation) ReservationControl.getcontrol().findByTablenum(tablenum).get(0); 
									
					
									
										lblNewLabel_5.setText(reservation.getName());
										lblNewLabel_6.setText(reservation.getTelnumber());
										lblNewLabel_7.setText(String.valueOf(reservation.getRetime()));
										java.util.List<Model.Consume> list = ConsumeControl.getcontrol().findByCName(reservation.getName());
										
										order = new String[list.size()][5];
										for (int i = 0; i < list.size(); i++) {
											order[i][0] = list.get(i).getCid().toString();
											order[i][1] = list.get(i).getCname();

											order[i][2] = list.get(i).getMname();
											order[i][3] = list.get(i).getMprice();
											consumeprice=Integer.parseInt(order[i][3]);
											consumetotal=consumetotal+consumeprice;
											
											}
										ConsumeTotal=String.valueOf(consumetotal);
										lblNewLabel_8.setText(ConsumeTotal);
										
										table_1.setModel(new DefaultTableModel(
												order,
												new String[] {
														"消费单号", "消费顾客", "\u83DC\u54C1\u540D", "\u83DC\u54C1\u5355\u4EF7"
												}
											));
										
									    } 
									else{
										lblNewLabel_5.setText(null);
										lblNewLabel_6.setText(null);
										lblNewLabel_7.setText(null);
										lblNewLabel_8.setText(null);
										table_1.setModel(new DefaultTableModel(
												new Object[][] {
												},
												new String[] {
														"消费单号", "消费顾客", "\u83DC\u54C1\u540D", "\u83DC\u54C1\u5355\u4EF7"
												}
											));
									}
								/*	lblNewLabel_1.setText(new Table(((JButton) e
											.getSource()).getText(),  TableControl.getcontrol().findById( ((JButton) e
											.getSource()).getText() ).getType() , TableControl.getcontrol().findById( ((JButton) e
													.getSource()).getText() ).getCount() ,TableControl.getcontrol().findById( ((JButton) e
															.getSource()).getText() ).getReFlag()).toString());*/
								}
										
							} 

							public void mousePressed(MouseEvent e) {
								// ((JButton)e.getSource()).setLocation(x,y);
								tableNum = ((JButton) e.getSource())
										.getText();
								px = e.getX();
								py = e.getY();
								bx = ((JButton) e.getSource()).getLocation().x;
								by = ((JButton) e.getSource()).getLocation().y;
								ox = ((JButton) e.getSource()).getLocation().x;
								oy = ((JButton) e.getSource()).getLocation().y;
								firstRoomNum = ((JButton) e.getSource())
										.getText();
								panel.add(((JButton) e.getSource()));
								 if (e.getButton() == MouseEvent.BUTTON3) {   
								     //pop.show((JButton)e.getSource(), e.getX(), e.getY());  
								    }
							}

							public void mouseReleased(MouseEvent e) {
								((JButton) e.getSource()).setLocation(ox, oy);
								if (firstRoomNum != lastRoomNum)
									try {
										//ChangeRoomUI changeroom = new ChangeRoomUI(firstRoomNum, lastRoomNum);
										//changeroom.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
										//changeroom.setVisible(true);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
							}

							public void mouseEntered(MouseEvent e) {
								lastRoomNum = ((JButton) e.getSource())
										.getText();
								// System.out.println(firstRoomNum+lastRoomNum);
							}

							public void mouseExited(MouseEvent e) {

							}

						});
				btnNewButtonStandard[i * 4 + j]
						.addMouseMotionListener(new MouseMotionAdapter() {
							public void mouseDragged(MouseEvent e) {
								x = e.getX() - (px - bx);
								y = e.getY() - (py - by);
								((JButton) e.getSource()).setLocation(x, y);
								bx = x;
								by = y;
							}

						});
				panel.add(btnNewButtonStandard[i * 4 + j]);
				if (i * 4 + j == standardNum - 1)
					break;
			}
		panel.setPreferredSize(new Dimension(400,
				30 + 150 * (tempStandardNum - 1)));
		panel.setLayout(null);
		
		

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("   包间    ", null, scrollPane_1, null);
		

		final JPanel panel_4 = new JPanel();
		scrollPane_1.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		
	final JButton btnNewButtoncompartment[] = new JButton[compartmentNum];
		
		int temcompartmentNum = compartmentNum / 4 + 1;
		if ((temcompartmentNum - 1) * 4 == compartmentNum)
			temcompartmentNum--;
		for (int i = 0; i < temcompartmentNum; i++)
			for (int j = 0; j < 4; j++) {
				
				Table table = new Table( ((Model.Table) TableControl.getcontrol().fIndTableByType(1).get(i * 4 + j)).getTid(),  
						((Model.Table) TableControl.getcontrol().fIndTableByType(1).get(i * 4 + j)).getType(),
						((Model.Table) TableControl.getcontrol().fIndTableByType(1).get(i * 4 + j)).getCount(),
						((Model.Table) TableControl.getcontrol().fIndTableByType(1).get(i * 4 + j)).getReFlag()
						   );
				
				btnNewButtoncompartment[i * 4 + j] = new JButton(table.getTid());
				btnNewButtoncompartment[i * 4 + j].setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
				btnNewButtoncompartment[i * 4 + j]
						.setVerticalAlignment(SwingConstants.TOP);
				btnNewButtoncompartment[i * 4 + j].setBounds(30 + 120 * j,
						30 + 120 * i, 100, 100);
				btnNewButtoncompartment[i * 4 + j].setContentAreaFilled(false);
				btnNewButtoncompartment[i * 4 + j]
						.setMargin(new Insets(0, 0, 0, 0));
				btnNewButtoncompartment[i * 4 + j].setFocusPainted(false);
				btnNewButtoncompartment[i * 4 + j]
						.setVerticalTextPosition(JButton.BOTTOM);
				btnNewButtoncompartment[i * 4 + j]
						.setHorizontalTextPosition(JButton.CENTER);
				btnNewButtoncompartment[i * 4 + j].setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButtoncompartment[i * 4 + j].setIcon(new ImageIcon(
						MainUI.class.getResource("/Image/icon03.png")));
				
				btnNewButtoncompartment[i * 4 + j]
						.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								if (e.getClickCount() == 1) {
									
									tableeat=null;
									reservation=null;
									
									ConsumeTotal = "0";
									int consumeprice = 0;
									int consumetotal=0;
									tableNum = ((JButton) e.getSource())
											.getText();
									lblNewLabel_4.setText( ((JButton) e.getSource())
											.getText());
									tableeat = TableControl.getcontrol().findById(tableNum);
									if(new Table(((JButton) e
											.getSource()).getText(),  TableControl.getcontrol().findById( ((JButton) e
											.getSource()).getText() ).getType() , TableControl.getcontrol().findById( ((JButton) e
													.getSource()).getText() ).getCount() ,TableControl.getcontrol().findById( ((JButton) e
															.getSource()).getText() ).getReFlag()).getReFlag()==1)
									{
										tablenum = ((JButton)e.getSource()).getText();
										reservation = (Reservation) ReservationControl.getcontrol().findByTablenum(tablenum).get(0);
										lblNewLabel_5.setText(reservation.getName());
										lblNewLabel_6.setText(reservation.getTelnumber());
										lblNewLabel_7.setText(String.valueOf(reservation.getRetime()));		
										java.util.List<Model.Consume> list = ConsumeControl.getcontrol().findByCName(reservation.getName());
										order = new String[list.size()][5];
										for (int i = 0; i < list.size(); i++) {
											order[i][0] = list.get(i).getCid().toString();
											order[i][1] = list.get(i).getCname();

											order[i][2] = list.get(i).getMname();
											order[i][3] = list.get(i).getMprice();
											consumeprice=Integer.parseInt(order[i][3]);
											consumetotal=consumetotal+consumeprice;
											
											}
										ConsumeTotal=String.valueOf(consumetotal);
										lblNewLabel_8.setText(ConsumeTotal);
										table_1.setModel(new DefaultTableModel(
												order,
												new String[] {
														"消费单号", "消费顾客", "\u83DC\u54C1\u540D", "\u83DC\u54C1\u5355\u4EF7"
												}
											));
										}
									else{
										lblNewLabel_5.setText(null);
										lblNewLabel_6.setText(null);
										lblNewLabel_7.setText(null);
										lblNewLabel_8.setText(null);
										table_1.setModel(new DefaultTableModel(
												new Object[][] {
												},
												new String[] {
														"消费单号", "消费顾客", "\u83DC\u54C1\u540D", "\u83DC\u54C1\u5355\u4EF7"
												}
											));
										
									}
										
									}
									
									
								
							}

							public void mousePressed(MouseEvent e) {
								// ((JButton)e.getSource()).setLocation(x,y);
								tableNum = ((JButton) e.getSource())
										.getText();
								px = e.getX();
								py = e.getY();
								bx = ((JButton) e.getSource()).getLocation().x;
								by = ((JButton) e.getSource()).getLocation().y;
								ox = ((JButton) e.getSource()).getLocation().x;
								oy = ((JButton) e.getSource()).getLocation().y;
								firstRoomNum = ((JButton) e.getSource())
										.getText();
								panel_4.add(((JButton) e.getSource()));
								 if (e.getButton() == MouseEvent.BUTTON3) {   
								     //pop.show((JButton)e.getSource(), e.getX(), e.getY());  
								    }
							}

							public void mouseReleased(MouseEvent e) {
								((JButton) e.getSource()).setLocation(ox, oy);
								if (firstRoomNum != lastRoomNum)
									try {
										//ChangeRoomUI changeroom = new ChangeRoomUI(firstRoomNum, lastRoomNum);
										//changeroom.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
										//changeroom.setVisible(true);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
							}

							public void mouseEntered(MouseEvent e) {
								lastRoomNum = ((JButton) e.getSource())
										.getText();
								// System.out.println(firstRoomNum+lastRoomNum);
							}

							public void mouseExited(MouseEvent e) {

							}

						});
				btnNewButtoncompartment[i * 4 + j]
						.addMouseMotionListener(new MouseMotionAdapter() {
							public void mouseDragged(MouseEvent e) {
								x = e.getX() - (px - bx);
								y = e.getY() - (py - by);
								((JButton) e.getSource()).setLocation(x, y);
								bx = x;
								by = y;
							}

						});
				panel_4.add(btnNewButtoncompartment[i * 4 + j]);
				if (i * 4 + j == compartmentNum - 1)
					break;
			}
		panel_4.setPreferredSize(new Dimension(400,
				30 + 150 * (temcompartmentNum - 1)));
		panel_4.setLayout(null);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 927, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u7EF4\u62A4");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5907\u4EFD\u6570\u636E\u5E93");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 DateSecurity chooseUI = new  DateSecurity();
				chooseUI.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				chooseUI.setModal(true);
				chooseUI.setVisible(true);
				
			}
		});
		JMenu mnNewMenu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5173\u4E8E\u7CFB\u7EDF");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AboutUI aboutui = new AboutUI();
				aboutui.setVisible(true);
				
				
			}
			
			
			
		});
		/*Timer time1=new Timer(true);
		time1.schedule(new TimerTask() {
			public void run() {
		timer = new Timer(true);
		timer.schedule(new TimerTask() {
			public void run() {
				
				java.util.List list
				
				
				
				
				timer.cancel();
			}
		}, 0 * 1000, 1 * 10);}},0 * 1000, 3 * 1000);*/
	}
}
