package com.yourstore.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "\"Storage\"")
public class Storage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Storage_No")
	private Integer storageNo;

	@ManyToOne
	@JoinColumn(name = "Store_ID", nullable = false)
	private Store store;

	@Column(name = "Location", nullable = false)
	private String location;

	@Column(name = "Reorder_Level", nullable = false)
	private Integer reorderLevel;

	@Column(name = "Max_Stock", nullable = false)
	private Integer maxStock;

	@Column(name = "Min_Stock", nullable = false)
	private Integer minStock;

	@OneToMany(mappedBy = "storage")
	private Set<Employee> employees = new HashSet<>();

	public Integer getStorageNo() {
		return storageNo;
	}

	public void setStorageNo(Integer storageNo) {
		this.storageNo = storageNo;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Integer getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(Integer maxStock) {
		this.maxStock = maxStock;
	}

	public Integer getMinStock() {
		return minStock;
	}

	public void setMinStock(Integer minStock) {
		this.minStock = minStock;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
