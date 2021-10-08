package librarysystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class AddNewMember extends JFrame {

	private JPanel contentPane;
	private JTextField textMemberId;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textStreet;
	private JTextField textCity;
	private JTextField textZip;
	private JTextField textTelephone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewMember frame = new AddNewMember();
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
	public AddNewMember() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewMember.class.getResource("/librarysystem/logo-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(36, 103, 83, 44);
		contentPane.add(lblNewLabel);
		
		textMemberId = new JTextField();
		textMemberId.setBounds(142, 101, 292, 46);
		contentPane.add(textMemberId);
		textMemberId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 158, 119, 55);
		contentPane.add(lblNewLabel_1);
		
		textFname = new JTextField();
		textFname.setBounds(142, 158, 292, 50);
		contentPane.add(textFname);
		textFname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(36, 224, 83, 32);
		contentPane.add(lblNewLabel_2);
		
		textLname = new JTextField();
		textLname.setBounds(142, 219, 292, 44);
		contentPane.add(textLname);
		textLname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Street:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(36, 280, 83, 32);
		contentPane.add(lblNewLabel_3);
		
		textStreet = new JTextField();
		textStreet.setBounds(142, 276, 292, 44);
		contentPane.add(textStreet);
		textStreet.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("City:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(36, 348, 48, 14);
		contentPane.add(lblNewLabel_4);
		
		textCity = new JTextField();
		textCity.setBounds(142, 327, 292, 44);
		contentPane.add(textCity);
		textCity.setColumns(10);
		
		JComboBox comboState = new JComboBox();
		comboState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboState.setModel(new DefaultComboBoxModel(new String[] {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"}));
		comboState.setBounds(142, 382, 292, 46);
		contentPane.add(comboState);
		
		JLabel lblNewLabel_5 = new JLabel("State:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(36, 398, 48, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Zip:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(36, 463, 48, 14);
		contentPane.add(lblNewLabel_6);
		
		textZip = new JTextField();
		textZip.setBounds(140, 451, 294, 43);
		contentPane.add(textZip);
		textZip.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telephone:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(36, 514, 97, 38);
		contentPane.add(lblNewLabel_7);
		
		textTelephone = new JTextField();
		textTelephone.setBounds(142, 511, 292, 41);
		contentPane.add(textTelephone);
		textTelephone.setColumns(10);
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddMember.setBounds(185, 573, 204, 45);
		contentPane.add(btnAddMember);
		
		JLabel lblNewLabel_8 = new JLabel("Add Member");
		lblNewLabel_8.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setIcon(new ImageIcon(AddNewMember.class.getResource("/librarysystem/AddMember1.png")));
		lblNewLabel_8.setFont(new Font("Candara", Font.BOLD, 30));
		lblNewLabel_8.setBounds(20, 11, 414, 81);
		contentPane.add(lblNewLabel_8);
	}
}
