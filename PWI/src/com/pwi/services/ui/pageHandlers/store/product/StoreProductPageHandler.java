package com.pwi.services.ui.pageHandlers.store.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.pwi.constants.FrameNames;
import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.store.product.StoreProductService;
import com.pwi.services.store.product.dto.StoreProductDTO;
import com.pwi.services.store.product.dto.StoreProductOutDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;

public class StoreProductPageHandler extends BasePageHandler  implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request)
	{
		IResponseHandler response = getStoreProducts(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getStoreProducts(HttpServletRequest request) 
	{
		IResponseHandler response = getServiceExecutor().callService(getService(), "FetchStoreProduct", new StoreProductDTO());
		if(isSuccess(response, request))
		{
			request.setAttribute("products", ((StoreProductOutDTO)response).getProducts());
			request.setAttribute("stores", ((StoreProductOutDTO)response).getStores());
			request.setAttribute("stroesProduct", ((StoreProductOutDTO)response).getStoreProducts());
			return (StoreProductOutDTO)response;
			
		}
		else
		{
			return response;
		}
		
	}
	
	

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) 
	{

		IResponseHandler response = addStoreProduct(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}
	
	protected IResponseHandler addStoreProduct(HttpServletRequest request)
	{
		String store = request.getParameter("store");
		String products = request.getParameter("products");
		String instock = request.getParameter("instock");
		String InTransit = request.getParameter("InTransit");
		String quantity = request.getParameter("quantity");
		String reorderPoint = request.getParameter("reorderPoint");
		
		reorderPoint = reorderPoint ==null ?"0" : reorderPoint;
		InTransit = InTransit ==null ?"0" : InTransit;
		quantity = quantity ==null ?"0" : quantity;
		store = store ==null ?"0" : store;
		products = products ==null ?"0" : products;
		boolean isInstock = instock !=null && instock.equals("1");
		
		
		StoreProductDTO inDTO= new StoreProductDTO ();
		inDTO.setStoreID(Long.valueOf(store));
		inDTO.setProductID(Long.valueOf(store));
		inDTO.setInstock(isInstock);
		inDTO.setQuantity(Integer.valueOf(quantity));
		inDTO.setInTransit(Integer.valueOf(InTransit));
		inDTO.setReorderPoint(Integer.valueOf(reorderPoint));
		
		
		
		IResponseHandler response = getServiceExecutor().callService(getService(), "SaveStoreProduct", inDTO);
		
		if(isSuccess(response, request,true))
		{
			return getStoreProducts(request);
		}
		else
		{
			return response;
		}
	}


	
	protected String getNavUrl (HttpServletRequest request)
	{
		
		String navUrl = FrameNames.ADD_STORE_PRODUCT+".jsp";
		return navUrl;
		
	}

	@Override
	public IResponseHandler executeDelete(HttpServletRequest request) {
		
		IResponseHandler response = deleteStoreProduct(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}
	
	protected IResponseHandler deleteStoreProduct(HttpServletRequest request) 
	{
		String storeProductID = request.getParameter("selectedID");
		storeProductID =storeProductID == null ? "-1" : storeProductID;
		StoreProductDTO dto = new StoreProductDTO();
		dto.setStoreProductID(Long.valueOf(storeProductID));
		
		
		
		IResponseHandler response = getServiceExecutor().callService(getService(), "DeleteStoreProduct", dto);
		if(isSuccess(response, request,true))
		{
			return getStoreProducts(request);
		}
		else
		{
			return response;
		}
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {
		return null;
	}

	@Override
	protected ServiceBase getService() {

		return (ServiceBase)SpringApplicationContext.getApplicationContext().getBean("storeProductService");
	}
	
}