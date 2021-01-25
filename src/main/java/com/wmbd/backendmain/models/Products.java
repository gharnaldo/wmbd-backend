package com.wmbd.backendmain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;

@Document(collection = "products")
public class Products {
	  @Id
	  @NotNull
	  private String _id;
	  private int id;
	  private String brand;
	  private String description;
	  private String image;
	  private int price;
	  
	public Products() {
		super();
	}

	public Products(@NotNull String _id, int id, String brand, String description, String image, int price) {
		super();
		this._id = _id;
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.price = price;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	@Override
	public String toString() {
		return "Products [_id=" + _id + ", id=" + id + ", brand=" + brand + ", description=" + description + ", image="
				+ image + ", price=" + price + "]";
	} 
	
	  
}
