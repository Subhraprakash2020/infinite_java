package com.java.library;

import java.sql.Date;

public class BookReturn {
	private String userName;
	private int bookId;
	private Date fromDate;
	private Date today;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	@Override
	public String toString() {
		return "BookReturn [userName=" + userName + ", bookId=" + bookId + ", fromDate=" + fromDate + ", today=" + today
				+ "]";
	}
	public BookReturn(String userName, int bookId, Date fromDate, Date today) {
		super();
		this.userName = userName;
		this.bookId = bookId;
		this.fromDate = fromDate;
		this.today = today;
	}
	public BookReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
