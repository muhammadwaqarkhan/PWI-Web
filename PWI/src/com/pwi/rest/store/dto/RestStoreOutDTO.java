package com.pwi.rest.store.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.services.store.dto.StoreDTO;
import com.pwi.services.store.dto.StoreOutDTO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.StaxDriver;

@XStreamAlias("RestStoreOutDTO")

public class RestStoreOutDTO 
{
	@XStreamAlias("RestStoreDTO")
	public List<RestStoreDTO> restStore = new ArrayList<RestStoreDTO>(); 
	
	
	public List<RestStoreDTO> getRestStore() {
		return restStore;
	}

	public void setRestStore(List<RestStoreDTO> restStore) {
		this.restStore = restStore;
	}

	
	public String dissambletoSILXML (StoreOutDTO outDTO)
	{
		for(StoreDTO dto :outDTO.getStores())
		getRestStore().add(new RestStoreDTO().assemble(dto));
		
		
		XStream xstream = new XStream (new StaxDriver ());
		xstream.processAnnotations (RestStoreOutDTO.class);
		String xml = xstream.toXML (this);

		return xml;
	}
	
	@XStreamAlias("RestStore")
	public class RestStoreDTO
	{
		@XStreamAlias("storeName")
		private String 			storeName;
		
		@XStreamAlias("storeID")
		private Long 			storeID;
		
		@XStreamAlias("brancheName")
		private String 			brancheName;
		
		@XStreamAlias("branchID")
		private Long 			branchID;
		
		@XStreamAlias("street")
		private String 			street;
		
		@XStreamAlias("city")
		private String 			city;
		
		@XStreamAlias("postalCode")
		private String 			postalCode;
		
		@XStreamAlias("country")
		private String 			country;
		
		@XStreamAlias("addressID")
		private Long 			addressID;
		
		
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		public Long getStoreID() {
			return storeID;
		}
		public void setStoreID(Long storeID) {
			this.storeID = storeID;
		}
		public String getBrancheName() {
			return brancheName;
		}
		public void setBrancheName(String brancheName) {
			this.brancheName = brancheName;
		}
		public Long getBranchID() {
			return branchID;
		}
		public void setBranchID(Long branchID) {
			this.branchID = branchID;
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
		public Long getAddressID() {
			return addressID;
		}
		public void setAddressID(Long addressID) {
			this.addressID = addressID;
		}
		
		public RestStoreDTO assemble (StoreDTO dto)
		{
			this.addressID=dto.getAddress().getAddressID();
			this.brancheName =dto.getBrancheName();
			this.branchID = dto.getBranchID();
			this.city=dto.getAddress().getCity();
			this.country=dto.getAddress().getCountry();
			this.postalCode=dto.getAddress().getPostalCode();
			this.storeID=dto.getStoreID();
			this.storeName=dto.getStoreName();
			this.street=dto.getStoreName();
			
			return this;
			
		}
	}



	
}
