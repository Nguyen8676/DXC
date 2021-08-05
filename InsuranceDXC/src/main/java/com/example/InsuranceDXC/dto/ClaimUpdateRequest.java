package com.example.InsuranceDXC.dto;

public class ClaimUpdateRequest {
	private String policyNo;
	private String dateOccurred;
	private String reserveCurrency;
	private String reserveAmount;
	private String claimNo;
	
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
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	
	
}
