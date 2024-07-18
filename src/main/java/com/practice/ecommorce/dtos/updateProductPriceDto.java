package com.practice.ecommorce.dtos;

public class updateProductPriceDto {
	private long id;
    private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "updateProductPriceDto [id=" + id + ", price=" + price + "]";
	}


}
