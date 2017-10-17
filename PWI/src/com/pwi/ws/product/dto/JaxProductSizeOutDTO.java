package com.pwi.ws.product.dto;

import com.pwi.header.Header;
import com.pwi.services.product.dto.ProductDTO;

public class JaxProductSizeOutDTO {
	private Header header;
	private Long productID;
	private String productName;
	private Integer size;

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
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public ProductDTO assemble()
	{
		ProductDTO dto = new ProductDTO();	
		dto.setProductName(productName);

		return dto;
	}
}
