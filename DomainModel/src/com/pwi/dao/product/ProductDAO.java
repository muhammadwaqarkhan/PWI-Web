package com.pwi.dao.product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.company.Company;
import com.pwi.domain.product.Product;
import com.pwi.spring.SpringApplicationContext;

public class ProductDAO extends BaseDAO implements IProductDAO{

	public static ProductDAO getInstance (Session session)
	{
		ProductDAO singleton= (ProductDAO)SpringApplicationContext.getApplicationContext().getBean("productDAO");
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

		//String hql = "from com.pwi.domain.product.Product where productID=:productID";
		
		Query query = getSession().getNamedQuery(Product.Queries.READ_BY_PRIMARY_KEY);  
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
		//String hql = "from com.pwi.domain.product.Product ";
		
		
		Query query = getSession().getNamedQuery(Product.Queries.READ_BY_ALL_PRODUCTS);  
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
		//String hql = "from com.pwi.domain.product.Product where  productName=:productName and size=:size and productType=:productType";
		Query query = getSession().getNamedQuery(Product.Queries.READ_BY_SIZE_NAME_TYPE);
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
		//String hql = "from com.pwi.domain.product.Product where  productName=:productName ";
		
		Query query = getSession().getNamedQuery(Product.Queries.READ_BY_NAME);
		
		query.setParameter("productName", name);
		return query.list();
	}

}
