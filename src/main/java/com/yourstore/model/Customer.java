package com.yourstore.model;

import java.time.LocalDate;
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
@Table(name = "\"Customer\"")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_ID")
	private Integer customerId;

	@Column(name = "F_Name", nullable = false)
	private String firstName;

	@Column(name = "M_Name", nullable = false)
	private String middleName;

	@Column(name = "L_Name", nullable = false)
	private String lastName;

	@Column(name = "Gender", nullable = false, length = 1)
	private String gender;

	@Column(name = "Birth_Date", nullable = false)
	private LocalDate birthDate;

	@Email
	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Users> users = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(mappedBy = "customer")
	private Set<CustomerOrder> orders = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Cart> cartItems = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<WishList> whishListItmes = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<PhoneNumbersCustomers> phoneNumbers = new HashSet<>();

	@OneToMany(mappedBy = "customer")
	private Set<Notifications> notifications = new HashSet<>();
}
