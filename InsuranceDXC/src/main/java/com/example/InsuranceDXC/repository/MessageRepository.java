package com.example.InsuranceDXC.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InsuranceDXC.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, BigInteger> {

}
