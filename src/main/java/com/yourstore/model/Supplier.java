package com.yourstore.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "Supplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Supplier_ID")
	private Integer supplierId;

	@Column(name = "Supplier_Name", nullable = false)
	private String supplierName;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	//Relationships
	@OneToMany(mappedBy = "supplier")
	private Set<Product> products = new HashSet<>();

	@OneToMany(mappedBy = "supplier")
	private Set<SupplyOrder> supplyOrders = new HashSet<>();

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private Set<PhoneNumbersSupplier> phoneNumbers = new HashSet<>();

	// Getters and Setters
	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<SupplyOrder> getSupplyOrders() {
		return supplyOrders;
	}

	public void setSupplyOrders(Set<SupplyOrder> supplyOrders) {
		this.supplyOrders = supplyOrders;
	}

	public Set<PhoneNumbersSupplier> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumbersSupplier> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
