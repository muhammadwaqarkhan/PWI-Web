package com.pwi.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
/**
 * Holds all data which is relevant to Address 
 *  @author Waqar Contact 03346100977
 */
@Entity()
@Table(name = "Address", schema = "pwi")
public class Address {

	
	private static final int	STREET_LENGTH				= 45;
	private static final int	CITY_LENGTH					= 45;
	private static final int	POSTCODE_LENGTH				= 45;
	private static final int	COUNTRY_LENGTH				= 45;
	

	@Column(name = "addressID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long addressID;
	
	@Size(max = STREET_LENGTH, message = "Name")
	@Column(name = "street", length = STREET_LENGTH)
	private String street;
	
	
	@Size(max = CITY_LENGTH, message = "city")
	@Column(name = "city", length = CITY_LENGTH)
	private String city;
	
	
	@Size(max = POSTCODE_LENGTH, message = "postCode")
	@Column(name = "postCode", length = POSTCODE_LENGTH)
	private String postCode;
	
	
	@Size(max = COUNTRY_LENGTH, message = "country")
	@Column(name = "country", length = COUNTRY_LENGTH)
	private String country;
	
	
	/**
	 * Returns the primary key of the object
	 * 
	 * @return key
	 */
	public Long getAddressID() {
		return addressID;
	}
	
	/**
	 * @param addressID
	 *            Address ID
	 * @see #addressID
	 */
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	
	/**
	 * Returns the street
	 * 
	 * @return String
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * @param street
	 *            street 
	 * @see #street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * Returns the city
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city
	 *            city 
	 * @see #city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Returns the postCode
	 * 
	 * @return postCode
	 */
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * @param postCode
	 *            postCode 
	 * @see #postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * Returns the country
	 * 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country
	 *            country 
	 * @see #country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
}
