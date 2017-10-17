package com.pwi.ws.branch;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.BranchService;
import com.pwi.services.branch.dto.BranchStoreProductOutDTO;
import com.pwi.services.branch.dto.BranchStoreProductOutDTO.StoreProductQuantitySize;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.ws.branch.dto.JaxBranchDTO;
import com.pwi.ws.branch.dto.JaxBranchOutDTO;

@WebService(targetNamespace = "com.pwi.ws.JaxStoreServices")
public class JaxBranchServices implements IJaxBranchServices
{
	
	@Override
	public List<JaxBranchOutDTO> getBranchStoreQuantity(JaxBranchDTO input) 
	{
		List<JaxBranchOutDTO> outDTO = new ArrayList<JaxBranchOutDTO>();
		ServiceExecutor executor= BasePageHandler.getServiceExecutor();
		ServiceBase base = new BranchService();
		Object object = executor.callService(base, "webServiceBranch", input.assemble());
		
		
		if(object instanceof BranchStoreProductOutDTO )
		{
			for(StoreProductQuantitySize branch : ((BranchStoreProductOutDTO)object).getQuantitySize())
			{
				JaxBranchOutDTO dto = new JaxBranchOutDTO();
				dto.setBranchName(branch.getBranchName());
				dto.setStoreName(branch.getStoreName());
				dto.setQuantity(branch.getQuantity());
				dto.setSize(branch.getSize());
				
				outDTO.add(dto);
			}
		}
		
		return outDTO;
	}
	
	
	
	
	
}
