package com.wmbd.backendmain.transportLayer;


import com.google.gson.Gson;
import com.wmbd.backendmain.exceptions.ExceptionWithMessage;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;


@Service
public class RequestBuilder {




    public ResponseEntity<String> get(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForEntity(url, String.class);
        } catch (Exception e) {
            HttpStatus status;
            System.out.print(e);
            status = ((HttpClientErrorException) e).getStatusCode();
            if (e instanceof HttpClientErrorException) {
                throw new ExceptionWithMessage(((HttpClientErrorException) e).getResponseBodyAsString(), status);
            }
            if (e instanceof HttpServerErrorException) {
                throw new ExceptionWithMessage(((HttpServerErrorException) e).getResponseBodyAsString(), status);
            }
            throw new ExceptionWithMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    public ResponseEntity<String> getH(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity entity = new HttpEntity(headers);
        try {
            //return restTemplate.getForEntity(url, String.class);
        	return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
        	System.out.print(e);
            HttpStatus status;
            status = ((HttpClientErrorException) e).getStatusCode();
            if (e instanceof HttpClientErrorException) {

                throw new ExceptionWithMessage(((HttpClientErrorException) e).getResponseBodyAsString(), status);
            }
            if (e instanceof HttpServerErrorException) {
                throw new ExceptionWithMessage(((HttpServerErrorException) e).getResponseBodyAsString(), status);
            }
            throw new ExceptionWithMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
  

}
