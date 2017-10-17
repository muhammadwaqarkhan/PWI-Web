package com.pwi.ws.product;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.pwi.header.Header;
import com.pwi.services.product.dto.ProductOutDTO;
import com.pwi.ws.product.dto.JaxDeleteProductDTO;
import com.pwi.ws.product.dto.JaxProductDTO;
import com.pwi.ws.product.dto.JaxProductSizeDTO;
import com.pwi.ws.product.dto.JaxProductSizeOutDTO;

@WebService
@SOAPBinding() 
public interface IJaxProductServices {
	
	@WebMethod 
	ProductOutDTO getProduct(Header header);  
	@WebMethod 
	String addProduct(JaxProductDTO input);  
	
	@WebMethod 
	String updateProduct(JaxProductDTO input);
	
	@WebMethod 
	String deleteProduct(JaxDeleteProductDTO input);
	
	@WebMethod 
	List<JaxProductSizeOutDTO> productSize(JaxProductSizeDTO input);

}
