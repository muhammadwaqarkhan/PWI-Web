package com.pwi.services.brand.dto;

import com.pwi.domain.brand.Brand;
import com.pwi.dto.BaseDTO;

public class BrandDTO extends BaseDTO
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long brandID;
	private String brandName;


	
	
	
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

	
	public BrandDTO assemble(Brand brand)
	{
		this.brandID = brand.getBrandID();
		this.brandName=brand.getBrandName();
	
		
		return this;
	}
}
