package com.d2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.d2.model.Book;

public class BookDAO {
	
	private String url = "jdbc:mysql://127.0.0.1:3306/Library";
	private String uName = "root";
	private String pw = "withkukuu";
	
	private static final String INSERT_BOOKS_SQL = "INSERT INTO books_tb" + " (bookId, title, author, category, valid) VALUES " 
													+ "(?, ?, ?, ?, ?);";
	
	private static final String SELECT_BOOK_BY_ID = "select id,bookId,title,author,category,valid from books_tb where id =?";
	private static final String SELECT_ALL_BOOKS = "select * from books_tb";
	private static final String DELETE_BOOK_SQL = "delete from books_tb where id =?;";
	private static final String UPDATE_BOOK_SQL = "update books_tb set bookId = ?, title = ?, author = ?, category = ?, valid = ? where id =?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, uName, pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//Create or Insert book
	public void insertBook(Book book) throws SQLException {
		try(Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(INSERT_BOOKS_SQL)) {
			//pst.setInt(1, book.getId());
			pst.setString(1, book.getBookId());	
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getCategory());
			pst.setInt(5, 1);
			System.out.println(pst);
			pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Update book
	public boolean updateBook(Book book) throws SQLException {
		boolean rowUpdated;
		try(Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(UPDATE_BOOK_SQL)) {
			pst.setString(1, book.getBookId());
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getCategory());
			pst.setInt(5, book.getValid());
			pst.setInt(6, book.getId());
			rowUpdated = pst.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//Select Book by Id
	public Book selectBook(int id) {
		Book b = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String bookId = rs.getString("bookId");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				int valid = rs.getInt("valid");
				
				b = new Book(id, bookId, title, author, category, valid);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return b;
	}
	
	
	//Select books 
	public List<Book> selectAllBooks() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Book> books = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String bookId = rs.getString("bookId");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				int valid = rs.getInt("valid");
				books.add(new Book(id, bookId, title, author, category, valid));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return books;
	}
	
	
	//Delete book
	public boolean deleteBook(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}