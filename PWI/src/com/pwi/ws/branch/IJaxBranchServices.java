package com.pwi.ws.branch;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.pwi.ws.branch.dto.JaxBranchDTO;
import com.pwi.ws.branch.dto.JaxBranchOutDTO;

@WebService
@SOAPBinding() 
public interface IJaxBranchServices {
	
	
	List<JaxBranchOutDTO> getBranchStoreQuantity(JaxBranchDTO input);
	

	
}
