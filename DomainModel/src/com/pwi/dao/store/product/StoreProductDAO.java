package com.pwi.dao.store.product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.brand.Brand;
import com.pwi.domain.product.store.StoreProduct;
import com.pwi.spring.SpringApplicationContext;

public class StoreProductDAO extends BaseDAO implements IStoreProductDAO{

	public static StoreProductDAO getInstance (Session session)
	{
		StoreProductDAO dao= (StoreProductDAO)SpringApplicationContext.getApplicationContext().getBean("storeProductDAO");
		dao.init(session);
		return dao;
	}

	@Override
	public StoreProduct findByPrimaryKey(Long storeProductID) 
	{
		//String hql = "from StoreProduct where storeProductID=:storeProductID";
		
		
		
		Query query = getSession().getNamedQuery(StoreProduct.Queries.READ_BY_PRIMARY_KEY);  
		query.setParameter("storeProductID", storeProductID);
		return (StoreProduct)query.uniqueResult();	

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreProduct> readStoresProduct() {

		//String hql = "from StoreProduct";
		
		Query query = getSession().getNamedQuery(StoreProduct.Queries.READ_BY_ALL_STORE_PRODUCT);
		return query.list();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreProduct> readByStoreID(Long storeID) {
	
		//String hql = "from StoreProduct where storeID=:storeID";
		
		Query query = getSession().getNamedQuery(StoreProduct.Queries.READ_BY_STORE_ID);
		query.setParameter("storeID", storeID);
		return query.list();	 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreProduct> readByProductID(Long productID) {
		
		//String hql = "from StoreProduct where productID=:productID";
		
		Query query = getSession().getNamedQuery(StoreProduct.Queries.READ_BY_PRODUCT_ID);
		query.setParameter("productID", productID);
		return query.list();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreProduct> readByStoreIDProductID(Long productID, Long storeID) 
	{
		//String hql = "from StoreProduct where productID=:productID and storeID=:storeID";
		Query query = getSession().getNamedQuery(StoreProduct.Queries.READ_BY_STORE_PRODUCT_ID);
		query.setParameter("productID", productID);
		query.setParameter("storeID", storeID);
		return query.list();	
	}
	
	

	

}
