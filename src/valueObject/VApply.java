package valueObject;

public class VApply {
	int lectureID;
    int studentID;
    
    public VApply() {
    	this.lectureID = 0;
		this.studentID = 0;
    }
    
	public int getLectureID() {
		return lectureID;
	}

	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
       
}
