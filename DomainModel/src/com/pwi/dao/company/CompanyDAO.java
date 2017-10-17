package com.pwi.dao.company;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.company.Company;

public class CompanyDAO extends BaseDAO implements ICompanyDAO{

	public static CompanyDAO getInstance (Session session)
	{
		CompanyDAO singleton= new CompanyDAO();
		singleton.init(session);
		return singleton;
	}
	
	/***
	 * This method called list of Company object
	 * 
	 * @param Long: company ID
	 *        
	 * @return Company
	 */
	
	@Override
	public Company findByPrimaryKey(Long companyID) {

		String hql = "from com.pwi.domain.company.Company where companyID=:companyID";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("companyID", companyID);
		return (Company)query.uniqueResult();
	}

}
