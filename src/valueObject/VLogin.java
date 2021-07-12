package valueObject;

public class VLogin {
	private String userId;
	private String password;
	
	public VLogin(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public VLogin() {
		this.userId = null;
		this.password = null;
	}
	
	public void setID(String id) {
		userId = id;
	}
	public void setPW(String pw) {
		password = pw;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
}
