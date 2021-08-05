package com.example.InsuranceDXC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.status;
//
import com.example.InsuranceDXC.model.Client;
import com.example.InsuranceDXC.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	@Autowired
	ClientService clientservice;
	
	@GetMapping("/getall")
    public List<Client> getAllClient() {
        return clientservice.getClient();
    }
	
	@GetMapping
	public String test() {
		return "hello world";
	}
}
