package com.pwi.ws.store;

import javax.jws.WebService;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.header.Header;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.product.ProductService;
import com.pwi.services.store.StoreService;
import com.pwi.services.store.dto.StoreDTO;
import com.pwi.services.store.dto.StoreOutDTO;
import com.pwi.services.store.product.StoreProductService;
import com.pwi.services.store.product.dto.StoreProductOutDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;
import com.pwi.ws.store.dto.JaxDeleteStoreDTO;
import com.pwi.ws.store.dto.JaxStoreDTO;
import com.pwi.ws.store.dto.JaxStoreProductDTO;
import com.pwi.ws.store.dto.JaxStoreProductQuantityDTO;

@WebService(targetNamespace = "com.pwi.ws.JaxStoreServices")
public class JaxStoreServices implements IJaxStoreServices
{
	private final String SUCCESS="success";
	private final String FAILURE="failure";
	@Override
	public StoreOutDTO getStore(Header header) {
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new StoreService();
		Object object = executor.callService(base, "FetchStore", new StoreDTO());
		
		if(object instanceof StoreOutDTO )
		{
			return (StoreOutDTO)object;
		}

		return new StoreOutDTO();
	}

	@Override
	public String addStore(JaxStoreDTO input) {
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new StoreService();
		Object object = executor.callService(base, "SaveStore", input.assemble());
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return SUCCESS;
		}

		return FAILURE;
	}

	@Override
	public String updateStore(JaxStoreDTO input) 
	{
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new ProductService();
		Object object = executor.callService(base, "UpdateStore", input.assemble());
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return SUCCESS;
		}

		return FAILURE;
	}

	@Override
	public String deleteStore(JaxDeleteStoreDTO input) {
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new StoreService();
		Object object = executor.callService(base, "DeleteStore", input.assemble());
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return SUCCESS;
		}

		return FAILURE;
	}

	@Override
	public StoreProductOutDTO storeItemQuantity(JaxStoreProductDTO input) {
		
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new StoreProductService();
		Object object = executor.callService(base, "WebServiceStoreProduct", input.assemble());
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return (StoreProductOutDTO)object;
		}

		return new StoreProductOutDTO();
	}

	@Override
	public String updateStoreItemQuantity(JaxStoreProductQuantityDTO input) {
		
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new StoreProductService();
		Object object = executor.callService(base, "updateStoreProductQuantity", input.assemble());
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return SUCCESS;
		}

		return FAILURE;
		

	}
	
	
	
	
}
