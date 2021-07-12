package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.VLecture;

public class MLecture extends MModel{
	private Scanner scanner;
	private FileWriter fileWriter;
	private int id;	
	private String name;
	private String professor;
	private int grade;	
	private String time;
	
	public MLecture(Scanner scanner) {
		this.scanner = scanner;
	}	

	public MLecture(FileWriter fileWriter, VLecture vLecture) {
		this.fileWriter = fileWriter;
		this.id = vLecture.getId();
		this.name = vLecture.getName();
		this.professor = vLecture.getProfessor();
		this.grade = vLecture.getGrade();
		this.time = vLecture.getTime();
	}

	public String read() {		
		this.id = scanner.nextInt();
		this.name = scanner.next();
		this.professor = scanner.next();
		this.grade = scanner.nextInt();
		this.time = scanner.next();
		return Integer.toString(this.id);
	}	

	public void save() {
		try {
			this.fileWriter.write(this.id+ " ");
			this.fileWriter.write(this.name+ " ");
			this.fileWriter.write(this.professor+ " ");
			this.fileWriter.write(this.grade+ " ");
			this.fileWriter.write(this.time+ "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Scanner getScanner() {
		return scanner;
	}

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getProfessor() {
		return professor;
	}


	public int getGrade() {
		return grade;
	}


	public String getTime() {
		return time;
	}

}
