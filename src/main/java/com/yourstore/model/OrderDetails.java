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

@Entity
@Table(name = "Order_Details")
public class OrderDetails {
	@EmbeddedId
	private OrderDetailsId id;

	@ManyToOne
	@MapsId("orderId")
	@JoinColumn(name = "Order_ID")
	private CustomerOrder order;

	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "Product_ID")
	private Product product;
}
