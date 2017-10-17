package com.pwi.ws.store.dto;

import com.pwi.header.Header;
import com.pwi.services.store.product.dto.StoreProductDTO;

public class JaxStoreProductDTO 
{
	private Header header;
	private Long productID;
	private Long storeID;
	
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public Long getStoreID() {
		return storeID;
	}
	public void setStoreID(Long storeID) {
		this.storeID = storeID;
	}
	
	
	
	
	public StoreProductDTO assemble()
	{
		StoreProductDTO dto = new StoreProductDTO();
		dto .setStoreID(storeID);
		dto .setProductID(productID);
		return dto;
	}
}
