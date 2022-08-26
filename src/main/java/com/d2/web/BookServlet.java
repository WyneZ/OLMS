package com.d2.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.d2.dao.BookDAO;
import com.d2.dao.UserDAO;
import com.d2.model.Book;
import com.d2.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bDao;
	private UserDAO uDao;
	
	@Override
	public void init() throws ServletException {
		bDao = new BookDAO();
		uDao = new UserDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/user":
				userView(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
			case "/list":
				listBook(request, response);
				break;
			case "/login":
				logIn(request, response);
				break;
			case "/rent":
				rentBook(request, response);
				break;
			case "/rentList":
				listRent(request, response);
				break;
			case "/insertUser":
				insertUser(request, response);
				break;
			case "/deleteUser":
				deleteUser(request, response);
				break;
			case "/searchAuthor":
				searchAuthor(request, response);
				break;
			case "/uSearchAuthor":
				uSearchAuthor(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			default:
				choose(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void userView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> listBook = bDao.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-view.jsp");
		dispatcher.forward(request, response);
	}

	private void choose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("choose.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
	
	private void rentBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book b = bDao.selectBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("b", b);
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String roll_no = request.getParameter("roll_no");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		User user = new User(name, roll_no, title, author, date);
		uDao.insertUser(user);
		response.sendRedirect("user");
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Book> listBook = bDao.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listRent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = uDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rent-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bDao.selectBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-book-form.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int bId = Integer.parseInt(request.getParameter("bid"));
		String bookId = request.getParameter("bid");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		int valid = 1;
		Book newBook = new Book(bookId, title, author, category, valid);
		bDao.insertBook(newBook);
		response.sendRedirect("list");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String bookId = request.getParameter("bid");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		int valid = Integer.parseInt(request.getParameter("valid"));
		Book book = new Book(id, bookId, title, author, category, valid);
		bDao.updateBook(book);
		
		List<User> users = uDao.selectAllUsers();
		for(User u : users) {
			if(u.getTitle().equals(title)) {
				
			}
		}
		response.sendRedirect("list");
	}
	
	private void searchAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aName = request.getParameter("author");
		List<Book> bList = bDao.selectAllBooks();
		List<Book> bookList = new ArrayList<>();
		//Book b = new Book();
		for(Book b : bList) {
			if(b.getAuthor().equals(aName)) {
				bookList.add(b);
			}
		}
		request.setAttribute("authorList", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchAuthor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void uSearchAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aName = request.getParameter("author");
		List<Book> bList = bDao.selectAllBooks();
		List<Book> bookList = new ArrayList<>();
		//Book b = new Book();
		for(Book b : bList) {
			if(b.getAuthor().equals(aName)) {
				bookList.add(b);
			}
		}
		request.setAttribute("authorList", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("uSearchAuthor.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bDao.deleteBook(id);
		response.sendRedirect("list");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		uDao.deleteUser(id);
		response.sendRedirect("rentList");
	}
	

}
