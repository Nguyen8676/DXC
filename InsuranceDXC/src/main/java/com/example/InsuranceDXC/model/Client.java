package com.example.InsuranceDXC.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`Client`")
public class Client {

	@Column(name = "`ID`")
	private BigInteger id;

	 @Id
	 @Column(name="`Client Number`", columnDefinition = "VARCHAR(8)") 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private String clientNumber;
	 
	 
	 @Column(name="`First Name`", columnDefinition = "NVARCHAR(60)") 
	 private String firstName;
	 
	 @Column(name="`Last Name`", columnDefinition = "NVARCHAR(60)") 
	 private String lastName;
	 
	 @Column(name="`Gender`", columnDefinition = "VARCHAR(30)") 
	 private String gender;
	 
	 @Column(name="`Date of Birth`", columnDefinition = "date") 
	 private String dateOfBirth;
	 
	 @Column(name="`Indentity Number`", columnDefinition = "VARCHAR(30)") 
	 private String indentityNumber;
	 
	 @Column(name="`Marital Status`", columnDefinition = "VARCHAR(30)") 
	 private String maritalStatus;
	 
	 @Column(name="`Address`", columnDefinition = "NVARCHAR(120)") 
	 private String address;
	 
	 @Column(name="`Country`", columnDefinition = "VARCHAR(30)") 
	 private String country;
	 

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIndentityNumber() {
		return indentityNumber;
	}

	public void setIndentityNumber(String indentityNumber) {
		this.indentityNumber = indentityNumber;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
