package com.wmbd.backendmain.controllers;


import io.swagger.annotations.ApiOperation;

import org.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wmbd.backendmain.dtos.ProductsDTO;
import com.wmbd.backendmain.services.ProductsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wmbd")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @ApiOperation(value = "Returns results of Brand Discounts.")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    @GetMapping(value = "/products/search", produces = "application/json")
    public ResponseEntity<List<ProductsDTO>> getProducts(@RequestParam String keyword) throws IOException, JSONException {    	
    	List<ProductsDTO> productsDTOResponses = new ArrayList<>();
    	productsDTOResponses = productsService.getProducts(keyword);
    	return new ResponseEntity<List<ProductsDTO>>(productsDTOResponses, HttpStatus.OK); 
    }

    @ApiOperation(value = "Returns all of Brand Discounts.")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<List<ProductsDTO>> getAll() throws IOException, JSONException {    	
    	List<ProductsDTO> productsDTOResponses = new ArrayList<>();
    	productsDTOResponses = productsService.getAll();
    	return new ResponseEntity<List<ProductsDTO>>(productsDTOResponses, HttpStatus.OK); 
    }
}
