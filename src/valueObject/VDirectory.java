package valueObject;

import java.util.Vector;

public class VDirectory {
	private String name;
	private String fileName;
	
	private int LineID;
	private  int departmentID;
    private String departmentName;
	
	public VDirectory(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}
	
	public VDirectory() {
		this.LineID = 0;
		this.departmentID = 0;
		this.departmentName = null;
	}

	public String getName() {
		return name;
	}

	public String getFileName() {
		return fileName;
	}
	public int getLineID() {
		return LineID;
	}

	public void setLineID(int lineID) {
		LineID = lineID;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}

