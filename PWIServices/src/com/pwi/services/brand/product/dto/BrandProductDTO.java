package com.pwi.services.brand.product.dto;

import org.springframework.stereotype.Component;

import com.pwi.domain.brand.product.BrandProduct;
import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;

@Component
public class BrandProductDTO extends BaseDTO implements IRequestHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long brandProductID;
	private Long productID;
	private Long brandID;
	private String brandName;
	private String productName;

	public Long getBrandProductID() {
		return brandProductID;
	}

	public void setBrandProductID(Long brandProductID) {
		this.brandProductID = brandProductID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Long getBrandID() {
		return brandID;
	}

	public void setBrandID(Long brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BrandProductDTO assemble(BrandProduct bp) {
		this.brandID = bp.getBrandID();
		this.brandName = bp.getBrand().getBrandName();
		this.productName = bp.getProduct().getProductName();
		this.brandProductID = bp.getBrandProductID();
		this.productID = bp.getProductID();

		return this;

	}
}
