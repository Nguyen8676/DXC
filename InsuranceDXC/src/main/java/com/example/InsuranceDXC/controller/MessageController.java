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
import com.example.InsuranceDXC.model.Message;
import com.example.InsuranceDXC.service.MessageService;


@RestController
@RequestMapping("/api/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/getall-message")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Message>> getAllMessage() {
         return status(HttpStatus.OK).body(messageService.getAllMessage());
    }
}
