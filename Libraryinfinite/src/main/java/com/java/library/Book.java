package com.java.library;

public class Book {
	private int id;
	private String name;
	private String author;
	private String edition;
	private String dept;
	private int noOfbooks;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getNoOfbook() {
		return noOfbooks;
	}
	public void setNoOfbook(int noOfbook) {
		this.noOfbooks = noOfbook;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", edition=" + edition + ", dept=" + dept
				+ ", noOfbook=" + noOfbooks + "]";
	}
	public Book(int id, String name, String author, String edition, String dept, int noOfbook) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.dept = dept;
		this.noOfbooks = noOfbook;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
