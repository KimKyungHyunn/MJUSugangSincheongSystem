package mainFrame;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants;
import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import mainFrame.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog  implements WindowListener{ 
	private static final long serialVersionUID = 1L;
	
	private PCreate pCreate;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	private JButton createButton;	
	private CLogin cLogin;
	private CUser cUser;
	

	public PLoginDialog(ActionHandler actionHandler) {
		addWindowListener(this);

		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		this.setResizable(false);

		this.setLayout(new FlowLayout());
		
		JPanel line1 = new JPanel();
			this.nameLabel = new JLabel(ELoginDialog.nameLabel.getText());
			line1.add(this.nameLabel);		
			this.nameText = new JTextField(ELoginDialog.sizeNameText.getInt());
			line1.add(this.nameText);
		this.add(line1);
	
		JPanel line2 = new JPanel();
			this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
			line2.add(this.passwordLabel);		
			this.passwordText = new JTextField(ELoginDialog.sizePasswordText.getInt());
			line2.add(this.passwordText);
		this.add(line2);
		
		JPanel line3 = new JPanel();
			this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
			line3.add(this.okButton);
			this.okButton.addActionListener(actionHandler);
			this.okButton.setActionCommand(this.okButton.getText());
			this.getRootPane().setDefaultButton(this.okButton);
			
			this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
			line3.add(this.cancelButton);
			this.cancelButton.addActionListener(actionHandler);
			this.cancelButton.setActionCommand(this.cancelButton.getText());			
			
			this.createButton = new JButton(ELoginDialog.createButtonLabel.getText());
			line3.add(this.createButton);
			this.createButton.addActionListener(actionHandler);
			this.createButton.setActionCommand(this.createButton.getText());
		this.add(line3);
		
		this.cLogin = new CLogin();
		this.cUser = new CUser();	
		this.pCreate = new PCreate();
	}
		

	public void initialize() {
		
	}	
	
	public VUser validateUser(String actionCommand) {
		VUser vUser = null;
		if(actionCommand.contentEquals(this.okButton.getText())) {
			VLogin vLogin = new VLogin(this.nameText.getText(), this.passwordText.getText());
			boolean bLoginSuccess = cLogin.validate(vLogin);
	
			if (bLoginSuccess) {
				vUser = this.cUser.getUser(vLogin.getUserId());		
				if (vUser == null) {
					 JOptionPane.showMessageDialog(null,
							 Constants.ELoginDialog.noAccountInfo.getText(),
                             "로그인 오류",
                             JOptionPane.ERROR_MESSAGE);
				}
			}else {
				 JOptionPane.showMessageDialog(null,
						 Constants.ELoginDialog.loginFailed.getText(),
                         "로그인 오류",
                         JOptionPane.ERROR_MESSAGE);
			}
		}else if(actionCommand.contentEquals(this.createButton.getText())) {
			this.pCreate.setVisible(true);
			this.dispose();
		}else {
			System.exit(0);
		}
		return vUser;
	}
		
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {	}
	public void windowOpened(WindowEvent arg0) {}

}
