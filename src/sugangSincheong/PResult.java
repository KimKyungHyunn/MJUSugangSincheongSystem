package sugangSincheong;

import java.util.Scanner;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPResultSelection;
import control.CResult;
import valueObject.VDirectory;
import valueObject.VLecture;
import valueObject.VUser;


public class PResult extends PGangjwaContainer {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Vector<VLecture> vLectures;
	private DefaultTableModel tableModel;
	
	public PResult() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.table);
		this.add(scrollPane);
		
		Vector<String> header = new Vector<String>();
		header.addElement(EPResultSelection.gangjwaNo.getText());
		header.addElement(EPResultSelection.gangjwaName.getText());
		tableModel = new DefaultTableModel(header, 0);
		this.table.setModel(tableModel);	
		this.vLectures = new Vector<VLecture>();
	}
	
	public void initialize(String fileName) {
		CResult cResult = new CResult();
		this.vLectures = cResult.get(fileName);
		this.updateTableData();
	}
	
	public void save(String fileName) {
		CResult cResult = new CResult();
		cResult.save(fileName, this.vLectures);
	}
	
	public Vector<VLecture> removeDuplicateGangjwas(Vector<VLecture> SelectedLectures) {
		Vector<VLecture> NewLectures = new Vector<VLecture>();
		for(VLecture SLecture: SelectedLectures) {	
			boolean flag = false;
			for(VLecture Lectures : this.vLectures) {
				if(SLecture.getId()==Lectures.getId()) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				NewLectures.add(SLecture);
			}
		}
		return NewLectures;
	}
	
	private void updateTableData(){
		this.tableModel.setRowCount(0);
		for(VLecture Lecture: vLectures) {				
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(Lecture.getId()));
			row.add(Lecture.getName());
			this.tableModel.addRow(row);				
		}			
		if (vLectures.size() > 0) {
			this.table.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
	
	public void addGangjwas(Vector<VLecture> SelectedLectures) {
		this.vLectures.addAll(SelectedLectures);
		this.updateTableData();
	}	
	
	public Vector<VLecture> getGangjwas() {
		return this.vLectures;
	}

	@Override
	public Vector<VLecture> removeSeletedGangjwas() {
		int[] indexes = this.table.getSelectedRows();
		Vector<VLecture> vRemoveLectures = new Vector<VLecture>();
		for(int i = indexes.length-1; i>= 0; i--) {
			VLecture vRemoveLecture = this.vLectures.remove(indexes[i]);
			vRemoveLectures.add(vRemoveLecture);
		}
		this.updateTableData();
		return vRemoveLectures;
	}
}
