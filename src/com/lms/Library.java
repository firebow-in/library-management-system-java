package com.lms;

import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) return book;
        }
        return null;
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) return user;
        }
        return null;
    }

    public boolean issueBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println(" Book not found.");
            return false;
        }
        if (user == null) {
            System.out.println(" User not found.");
            return false;
        }
        if (book.isIssued()) {
            System.out.println(" Book is already issued to someone.");
            return false;
        }
        if (user.getIssuedBook() != null) {
            System.out.println(" User already has a book issued.");
            return false;
        }

        user.issueBook(book);
        System.out.println(" Book issued successfully to " + user.getName());
        return true;
    }

    public boolean returnBook(String userId) {
        User user = findUserById(userId);
        if (user != null && user.getIssuedBook() != null) {
            user.returnBook();
            System.out.println(" Book returned successfully by " + user.getName());
            return true;
        }
        System.out.println(" No book to return or user not found.");
        return false;
    }

    public void listAllBooks() {
        System.out.println("📚 Book List:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listAllUsers() {
        System.out.println("👥 User List:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
