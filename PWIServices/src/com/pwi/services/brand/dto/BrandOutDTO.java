package com.pwi.services.brand.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.dto.BaseDTO;

public class BrandOutDTO extends BaseDTO 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	List<BrandDTO> brands = new ArrayList<BrandDTO>();


	public List<BrandDTO> getBrands() {
		return brands;
	}


	public void setBrands(List<BrandDTO> brands) {
		this.brands = brands;
	}

	
	
	

	
}
