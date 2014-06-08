package edu.nju.bookHouse.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	private String category;

	private Set<Book> books = new HashSet<Book>();
	
	public Category(){}
	
	public Category(String category) {
		this.category = category;
	}
	
	@Id
	public String getCategory() {
		return category;
	}

	public void setCategory(String categoty) {
		this.category = categoty;
	}

	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
