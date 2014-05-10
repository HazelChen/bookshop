package edu.nju.bookshop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book {
	private String id;
	private String name;
	private String ISBN;
	private String author;
	private String category;
	private String press;
	private Date publishDate;
	private double price;
	private String description;
	private int num;
	
	private Set<Customer> customersBoughtIt = new HashSet<Customer>();
	private Set<Customer> customersPutCart = new HashSet<Customer>();
	private Set<Customer> customersCollectedIt = new HashSet<Customer>();
	
}
