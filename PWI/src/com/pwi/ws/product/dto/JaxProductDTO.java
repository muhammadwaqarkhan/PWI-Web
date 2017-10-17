package com.pwi.ws.product.dto;

import com.pwi.header.Header;
import com.pwi.services.product.dto.ProductDTO;

public class JaxProductDTO 
{
	private Header header;
	private Long productID;
	private String productName;
	private String productType;
	private Integer MOQ;
	private Integer size;
	private Integer QPB;
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
	
	public Integer getMOQ() {
		return MOQ;
	}
	public void setMOQ(Integer mOQ) {
		MOQ = mOQ;
	}
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getQPB() {
		return QPB;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public void setQPB(Integer qPB) {
		QPB = qPB;
	}
	
	public ProductDTO assemble()
	{
		ProductDTO dto = new ProductDTO();
		dto.setProductID(productID);
		dto.setMOQ(MOQ);
		dto.setProductName(productName);
		dto.setProductType(productType);
		dto.setQPB(QPB);
		dto.setSize(size);
		return dto;
	}
}
