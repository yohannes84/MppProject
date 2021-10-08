package librarysystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.ControllerInterface;
import business.SystemController;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class MainForm extends JFrame {
	
	ControllerInterface ci = new SystemController();
	public final static MainForm INSTANCE = new MainForm();
	
	JPanel mainPanel;
	JMenuBar menuBar;
    JMenu options,operations;
    JMenuItem login, allBookIds, allMemberIds,addNewMember,checkoutBook,addNewCopy;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	
	 private void createMenus() {
	    	menuBar = new JMenuBar();
			menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
			addMenuItems();
			setJMenuBar(menuBar);		
	    }
	
	 private void addMenuItems() {
	       options = new JMenu("Options");  
	       operations =  new JMenu("Operations");
	 	   menuBar.add(options);
	 	   menuBar.add(operations);
	 	   login = new JMenuItem("Login");
	 	  login.addActionListener(new LoginListener());
	 	   allBookIds = new JMenuItem("All Book Ids");
	 	   allBookIds.addActionListener(new AllBookIdsListener());
	 	   allMemberIds = new JMenuItem("All Member Ids");
	 	  allMemberIds.addActionListener(new AllMemberIdsListener());
	 	   addNewMember = new JMenuItem("Add New Member");
	 	  // addNewMember.addActionListener(new AddNewMemberListener());
	 	   checkoutBook = new JMenuItem("Checkout Book");
	 	 // checkoutBook.addActionListener(new CheckoutListener());
	 	   addNewCopy = new JMenuItem("Add New Copy");
	 	  //addNewCopy.addActionListener(new AddNewCopyListener());
	 	   
	 	   
	 	   options.add(login);
	 	   options.add(allBookIds);
	 	   options.add(allMemberIds);
	 	   operations.add(addNewMember);
	 	   operations.add(checkoutBook);
	 	   operations.add(addNewCopy);
	    }
	 
	 class LoginListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				LoginWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
				LoginWindow.INSTANCE.setVisible(true);
				
			}
	    	
	    }
	    class AllBookIdsListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				AllBookIdsWindow.INSTANCE.init();
				
				List<String> ids = ci.allBookIds();
				Collections.sort(ids);
				StringBuilder sb = new StringBuilder();
				for(String s: ids) {
					sb.append(s + "\n");
				}
				System.out.println(sb.toString());
				AllBookIdsWindow.INSTANCE.setData(sb.toString());
				AllBookIdsWindow.INSTANCE.pack();
				//AllBookIdsWindow.INSTANCE.setSize(660,500);
				Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
				AllBookIdsWindow.INSTANCE.setVisible(true);
				
			}
	    	
	    }
	    
	    class AllMemberIdsListener implements ActionListener {

	    	@Override
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				AllMemberIdsWindow.INSTANCE.init();
				AllMemberIdsWindow.INSTANCE.pack();
				AllMemberIdsWindow.INSTANCE.setVisible(true);
				
				
				LibrarySystem.hideAllWindows();
				AllBookIdsWindow.INSTANCE.init();
				
				List<String> ids = ci.allMemberIds();
				Collections.sort(ids);
				StringBuilder sb = new StringBuilder();
				for(String s: ids) {
					sb.append(s + "\n");
				}
				System.out.println(sb.toString());
				AllMemberIdsWindow.INSTANCE.setData(sb.toString());
				AllMemberIdsWindow.INSTANCE.pack();
				//AllMemberIdsWindow.INSTANCE.setSize(660,500);
				Util.centerFrameOnDesktop(AllMemberIdsWindow.INSTANCE);
				AllMemberIdsWindow.INSTANCE.setVisible(true);
				
				
			}
	    	
	    }
	    
