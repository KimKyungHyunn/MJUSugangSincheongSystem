package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.VUser;

public class MUser extends MModel{
	private Scanner scanner;
	private FileWriter fileWriter;
	private String userId;
	private String name;
	private String address;
	
	public MUser(Scanner scanner) {
		this.scanner = scanner;
	}

	public MUser(FileWriter fileWriter, VUser vuser) {
		this.fileWriter = fileWriter;
		this.userId = vuser.getUserId();
		this.address = vuser.getAddress();
		this.name = vuser.getName();
	}

	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}

	public String read() {		
		this.userId = scanner.nextLine();
		this.name = scanner.nextLine();
		this.address = scanner.nextLine();
		return userId;
	}

	public void save() {
		try {
			this.fileWriter.write(this.userId+ "\n");
			this.fileWriter.write(this.name+ "\n");
			this.fileWriter.write(this.address);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
