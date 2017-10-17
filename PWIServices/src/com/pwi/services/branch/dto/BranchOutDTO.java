package com.pwi.services.branch.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.dto.BaseDTO;

public class BranchOutDTO extends BaseDTO 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	List<BranchDTO> branches = new ArrayList<BranchDTO>();

	public List<BranchDTO>  getBranches() {
		return branches;
	}

	public String getCompanyName() 
	{
		if(branches.size()>0)
			return branches.get(0).getCompanyName();
		else
			return "";
	}

	
	public void setBranches(List<BranchDTO> branches) {
		this.branches = branches;
	}
	
	

	
}
