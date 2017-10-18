package com.pwi.services.product.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pwi.dto.BaseDTO;
import com.pwi.spring.SpringApplicationContext;
@Component
public class ProductOutDTO  extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<ProductDTO> products = new ArrayList<ProductDTO>();

	
	
	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
}
