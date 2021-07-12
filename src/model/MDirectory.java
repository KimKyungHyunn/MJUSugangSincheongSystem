package model;

import java.util.Scanner;

public class MDirectory extends MModel {
	private Scanner scanner;
	private String id;
	private String name;
	private String fileName;

	public MDirectory(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFileName() {
		return fileName;
	}

	public String read() {
		this.id = scanner.next();
		this.name = scanner.next();
		this.fileName = scanner.next();
		return this.id;
	}
}
