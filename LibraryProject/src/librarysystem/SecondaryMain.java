package librarysystem;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SecondaryMain {

	public static void main(String[] args) {
	      EventQueue.invokeLater(() -> 
	         {
//	            MainForm.INSTANCE.setTitle("Library Application");
//	            MainForm.INSTANCE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	            
//	            //LibrarySystem.INSTANCE.init();
//	            centerFrameOnDesktop(MainForm.INSTANCE);
//	            MainForm.INSTANCE.setVisible(true);
//	            
	            LibrarySystem.hideAllWindows();
				LoginWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
				LoginWindow.INSTANCE.setVisible(true);
				
	         });
	   }
	   
	   public static void centerFrameOnDesktop(Component f) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			int height = toolkit.getScreenSize().height;
			int width = toolkit.getScreenSize().width;
			int frameHeight = f.getSize().height;
			int frameWidth = f.getSize().width;
			f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
		}

}
