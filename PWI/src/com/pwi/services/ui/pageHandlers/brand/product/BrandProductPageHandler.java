package com.pwi.services.ui.pageHandlers.brand.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.pwi.constants.FrameNames;
import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.brand.product.BrandProductService;
import com.pwi.services.brand.product.dto.BrandProductDTO;
import com.pwi.services.brand.product.dto.BrandProductOutDTO;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.store.product.StoreProductService;
import com.pwi.services.store.product.dto.StoreProductDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;

public class BrandProductPageHandler extends BasePageHandler implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request)
	{
		IResponseHandler response = getBrandProducts(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getBrandProducts(HttpServletRequest request) 
	{
	

		
		IResponseHandler response = getServiceExecutor().callService(getService() , "FetchBrandProduct", new StoreProductDTO());
		if(isSuccess(response, request))
		{	
			request.setAttribute("products", ((BrandProductOutDTO)response).getProducts());
			request.setAttribute("brands", ((BrandProductOutDTO)response).getBrand());
			request.setAttribute("brandProduct", ((BrandProductOutDTO)response).getBrandProducts());
			return (BrandProductOutDTO)response;
			
		}
		else
		{
			return response;
		}
		
	}
	
	

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) 
	{

		IResponseHandler response = addBrandProduct(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}
	
	protected IResponseHandler addBrandProduct(HttpServletRequest request)
	{
		String brand = request.getParameter("brand");
		String products = request.getParameter("products");
		
		BrandProductDTO inDTO= new BrandProductDTO ();
		inDTO.setBrandID(Long.valueOf(brand));
		inDTO.setProductID(Long.valueOf(products));
		
		
		IResponseHandler response = getServiceExecutor().callService(getService() , "SaveBrandProduct", inDTO);
		
		if(isSuccess(response, request))
		{
			return getBrandProducts(request);
		}
		else
		{
			return response;
		}
	}


	
	protected String getNavUrl (HttpServletRequest request)
	{
		
		String navUrl = FrameNames.ADD_BRAND_PRODUCT+".jsp";
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
		
		IResponseHandler response = getServiceExecutor().callService(getService() , "DeleteStoreProduct", dto);
		if(isSuccess(response, request,true))
		{
			return getBrandProducts(request);
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
	protected ServiceBase getService() 
	{
	
		return (ServiceBase)SpringApplicationContext.getBean("brandProductService");
	}
	
}