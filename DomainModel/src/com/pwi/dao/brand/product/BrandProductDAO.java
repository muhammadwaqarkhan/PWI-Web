package com.pwi.dao.brand.product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.brand.product.BrandProduct;
import com.pwi.domain.user.UserAccounts;
import com.pwi.spring.SpringApplicationContext;

public class BrandProductDAO extends BaseDAO implements IBrandProductDAO{

	public static BrandProductDAO getInstance (Session session)
	{
		BrandProductDAO dao= (BrandProductDAO)SpringApplicationContext.getApplicationContext().getBean("brandProductDAO");
		dao.init(session);
		return dao;
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
		
		//String hql = "from BrandProduct where brandProductID=:brandProductID";
		
		Query query = getSession().getNamedQuery(BrandProduct.Queries.READ_BY_PRIMARY_KEY);  
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
		//String hql = "from BrandProduct";
		
		Query query = getSession().getNamedQuery(BrandProduct.Queries.READ_BY_ALL_BRANDS);  
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
		//String hql = "from BrandProduct where branID=:branID";
		
		Query query = getSession().getNamedQuery(BrandProduct.Queries.READ_BY_BRAND_ID);  
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
		//String hql = "from BrandProduct where productID=:productID";
		
		
		Query query = getSession().getNamedQuery(BrandProduct.Queries.READ_BY_PRODUCT_ID);  
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
		//String hql = "from BrandProduct where productID=:productID and branID=:branID";
		
		
		Query query = getSession().getNamedQuery(BrandProduct.Queries.READ_BY_BRAND_AND_PRODUCT_ID);
		query.setParameter("productID", productID);
		query.setParameter("branID", brandID);
		return query.list();
	}

	
	
	

	

}
