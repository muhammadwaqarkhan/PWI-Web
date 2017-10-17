package com.pwi.ws.product.dto;

import com.pwi.header.Header;
import com.pwi.services.product.dto.ProductDTO;

public class JaxProductSizeDTO {
	private Header header;
	private Long productID;
	private String productName;


	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	
	public ProductDTO assemble()
	{
		ProductDTO dto = new ProductDTO();	
		dto.setProductName(productName);
		dto.setProductID(productID);

		return dto;
	}
}
