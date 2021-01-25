package com.wmbd.backendmain;



import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wmbd.backendmain.models.Products;
import com.wmbd.backendmain.repository.ProductsRepository;





@SpringBootApplication
public class WmbdBackendMainApplication {

  @Autowired
  private ProductsRepository repository;
	  
	public static void main(String[] args) {
		SpringApplication.run(WmbdBackendMainApplication.class, args);
			
	}
	
}