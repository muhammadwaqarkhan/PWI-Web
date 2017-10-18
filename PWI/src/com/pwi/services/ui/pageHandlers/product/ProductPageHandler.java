package com.pwi.services.ui.pageHandlers.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.pwi.constants.FrameNames;
import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.product.ProductService;
import com.pwi.services.product.dto.ProductDTO;
import com.pwi.services.product.dto.ProductOutDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;

public class ProductPageHandler  implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request)
	{
		IResponseHandler response = getProducts(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getProducts(HttpServletRequest request) 
	{

		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new ProductService();
		Object object = executor.callService(service, "FetchProduct", new ProductDTO());
		if(object instanceof ProductOutDTO)
		{
			request.setAttribute("products", ((ProductOutDTO)object).getProducts());
			
			return (ProductOutDTO)object;
			
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
		
	}
	
	

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		IResponseHandler response = addProduct(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}
	
	protected IResponseHandler addProduct(HttpServletRequest request)
	{
		
		
		ProductDTO dto = getProductDTO(request);

		
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new ProductService();
		Object object = executor.callService(service, "SaveProduct", dto);
		
		if(object instanceof ProductOutDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getProducts(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
	}


	
	protected String getNavUrl (HttpServletRequest request)
	{
		
		String navUrl = FrameNames.ADD_PRODUCT+".jsp";
		return navUrl;
		
	}

	@Override
	public IResponseHandler executeDelete(HttpServletRequest request) {
		
		
		return null;
	}
	
	protected IResponseHandler updateProduct(HttpServletRequest request) 
	{
		String sproductID = request.getParameter("selectedID");
		sproductID  =sproductID  == null ? "-1" : sproductID ;
		
		
		ProductDTO dto = getProductDTO(request);
		dto.setProductID(Long.valueOf(sproductID ));
		
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new ProductService();
		Object object = executor.callService(service, "UpdateProduct", dto);
		if(object instanceof ProductOutDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getProducts(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {
		IResponseHandler response = updateProduct(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}
	private ProductDTO getProductDTO(HttpServletRequest request)
	{
		
		String size = request.getParameter("size");
		String productName = request.getParameter("productName");
		String productType = request.getParameter("productType");
		
		String MOQ = request.getParameter("MOQ");
		String QPB = request.getParameter("QPB");
		MOQ = MOQ==null ? "0" : MOQ;
		QPB= QPB==null ? "0" : QPB;
		size= size==null ? "0" : size;

		
		ProductDTO dto = new ProductDTO();
		dto.setProductName(productName);
		dto.setProductType(productType);
		dto.setMOQ(Integer.valueOf(MOQ));
		dto.setQPB(Integer.valueOf(QPB));
		dto.setSize(Integer.valueOf(size));
		return dto;
	}
}