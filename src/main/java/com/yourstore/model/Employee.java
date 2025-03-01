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
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_ID")
	private Integer employeeId;

	@ManyToOne
	@JoinColumn(name = "Store_ID", nullable = false)
	private Store store;

	@ManyToOne
	@JoinColumn(name = "Storage_No")
	private Storage storage;

	@Column(name = "F_Name", nullable = false)
	private String firstName;

	@Column(name = "M_Name")
	private String middleName;

	@Column(name = "L_Name", nullable = false)
	private String lastName;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@Column(name = "Gender", nullable = false, length = 1)
	private String gender;

	@Column(name = "Role", nullable = false)
	private String role;

	@ManyToOne
	@JoinColumn(name = "Supervisor")
	private Employee supervisor;

	@OneToMany(mappedBy = "supervisor")
	private Set<Employee> subordinates = new HashSet<>();

	@OneToMany(mappedBy = "employeeSeller")
	private Set<CustomerOrder> orders = new HashSet<>();

	@OneToMany(mappedBy = "employee")
	private Set<SupplyOrder> supplyOrders = new HashSet<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<PhoneNumbersEmployees> phoneNumbers = new HashSet<>();

	@OneToMany(mappedBy = "employee")
	private Set<Notification> notifications = new HashSet<>();

	@OneToMany(mappedBy = "employee")
	private Set<AuditLog> auditLogs = new HashSet<>();

	// Getters and Setters
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public Set<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public Set<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustomerOrder> orders) {
		this.orders = orders;
	}

	public Set<SupplyOrder> getSupplyOrders() {
		return supplyOrders;
	}

	public void setSupplyOrders(Set<SupplyOrder> supplyOrders) {
		this.supplyOrders = supplyOrders;
	}

	public Set<PhoneNumbersEmployees> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumbersEmployees> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Set<AuditLog> getAuditLogs() {
		return auditLogs;
	}

	public void setAuditLogs(Set<AuditLog> auditLogs) {
		this.auditLogs = auditLogs;
	}
}
