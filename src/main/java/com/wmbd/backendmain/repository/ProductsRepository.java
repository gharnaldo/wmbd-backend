package com.wmbd.backendmain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.wmbd.backendmain.models.Products;

public interface ProductsRepository extends MongoRepository<Products, String>{
	  public Products findById(int id);
	  public List<Products> findByDescriptionContainingIgnoreCaseOrBrandContainingIgnoreCase(String description, String brand);
}
