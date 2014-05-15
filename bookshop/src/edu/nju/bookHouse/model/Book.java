package edu.nju.bookHouse.model;

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
	
	private Set<CustomerInfo> customersBoughtIt = new HashSet<CustomerInfo>();
	private Set<CustomerInfo> customersPutCart = new HashSet<CustomerInfo>();
	private Set<CustomerInfo> customersCollectedIt = new HashSet<CustomerInfo>();
	
}
