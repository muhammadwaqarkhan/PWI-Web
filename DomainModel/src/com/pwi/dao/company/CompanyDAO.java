package com.pwi.dao.company;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.company.Company;
import com.pwi.spring.SpringApplicationContext;

public class CompanyDAO extends BaseDAO implements ICompanyDAO{

	public static CompanyDAO getInstance (Session session)
	{
		CompanyDAO dao= (CompanyDAO)SpringApplicationContext.getApplicationContext().getBean("companyDAO");
		dao.init(session);
		return dao;
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

		//String hql = "from com.pwi.domain.company.Company where companyID=:companyID";
		
		//Query query = getSession().createQuery(hql);
		
		Query query = getSession().getNamedQuery(Company.Queries.READ_BY_PRIMARY_KEY);  
		query.setParameter("companyID", companyID);
		return (Company)query.uniqueResult();
	}

}
