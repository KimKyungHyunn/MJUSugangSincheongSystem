package sugangSincheong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants.EConfiguration;
import valueObject.VLecture;
import valueObject.VUser;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PSelection pSelection;
	private PMove pMove1;
	private PResult pMiridamgi;
	private PMove pMove2;
	private PResult pResult;
	private String userID;
	private VUser vUser;

	public PContentPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		ActionHandler actionHandler = new ActionHandler();
		ListSelectionListener listSelectionHandler = new ListSelectionHandler();

		this.pSelection = new PSelection(listSelectionHandler);
		this.add(this.pSelection);

		this.pMove1 = new PMove(actionHandler);
		this.add(this.pMove1);

		this.pMiridamgi = new PResult();
		this.add(pMiridamgi);

		this.pMove2 = new PMove(actionHandler);
		this.add(this.pMove2);

		this.pResult = new PResult();
		this.add(pResult);
	}

	public void initialize(VUser vUser) {
		this.vUser = vUser;

		this.pMove1.initialize();
		this.pMove2.initialize();

		this.pMiridamgi.initialize(vUser.getUserId() + EConfiguration.miridamgifilePostfix.getText());
		this.pResult.initialize(vUser.getUserId() + EConfiguration.sincheongfilePostfix.getText());

		this.pSelection.initialize(this.pMiridamgi, this.pResult);
	}

	public void save() {
		this.pMiridamgi.save(vUser.getUserId() + EConfiguration.miridamgifilePostfix.getText());
		this.pResult.save(vUser.getUserId() + EConfiguration.sincheongfilePostfix.getText());
	}

	public void updateGangjwas(Object source) {
		this.pSelection.updateGangjwas(source);
	}

	private void moveGangjwas(PGangjwaContainer source, PGangjwaContainer target) {
		Vector<VLecture> vSelectedGangjwas = source.removeSeletedGangjwas();
		target.addGangjwas(vSelectedGangjwas);
	}

	private void moveGangjwas(Object source) {
		if (source.equals(this.pMove1.getMoveRightButton())) {
			this.moveGangjwas(this.pSelection, this.pMiridamgi);
		} else if (source.equals(this.pMove1.getMoveLeftButton())) {
			this.moveGangjwas(this.pMiridamgi, this.pSelection);
		} else if (source.equals(this.pMove2.getMoveRightButton())) {
			this.moveGangjwas(this.pMiridamgi, this.pResult);
		} else if (source.equals(this.pMove2.getMoveLeftButton())) {
			this.moveGangjwas(this.pResult, this.pMiridamgi);
		}
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			moveGangjwas(e.getSource());
		}
	}

	public class ListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			updateGangjwas(event.getSource());
		}
	}
}
