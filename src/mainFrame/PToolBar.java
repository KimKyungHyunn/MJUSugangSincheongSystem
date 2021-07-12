package mainFrame;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import constants.Constants;

public class PToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	
	public PToolBar() {
//		JButton button1 = new JButton("미리담기");
//		this.add(button1);	
		this.setLayout(new GridLayout(1,2,0,0));	
		for(Constants.EImages image : Constants.EImages.values()) {
		ImageIcon icon1 = new ImageIcon(image.getText());		
		JButton button1 = new JButton(icon1);
		button1.setToolTipText("icon");
		this.add(button1);	
		}
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
}
