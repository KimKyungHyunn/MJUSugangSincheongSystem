package constants;

public class Constants {
	
	public enum EConfiguration {
		rootFileName("root"),
		miridamgifilePostfix("M"),
		sincheongfilePostfix("S");
		
		private String text;
		private EConfiguration(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum ELoginDialog {
		width("300"),
		height("200"),
		nameLabel(" 아이디   "),
		sizeNameText("10"),
		passwordLabel("비밀번호"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		createButtonLabel("회원가입"),
		noAccountInfo("회원정보 존재하지 않습니다"),
		loginFailed("아이디나 비밀번호가 틀렸습니다");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	public enum ECreateDialog {
		width("300"),
		height("600"),
		idLabel("아이디"),
		nameLabel("이름"),
		addressLabel("주소"),
		passwordLabel("비밀번호"),
		sizeText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		doneMessage("회원가입 완료되었습니다");
		
		private String text;
		private ECreateDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EMainFrame {
		WIDTH("1000"),
		HEIGHT("600");
		
		private String text;
		private EMainFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EMenuBar {
		FILE("파일"),
		EDIT("편집");
		
		private String text;
		
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		NEW("생성"),
		OPEN("열기"),
		SAVE("저장"),
		SAVEAS("다른이름으로"),
		PRINT("프린트"),
		EXIT("종료");
		
		private String text;
		
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		COPY("복사"),
		CUT("자르기"),
		PASTE("붙여넣기"),
		DELETE("삭제");
		
		private String text;
		
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EDirectory {
		campus("캠퍼스"),
		college("대학"),
		hakgwa("학과");
			
		private String text;
		
		EDirectory(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EPGangjwaSelection {
		gangjwaNo("강좌번호"),
		gangjwaName("강좌명"),
		damGangCyosu("강담당교수"),
		time("시간");
			
		private String text;
		
		EPGangjwaSelection(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EPResultSelection {
		gangjwaNo("강좌번호"),
		gangjwaName("강좌명");
		
		private String text;
		
		EPResultSelection(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EImages {
		Miri("2lms_swing/image/miri.png"),
		Gain("2lms_swing/image/gain.png");	
		private String text;
		
		EImages(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
}
