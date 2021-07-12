package mainFrame;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import constants.Constants;
import mainFrame.PMainFrame.windowHandler;
import sugangSincheong.PSugangSincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangSincheongPanel pMainPanel;
	private windowHandler windowHandler;

	// constructor
	public PMainFrame() {
		// set attributes
		this.setSize(Constants.EMainFrame.WIDTH.getInt(), Constants.EMainFrame.HEIGHT.getInt());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create and register components

		this.windowHandler = new windowHandler();
		this.addWindowListener(this.windowHandler);

		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);

		this.setLayout(new BorderLayout());

		this.pToolBar = new PToolBar();
		this.add(this.pToolBar, BorderLayout.NORTH);

		this.pMainPanel = new PSugangSincheongPanel();
		this.add(this.pMainPanel, BorderLayout.CENTER);

	}

	public void initialize(VUser vUser) {
		this.pMenuBar.initialize();
		this.pToolBar.initialize();
		this.pMainPanel.initialize(vUser);
	}

	public void save() {
		this.pMainPanel.save();
	}

	public class windowHandler implements WindowListener {

		public void windowActivated(WindowEvent e) {
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
			save();
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowOpened(WindowEvent e) {
		}

	}
}
