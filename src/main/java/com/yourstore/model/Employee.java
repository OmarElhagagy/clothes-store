package com.yourstore.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
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

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		result = prime * result + ((subordinates == null) ? 0 : subordinates.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((supplyOrders == null) ? 0 : supplyOrders.hashCode());
		result = prime * result + ((phoneNumbers == null) ? 0 : phoneNumbers.hashCode());
		result = prime * result + ((notifications == null) ? 0 : notifications.hashCode());
		result = prime * result + ((auditLogs == null) ? 0 : auditLogs.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		if (subordinates == null) {
			if (other.subordinates != null)
				return false;
		} else if (!subordinates.equals(other.subordinates))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (supplyOrders == null) {
			if (other.supplyOrders != null)
				return false;
		} else if (!supplyOrders.equals(other.supplyOrders))
			return false;
		if (phoneNumbers == null) {
			if (other.phoneNumbers != null)
				return false;
		} else if (!phoneNumbers.equals(other.phoneNumbers))
			return false;
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		if (auditLogs == null) {
			if (other.auditLogs != null)
				return false;
		} else if (!auditLogs.equals(other.auditLogs))
			return false;
		return true;
	}
}
