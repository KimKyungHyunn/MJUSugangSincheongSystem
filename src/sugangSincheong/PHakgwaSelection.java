package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EConfiguration;
import constants.Constants.EDirectory;
import control.CDirectory;
import valueObject.VDirectory;

public class PHakgwaSelection extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	private String fileName;
	
	public PHakgwaSelection(ListSelectionListener listSelectionHandler) {	
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		

		JScrollPane scrollpane1 = new JScrollPane();
		this.pCampus = new PDirectory(EDirectory.campus.getText(), listSelectionHandler);
		scrollpane1.setViewportView(this.pCampus);
		this.add(scrollpane1);

		JScrollPane scrollpane2 = new JScrollPane();
		this.pCollege = new PDirectory(EDirectory.college.getText(), listSelectionHandler);
		scrollpane2.setViewportView(this.pCollege);
		this.add(scrollpane2);

		JScrollPane scrollpane3 = new JScrollPane();
		this.pHakgwa = new PDirectory(EDirectory.hakgwa.getText(), listSelectionHandler);
		scrollpane3.setViewportView(this.pHakgwa);
		this.add(scrollpane3);
	}

	public void initialize() {
		this.fileName = EConfiguration.rootFileName.getText();
		this.fileName = this.pCampus.initialize(fileName);
		this.fileName = this.pCollege.initialize(fileName);
		this.fileName = this.pHakgwa.initialize(fileName);		
	}
	
	public String update(Object source) {
		if(source.equals(this.pCampus.getSelectionModel())) {
			fileName = this.pCampus.vDirectories.get(this.pCampus.getSelectedRow()).getFileName();
			fileName = this.pCollege.initialize(fileName);
			fileName = this.pHakgwa.initialize(fileName);
		}else if(source.equals(this.pCollege.getSelectionModel())) {						
			fileName = this.pCollege.vDirectories.get(this.pCollege.getSelectedRow()).getFileName();
			fileName = this.pHakgwa.initialize(fileName);
		}else if(source.equals(this.pHakgwa.getSelectionModel())) {
			fileName = this.pHakgwa.vDirectories.get(this.pHakgwa.getSelectedRow()).getFileName();
		}
		return fileName;
	}
	
	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;
		
		private CDirectory cDirectory;
		private DefaultTableModel tableModel;
		private ListSelectionListener listSelectionHandler;
		private Vector<VDirectory> vDirectories;
		
		public PDirectory(String title, ListSelectionListener listSelectionHandler) {
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.cDirectory = new CDirectory();
			this.listSelectionHandler = listSelectionHandler;
			Vector<String> header = new Vector<String>();
			header.addElement(title);				
			tableModel = new DefaultTableModel(header, 0);
			this.setModel(tableModel);		
			this.getSelectionModel().addListSelectionListener(listSelectionHandler);			
		}
		
		public String initialize(String fileName) {
			getData(fileName);
			return  vDirectories.get(this.getSelectedRow()).getFileName();
		}
		
		//filename의 데이터 가져와 테이블 저장, 출력
		public void getData(String filename) {
			this.getSelectionModel().removeListSelectionListener(listSelectionHandler);
			this.tableModel.setRowCount(0);
			vDirectories = cDirectory.getData(filename);	
			for(VDirectory vDirectory: vDirectories) {				
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);				
			}			
			if (vDirectories.size() > 0) {
				this.getSelectionModel().addSelectionInterval(0, 0);
			}
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
		}	

	}
	public String getFileName() {
		return this.fileName;
	}
}
