package com.pwi.services.branch.store;

import org.springframework.stereotype.Service;

import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.BranchService;
import com.pwi.services.branch.store.dto.BranchStoreDTO;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.store.StoreService;
@Service
public class BranchStoreService extends ServiceBase {

	/***
	 * This method called to fetch the information of branch store
	 * 
	 * @param none
	 *            
	 * @return BranchStoreDTO (which contain all stores which belong to branch )
	 */
	@ServiceMethod(name = "FetchBranchStore")
	public IResponseHandler fetchBranch()
	{
	
		BranchStoreDTO dto = new BranchStoreDTO();
		
		StoreService store = (StoreService)newInstance(new StoreService());
		BranchService branch = (BranchService)newInstance(new BranchService());
		
		dto.setStoreDTO(store.fetchStore()) ;
		dto.setBranchDTO(branch.fetchBranch());
	
		return dto;
	}
	
}
