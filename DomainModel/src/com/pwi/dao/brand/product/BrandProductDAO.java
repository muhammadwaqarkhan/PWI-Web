package com.pwi.dao.brand.product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.brand.product.BrandProduct;

public class BrandProductDAO extends BaseDAO implements IBrandProductDAO{

	public static BrandProductDAO getInstance (Session session)
	{
		BrandProductDAO singleton= new BrandProductDAO();
		singleton.init(session);
		return singleton;
	}

	/***
	 * This method called get BrandProduct object
	 * 
	 * @param Long primary key of BrandProduct
	 *            
	 * @return BrandProduct
	 */
	@Override
	public BrandProduct findByPrimaryKey(Long brandProductID) {
		
		String hql = "from BrandProduct where brandProductID=:brandProductID";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("brandProductID", brandProductID);
		return (BrandProduct)query.uniqueResult();	
	}

	/***
	 * This method called all BrandProduct object
	 * 
	 * @param none
	 *            
	 * @return List<BrandProduct>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandProduct> readBrandProduct() {
		String hql = "from BrandProduct";
		Query query = getSession().createQuery(hql);
		return query.list();	
	}

	/***
	 * This method called list of BrandProduct object
	 * 
	 * @param Long: brand id
	 *            
	 * @return List<BrandProduct>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandProduct> readByBrandID(Long brandID) 
	{
		String hql = "from BrandProduct where branID=:branID";
		Query query = getSession().createQuery(hql);
		query.setParameter("branID", brandID);
		return query.list();	
	}

	/***
	 * This method called list of BrandProduct object
	 * 
	 * @param Long: product id
	 *            
	 * @return List<BrandProduct>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandProduct> readByProductID(Long productID) 
	{
		String hql = "from BrandProduct where productID=:productID";
		Query query = getSession().createQuery(hql);
		query.setParameter("productID", productID);
		return query.list();	
	}

	/***
	 * This method called list of BrandProduct object
	 * 
	 * @param Long: product id
	 *        Long: brand id 
	 * @return List<BrandProduct>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandProduct> readByBrandIDProductID(Long productID, Long brandID) 
	{
		String hql = "from BrandProduct where productID=:productID and branID=:branID";
		Query query = getSession().createQuery(hql);
		query.setParameter("productID", productID);
		query.setParameter("branID", brandID);
		return query.list();
	}

	
	
	

	

}
