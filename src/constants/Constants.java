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
		nameLabel(" ���̵�   "),
		sizeNameText("10"),
		passwordLabel("��й�ȣ"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		createButtonLabel("ȸ������"),
		noAccountInfo("ȸ������ �������� �ʽ��ϴ�"),
		loginFailed("���̵� ��й�ȣ�� Ʋ�Ƚ��ϴ�");
		
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
		idLabel("���̵�"),
		nameLabel("�̸�"),
		addressLabel("�ּ�"),
		passwordLabel("��й�ȣ"),
		sizeText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		doneMessage("ȸ������ �Ϸ�Ǿ����ϴ�");
		
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
		FILE("����"),
		EDIT("����");
		
		private String text;
		
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		NEW("����"),
		OPEN("����"),
		SAVE("����"),
		SAVEAS("�ٸ��̸�����"),
		PRINT("����Ʈ"),
		EXIT("����");
		
		private String text;
		
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		COPY("����"),
		CUT("�ڸ���"),
		PASTE("�ٿ��ֱ�"),
		DELETE("����");
		
		private String text;
		
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EDirectory {
		campus("ķ�۽�"),
		college("����"),
		hakgwa("�а�");
			
		private String text;
		
		EDirectory(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EPGangjwaSelection {
		gangjwaNo("���¹�ȣ"),
		gangjwaName("���¸�"),
		damGangCyosu("����米��"),
		time("�ð�");
			
		private String text;
		
		EPGangjwaSelection(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EPResultSelection {
		gangjwaNo("���¹�ȣ"),
		gangjwaName("���¸�");
		
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
