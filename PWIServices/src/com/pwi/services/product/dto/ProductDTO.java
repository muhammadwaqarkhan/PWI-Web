package com.pwi.services.product.dto;

import org.springframework.stereotype.Component;

import com.pwi.domain.product.Product;
import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.services.brand.product.dto.BrandProductOutDTO;
import com.pwi.spring.SpringApplicationContext;
@Component
public class ProductDTO extends BaseDTO implements IRequestHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public void setQPB(Integer qPB) {
		QPB = qPB;
	}
	
	public ProductDTO assemble(Product product)
	{
		
		this.MOQ=product.getMOQ();
		this.productID=product.getProductID();
		this.productName=product.getProductName();
		this.productType =product.getProductType();
		this.size=product.getSize();
		this.QPB=product.getQPB();
		return this;
	}
	
}
