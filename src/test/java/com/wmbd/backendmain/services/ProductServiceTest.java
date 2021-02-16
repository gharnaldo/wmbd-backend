package com.wmbd.backendmain.services;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import com.wmbd.backendmain.dtos.ProductsDTO;
import com.wmbd.backendmain.models.Products;
import com.wmbd.backendmain.services.servicesImp.ProductsServiceImp;

@SpringBootTest
public class ProductServiceTest {


    
    @Autowired
    ProductsService productsService;
    
    ProductsServiceImp productsServiceImp = new ProductsServiceImp();
    
    
    @Test
    @DisplayName("Debe identificar 5 caracteres repetidos en \"Juego Red Dead Redemption II\"")
    void find5repeatedChars_shouldReturn50() {    	
    	// given
    	Products product = new Products("001", 1, "Marca1", "Juego Red Dead Redemption II", "url", 100000);
    	//When
    	ProductsDTO productDTO = new ProductsDTO();
    	productDTO = productsServiceImp.calculate(product);
    	//Then
    	assertEquals(Double.valueOf(50),productDTO.getDiscount());
    }
    
    @Test
    @DisplayName("Debe devolver excepcion BAD REQUEST si busca por menos de 3 caracteres")
    public void keywordWithLessThan3StringChars_shouldThrowException() {
    	// given
    	String keyword = "Mar";
        // When
    	Throwable thrown = assertThrows(ResponseStatusException.class, () -> productsServiceImp.getProducts(keyword));
        // then
        assertEquals("400 BAD_REQUEST \"400 BAD_REQUEST\"",thrown.getMessage());
    }
    
    @Test
    @DisplayName("Debe devolver resultados si busca por menos de 3 caracteres numericos")
    public void keywordWithLessThan3IntChars_shouldNotThrowException() throws NumberFormatException, IOException, JSONException {
    	// given
    	String keyword = "12";
    	// when
    	List<ProductsDTO> productsDTOResponses = new ArrayList<>();
    	productsDTOResponses = productsService.getProducts(keyword);
    	//then
        assertTrue(productsDTOResponses.size() > 0, "Found");
    }
	 
}
