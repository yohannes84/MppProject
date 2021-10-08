package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import business.*;
import javax.swing.JTree;
import javax.swing.JSplitPane;


public class LoginWindow extends JFrame implements LibWindow {
    public static final LoginWindow INSTANCE = new LoginWindow();
	
	private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel upperHalf;
	private JPanel middleHalf;
	private JPanel lowerHalf;
	private JPanel container;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel leftTextPanel;
	private JPanel rightTextPanel;
	
	private JTextField username;
	private JTextField password;
	private JLabel label;
	private JButton loginButton;
	private JButton logoutButton;
	
	
	String pathToImage;
	String pathToImage2;
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	private JTextField messageBar = new JTextField();
	public void clear() {
		messageBar.setText("");
	}
	
	 private void setPathToImage() {
	    	String currDirectory = System.getProperty("user.dir");
	    	pathToImage = currDirectory+"\\src\\librarysystem\\Book2.png";
	    	pathToImage2 = currDirectory+"\\src\\librarysystem\\gr.png";
	    }
	
	/* This class is a singleton */
    private LoginWindow () {}
    
    public void init() { 
    	
    	
    	   setPathToImage();
    	
	    	TitledBorder borderLogin = new TitledBorder("Login");
	    	borderLogin.setTitleJustification(TitledBorder.LEFT);
	    	borderLogin.setTitlePosition(TitledBorder.TOP);
	    	mainPanel = new JPanel();
	    	mainPanel.setBorder(borderLogin);
    		defineUpperHalf();
    		defineMiddleHalf();
    		defineLowerHalf();
    		BorderLayout bl = new BorderLayout();
    		bl.setVgap(30);
    		mainPanel.setLayout(bl);
    		mainPanel.setBackground(Color.LIGHT_GRAY);
    		
    		
    					
    		mainPanel.add(upperHalf, BorderLayout.NORTH);
    		mainPanel.add(middleHalf, BorderLayout.CENTER);
    		mainPanel.add(lowerHalf, BorderLayout.SOUTH);
    		getContentPane().setBackground(Color.lightGray);
    		getContentPane().setBackground(getBackground());
    		getContentPane().add(mainPanel);
    		
    		isInitialized(true);
    	    pack();
    		//setSize(660, 500);

    	
    }
    private void defineUpperHalf() {
    		
    		upperHalf = new JPanel();
    		upperHalf.setLayout(new BorderLayout());
    		//upperHalf.setBackground(Color.red);
    		defineTopPanel();
    		defineMiddlePanel();
    		defineLowerPanel();
    		upperHalf.add(topPanel, BorderLayout.NORTH);
    		upperHalf.add(middlePanel, BorderLayout.CENTER);
    		upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    		
    	}
    	private void defineMiddleHalf() {
    		middleHalf = new JPanel();
    		middleHalf.setLayout(new BorderLayout());
    		middleHalf.setBackground(Color.red);
    		JSeparator s = new JSeparator();
    		s.setOrientation(SwingConstants.HORIZONTAL);
    		//middleHalf.add(Box.createRigidArea(new Dimension(0,50)));
    		middleHalf.add(s, BorderLayout.SOUTH);
    		
    	}
    	private void defineLowerHalf() {

    		lowerHalf = new JPanel();
    		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
    		
    		JButton backButton = new JButton("<< Back to Main");
    		addBackButtonListener(backButton);
    		lowerHalf.add(backButton);
    		
    	}
    	private void defineTopPanel() {
    		topPanel = new JPanel();
    		ImageIcon image2 = new ImageIcon(pathToImage2);
    		
    		
    		JPanel intPanel = new JPanel(new BorderLayout());
    		intPanel.setBackground(new Color(185,17,128));
    		//intPanel.add(new JLabel(image2));	
    		intPanel.add(Box.createRigidArea(new Dimension(60,300)), BorderLayout.NORTH);
    		//JLabel loginLabel = new JLabel("Login");
    		//Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
    		//intPanel.add(loginLabel, BorderLayout.CENTER);
    		ImageIcon image = new ImageIcon(pathToImage);
    		topPanel.add(new JLabel(image));	
    		
    		topPanel.setBackground(Color.LIGHT_GRAY);
    		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    		topPanel.add(intPanel);
    		
    	}
    	
    	
    	
    	private void defineMiddlePanel() {
    		middlePanel=new JPanel();
    		middlePanel.setLayout(new GridLayout(2,1,10,5));
    		//middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    		defineLeftTextPanel();
    		defineRightTextPanel();
    		//middlePanel.setBackground(Color.red);
    		middlePanel.add(leftTextPanel);
    		middlePanel.add(rightTextPanel);
    	}
    	private void defineLowerPanel() {
    		lowerPanel = new JPanel();
    		loginButton = new JButton("Login");
    		addLoginButtonListener(loginButton);
    		lowerPanel.add(loginButton);
    	}

    	private void defineLeftTextPanel() {
    		
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		topText.setLayout(new GridLayout(2,1));
//    		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
//    		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
    		
    		username = new JTextField();
    		label = new JLabel("Username");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		
    		topText.add(label);
    		topText.add(username);
    		
    		leftTextPanel = new JPanel();
    		leftTextPanel.setLayout(new GridLayout(0, 1,0,0));
    		leftTextPanel.add(topText,BorderLayout.NORTH);
    		//leftTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	private void defineRightTextPanel() {
    		
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
//    		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
//    		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
    		topText.setLayout(new GridLayout(2,1));
    		//bottomText.setLayout(new GridLayout(0, 1,0,0));
    		
    		password = new JPasswordField(25);
    		label = new JLabel("Password");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		
    		topText.add(label);
    		topText.add(password);
    		
    		rightTextPanel = new JPanel();
    		//rightTextPanel.setBackground(Color.red);
    		rightTextPanel.setLayout(new GridLayout(0, 1,0,0));
    		//rightTextPanel.setLayout(new BorderLayout());
    		rightTextPanel.add(topText,BorderLayout.NORTH);
    		//rightTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	
    	private void addBackButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			LibrarySystem.hideAllWindows();
    			LibrarySystem.INSTANCE.setVisible(true);
    		});
    	}
    	
    	private void addLoginButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			SystemController systemController = new SystemController();
				try {
					systemController.login(username.getText() , password.getText());
				} catch (LoginException e) {
					
					 JOptionPane.showMessageDialog(this,e.getMessage(),"Error dialog", JOptionPane.ERROR_MESSAGE);
					//e.printStackTrace();
				}
				if(systemController.currentAuth != null){
					System.out.println("*****"+SystemController.currentAuth);
//					systemController.addLibraryMember("2222","87654","9876","1234","2345","234","234","2345");
//					systemController.checkoutBook("1004","48-56882");
				//systemController.addCopyOfExistingBook("48-56882");
					JOptionPane.showMessageDialog(this,"Successful Login");
					
					MainForm.INSTANCE.setTitle("Library Application");
		            MainForm.INSTANCE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            
		            //LibrarySystem.INSTANCE.init();
		            Util.centerFrameOnDesktop(MainForm.INSTANCE);
		            MainForm.INSTANCE.setVisible(true);
		            this.INSTANCE.setVisible(false);

				}
				else{
					System.out.println("*****"+SystemController.currentAuth);

					JOptionPane.showMessageDialog(this,"Error");
				}
    		});
    	}
}
