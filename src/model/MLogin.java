package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLogin;

public class MLogin extends MModel {
	private Scanner scanner;
	private FileWriter fileWriter;
	private String userId;
	private String password;

	public MLogin(Scanner scanner) {
		this.scanner = scanner;
	}

	public MLogin(FileWriter fileWriter, VLogin vlogin) {
		this.fileWriter = fileWriter;
		this.userId = vlogin.getUserId();
		this.password = vlogin.getPassword();
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String read() {
		this.userId = scanner.next();
		this.password = scanner.next();
		return this.userId;
	}

	public void save(Vector<String> lines) throws IOException {
		for (String line : lines) {
			this.fileWriter.write(line + "\n");
		}

		this.fileWriter.write(this.userId + " ");
		this.fileWriter.write(this.password + "\n");
	}
}
