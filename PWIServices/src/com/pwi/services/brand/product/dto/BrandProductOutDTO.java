package com.pwi.services.brand.product.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.services.brand.dto.BrandOutDTO;
import com.pwi.services.product.dto.ProductOutDTO;
import com.pwi.spring.SpringApplicationContext;

@Component
public class BrandProductOutDTO extends BaseDTO implements IRequestHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<BrandProductDTO> brandProducts = new ArrayList<BrandProductDTO>();
	BrandOutDTO brand; 
	ProductOutDTO products;
	
	
	public List<BrandProductDTO> getBrandProducts() {
		return brandProducts;
	}

	public void setBrandProducts(List<BrandProductDTO> brandProducts) {
		this.brandProducts = brandProducts;
	}

	public BrandOutDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandOutDTO brand) {
		this.brand = brand;
	}

	public ProductOutDTO getProducts() {
		return products;
	}

	public void setProducts(ProductOutDTO products) {
		this.products = products;
	}

	

	
}
