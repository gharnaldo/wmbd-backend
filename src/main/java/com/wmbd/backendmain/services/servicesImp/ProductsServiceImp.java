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
				    productDTO.setId(products.get(i).getId());
				    productDTO.setBrand(products.get(i).getBrand());
				    productDTO.setDescription(products.get(i).getDescription());
				    productDTO.setImage(products.get(i).getImage());
				    productDTO.setDiscount((double)0);
				    productDTO.setPrice(products.get(i).getPrice());
				    productDTO.setFinalPrice((double) products.get(i).getPrice());
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
				//es numerico
				product = repository.findById(Integer.valueOf(keyword));				
			}else {
				//No es numerico
			}
			if (product != null)
			{
				//Existe por Id
				ProductsDTO productDTO = new ProductsDTO();
				productDTO = calculate(product);
				productsDTOResponses.add(productDTO);
			}else {
				if (keyword.length()>3)
				{
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
				}else {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
				}
		  }
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    	return productsDTOResponses; 
	}

	public ProductsDTO calculate(Products product) {
		ProductsDTO productDTO = new ProductsDTO();
		try {
		    str = product.getDescription().toLowerCase().trim().replace(" ", "");
		    discount = (double) 0;
		    str.chars().mapToObj(e -> Character.toString((char) e)).distinct().forEach(d -> { if(StringUtils.countMatches(str, d) > 1) { discount += 10; System.out.println(d); } });
		    Double finalPrice = (double) 0;
		    if (discount > 50) discount = (double) 50;
		    finalPrice =  product.getPrice()-(product.getPrice()*(discount/100));
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


