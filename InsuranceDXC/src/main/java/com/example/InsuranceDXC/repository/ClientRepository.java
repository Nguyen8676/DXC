package com.example.InsuranceDXC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InsuranceDXC.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,String>{
	
}
