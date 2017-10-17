package com.pwi.ws.product.dto;

import com.pwi.header.Header;
import com.pwi.services.product.dto.ProductDTO;

public class JaxDeleteProductDTO {
	private Header header;
	private Long productID;
	private String productName;
	private String productType;
	private Integer productSize;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getProductSize() {
		return productSize;
	}
	public void setProductSize(Integer productSize) {
		this.productSize = productSize;
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
		dto.setProductType(productType);
		dto.setSize(productSize);
		return dto;
	}
}
