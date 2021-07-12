package sugangSincheong;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PFooterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel welcomeLabel;
	public PFooterPanel() {
		this.welcomeLabel = new JLabel();
		this.add(this.welcomeLabel);
	}

	public void initialize() {
		Calendar cal =  Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		String time = Integer.toString(hour) + ":" + Integer.toString(min);
		
		this.welcomeLabel.setText("현재 시각 "+ time);
		this.welcomeLabel.setFont(new Font("Serif", Font.BOLD, 15));
	}
}
