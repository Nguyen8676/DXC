package com.example.InsuranceDXC.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;

@Entity
@Table(name="`Claim`")
@Builder
public class Claim{
	@Column(name="`ID`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Id
	@Column(name="`Claim No`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String claimNo;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`Policy No`")
	private Motor motor;
	
	@Column(name="`Date Occurred`")
	private String dateOccurred;
	
	@Column(name="`Reserve Currency`")
	private String reserveCurrency;
	
	@Column(name="`Reserve Amount`")
	private String reserveAmount;
	
	@Column(name="`Status`")
	private boolean status;
	
	

	public Claim() {
		super();
	}

	public Claim(BigInteger id, String claimNo, Motor motor, String dateOccurred, String reserveCurrency,
			String reserveAmount, boolean status) {
		super();
		this.id = id;
		this.claimNo = claimNo;
		this.motor = motor;
		this.dateOccurred = dateOccurred;
		this.reserveCurrency = reserveCurrency;
		this.reserveAmount = reserveAmount;
		this.status = status;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public String getDateOccurred() {
		return dateOccurred;
	}

	public void setDateOccurred(String dateOccurred) {
		this.dateOccurred = dateOccurred;
	}

	public String getReserveCurrency() {
		return reserveCurrency;
	}

	public void setReserveCurrency(String reserveCurrency) {
		this.reserveCurrency = reserveCurrency;
	}

	public String getReserveAmount() {
		return reserveAmount;
	}

	public void setReserveAmount(String reserveAmount) {
		this.reserveAmount = reserveAmount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}