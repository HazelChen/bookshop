package edu.nju.bookshop.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer {
	private String id;
	private String password;
	
	private String sex;
	private String place;
	private Date birthday;
	
	private Date registerDay;
	
	private Bank bank;
	
	private Set<Book> booksBought = new HashSet<Book>();
	private Set<Book> booksInShoppingCart = new HashSet<Book>();
	private Set<Book> booksCollected = new HashSet<Book>();
}
