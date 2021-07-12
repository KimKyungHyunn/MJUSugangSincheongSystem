package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VApply;
import valueObject.VDirectory;
import valueObject.VLecture;
import valueObject.VLine;
import valueObject.VLogin;
import valueObject.VReservation;
import valueObject.VUser;
import model.MLecture;
import model.MLogin;
import model.MModel;
import model.MUser;

public class DAO {

	protected Connection connect;
	protected PreparedStatement statement;
	protected ResultSet resultSet;
	protected String sql;
	
	public DAO() {
		this.connect = null;
		this.statement = null;
		this.resultSet = null;
		this.sql = null;
	}

	public Connection getConnection() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");	        
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ApplySystem?serverTimezone=UTC","root","1234");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return connect;
	}

	public void closeConnection(Connection connect) {
		if (connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
			}
		}
	}

	public boolean checkLogin(String id, String pw) {
		this.sql = "select * from LoginList where loginID =? and  loginPW =?";	
		
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setString(1, id);
			this.statement.setString(2, pw);
			this.resultSet = this.statement.executeQuery();
			
			if(this.resultSet.next()) {				
				return true;
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return false;		
	}
	
	public VUser getStudent(String id) {
		VUser student = new VUser();		
		this.sql = "select * from Student where loginID =?";	
		
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setString(1, id);
			this.resultSet = this.statement.executeQuery();
			
			if(this.resultSet.next()) {
				student.setStudentID(resultSet.getInt("studentID"));
				student.setUserId(resultSet.getString("loginID"));
				student.setName(resultSet.getString("studentName"));
				student.setAccountNum(resultSet.getInt("accountNum"));
				student.setGrade(resultSet.getString("grade"));
				student.setMajor(resultSet.getString("major"));
				return student;
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return null;
	}
	
	public Vector<VLine> getAllLine() {
		Vector<VLine> VecLine = new Vector<VLine>();	
		this.sql = "select * from Line";	
		
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.resultSet = this.statement.executeQuery();
		
			while(resultSet.next()) {
				VLine line = new VLine();
				line.setLineID(resultSet.getInt("lineID"));
				line.setLineName(resultSet.getString("lineName"));
				VecLine.add(line);
			}
			return VecLine;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return null;
	}
	
	public Vector<VDirectory> getAllDepartment() {
		Vector<VDirectory> VecDepartment = new Vector<VDirectory>();	
		this.sql = "select * from Department";	
		
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.resultSet = this.statement.executeQuery();
		
			while(resultSet.next()) {
				VDirectory department = new VDirectory();
				department.setLineID(resultSet.getInt("DLineID"));
				department.setDepartmentID(resultSet.getInt("departmentID"));
				department.setDepartmentName(resultSet.getString("departmentName"));
				VecDepartment.add(department);
			}
			return VecDepartment;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return null;
	}
	
	public Vector<VDirectory> getDepartment(int lineID) {
		Vector<VDirectory> VecDepartment = new Vector<VDirectory>();	
		this.sql = "select * from Department where DLineID = ?";	
		
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setInt(1, lineID);
			this.resultSet = this.statement.executeQuery();
		
			while(resultSet.next()) {
				VDirectory department = new VDirectory();
				department.setLineID(resultSet.getInt("DLineID"));
				department.setDepartmentID(resultSet.getInt("departmentID"));
				department.setDepartmentName(resultSet.getString("departmentName"));
				VecDepartment.add(department);
			}
			return VecDepartment;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return null;
	}
	
	public Vector<VLecture> getAllLecture() {
		Vector<VLecture> VecLecture = new Vector<VLecture>();	
		this.sql = "select * from Lecture";
		
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);			
			this.resultSet = this.statement.executeQuery();
		
			while(resultSet.next()) {
				VLecture lecture = new VLecture();
				lecture.setDepartmentName(resultSet.getString("departmentName"));
				lecture.setId(resultSet.getInt("lectureID"));
				lecture.setName(resultSet.getString("lectureName"));
				lecture.setProfessor(resultSet.getString("professor"));
				lecture.setTime(resultSet.getString("lectureTime"));
				lecture.setGradeSize(resultSet.getInt("gradeSize"));
				lecture.setNumApplyPerson(resultSet.getInt("numApplyPerson"));
				lecture.setNumLimited(resultSet.getInt("numLimited"));
				VecLecture.add(lecture);
			}
			return VecLecture;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return null;
	}
	
	public Object getLecture(String where, Object value) {
		Vector<VLecture> VecLecture = new Vector<VLecture>();	
		VLecture Lecture = new VLecture();
		this.sql = "select * from Lecture where "+ where +" = ?";
		
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			
			if(value instanceof Integer) {							
				this.statement.setInt(1, (Integer)value);
			}else {
				this.statement.setString(1, (String)value);
			}
				
			this.resultSet = this.statement.executeQuery();
		
			while(resultSet.next()) {
				VLecture lecture = new VLecture();
				lecture.setDepartmentName(resultSet.getString("departmentName"));
				lecture.setId(resultSet.getInt("lectureID"));
				lecture.setName(resultSet.getString("lectureName"));
				lecture.setProfessor(resultSet.getString("professor"));
				lecture.setTime(resultSet.getString("lectureTime"));
				lecture.setGradeSize(resultSet.getInt("gradeSize"));
				lecture.setNumApplyPerson(resultSet.getInt("numApplyPerson"));
				lecture.setNumLimited(resultSet.getInt("numLimited"));
				Lecture = lecture;
				VecLecture.add(lecture);
			}
			if(where.equals("lectureID")) {
				return Lecture;
			}else {
				return VecLecture;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return null;
	}
	
	public boolean insertApply(String sugang, int lectureID, int studentID)  {
		this.sql = "insert into " + sugang + " values(?, ?)";
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setInt(1, lectureID);
			this.statement.setInt(2, studentID);
			int result = this.statement.executeUpdate();
			
			if(result>0) {
				return true;
			}
			} catch (SQLException e) {
				 e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return false;
	}
	
	public boolean deleteApply(String sugang, int lectureID, int studentID) {
		this.sql = "delete from "+ sugang + " where lectureID = ? and studentID = ?";
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setInt(1, lectureID);
			this.statement.setInt(2, studentID);
			int result = this.statement.executeUpdate();
			
			if(result>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return false;
	}
	
	public boolean checkLectureLimit(int lectureID) {
		this.sql = "select * from Lecture where lectureID = ? and numApplyPerson < numLimited";
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setInt(1, lectureID);
			this.resultSet = this.statement.executeQuery();
			
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return false;
	}

	public boolean updateNumApplyPerson(int value, int lectureID) {
		this.sql = "update Lecture set numApplyPerson = numApplyPerson+? where lectureID = ?";
		try {
			this.connect = getConnection();
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setInt(1, value);
			this.statement.setInt(2, lectureID);		
			int result = this.statement.executeUpdate();
			
			if(result>0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return false;
	}	
	
	public Object getApplyList(String sugang, int StudentID) {
		Vector<VApply> VecApply = new Vector<VApply>();	
		Vector<VReservation> VecReservation = new Vector<VReservation>();	
		
		this.sql = "select * from " + sugang + " where studentID = ?";
		
		try {
			this.connect = getConnection();		
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setInt(1, StudentID);	
			this.resultSet = this.statement.executeQuery();
			
			if (sugang.equals("Apply")) {
				while (resultSet.next()) {
					VApply apply = new VApply();
					apply.setLectureID(resultSet.getInt("lectureID"));
					apply.setStudentID(StudentID);
					VecApply.add(apply);
				}
				return VecApply;
			} else {
				while (resultSet.next()) {
					VReservation reservation = new VReservation();
					reservation.setLectureID(resultSet.getInt("lectureID"));
					reservation.setStudentID(StudentID);
					VecReservation.add(reservation);
				}
				return VecReservation;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return null;
	}
	
	public int maxID() {
		int maxID = 0;
		this.sql = "select Max(lectureID) from Lecture";

		try {
			this.connect = getConnection();		
			this.statement = this.connect.prepareStatement(this.sql);
			this.resultSet = this.statement.executeQuery();
			if(this.resultSet.next()) {
				maxID = this.resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return maxID + 1;
	}


	public boolean insertNewLecture(int num, String DepartmentName, String Name, String Professor, String Time,
			String GradeSize, String NumLimited) {
		this.sql = "insert into Lecture values(?,?,?,?,?,?,?,?)";

		try {
			this.connect = getConnection();		
			this.statement = this.connect.prepareStatement(this.sql);
			this.statement.setString(1, DepartmentName);	
			this.statement.setInt(2, num);	
			this.statement.setString(3, Name);	
			this.statement.setString(4, Professor);	
			this.statement.setString(5, Time);	
			this.statement.setInt(6, Integer.parseInt(GradeSize));	
			this.statement.setInt(7, 0);	
			this.statement.setInt(8, Integer.parseInt(NumLimited));	
			
			int result = this.statement.executeUpdate();
			
			if(result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connect);
		}	
		return false;
	}
	
	public void getStudentInfor() {

	}

	public MModel getAModel(String fileName, Class<?> clazz, String key) {
		try {
			Scanner scanner = new Scanner(new File("2lms_swing/userInfo/" + fileName));			
			while (scanner.hasNext()) {
				Constructor<?> constructor = clazz.getConstructor(Scanner.class);					
				MModel mModel = (MModel)constructor.newInstance(scanner);
				String mModelkey = mModel.read();
				if (mModelkey.contentEquals(key)) {
					scanner.close();
					return mModel;
				}
			}
			scanner.close();
		} catch (FileNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void saveResult(String fileName, Vector<VLecture> vLectures) {
		try {
			FileWriter fileWriter = new FileWriter(new File("2lms_swing/data/"+fileName));
			for(VLecture vLecture : vLectures) {
				MLecture mLecture = new MLecture(fileWriter, vLecture);
				mLecture.save();
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<MModel> getModels(String FileName, Class<?> clazz){
		Vector<MModel> mModels = new Vector<MModel>();
		try {
			File file = new File("2lms_swing/data/" + FileName);
			if (file.exists()) {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNext()) {
					Constructor<?> constructor = clazz.getConstructor(Scanner.class);
					MModel mModel = (MModel) constructor.newInstance(scanner);
					mModel.read();
					mModels.add(mModel);
				}
				scanner.close();
			}			
		} catch (FileNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return mModels;
	}

	public void createUser(VUser vuser) {
		try {
			FileWriter fileWriter = new FileWriter(new File("2lms_swing/userInfo/"+vuser.getUserId()));
			MUser mUser = new MUser(fileWriter, vuser);
			mUser.save();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createAccount(VLogin vlogin) throws IOException {
		File file = new File("2lms_swing/userInfo/userId");
		Vector<String> lines = new Vector<String>();
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}
		
		FileWriter fileWriter = new FileWriter(file);
		MLogin mLogin = new MLogin(fileWriter, vlogin);
		mLogin.save(lines);
		fileWriter.close();
	}
}