package com.pwi.services.branch.dto;

import org.springframework.stereotype.Component;

import com.pwi.domain.branch.Branch;
import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.services.address.dto.AddressDTO;
import com.pwi.spring.SpringApplicationContext;
@Component
public class BranchDTO extends BaseDTO implements IRequestHandler
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6802212527262029184L;
	
	private Long 			branchID;
	private String 			branchName;
	private String 			street;
	private String 			city;
	private String 			postalCode;
	private String 			country;
	private Long 			addressID;
	private Long 			companyID;
	private String 			companyName;
	private AddressDTO address = new AddressDTO();
		
	
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getBranchID() {
		return branchID;
	}
	public void setBranchID(Long branchID) {
		this.branchID = branchID;
	}

	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}


	public Long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public BranchDTO assemble(Branch branch)
	{
		this.addressID=branch.getAddressID();
		this.branchID=branch.getBranchID();
		this.branchName=branch.getBranchName();
		this.city=branch.getAddress().getCity();
		this.country=branch.getAddress().getCountry();
		this.postalCode=branch.getAddress().getPostCode();
		this.street=branch.getAddress().getStreet();
		this.companyName=branch.getCompany().getName();
		//this.address=branch.getAddress();
		
		
		return this;
	}
}
