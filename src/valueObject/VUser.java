package valueObject;

public class VUser {
	private String userId;
	private String name;
	private String address;
	
	private int StudentID;
	private String PW;
	private int AccountNum;
	private String Grade;
	private String major;
	//String ID;
	//String Name;

	public VUser(String userId, String name, String address) {
		this.userId = userId;
		this.name = name;
		this.address = address;
	}
	
	public VUser() {
		this.StudentID = 0;
		this.userId = null;
		this.PW = null;
		this.AccountNum = 0;
		this.Grade = null;
		this.major = null;
		this.name = null;		
	}
	
	public void setUserId(String string) {
		userId = string;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//setAddress();
	
	public String getAddress() {
		return address;
	}
	
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	
	public int getStudentID() {
		return StudentID;
	}

	public void setPW(String pW) {
		PW = pW;
	}
	
	public String getPW() {
		return PW;
	}

	
	public void setAccountNum(int accountNum) {
		AccountNum = accountNum;
	}
	
	public int getAccountNum() {
		return AccountNum;
	}


	public void setGrade(String grade) {
		Grade = grade;
	}
	
	public String getGrade() {
		return Grade;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}	
	
	public String getMajor() {
		return major;
	}
	
}
