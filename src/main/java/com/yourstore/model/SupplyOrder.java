package com.yourstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Supply_Order")
public class SupplyOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Supply_Order_ID")
	private Integer supplyOrderId;

	@ManyToOne
	@JoinColumn(name = "Supplier_ID", nullable = false)
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "Product_ID", nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "Employee_ID", nullable = false)
	private Employee employee;

	@Column(name = "Quantity_Ordered", nullable = false)
	private Integer quantityOrdered;

	@Column(name = "Price", nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@Column(name = "Order_Date", nullable = false)
	private LocalDate orderDate;

	// getters and setters
	public Integer getSupplyOrderId() {
		return supplyOrderId;
	}

	public void setSupplyOrderId(Integer supplyOrderId) {
		this.supplyOrderId = supplyOrderId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	// equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplyOrderId == null) ? 0 : supplyOrderId.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((quantityOrdered == null) ? 0 : quantityOrdered.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
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
		SupplyOrder other = (SupplyOrder) obj;
		if (supplyOrderId == null) {
			if (other.supplyOrderId != null)
				return false;
		} else if (!supplyOrderId.equals(other.supplyOrderId))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (quantityOrdered == null) {
			if (other.quantityOrdered != null)
				return false;
		} else if (!quantityOrdered.equals(other.quantityOrdered))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		return true;
	}
}
