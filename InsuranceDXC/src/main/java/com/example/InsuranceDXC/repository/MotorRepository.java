package com.example.InsuranceDXC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InsuranceDXC.model.Motor;

@Repository
public interface MotorRepository extends JpaRepository<Motor, String> {
	
	Motor findByPolicyNo(String policyNo);

}
