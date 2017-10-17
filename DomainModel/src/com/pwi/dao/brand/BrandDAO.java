package com.pwi.dao.brand;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.brand.Brand;
/**
 * 
 * create BrandDAO class to read queries for brand table
 * 
 * @author Waqar Contact 03346100977
 */
public class BrandDAO extends BaseDAO implements IBrandDAO
{

	public static BrandDAO getInstance (Session session)
	{
		BrandDAO singleton= new BrandDAO ();
		singleton.init(session);
		return singleton;
	}
	
	/***
	 * This method called list of Brand object
	 * 
	 * @param none
	 *        
	 * @return List<Brand>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> readBrands() 
	{
		String hql = "from com.pwi.domain.brand.Brand";
		
		Query query = getSession().createQuery(hql);
		
		return query.list();

	}

	/***
	 * This method called list of Brand object
	 * 
	 * @param Long: primary Key
	 *        
	 * @return Brand
	 */
	@Override
	public Brand findByPrimaryKey(Long key) {
		
		Query query = getSession().createQuery("from com.pwi.domain.brand.Brand where brandID=:brandID");
		query.setParameter("brandID", key);
		return (Brand) query.uniqueResult();
	}

}
