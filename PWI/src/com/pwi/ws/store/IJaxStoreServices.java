package com.pwi.ws.store;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.pwi.header.Header;
import com.pwi.services.store.dto.StoreOutDTO;
import com.pwi.services.store.product.dto.StoreProductOutDTO;
import com.pwi.ws.store.dto.JaxDeleteStoreDTO;
import com.pwi.ws.store.dto.JaxStoreDTO;
import com.pwi.ws.store.dto.JaxStoreProductDTO;
import com.pwi.ws.store.dto.JaxStoreProductQuantityDTO;

@WebService
@SOAPBinding() 
public interface IJaxStoreServices {
	
	@WebMethod 
	StoreOutDTO getStore(Header header);  
	@WebMethod 
	String addStore(JaxStoreDTO input);  
	
	@WebMethod 
	String updateStore(JaxStoreDTO input);
	
	@WebMethod 
	String deleteStore(JaxDeleteStoreDTO input);
	
	@WebMethod 
	StoreProductOutDTO storeItemQuantity(JaxStoreProductDTO input);
	
	@WebMethod 
	String updateStoreItemQuantity(JaxStoreProductQuantityDTO input);

	
}
