package com.pwi.ws.store.dto;

import com.pwi.services.address.dto.AddressDTO;

public class JaxAddressDTO 
{
	private String 			street;
	private String 			city;
	private String 			postalCode;
	private String 			country;
	private Long 			addressID;
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
	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	
	public AddressDTO assemble()
	{
		AddressDTO dto = new AddressDTO();
		dto.setCity(city);
		dto.setCountry(country);
		dto.setPostalCode(postalCode);
		dto.setStreet(street);
		
		return dto;
	}
}
