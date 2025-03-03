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

@Entity
@Table(name = "Categories")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Category_ID")
	private Integer categoryId;

	@Column(name = "Category_Name", nullable = false, unique = true)
	private String categoryName;

	@OneToMany(mappedBy = "category")
	private Set<ProductCategories> productCategories = new HashSet<>();

	// Getters and setters
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<ProductCategories> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(Set<ProductCategories> productCategories) {
		this.productCategories = productCategories;
	}
}
