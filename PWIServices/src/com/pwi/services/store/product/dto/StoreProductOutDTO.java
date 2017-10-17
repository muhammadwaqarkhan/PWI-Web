package com.pwi.services.store.product.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.services.product.dto.ProductOutDTO;
import com.pwi.services.store.dto.StoreOutDTO;


public class StoreProductOutDTO extends BaseDTO implements IRequestHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<StoreProductDTO> storeProducts = new ArrayList<StoreProductDTO>();
	StoreOutDTO stores; 
	ProductOutDTO products;
	
	public List<StoreProductDTO> getStoreProducts() {
		return storeProducts;
	}

	public void setStoreProducts(List<StoreProductDTO> storeProducts) {
		this.storeProducts = storeProducts;
	}

	public StoreOutDTO getStores() {
		return stores;
	}

	public void setStores(StoreOutDTO stores) {
		this.stores = stores;
	}

	public ProductOutDTO getProducts() {
		return products;
	}

	public void setProducts(ProductOutDTO products) {
		this.products = products;
	}

	

	
}
