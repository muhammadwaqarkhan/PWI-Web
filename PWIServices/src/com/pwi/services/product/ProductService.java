package com.pwi.services.product;

import java.util.ArrayList;
import java.util.List;

import com.pwi.dao.product.ProductDAO;
import com.pwi.domain.product.Product;
import com.pwi.factory.DomainFactory;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.product.dto.ProductDTO;
import com.pwi.services.product.dto.ProductOutDTO;

public class ProductService extends ServiceBase
{
	/***
	 * This method called to fetch the information of product
	 * 
	 * @param none
	 *            
	 * @return ProductOutDTO (which contain product information )
	 */
	@ServiceMethod(name = "FetchProduct")
	public IResponseHandler fetchProduct()
	{
		ProductOutDTO outDTO = new ProductOutDTO();
		
		
		List<Product> products = ProductDAO.getInstance(getSession()).readProducts();
	
		for(Product prodcut : products)
		{
			outDTO.getProducts().add(new ProductDTO().assemble(prodcut));
		}
		return outDTO;
	}
	
	/***
	 * This method called to save product information
	 * 
	 * @param ProductDTO (input parameter which contain product information came user end)
	 *            
	 * @return return IResponseHandler which contain either request success or fail
	 */
	@ServiceMethod(name = "SaveProduct")
	public IResponseHandler saveProduct(ProductDTO dto)
	{
		ProductOutDTO outDTO = new ProductOutDTO();
		
		Product product = DomainFactory.getInstance().newProduct();
	
		assemble(dto,product);
		
		getSession().persist(product);
		
		return outDTO;
	}
	
	/***
	 * This method called to update the information of product
	 * 
	 * @param ProductDTO (input parameter which contain product information came user end)
	 *            
	 * @return return IResponseHandler which contain either request success or fail
	 */
	@ServiceMethod(name = "UpdateProduct")
	public IResponseHandler updateProduct(ProductDTO dto)
	{
		ProductOutDTO outDTO = new ProductOutDTO();
		
		
		Product product = ProductDAO.getInstance(getSession()).findByPrimaryKey(dto.getProductID());
	
		assemble(dto,product);
		getSession().update(product);
		
		return outDTO;
	}
	
	/***
	 * This method called to delete the information of product
	 * 
	 * @param ProductDTO (input parameter which contain product ID)
	 *            
	 * @return return IResponseHandler which contain either request success or fail
	 */
	@ServiceMethod(name = "DeleteProduct")
	public IResponseHandler deleteProduct(ProductDTO dto)
	{
		Product product = null;
		
		if (dto.getProductID() != null && dto.getProductID() > 0)
			ProductDAO.getInstance(getSession()).findByPrimaryKey(dto.getProductID());
		else
			product = ProductDAO.getInstance(getSession()).readBySizeNameAndType(dto.getSize(), dto.getProductName(),
					dto.getProductType());
		
		getSession().delete(product);
		
		
		return dto;
	}
	
	/***
	 * This method called from webservice which return product on the base of input
	 * 
	 * @param ProductDTO (input parameter)
	 *            
	 * @return return ProductOutDTO which contain either request success or fail and product information
	 */
	@ServiceMethod(name = "WebServiceFetchProduct")
	public IResponseHandler webServiceFetchProduct(ProductDTO dto)
	{
		ProductOutDTO outDTO = new ProductOutDTO();
		List<Product> products=new ArrayList<Product>();
		
		if(dto.getProductID()==null || dto.getProductID() ==0)
			products = ProductDAO.getInstance(getSession()).readProducts();
		else if(dto.getProductID()!=null && dto.getProductID() >0)
			products.add(ProductDAO.getInstance(getSession()).findByPrimaryKey(dto.getProductID()));
		
		else if(dto.getProductName()!=null && dto.getProductName().length() >0)
		{
			products =ProductDAO.getInstance(getSession()).readByName(dto.getProductName().trim());
		}
	
		for(Product prodcut : products)
		{
			outDTO.getProducts().add(new ProductDTO().assemble(prodcut));
		}
		return outDTO;
	}
	
	/***
	 * This method called assemble product from DTO to domain object
	 * 
	 * @param ProductDTO (input parameter)
	 *            
	 * @return return void
	 */
	protected void assemble(ProductDTO dto,Product product) 
	{
		product.setMOQ(product.getMOQ());
		product.setProductName(dto.getProductName());
		product.setProductType(dto.getProductType());
		product.setSize(dto.getSize());
		product.setQPB(dto.getQPB());
	}
	

}
