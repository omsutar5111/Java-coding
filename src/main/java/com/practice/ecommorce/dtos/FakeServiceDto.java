package com.practice.ecommorce.dtos;



public class FakeServiceDto {
    private  long id;
    private  String image;
    private String title;
    private double price;
    private String category;
    private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "FakeServiceDto [id=" + id + ", image=" + image + ", title=" + title + ", price=" + price + ", category="
				+ category + ", description=" + description + "]";
	}
    
    
}
