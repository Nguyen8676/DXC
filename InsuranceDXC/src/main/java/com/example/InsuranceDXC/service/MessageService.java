package com.example.InsuranceDXC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InsuranceDXC.model.Claim;
import com.example.InsuranceDXC.model.Message;
import com.example.InsuranceDXC.repository.ClientRepository;
import com.example.InsuranceDXC.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired 
	private MessageRepository messagerepository;
	
	 public List<Message> getAllMessage() {
		return messagerepository.findAll();
	       
	 }
	
}
