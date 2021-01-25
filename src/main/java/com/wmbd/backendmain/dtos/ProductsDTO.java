package com.wmbd.backendmain.dtos;

public class ProductsDTO {

	int id;
	String brand;
	String description;
	String image;
	int price;
	Double discount;
	Double finalPrice;
	
	public ProductsDTO() {
		super();
	}

	public ProductsDTO(int id, String brand, String description, String image, int price, Double discount,
			Double finalPrice) {
		super();
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.price = price;
		this.discount = discount;
		this.finalPrice = finalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "ProductsDTO [id=" + id + ", brand=" + brand + ", description=" + description + ", image=" + image
				+ ", price=" + price + ", discount=" + discount + ", finalPrice=" + finalPrice + "]";
	}
	

	
}