//	    class AddNewMemberListener implements ActionListener {
//		}
//		
//		class CheckoutListener implements ActionListener {
//		}
//
//		class AddNewCopyListener implements ActionListener {
//		}
//	    
	    

	 
	public MainForm() {
		createMenus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jPanel_Menu = new JPanel();
		jPanel_Menu.setBackground(new Color(36, 37, 42));
		jPanel_Menu.setBounds(0, 11, 285, 678);
		contentPane.add(jPanel_Menu);
		
		JPanel jPanel_Header = new JPanel();
		jPanel_Header.setBackground(new Color(1, 50, 67));
		
		JLabel jLabel_Dashboard_Logo = new JLabel();
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Library");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 36));
		GroupLayout gl_jPanel_Header = new GroupLayout(jPanel_Header);
		gl_jPanel_Header.setHorizontalGroup(
			gl_jPanel_Header.createParallelGroup(Alignment.LEADING)
				.addGap(0, 285, Short.MAX_VALUE)
				.addGroup(gl_jPanel_Header.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel_Dashboard_Logo, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel1)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_jPanel_Header.setVerticalGroup(
			gl_jPanel_Header.createParallelGroup(Alignment.LEADING)
				.addGap(0, 107, Short.MAX_VALUE)
				.addGroup(gl_jPanel_Header.createSequentialGroup()
					.addGroup(gl_jPanel_Header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel_Header.createSequentialGroup()
							.addContainerGap()
							.addComponent(jLabel_Dashboard_Logo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel_Header.createSequentialGroup()
							.addGap(26)
							.addComponent(jLabel1)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		jPanel_Header.setLayout(gl_jPanel_Header);
		
		JButton jButton_Books_List_ = new JButton();
		jButton_Books_List_.setText("Books List");
		jButton_Books_List_.setForeground(Color.WHITE);
		jButton_Books_List_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_Books_List_.setContentAreaFilled(false);
		
		JButton jButton_DeleteBook_ = new JButton();
		jButton_DeleteBook_.setText("Delete Book");
		jButton_DeleteBook_.setForeground(Color.WHITE);
		jButton_DeleteBook_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_DeleteBook_.setContentAreaFilled(false);
		
		JButton jButton_EditBook_ = new JButton();
		jButton_EditBook_.setText("Edit Book");
		jButton_EditBook_.setForeground(Color.WHITE);
		jButton_EditBook_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_EditBook_.setContentAreaFilled(false);
		
		JButton jButton_AddBook_ = new JButton();
		jButton_AddBook_.setText("Add Book");
		jButton_AddBook_.setForeground(Color.WHITE);
		jButton_AddBook_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_AddBook_.setContentAreaFilled(false);
		
		JLabel jLabel13 = new JLabel();
		jLabel13.setText("Books");
		jLabel13.setForeground(Color.WHITE);
		jLabel13.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton jButton_Members_List_ = new JButton();
		jButton_Members_List_.setText("Members List");
		jButton_Members_List_.setForeground(Color.WHITE);
		jButton_Members_List_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_Members_List_.setContentAreaFilled(false);
		
		JButton jButton_DeleteMember_ = new JButton();
		jButton_DeleteMember_.setText("Delete Member");
		jButton_DeleteMember_.setForeground(Color.WHITE);
		jButton_DeleteMember_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_DeleteMember_.setContentAreaFilled(false);
		
		JButton jButton_EditMember_ = new JButton();
		jButton_EditMember_.setText("Edit Member");
		jButton_EditMember_.setForeground(Color.WHITE);
		jButton_EditMember_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_EditMember_.setContentAreaFilled(false);
		
		JButton jButton_AddMember_ = new JButton();
		jButton_AddMember_.setText("Add Member");
		jButton_AddMember_.setForeground(Color.WHITE);
		jButton_AddMember_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_AddMember_.setContentAreaFilled(false);
		
		JLabel jLabel8 = new JLabel();
		jLabel8.setText("Members");
		jLabel8.setForeground(Color.WHITE);
		jLabel8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton jButton_Manage_Genres_ = new JButton();
		jButton_Manage_Genres_.setText("Manage Genres");
		jButton_Manage_Genres_.setForeground(Color.WHITE);
		jButton_Manage_Genres_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_Manage_Genres_.setContentAreaFilled(false);
		
		JLabel jLabel11 = new JLabel();
		jLabel11.setText("Genres");
		jLabel11.setForeground(Color.WHITE);
		jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton jButton_Manage_Authors_ = new JButton();
		jButton_Manage_Authors_.setText("Manage Authors");
		jButton_Manage_Authors_.setForeground(Color.WHITE);
		jButton_Manage_Authors_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_Manage_Authors_.setContentAreaFilled(false);
		
		JLabel jLabel12 = new JLabel();
		jLabel12.setText("Authors");
		jLabel12.setForeground(Color.WHITE);
		jLabel12.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel jLabel_CirculationTitle_ = new JLabel();
		jLabel_CirculationTitle_.setText("Circulation");
		jLabel_CirculationTitle_.setForeground(Color.WHITE);
		jLabel_CirculationTitle_.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton jButton_IssueBook_ = new JButton();
		jButton_IssueBook_.setText("Issue Book");
		jButton_IssueBook_.setForeground(Color.WHITE);
		jButton_IssueBook_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_IssueBook_.setContentAreaFilled(false);
		
		JLabel jLabel_some_awsome_name_here_ = new JLabel();
		jLabel_some_awsome_name_here_.setText("|");
		jLabel_some_awsome_name_here_.setForeground(Color.WHITE);
		jLabel_some_awsome_name_here_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton jButton_ReturnBook_ = new JButton();
		jButton_ReturnBook_.setText("Return Book");
		jButton_ReturnBook_.setForeground(Color.WHITE);
		jButton_ReturnBook_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButton_ReturnBook_.setContentAreaFilled(false);
		
		JButton jButton_ManageUsers_ = new JButton();
		jButton_ManageUsers_.setText("Manage Users");
		jButton_ManageUsers_.setForeground(Color.WHITE);
		jButton_ManageUsers_.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jButton_ManageUsers_.setContentAreaFilled(false);
		GroupLayout gl_jPanel_Menu = new GroupLayout(jPanel_Menu);
		gl_jPanel_Menu.setHorizontalGroup(
			gl_jPanel_Menu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 285, Short.MAX_VALUE)
				.addComponent(jPanel_Header, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
				.addGroup(gl_jPanel_Menu.createSequentialGroup()
					.addGroup(gl_jPanel_Menu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel_Menu.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_jPanel_Menu.createParallelGroup(Alignment.TRAILING)
								.addComponent(jButton_Books_List_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_DeleteBook_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_EditBook_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_AddBook_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_Members_List_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_DeleteMember_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_EditMember_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_AddMember_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_Manage_Genres_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_Manage_Authors_, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_jPanel_Menu.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_jPanel_Menu.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel_Menu.createSequentialGroup()
									.addGap(18)
									.addComponent(jLabel_CirculationTitle_, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_jPanel_Menu.createSequentialGroup()
									.addComponent(jButton_IssueBook_)
									.addGap(11)
									.addComponent(jLabel_some_awsome_name_here_)
									.addGap(13)
									.addComponent(jButton_ReturnBook_)))))
					.addContainerGap(27, Short.MAX_VALUE))
				.addComponent(jButton_ManageUsers_, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
		);
		gl_jPanel_Menu.setVerticalGroup(
			gl_jPanel_Menu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 659, Short.MAX_VALUE)
				.addGroup(gl_jPanel_Menu.createSequentialGroup()
					.addComponent(jPanel_Header, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_Manage_Genres_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_Manage_Authors_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_AddMember_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_EditMember_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_DeleteMember_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_Members_List_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_AddBook_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_EditBook_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_DeleteBook_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_Books_List_)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel_CirculationTitle_, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel_Menu.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton_IssueBook_)
						.addComponent(jButton_ReturnBook_)
						.addComponent(jLabel_some_awsome_name_here_))
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(jButton_ManageUsers_))
		);
		jPanel_Menu.setLayout(gl_jPanel_Menu);
		
		JPanel jPanel_3 = new JPanel();
		jPanel_3.setBackground(new Color(255, 178, 41));
		jPanel_3.setBounds(337, 11, 280, 220);
		contentPane.add(jPanel_3);
		
		JPanel jPanel_1_header1 = new JPanel();
		jPanel_1_header1.setBackground(new Color(246, 145, 16));
		
		JLabel jLabel9 = new JLabel();
		jLabel9.setText("Books");
		jLabel9.setForeground(Color.WHITE);
		jLabel9.setFont(new Font("SansSerif", Font.BOLD, 24));
		GroupLayout gl_jPanel_1_header1 = new GroupLayout(jPanel_1_header1);
		gl_jPanel_1_header1.setHorizontalGroup(
			gl_jPanel_1_header1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 280, Short.MAX_VALUE)
				.addGroup(gl_jPanel_1_header1.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		gl_jPanel_1_header1.setVerticalGroup(
			gl_jPanel_1_header1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 60, Short.MAX_VALUE)
				.addGroup(gl_jPanel_1_header1.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel_1_header1.setLayout(gl_jPanel_1_header1);
		
		JLabel jLabel_BooksCount = new JLabel();
		jLabel_BooksCount.setText("00532");
		jLabel_BooksCount.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_BooksCount.setForeground(Color.WHITE);
		jLabel_BooksCount.setFont(new Font("SansSerif", Font.BOLD, 36));
		GroupLayout gl_jPanel_3 = new GroupLayout(jPanel_3);
		gl_jPanel_3.setHorizontalGroup(
			gl_jPanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 280, Short.MAX_VALUE)
				.addComponent(jPanel_1_header1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jLabel_BooksCount, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
		);
		gl_jPanel_3.setVerticalGroup(
			gl_jPanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 220, Short.MAX_VALUE)
				.addGroup(gl_jPanel_3.createSequentialGroup()
					.addGroup(gl_jPanel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel_1_header1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jPanel_3.createSequentialGroup()
							.addGap(91)
							.addComponent(jLabel_BooksCount, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		jPanel_3.setLayout(gl_jPanel_3);
		
		JPanel jPanel_2 = new JPanel();
		jPanel_2.setBackground(new Color(75, 192, 18));
		jPanel_2.setBounds(807, 11, 280, 220);
		contentPane.add(jPanel_2);
		
		JPanel jPanel_2_header = new JPanel();
		jPanel_2_header.setBackground(new Color(65, 160, 10));
		
		JLabel jLabel3 = new JLabel();
		jLabel3.setText("Members");
		jLabel3.setForeground(Color.WHITE);
		jLabel3.setFont(new Font("SansSerif", Font.BOLD, 24));
		GroupLayout gl_jPanel_2_header = new GroupLayout(jPanel_2_header);
		gl_jPanel_2_header.setHorizontalGroup(
			gl_jPanel_2_header.createParallelGroup(Alignment.LEADING)
				.addGap(0, 280, Short.MAX_VALUE)
				.addGroup(gl_jPanel_2_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		gl_jPanel_2_header.setVerticalGroup(
			gl_jPanel_2_header.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_jPanel_2_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel_2_header.setLayout(gl_jPanel_2_header);
		
		JLabel jLabel_MembersCount = new JLabel();
		jLabel_MembersCount.setText("11389");
		jLabel_MembersCount.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_MembersCount.setForeground(Color.WHITE);
		jLabel_MembersCount.setFont(new Font("SansSerif", Font.BOLD, 36));
		GroupLayout gl_jPanel_2 = new GroupLayout(jPanel_2);
		gl_jPanel_2.setHorizontalGroup(
			gl_jPanel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 280, Short.MAX_VALUE)
				.addComponent(jPanel_2_header, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jLabel_MembersCount, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
		);
		gl_jPanel_2.setVerticalGroup(
			gl_jPanel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 220, Short.MAX_VALUE)
				.addGroup(gl_jPanel_2.createSequentialGroup()
					.addComponent(jPanel_2_header, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(jLabel_MembersCount, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 56, Short.MAX_VALUE))
		);
		jPanel_2.setLayout(gl_jPanel_2);
		
		JLabel jLabel_FormTitle = new JLabel();
		jLabel_FormTitle.setText("  Book List");
		jLabel_FormTitle.setOpaque(true);
		jLabel_FormTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_FormTitle.setForeground(Color.WHITE);
		jLabel_FormTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		jLabel_FormTitle.setBackground(new Color(1, 152, 117));
		jLabel_FormTitle.setBounds(337, 251, 750, 75);
		contentPane.add(jLabel_FormTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(345, 349, 742, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Book Name", "ISBN", "Author", "No of Copies", "Edition"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}
}
