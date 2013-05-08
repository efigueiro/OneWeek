package com.oneweek.model.entity;

import java.io.Serializable;

public class ProductType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productTypeId;
	private String name;
	private String description;

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
