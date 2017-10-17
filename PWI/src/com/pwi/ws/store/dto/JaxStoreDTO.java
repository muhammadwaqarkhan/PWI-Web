package com.pwi.ws.store.dto;

import com.pwi.services.store.dto.StoreDTO;


public class JaxStoreDTO {

	private String storeName;
	private Long storeID;
	private String brancheName;
	private Long branchID;
	private JaxAddressDTO address = new JaxAddressDTO();
	
	
	
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
	public JaxAddressDTO getAddress() {
		return address;
	}
	public void setAddress(JaxAddressDTO address) {
		this.address = address;
	}
	
	public StoreDTO assemble()
	{
		StoreDTO dto = new StoreDTO();
		dto.setAddress(address.assemble());
		dto.setBrancheName(brancheName);
		dto.setStoreName(storeName);
		dto.setBranchID(branchID);
		return dto;
	}
}
