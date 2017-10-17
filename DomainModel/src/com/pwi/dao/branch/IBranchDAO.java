package com.pwi.dao.branch;

import java.util.List;

import com.pwi.domain.branch.Branch;
/**
 * 
 * create IBranchDAO interface 
 * 
 * @author Waqar Contact 03346100977
 */
public interface IBranchDAO 
{
	List<Branch> readBranches();
	Branch findByPrimaryKey(Long branchID);
	Branch readByBranchName(String branchName);
}
