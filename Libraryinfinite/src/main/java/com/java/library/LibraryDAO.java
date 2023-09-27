package com.java.library;

import java.sql.SQLException;
import java.util.List;



public interface LibraryDAO {
	String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException;
	int authenticate(LibUsers libusers) throws ClassNotFoundException, SQLException;
//	List<Book> searchType(String dept) throws ClassNotFoundException, SQLException;
	Book searchType(int id) throws ClassNotFoundException, SQLException;
	List<Book> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException;
//	String updateBooks(Book book) throws ClassNotFoundException, SQLException;
	int issueOrNot(String userName, int bookId) throws ClassNotFoundException, SQLException;
	String issueBook(String userName, String bookId) throws ClassNotFoundException, SQLException;
	List<LibUser> showHistory(String userName) throws ClassNotFoundException, SQLException;
	List<BookReturn> showReturn(String userName) throws ClassNotFoundException, SQLException;
	String returnBook( String bookId) throws ClassNotFoundException, SQLException;
}
