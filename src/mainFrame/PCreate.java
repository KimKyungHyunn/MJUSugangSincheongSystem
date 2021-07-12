package mainFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants;
import constants.Constants.ECreateDialog;
import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import mainFrame.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;

public class PCreate extends JDialog  implements WindowListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel idLabel;
	private JTextField idText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel addressLabel;
	private JTextField addressText;
	private JButton okButton;
	private JButton cancelButton;	
	private CLogin cLogin;
	private CUser cUser;
	
	public PCreate() {
		ActionHandler actionHandler = new ActionHandler();
		addWindowListener(this);
		
		this.setSize(ECreateDialog.width.getInt(), ECreateDialog.height.getInt());
		this.setResizable(false);

		this.setLayout(new FlowLayout());

		JPanel line1 = new JPanel();
		this.idLabel = new JLabel(ECreateDialog.idLabel.getText());
		line1.add(this.idLabel);
		this.idText = new JTextField(ECreateDialog.sizeText.getInt());
		line1.add(this.idText);
		this.add(line1);

		JPanel line2 = new JPanel();
		this.passwordLabel = new JLabel(ECreateDialog.passwordLabel.getText());
		line2.add(this.passwordLabel);
		this.passwordText = new JTextField(ECreateDialog.sizeText.getInt());
		line2.add(this.passwordText);
		this.add(line2);

		JPanel line3 = new JPanel();
		this.nameLabel = new JLabel(ECreateDialog.nameLabel.getText());
		line3.add(this.nameLabel);
		this.nameText = new JTextField(ECreateDialog.sizeText.getInt());
		line3.add(this.nameText);
		this.add(line3);
		
		JPanel line4 = new JPanel();
		this.addressLabel = new JLabel(ECreateDialog.addressLabel.getText());
		line4.add(this.addressLabel);
		this.addressText = new JTextField(ECreateDialog.sizeText.getInt());
		line4.add(this.addressText);
		this.add(line4);
		
		JPanel line5 = new JPanel();
		this.okButton = new JButton(ECreateDialog.okButtonLabel.getText());
		line5.add(this.okButton);
		this.okButton.addActionListener(actionHandler);
		this.okButton.setActionCommand(this.okButton.getText());
		this.getRootPane().setDefaultButton(this.okButton);

		this.cancelButton = new JButton(ECreateDialog.cancelButtonLabel.getText());
		line5.add(this.cancelButton);
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setActionCommand(this.cancelButton.getText());
		this.add(line5);
		
		this.cLogin = new CLogin();
		this.cUser = new CUser();	
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DoAction(e.getActionCommand());
		}
	}

	public void DoAction(String actionCommand) {
		if(actionCommand.contentEquals(this.okButton.getText())) {
			cLogin.createAccount(this.idText.getText(), this.passwordText.getText());
			cUser.createUser(this.idText.getText(), this.nameText.getText(), this.addressText.getText());
			JOptionPane.showMessageDialog(null,ECreateDialog.doneMessage.getText());
			this.dispose();
		}else {
			System.exit(0);
		}
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
