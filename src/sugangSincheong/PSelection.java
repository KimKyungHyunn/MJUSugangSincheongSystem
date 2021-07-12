package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import valueObject.VLecture;

public class PSelection extends PGangjwaContainer {
	private static final long serialVersionUID = 1L;

	private PHakgwaSelection pHakgwaSelection;
	private PGangjwaSelection pGangjwaSelection;

	public PSelection(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pHakgwaSelection = new PHakgwaSelection(listSelectionHandler);
		this.add(pHakgwaSelection);
		
		JScrollPane scrollPane = new JScrollPane();
		pGangjwaSelection = new PGangjwaSelection();
		scrollPane.setViewportView(pGangjwaSelection);
		this.add(scrollPane);
	}

	public void initialize(PResult pMiridamgi, PResult pResult) {
		this.pHakgwaSelection.initialize();
		String fileName = this.pHakgwaSelection.getFileName();
		this.pGangjwaSelection.initialize(fileName, pMiridamgi, pResult);
	}
	
	public void updateGangjwas(Object source) {
		String fileName = this.pHakgwaSelection.update(source);
		this.pGangjwaSelection.update(fileName);
	}

	public Vector<VLecture> removeSeletedGangjwas() {
		return this.pGangjwaSelection.removeSelectedGangjwas();
	}

	public void addGangjwas(Vector<VLecture> seletedLecture) {
		String fileName = this.pHakgwaSelection.getFileName();
		this.pGangjwaSelection.update(fileName);
	}
}
