package com.java.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAOImpl implements LibraryDAO {

	Connection connection;
	PreparedStatement pst;

	public boolean checkPassword(String pwd, String retype) {
		if (pwd.equals(retype)) {
			return true;
		}
		return false;
	}
	@Override
	public int issueOrNot(String userName, int bookId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionHelper.getConnection();
		String sql = "select count(*) cnt from TranBook where UserName=? and BookId=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, userName);
		pst.setInt(2, bookId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count =rs.getInt("cnt");
		return count;
	}

	@Override
	public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encPwd = EncryptPassword.getCode(libUsers.getPassword());
		String cmd = "Insert into LibUsers(UserName, passWord) values (?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, libUsers.getUserName());
		pst.setString(2, encPwd);
		pst.executeUpdate();
		return "Uset account Created";
	}

	@Override
	public int authenticate(LibUsers libusers) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encr = EncryptPassword.getCode(libusers.getPassword());
		String cmd = "Select count(*) cnt from LibUsers where userName = ? AND password = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, libusers.getUserName());
		pst.setString(2, encr.trim());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;

	}

	@Override
	public List<Book> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String sql;
		boolean isValid = true;
		if (searchType.equals("id")) {
			sql = " SELECT * FROM Books WHERE Id = ? ";
		} else if (searchType.equals("bookname")) {
			sql = " SELECT * FROM Books WHERE Name = ? ";
		} else if (searchType.equals("authorname")) {
			sql = " SELECT * FROM Books WHERE Author = ? ";
		} else if (searchType.equals("dept")) {
			sql = " SELECT * FROM Books WHERE Dept = ? ";
		} else {
			isValid = false;
			sql = " SELECT * FROM Books";
		}
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(sql);
		if (isValid == true) {
			pst.setString(1, searchValue);
		}
		ResultSet rs = pst.executeQuery();
		Book book = null;
		List<Book> booksList = new ArrayList<Book>();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setEdition(rs.getString("edition"));
			book.setDept(rs.getString("dept"));
			book.setNoOfbook(rs.getInt("TotalBooks"));
			booksList.add(book);
		}
		return booksList;

	}

	@Override
	public Book searchType(int id) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from books where id = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Book book = null;
		List<Book> bookList = new ArrayList<Book>();
		if (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setDept(rs.getString("dept"));
			book.setNoOfbook(rs.getInt("totalBooks"));
			bookList.add(book);
		}
		return book;
	}


	@Override
	public String issueBook(String userName, String bookId) throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(bookId);
		int count = issueOrNot(userName, id);
		Book bookdata = searchType(id);
		System.out.println("bookdata"+bookdata);
		int bookavail = bookdata.getNoOfbook();
		System.out.println("bookaava"+bookavail);
		if (bookavail > 0) {
			connection = ConnectionHelper.getConnection();
			String cmd = "insert into tranbook(Username, BookId) values(?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, userName);
			pst.setString(2, bookId);
			pst.executeUpdate();
			cmd = "update books set TotalBooks=TotalBooks-1 where id =?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, bookId);
			pst.executeUpdate();
			cmd = "insert into transreturn(username, Bookid) values(?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, userName);
			pst.setString(2, bookId);
			pst.executeUpdate();
			System.out.println("Sucesss");
		}
		return "Book Issued....";
	}

	@Override
	public List<LibUser> showHistory(String userName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from tranbook where userName = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, userName);
		ResultSet rs = pst.executeQuery();
		List<LibUser> bookList = new ArrayList<LibUser>();
		LibUser book = null;
		while(rs.next()) {
			book = new LibUser();
			book.setUserName(rs.getString("userName"));
			book.setBookId(rs.getInt("bookId"));
			book.setFromDate(rs.getDate("fromdate"));
			bookList.add(book);
			
		}
		
		return bookList;
	}

	@Override
	public List<BookReturn> showReturn(String userName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from transreturn";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<BookReturn> bookList = new ArrayList<BookReturn>();
		BookReturn bookR = null;
		while(rs.next()) {
			bookR = new BookReturn();
			bookR.setUserName(rs.getString("userName"));
			bookR.setBookId(rs.getInt("BookId"));
			bookR.setFromDate(rs.getDate("fromDate"));
			bookR.setToday(rs.getDate("todate"));
			bookList.add(bookR);
		}
		return bookList;
		
	}

	@Override
	public String returnBook(String bookId) throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(bookId);
		connection = ConnectionHelper.getConnection();
		String cmd = "Delete from transreturn where bookId = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, bookId);
		pst.executeUpdate();
		
		cmd =  "update books set TotalBooks=TotalBooks+1 where id =?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, bookId);
		pst.executeUpdate();
		
		return null;
	}
	

}
