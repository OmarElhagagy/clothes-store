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
@Table(name = "\"Store\"")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"Store_ID\"")
	private Integer id;

	@Column(name = "\"Address\"", nullable = false)
	private String address;

	@Email
	@Column(name = "\"email\"", nullable = false, unique = true)
	private String email;

	@Column(name = "\"Min_Stock\"", nullable = false)
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

	// Getters and Setters
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

	// Helper methods
	public void addStorage(Storage storage) {
		if (storages == null) {
			storages = new ArrayList<>();
		}
		storages.add(storage);
		storages.setStore(this);
	}

	public void removeStorage(Storage storage) {
		storages.remove(storage);
		storage.setStore(null);
	}

	public void addEmployee(Employee employee) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
		employees.setStore(null);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
		employees.setStore(null);
	}

	public void addStoreInventory(Inventory inventory) {
		if (inventories == null) {
			inventories = new ArrayList<>();
		}
		inventories.add(inventory);
		inventories.setStore(this);
	}

	public void removeStorageInventory(Inventory inventory) {
		inventories.remove(inventory);
		inventories.setStore(null);
	}

	
}
