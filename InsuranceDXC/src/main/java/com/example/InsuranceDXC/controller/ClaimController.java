package com.example.InsuranceDXC.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.status;
import com.example.InsuranceDXC.dto.ClaimRequest;
import com.example.InsuranceDXC.dto.ClaimUpdateRequest;
import com.example.InsuranceDXC.model.Claim;
import com.example.InsuranceDXC.model.Client;
import com.example.InsuranceDXC.service.ClaimService;
import com.example.InsuranceDXC.service.ClientService;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {
	@Autowired
	ClaimService claimservice;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value="/getImages")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> getImages() {

		return new ResponseEntity<List<String>>(claimservice.getImages(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getall")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Claim>> getAllClient() {
         return status(HttpStatus.OK).body(claimservice.getAllClaim());
    }
	
	@PostMapping("/create-claim")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> createClaim(@RequestBody ClaimRequest claimrequest){
		claimservice.createClaim(claimrequest);
		return new ResponseEntity<>("Claim created", HttpStatus.OK);
	}
	
	@PostMapping("/create-active-claim")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> createActiveClaim(@RequestBody ClaimRequest claimrequest){
		claimservice.createWithActiveClaim(claimrequest);
		return new ResponseEntity<>("Claim created", HttpStatus.OK);
	}
	
	
	@GetMapping("/get-claim/{claimNo}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Claim> findByClaimNo(@PathVariable String claimNo) {
		return status(HttpStatus.OK).body(claimservice.findByClaimNo(claimNo));
	}
	
	@PostMapping("/update-claim")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> updateClaim(@RequestBody ClaimUpdateRequest claimrequest){
		claimservice.updateClaim(claimrequest);
		return new ResponseEntity<>("Update success", HttpStatus.OK);
	}
	
	@GetMapping("/active-claim/{claimNo}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> activeClaim(@PathVariable String claimNo){
		claimservice.activeClaim(claimNo);
		return new ResponseEntity<>("Update success", HttpStatus.OK);
	}
}
