package com.practice.ecommorce.dtos;

import lombok.Data;


public class CreateProductDto {
    private String image;
    private String title;
    private String description;
    private String categoryName;
    private double price;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CreateProductDto [image=" + image + ", title=" + title + ", description=" + description
				+ ", categoryName=" + categoryName + ", price=" + price + "]";
	}
    
}
