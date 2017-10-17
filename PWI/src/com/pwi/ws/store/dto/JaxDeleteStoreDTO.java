package com.pwi.ws.store.dto;

import com.pwi.header.Header;
import com.pwi.services.store.dto.StoreDTO;

public class JaxDeleteStoreDTO {

	private Header header;
	private String storeName;
	private Long storeID;
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
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	
	public StoreDTO assemble()
	{
		StoreDTO dto = new StoreDTO ();
		dto.setStoreName(storeName);
		dto.setStoreID(storeID);
		return dto;
	}
}
