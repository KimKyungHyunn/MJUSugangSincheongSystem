package sugangSincheong;

import java.util.HashSet;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPGangjwaSelection;
import control.CDirectory;
import control.CLecture;
import valueObject.VLecture;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private Vector<VLecture> vLectures;
	private CLecture cLecture;
	private PResult pMiridamgi;
	private PResult pResult;
	
	public PGangjwaSelection() {
		cLecture = new CLecture();
		
		Vector<String> header = new Vector<String>();
		header.addElement(EPGangjwaSelection.gangjwaNo.getText());
		header.addElement(EPGangjwaSelection.gangjwaName.getText());
		header.addElement(EPGangjwaSelection.damGangCyosu.getText());
		header.addElement(EPGangjwaSelection.time.getText());
		tableModel = new DefaultTableModel(header, 0);
		this.setModel(tableModel);		
		this.vLectures = new Vector<VLecture>();
	}
	
	public void initialize(String fileName, PResult pMiridamgi, PResult pResult) {
		this.pMiridamgi = pMiridamgi;
		this.pResult = pResult;
		
		this.update(fileName);	
	}
	
	public void update(String fileName) {
		this.cLecture = new CLecture();
		this.vLectures = cLecture.getData(fileName);	
		this.removeDuplicateGangjwas(this.pMiridamgi.getGangjwas());
		this.removeDuplicateGangjwas(this.pResult.getGangjwas());
		updateTableData();
	}

	public void removeDuplicateGangjwas(Vector<VLecture> Ganjwas) {
		for(int index = this.vLectures.size()-1; index>=0; index--) {
			for(VLecture vLecture : Ganjwas) {
				if(this.vLectures.get(index).getId()==vLecture.getId()) {
					this.vLectures.remove(index);
					break;
				}
			}
		}
	}
	
	private void updateTableData(){
		this.tableModel.setRowCount(0);
		for(VLecture vLecture: vLectures) {				
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(vLecture.getId()));
			row.add(vLecture.getName());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			this.tableModel.addRow(row);				
		}		
		if (vLectures.size() > 0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
	}

	public Vector<VLecture> removeSelectedGangjwas() {
		int[] indexes = this.getSelectedRows();
		Vector<VLecture> vRemoveLectures = new Vector<VLecture>();
		for(int i = indexes.length-1; i>= 0; i--) {
			VLecture vRemoveLecture = this.vLectures.remove(indexes[i]);
			vRemoveLectures.add(vRemoveLecture);
		}
		this.updateTableData();
		return vRemoveLectures;
	}

	public void addGangjwas(Vector<VLecture> seletedLecture) {
		this.vLectures.addAll(seletedLecture);
		this.updateTableData();
	}
}
