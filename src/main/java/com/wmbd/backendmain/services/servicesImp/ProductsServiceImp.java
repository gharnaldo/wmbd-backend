package com.wmbd.backendmain.services.servicesImp;


import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.wmbd.backendmain.dtos.ProductsDTO;
import com.wmbd.backendmain.models.Products;
import com.wmbd.backendmain.repository.ProductsRepository;
import com.wmbd.backendmain.services.ProductsService;
import com.wmbd.backendmain.transportLayer.RequestBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProductsServiceImp implements ProductsService {

    @Autowired
    private ProductsRepository repository;
    
    Double discount = (double) 0; 
    String str = null;
	
	@Override
	public List<ProductsDTO> getAll() throws IOException, JSONException, NumberFormatException {
    	List<ProductsDTO> productsDTOResponses = new ArrayList<>();
    	List<Products> products;
		Products product = null;
		try {	
			products = repository.findAll();
		    // fetch all products
			if (products != null && products.size() > 0)
			{
		        for (int i = 0; i < products.size(); i++) 
		        { 		    
					ProductsDTO productDTO = new ProductsDTO();
					productDTO = calculate(products.get(i));
					productsDTOResponses.add(productDTO);
		        }
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    	return productsDTOResponses; 
	}
    
	@Override
	public List<ProductsDTO> getProducts(String keyword) throws IOException, JSONException, NumberFormatException {
    	List<ProductsDTO> productsDTOResponses = new ArrayList<>();
    	List<Products> products;
		Products product = null;
		try {
			if (StringUtils.isNumeric(keyword))
			{
				product = repository.findById(Integer.valueOf(keyword));
				System.out.println("Es numerico!");
			}else {
				System.out.println("No es numerico!");
			}
			if (product != null)
			{
				System.out.println("Existe por Id!");
				ProductsDTO productDTO = new ProductsDTO();
				productDTO = calculate(product);
				productsDTOResponses.add(productDTO);
			}else {
				
				products = repository.findByDescriptionContainingIgnoreCaseOrBrandContainingIgnoreCase(keyword,keyword);
			    // fetch all products
				if (products != null && products.size() > 0)
				{
			        for (int i = 0; i < products.size(); i++) 
			        { 		    
						ProductsDTO productDTO = new ProductsDTO();
						productDTO = calculate(products.get(i));
						productsDTOResponses.add(productDTO);
			        }
				}else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				}
		  }
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    	return productsDTOResponses; 
	}

	private ProductsDTO calculate(Products product) {
		ProductsDTO productDTO = new ProductsDTO();
		try {
		    str = product.getDescription().toLowerCase().trim().replace(" ", "");
		    discount = (double) 0;
		    str.chars().mapToObj(e -> Character.toString((char) e)).distinct().forEach(d -> { if(StringUtils.countMatches(str, d) > 1) { discount += 10; } });
		    Double finalPrice = (double) 0;
        	System.out.println(product.getBrand());
		    System.out.println(product.getDescription());
		    System.out.println(product.getPrice());
		    System.out.println("Descuento Inicial:"+discount);
		    if (discount > 50) discount = (double) 50;
		    System.out.println("Descuento Final:"+discount);
		    finalPrice =  product.getPrice()-(product.getPrice()*(discount/100));
		    System.out.println("Precio final:"+finalPrice);
		    productDTO.setId(product.getId());
		    productDTO.setBrand(product.getBrand());
		    productDTO.setDescription(product.getDescription());
		    productDTO.setImage(product.getImage());
		    productDTO.setDiscount(discount);
		    productDTO.setPrice(product.getPrice());
		    productDTO.setFinalPrice(finalPrice);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return productDTO;
	}


}


