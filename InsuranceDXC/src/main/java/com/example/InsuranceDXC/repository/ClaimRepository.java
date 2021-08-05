package com.example.InsuranceDXC.repository;


import java.math.BigInteger;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.InsuranceDXC.model.Claim;

import lombok.extern.log4j.Log4j;


@Repository

public interface ClaimRepository extends JpaRepository<Claim,String> {
	@Modifying
	@Query(value="SET ANSI_PADDING ON\r\n"
			+ "SET IDENTITY_INSERT [dbo].[Claim] ON\r\n"
			+ "INSERT [dbo].[Claim] ([ID],[Policy No],[Date Occurred],[Reserve Currency],[Reserve Amount],[Status])\r\n"
			+ "		VALUES (?1, ?2,CAST(?3 AS Date), ?4,\r\n"
			+ "		?5,?6)\r\n"
			+ "SET IDENTITY_INSERT [dbo].[Claim] OFF\r\n"
			+ "SET ANSI_PADDING OFF",nativeQuery = true)
	public void setIdentityOn(BigInteger id,String policyNo,String dateOccurred,String reservecurrency,Number reserveAmount,boolean status);
	
	@Modifying
	@Query(value="update Claim\r\n"
			+ "set [Policy No]=?1,[Date Occurred]=?2,[Reserve Currency]=?3,[Reserve Amount]=?4\r\n"
			+ "where [Claim No]=?5 and [Status]=0",nativeQuery=true)
	public void updateClaim(String policyNo,String dateOccurred,String reservecurrency,Number reserveAmount,String claimNo);
	
	
	@Query(value="select * from Claim where [Claim No]=?1",nativeQuery=true)
	public Claim findByClaimNo(String claimNo);
	
	@Modifying
	@Query(value="update Claim\r\n"
			+ "set [Status]=1\r\n"
			+ "where [Claim No]=?1 and [Status]=0",nativeQuery=true)
	public void updateApproveClaim(String claimNo);
		
//	@Modifying
//	@Query(value="SET ANSI_PADDING ON\r\n"
//			+ "SET IDENTITY_INSERT [dbo].[Claim] ON\r\n"
//			+ "INSERT [dbo].[Claim] ([ID],[Policy No],[Date Occurred],[Reserve Currency],[Reserve Amount],[Status])\r\n"
//			+ "		VALUES (?1, ?2,CAST(?3 AS Date), ?4,\r\n"
//			+ "		?5,1)\r\n"
//			+ "SET IDENTITY_INSERT [dbo].[Claim] OFF\r\n"
//			+ "SET ANSI_PADDING OFF",nativeQuery = true)
//	public void createWithActive(BigInteger id,String policyNo,String dateOccurred,String reservecurrency,Number reserveAmount);
	
}
