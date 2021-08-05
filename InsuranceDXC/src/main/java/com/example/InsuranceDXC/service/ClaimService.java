package com.example.InsuranceDXC.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.InsuranceDXC.dto.ClaimRequest;
import com.example.InsuranceDXC.dto.ClaimUpdateRequest;
import com.example.InsuranceDXC.model.Claim;
import com.example.InsuranceDXC.model.Client;
import com.example.InsuranceDXC.model.Motor;
import com.example.InsuranceDXC.repository.ClaimRepository;
import com.example.InsuranceDXC.repository.MotorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;




@Service

public class ClaimService {
	@Autowired
	ClaimRepository claimrepository;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	MotorRepository motorrepository;
	
	Logger logger = LoggerFactory.getLogger(ClaimService.class);

    public List<Claim> getAllClaim() {
    	 logger.info("get all Claim");
		return claimrepository.findAll();
    }
	
	@Transactional
	public void createClaim(ClaimRequest request) {
		Motor motor=motorrepository.findByPolicyNo(request.getPolicyNo());
		Claim claim=new Claim();
		try {
			Number reserveamout= NumberFormat.getInstance().parse(request.getReserveAmount());
			logger.info("convert to save reserveamount");
			claimrepository.setIdentityOn(request.getId(),request.getPolicyNo(),request.getDateOccurred(),request.getReserveCurrency(),reserveamout,false);
			logger.info("create claim");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void createWithActiveClaim(ClaimRequest request) {
		try {
			Number reserveamout= NumberFormat.getInstance().parse(request.getReserveAmount());
			logger.info("convert to save reserveamount");
			claimrepository.setIdentityOn(request.getId(),request.getPolicyNo(),request.getDateOccurred(),request.getReserveCurrency(),reserveamout,true);
			logger.info("create with active claim");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Claim findByClaimNo(String claimNo){
		return claimrepository.findByClaimNo(claimNo);
	}
	
	@Transactional
	public void updateClaim(ClaimUpdateRequest claimUpdateRequest) {
		try {
			Number reserveamout= NumberFormat.getInstance().parse(claimUpdateRequest.getReserveAmount());
			logger.info("convert to update");
			claimrepository.updateClaim(claimUpdateRequest.getPolicyNo(),claimUpdateRequest.getDateOccurred(),claimUpdateRequest.getReserveCurrency(),reserveamout,claimUpdateRequest.getClaimNo());
			logger.info("update");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void activeClaim(String claimNo) {
		logger.info("active claim");
		claimrepository.updateApproveClaim(claimNo);
	}
	
	@Transactional
	public List<String> getImages() {
		List<String> images=new ArrayList<String>();
		String filesPath= context.getRealPath("/images");
		File fileFolder=new File(filesPath);
		if(fileFolder != null) {
			for(final File file: fileFolder.listFiles()) {
				if(!file.isDirectory()) {
					String encodeBase64= null;
					try {
						String extension=FilenameUtils.getExtension(file.getName());
						FileInputStream fileInputStream=new FileInputStream(file);
						byte[] bytes=new byte[(int)file.length()];
						fileInputStream.read(bytes);
						encodeBase64=Base64.getEncoder().encodeToString(bytes);
						images.add("data:image/"+extension+";base64,"+encodeBase64);
						fileInputStream.close();
					}catch(Exception e) {
						
					}
				}
				
			}
		}
		 return images;
	}
}
