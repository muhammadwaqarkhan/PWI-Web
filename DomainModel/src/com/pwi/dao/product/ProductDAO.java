package com.pwi.dao.product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.product.Product;

public class ProductDAO extends BaseDAO implements IProductDAO{

	public static ProductDAO getInstance (Session session)
	{
		ProductDAO singleton= new ProductDAO();
		singleton.init(session);
		return singleton;
	}
	
	/***
	 * This method called to get  Product entity
	 * 
	 * @param Long: product ID
	 *        
	 * @return Product
	 */
	@Override
	public Product findByPrimaryKey(Long productID) {

		String hql = "from com.pwi.domain.product.Product where productID=:productID";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("productID", productID);
		return (Product)query.uniqueResult();
	}

	/***
	 * This method called to get  list of Product entity
	 * 
	 * @param none
	 *        
	 * @return List<Product>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readProducts() 
	{
		String hql = "from com.pwi.domain.product.Product ";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	
	/***
	 * This method called to get  list of Product entity
	 * 
	 * @param Integer: size of product
	 * 		  String: name of product
	 * 		  String type of product
	 *        
	 * @return Product
	 */
	@Override
	public Product readBySizeNameAndType(Integer size,String Name,String type) 
	{
		String hql = "from com.pwi.domain.product.Product where  productName=:productName and size=:size and productType=:productType";
		Query query = getSession().createQuery(hql);
		return (Product) query.uniqueResult();
	}

	/***
	 * This method called to get  list of Product entity
	 * 
	 * @param  String: name of product
     *
	 *        
	 * @return ist<Product>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readByName(String name) 
	{
		String hql = "from com.pwi.domain.product.Product where  productName=:productName ";
		Query query = getSession().createQuery(hql);
		query.setParameter("productName", name);
		return query.list();
	}

}
