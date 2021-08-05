package com.example.InsuranceDXC.dto;

import java.math.BigInteger;

public class ClaimRequest {
	private BigInteger id;
	private String policyNo;
	private String dateOccurred;
	private String reserveCurrency;
	private String reserveAmount;
	public ClaimRequest() {
		super();
	}
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
	
	
}
