package valueObject;

public class VLecture {
	private int id;	
	private String name;
	private String professor;
	private int grade;	
	private String time;
	
	private String departmentName;
	private int GradeSize;
	private int numApplyPerson;
	private int numLimited;
	//int ID;
	//String Name;
	//String Professor;
	//String Time;
	
	public VLecture(int id, String name, String professor, int grade, String time) {
		this.id = id;
		this.name = name;
		this.professor = professor;
		this.grade = grade;
		this.time = time;
	}

	public VLecture() {
		this.id = 0;
		this.name = null;
		this.professor = null;
		this.time = null;
		this.GradeSize = 0;
		this.departmentName = null;
		this.numApplyPerson = 0;
		this.numLimited = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getGradeSize() {
		return GradeSize;
	}

	public void setGradeSize(int gradeSize) {
		GradeSize = gradeSize;
	}

	public int getNumApplyPerson() {
		return numApplyPerson;
	}

	public void setNumApplyPerson(int numApplyPerson) {
		this.numApplyPerson = numApplyPerson;
	}

	public int getNumLimited() {
		return numLimited;
	}

	public void setNumLimited(int numLimited) {
		this.numLimited = numLimited;
	}
	
}