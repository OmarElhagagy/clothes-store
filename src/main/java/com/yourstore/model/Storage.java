package com.yourstore.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Storage")
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

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storageNo == null) ? 0 : storageNo.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((reorderLevel == null) ? 0 : reorderLevel.hashCode());
		result = prime * result + ((maxStock == null) ? 0 : maxStock.hashCode());
		result = prime * result + ((minStock == null) ? 0 : minStock.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Storage other = (Storage) obj;
		if (storageNo == null) {
			if (other.storageNo != null)
				return false;
		} else if (!storageNo.equals(other.storageNo))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (reorderLevel == null) {
			if (other.reorderLevel != null)
				return false;
		} else if (!reorderLevel.equals(other.reorderLevel))
			return false;
		if (maxStock == null) {
			if (other.maxStock != null)
				return false;
		} else if (!maxStock.equals(other.maxStock))
			return false;
		if (minStock == null) {
			if (other.minStock != null)
				return false;
		} else if (!minStock.equals(other.minStock))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		return true;
	}
}
