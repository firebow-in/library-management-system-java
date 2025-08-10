package com.lms;

public class User {
	
	private String userId;
	private String name;
	private Book issuedBook;
	
	public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBook = null; 
    }
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public Book getIssuedBook() {
		return issuedBook;
	}
	
	 public void issueBook(Book book) {
	        this.issuedBook = book;
	        book.issue();
	 }

	 public void returnBook() {
	     if (this.issuedBook != null) {
	         this.issuedBook.returnBook();
	         this.issuedBook = null;
	     }
	 }
	 @Override
	 public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", issuedBook=" + issuedBook + "]";
	 }
	
	 

}
