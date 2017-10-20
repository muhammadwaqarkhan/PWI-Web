package com.pwi.services.branch.store.dto;

import org.springframework.stereotype.Component;

import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.branch.dto.BranchOutDTO;
import com.pwi.services.store.dto.StoreOutDTO;

@Component
public class BranchStoreDTO extends BaseDTO implements IRequestHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StoreOutDTO storeDTO = new StoreOutDTO();
	BranchOutDTO branchDTO = new BranchOutDTO();

	public StoreOutDTO getStoreDTO() {
		return storeDTO;
	}

	public void setStoreDTO(IResponseHandler storeDTO) {
		this.storeDTO = (StoreOutDTO) storeDTO;
	}

	public BranchOutDTO getBranchDTO() {
		return branchDTO;
	}

	public void setBranchDTO(IResponseHandler branchDTO) {
		this.branchDTO = (BranchOutDTO) branchDTO;
	}
}
