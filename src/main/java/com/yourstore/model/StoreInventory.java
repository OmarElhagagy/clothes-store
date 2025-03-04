package com.yourstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Store_Inventory")
public class StoreInventory {
	
	@EmbeddedId
	private StoreInventoryId id;

	@ManyToOne
	@MapsId("storeId")
	@JoinColumn(name = "Store_ID")
	private Store store;

	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "Product_ID")
	private Product product;

	@Column(name = "Quantity", nullable = false)
	private Integer quantity;

	//Getters and Setters
	public StoreInventoryId getId() {
		return id;
	}

	public void setId(StoreInventoryId id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
