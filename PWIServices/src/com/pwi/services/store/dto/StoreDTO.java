package com.pwi.services.store.dto;

import org.springframework.stereotype.Component;

import com.pwi.domain.store.Store;
import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.services.address.dto.AddressDTO;

@Component
public class StoreDTO extends BaseDTO implements IRequestHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1903628870986067316L;

	private String storeName;
	private Long storeID;
	private String brancheName;
	private Long branchID;
	private AddressDTO address = new AddressDTO();

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

	public Long getBranchID() {
		return branchID;
	}

	public void setBranchID(Long branchID) {
		this.branchID = branchID;
	}

	public String getBrancheName() {
		return brancheName;
	}

	public void setBrancheName(String brancheName) {
		this.brancheName = brancheName;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public StoreDTO assemble(Store store) {
		this.storeID = store.getStoreID();
		this.storeName = store.getName();
		this.branchID = store.getBranchID();
		this.brancheName = store.getBranch().getBranchName();
		this.address.setStreet(store.getAddress().getStreet());
		this.address.setCity(store.getAddress().getCity());
		this.address.setCountry(store.getAddress().getCountry());
		this.address.setPostalCode(store.getAddress().getPostCode());
		this.address.setAddressID(store.getAddress().getAddressID());
		return this;

	}
}
