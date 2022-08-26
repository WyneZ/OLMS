package com.d2.model;

public class Book {
	
	private int id;
	private String bookId, title, author, category;
	private int valid;
	
	public Book() {
		
	}
	
	public Book(int id, String bookId, String title, String author, String category, int valid) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.valid = valid;
	}
	
	public Book(String bookId, String title, String author, String category, int valid) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.valid = valid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}