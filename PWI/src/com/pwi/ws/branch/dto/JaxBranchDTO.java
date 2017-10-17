package com.pwi.ws.branch.dto;

import com.pwi.services.branch.dto.BranchDTO;


public class JaxBranchDTO {

	private String brancheName;
	private Long branchID;

	
	public String getBrancheName() {
		return brancheName;
	}
	public void setBrancheName(String brancheName) {
		this.brancheName = brancheName;
	}
	public Long getBranchID() {
		return branchID;
	}
	public void setBranchID(Long branchID) {
		this.branchID = branchID;
	}

	
	public BranchDTO assemble()
	{
		BranchDTO dto = new BranchDTO();
		dto.setBranchName(brancheName);
		dto.setBranchID(branchID);
		return dto;
	}
}
