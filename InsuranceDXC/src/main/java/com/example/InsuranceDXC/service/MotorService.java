package com.example.InsuranceDXC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InsuranceDXC.model.Message;
import com.example.InsuranceDXC.model.Motor;
import com.example.InsuranceDXC.repository.MessageRepository;
import com.example.InsuranceDXC.repository.MotorRepository;

@Service
public class MotorService {
	@Autowired 
	private MotorRepository motorrepository;

	 public List<Motor> getAllMotor() {
		return motorrepository.findAll();   
	}
}
