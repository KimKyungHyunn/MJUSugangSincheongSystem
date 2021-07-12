package sugangSincheong;

import java.util.Vector;

import javax.swing.JPanel;

import valueObject.VLecture;

public abstract class PGangjwaContainer extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public abstract Vector<VLecture> removeSeletedGangjwas();
	public abstract void addGangjwas (Vector<VLecture> seletedLecture);
	
	
}
