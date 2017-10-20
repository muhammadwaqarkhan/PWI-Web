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

public class BrandProductPageHandler  implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request)
	{
		IResponseHandler response = getBrandProducts(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getBrandProducts(HttpServletRequest request) 
	{
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();

		ServiceBase service = (ServiceBase)SpringApplicationContext.getApplicationContext().getBean("brandProductService");
		Object object = executor.callService(service, "FetchBrandProduct", new StoreProductDTO());
		if(object instanceof BrandProductOutDTO)
		{	
			request.setAttribute("products", ((BrandProductOutDTO)object).getProducts());
			request.setAttribute("brands", ((BrandProductOutDTO)object).getBrand());
			request.setAttribute("brandProduct", ((BrandProductOutDTO)object).getBrandProducts());
			return (BrandProductOutDTO)object;
			
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
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
		
		
		ServiceBase service = new BrandProductService();
		Object object = BasePageHandler.getServiceExecutor().callService(service, "SaveBrandProduct", inDTO);
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getBrandProducts(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
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
		
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new StoreProductService();
		Object object = executor.callService(service, "DeleteStoreProduct", dto);
		if(object instanceof StoreProductDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getBrandProducts(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {
		return null;
	}
	
}