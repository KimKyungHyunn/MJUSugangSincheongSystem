package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import constants.Constants.ELoginDialog;
import valueObject.VUser;

public class Main {
	private PLoginDialog pLoginDialog ;
	private ActionHandler actionHandler;
	private PMainFrame pMainFrame;
	
	private void run() {
		this.actionHandler = new ActionHandler();
		this.pLoginDialog = new PLoginDialog(actionHandler);
		this.pLoginDialog.setVisible(true);		
	}
	
	public void initialize() {
		this.pLoginDialog.initialize();
	}
	
	public void validateUser(String actionCommand) {
		VUser vUser = pLoginDialog.validateUser(actionCommand);

		if(vUser != null) {
			pLoginDialog.dispose();
			this.pMainFrame = new PMainFrame();
			this.pMainFrame.setVisible(true);	
			this.pMainFrame.initialize(vUser);
		}
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			validateUser(e.getActionCommand());
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}
