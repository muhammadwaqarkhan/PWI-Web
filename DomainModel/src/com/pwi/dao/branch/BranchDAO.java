package com.pwi.dao.branch;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.pwi.constants.PWICodes;
import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.branch.Branch;

/**
 * 
 * create BranchDAO class to write queries for branch table
 * 
 * @author Waqar Contact 03346100977
 */
@Repository()
@Scope(value = "prototype")
public class BranchDAO extends BaseDAO  implements IBranchDAO
{
		
	public static BranchDAO getInstance (Session session)
	{
		BranchDAO singleton= new BranchDAO ();
		singleton.init(session);
		return singleton;
	}
	/**
	 * Reads all branches 
	 * 
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Branch> readBranches() {
		
		String hql = "from com.pwi.domain.branch.Branch where status=:status";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("status", PWICodes.INDICATOR_TRUE);
		return query.list();
		
	
	}
	
	 /***
	 * This method called get Branch object
	 * 
	 * @param Long primary key of branch
	 *            
	 * @return Branch
	 */
	@Override
	public Branch findByPrimaryKey(Long branchID) {

		String hql = "from com.pwi.domain.branch.Branch where branchID=:branchID";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("branchID", branchID);
		return (Branch)query.uniqueResult();
	}
	
	/***
	 * This method called get Branch object
	 * 
	 * @param String of branch Name
	 *            
	 * @return Branch
	 */
	@Override
	public Branch readByBranchName(String branchName) 
	{
		String hql = "from com.pwi.domain.branch.Branch where branchName=:branchName";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("branchName", branchName);
		return (Branch)query.uniqueResult();
	}



}
