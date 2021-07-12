package valueObject;

public class VReservation {
	int lectureID;
    int studentID;
//    String lectureTime;
    
    public VReservation() {
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

//	public String getLectureTime() {
//		return lectureTime;
//	}
//
//	public void setLectureTime(String lectureTime) {
//		this.lectureTime = lectureTime;
//	}
    
    
}
