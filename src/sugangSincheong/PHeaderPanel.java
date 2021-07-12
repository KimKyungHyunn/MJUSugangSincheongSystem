package sugangSincheong;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.VUser;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel welcomeLabel;
	public PHeaderPanel() {
		this.welcomeLabel = new JLabel();
		this.add(this.welcomeLabel);
	}
	public void initialize(VUser vUser) {
		this.welcomeLabel.setText(vUser.getName()+"¥‘ æ»≥Á«œººø‰.");
		this.welcomeLabel.setForeground(Color.BLUE);
	}
}
