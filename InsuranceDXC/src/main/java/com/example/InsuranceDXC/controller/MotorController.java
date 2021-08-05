package com.example.InsuranceDXC.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuranceDXC.model.Claim;
import com.example.InsuranceDXC.model.Motor;
import com.example.InsuranceDXC.service.ClaimService;
import com.example.InsuranceDXC.service.MotorService;

@RestController
@RequestMapping("/api/motor")
public class MotorController {
	@Autowired
	MotorService motorservice;
	
	@GetMapping("/getall-motor")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Motor>> getAllClient() {
         return status(HttpStatus.OK).body(motorservice.getAllMotor());
    }
}
