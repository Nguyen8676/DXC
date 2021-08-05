package com.example.InsuranceDXC.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InsuranceDXC.model.Client;
import com.example.InsuranceDXC.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired 
	private ClientRepository clientrepository;
	
	@Transactional
    public List<Client> getClient() {
        return clientrepository.findAll();
    }
}
