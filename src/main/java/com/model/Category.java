package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.springframework.stereotype.Component;


@Component
@Entity

public class Category 

{
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int cid;
	
	private String categoryName;
	 
	 private String categoryDescription;

	
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	 private Set<Product> products = new HashSet<Product>();
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	

}