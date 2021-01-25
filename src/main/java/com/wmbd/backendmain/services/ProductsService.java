package com.wmbd.backendmain.services;

import net.minidev.json.JSONObject;

import org.json.JSONException;

import com.wmbd.backendmain.dtos.ProductsDTO;

import java.io.IOException;
import java.util.List;


public interface ProductsService {
	List<ProductsDTO> getProducts(String keyword) throws IOException, JSONException;
	List<ProductsDTO> getAll() throws IOException, JSONException;
}
