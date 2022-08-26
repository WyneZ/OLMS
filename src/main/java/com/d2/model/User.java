package com.d2.model;

public class User {
	
	private int id;
	private String name;
	private String roll_no;
	private String title, author, date;
	
	public User(String name, String roll_no, String title, String author, String date) {
		super();
		this.name = name;
		this.roll_no = roll_no;
		this.title = title;
		this.author = author;
		this.date = date;
	}
	public User(int id, String name, String roll_no, String title, String author, String date) {
		super();
		this.id = id;
		this.name = name;
		this.roll_no = roll_no;
		this.title = title;
		this.author = author;
		this.date = date;
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
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
