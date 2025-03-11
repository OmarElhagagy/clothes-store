package com.yourstore.model;

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
@Table(name = "Store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Store_ID")
	private Integer id;

	@Column(name = "Address", nullable = false)
	private String address;

	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "Min_Stock", nullable = false)
	@Min(0)
	private Integer minStock;
	
	//Relationships
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Storage> storages = new HashSet<>();

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private Set<StoreInventory> inventories = new HashSet<>();

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private Set<ReservedStock> reservedStocks = new HashSet<>();

	@OneToMany(mappedBy = "store")
	private Set<Notification> notifications = new HashSet<>();

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMinStock() {
		return minStock;
	}

	public void setMinStock(Integer minStock) {
		this.minStock = minStock;
	}

	public Set<Storage> getStorages() {
		return storages;
	}

	public void setStorages(Set<Storage> storages) {
		this.storages = storages;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<StoreInventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<StoreInventory> inventories) {
		this.inventories = inventories;
	}

	public Set<ReservedStock> getReservedStocks() {
		return reservedStocks;
	}

	public void setReservedStocks(Set<ReservedStock> reservedStocks) {
		this.reservedStocks = reservedStocks;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((minStock == null) ? 0 : minStock.hashCode());
		result = prime * result + ((storages == null) ? 0 : storages.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((inventories == null) ? 0 : inventories.hashCode());
		result = prime * result + ((reservedStocks == null) ? 0 : reservedStocks.hashCode());
		result = prime * result + ((notifications == null) ? 0 : notifications.hashCode());
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
		Store other = (Store) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (minStock == null) {
			if (other.minStock != null)
				return false;
		} else if (!minStock.equals(other.minStock))
			return false;
		if (storages == null) {
			if (other.storages != null)
				return false;
		} else if (!storages.equals(other.storages))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (inventories == null) {
			if (other.inventories != null)
				return false;
		} else if (!inventories.equals(other.inventories))
			return false;
		if (reservedStocks == null) {
			if (other.reservedStocks != null)
				return false;
		} else if (!reservedStocks.equals(other.reservedStocks))
			return false;
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		return true;
	}
}
