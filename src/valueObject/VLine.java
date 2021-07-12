package valueObject;

public class VLine {
	
	int LineID;
	String LineName;
	
	public VLine() {
	  	this.LineID = 0;
		this.LineName = null;
	}
	
	public int getLineID() {
		return LineID;
	}
	public void setLineID(int lineID) {
		LineID = lineID;
	}
	public String getLineName() {
		return LineName;
	}
	public void setLineName(String lineName) {
		LineName = lineName;
	}
	
	
}
