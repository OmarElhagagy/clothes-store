package com.yourstore.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "\"Storage\"")
public class Storage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Storage_No")
	private Integer storageNo;

	@ManyToOne
	@JoinColumn(name = "Store_ID", nullable = false)
	private Store store;
}
