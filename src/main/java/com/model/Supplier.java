package com.model;


import java.util.HashSet;


import java.util.Set;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity

public class Supplier 
{
	
	@Id
	@GeneratedValue
	@Column(name="supplier_id")
	private int sid;
	private String supplierName;
	private String supplierAddress;

	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "supplier", cascade = CascadeType.ALL)
	 private Set<Product> products = new HashSet<Product>();
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	

}