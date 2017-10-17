package com.pwi.services.store.product;

import java.util.List;

import com.pwi.dao.product.ProductDAO;
import com.pwi.dao.store.StoreDAO;
import com.pwi.dao.store.product.StoreProductDAO;
import com.pwi.domain.product.Product;
import com.pwi.domain.product.store.StoreProduct;
import com.pwi.domain.store.Store;
import com.pwi.factory.DomainFactory;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.product.ProductService;
import com.pwi.services.product.dto.ProductOutDTO;
import com.pwi.services.store.StoreService;
import com.pwi.services.store.dto.StoreOutDTO;
import com.pwi.services.store.product.dto.StoreProductDTO;
import com.pwi.services.store.product.dto.StoreProductOutDTO;

public class StoreProductService extends ServiceBase
{
	/***
	 * This method called to fetch the information of store product
	 * 
	 * @param none
	 *            
	 * @return StoreProductOutDTO (which contain all store product information )
	 */
	@ServiceMethod(name = "FetchStoreProduct")
	public IResponseHandler fetchStoreProduct()
	{	
		StoreProductOutDTO outDTO = new StoreProductOutDTO();
		
		List<StoreProduct> sps= StoreProductDAO.getInstance(getSession()).readStoresProduct();
		
		for(StoreProduct sp : sps)
		{
			StoreProductDTO dto = new StoreProductDTO();
			
			outDTO.getStoreProducts().add(dto.assemble(sp));
		}
		
		StoreService storeService = (StoreService)newInstance(new StoreService());
		outDTO.setStores((StoreOutDTO)storeService.fetchStore());
		
		ProductService productService = (ProductService)newInstance(new ProductService());
		outDTO.setProducts((ProductOutDTO)productService.fetchProduct());
		
		return outDTO;
	}
	
	/***
	 * This method called to save the information of store product
	 * 
	 * @param StoreProductDTO which contain required information of store product
	 *            
	 * @return IResponseHandler to identified request status
	 */
	@ServiceMethod(name = "SaveStoreProduct")
	public IResponseHandler saveStoreProduct(StoreProductDTO dto)
	{	
		Store store = StoreDAO.getInstance(getSession()).findByPrimaryKey(dto.getStoreID());
		Product product = ProductDAO.getInstance(getSession()).findByPrimaryKey(dto.getProductID());
		
		StoreProduct sp = DomainFactory.getInstance().newStoreProduct(store, product);
		
		sp.setInstock(dto.isInstock());
		sp.setInTransit(dto.getInTransit());
		sp.setQuantity(dto.getQuantity());
		sp.setReorderPoint(dto.getReorderPoint());
		
		getSession().persist(sp);
		
		return dto;
	}

	/***
	 * This method called to delete the information of store product
	 * 
	 * @param StoreProductDTO which contain required information of store product
	 *            
	 * @return IResponseHandler to identified request status
	 */
	@ServiceMethod(name = "DeleteStoreProduct")
	public IResponseHandler deleteStoreProduct(StoreProductDTO dto)
	{	
		StoreProduct sp = StoreProductDAO.getInstance(getSession()).findByPrimaryKey(dto.getStoreProductID());
	
		getSession().delete(sp);
		
		return dto;
	}
	
	
	/***
	 * This method called from web-service to get store product
	 * 
	 * @param StoreProductDTO which contain required information of store product
	 *            
	 * @return StoreProductOutDTO to fetch all product which associate to store
	 */
	@ServiceMethod(name = "WebServiceStoreProduct")
	public IResponseHandler webServiceStoreProduct(StoreProductDTO dto)
	{	
		StoreProductOutDTO outDTO = new StoreProductOutDTO();
		List<StoreProduct> sps =getStoreProduct(dto);
		
		for(StoreProduct sp : sps)
		{
			dto = new StoreProductDTO();
			
			outDTO.getStoreProducts().add(dto.assemble(sp));
		}
				
		return outDTO;
	}
	
	/***
	 * This method called from web-service to update store product quantity
	 * 
	 * @param StoreProductDTO which contain required information of store product
	 *            
	 * @return IResponseHandler to identified request status either success or failure
	 */
	@ServiceMethod(name = "updateStoreProductQuantity")
	public IResponseHandler updateStoreProductQuantity(StoreProductDTO dto)
	{	
		
		List<StoreProduct> sps =getStoreProduct(dto);
		
		for(StoreProduct sp : sps)
		{
			sp.setQuantity(dto.getQuantity());
			getSession().update(sp);
		}

		return dto;
	}
	
	/***
	 * This method called to get list of Store product 
	 * 
	 * @param StoreProductDTO which contain required information of store product
	 *            
	 * @return List<StoreProduct> to read required data from DB
	 */
	protected List<StoreProduct>  getStoreProduct(StoreProductDTO dto) 
	{
		List<StoreProduct> sps;
		if(dto.getStoreID()!=null && dto.getStoreID() >0 && dto.getProductID()!=null && dto.getProductID() >0)
		{
			sps= StoreProductDAO.getInstance(getSession()).readByStoreIDProductID(dto.getProductID(),dto.getStoreID());
		}
		else if(dto.getStoreID()!=null && dto.getStoreID() >0)
			sps= StoreProductDAO.getInstance(getSession()).readByStoreID(dto.getStoreID());
		else if (dto.getProductID()!=null&& dto.getProductID()>0)
			sps= StoreProductDAO.getInstance(getSession()).readByStoreID(dto.getStoreID());
		else 
			sps =StoreProductDAO.getInstance(getSession()).readStoresProduct();
			
		
		return sps;
	}
}
