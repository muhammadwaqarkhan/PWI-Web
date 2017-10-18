package com.pwi.services.store.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.spring.SpringApplicationContext;
@Component
public class StoreOutDTO extends BaseDTO implements IResponseHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1903628870986067316L;

	List<StoreDTO> stores = new ArrayList<StoreDTO>();

	
	public List<StoreDTO> getStores() {
		return stores;
	}


	public void setStores(List<StoreDTO> stores) {
		this.stores = stores;
	} 
}
