package edu.nju.bookHouse.model.analyse;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoryAnalyse")
public class CategoryAnalyse {
	private String category;
	private int count;
	private Set<BookAnalyse> bookAnalyses;
	
	public CategoryAnalyse(){}
	
	public CategoryAnalyse(String category, int count) {
		this.category = category;
		this.count = count;
	}
	
	@Id
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@OneToMany(mappedBy="categoryAnalyse",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<BookAnalyse> getBookAnalyses() {
		return bookAnalyses;
	}

	public void setBookAnalyses(Set<BookAnalyse> bookAnalyses) {
		this.bookAnalyses = bookAnalyses;
	}
	
	
	
}
