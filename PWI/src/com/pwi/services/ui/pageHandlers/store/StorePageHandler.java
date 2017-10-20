package com.pwi.services.ui.pageHandlers.store;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.pwi.constants.FrameNames;
import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.store.BranchStoreService;
import com.pwi.services.branch.store.dto.BranchStoreDTO;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.store.StoreService;
import com.pwi.services.store.dto.StoreDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;

public class StorePageHandler  implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request)
	{
		IResponseHandler response = getStores(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getStores(HttpServletRequest request) 
	{

		StoreDTO dto  = new StoreDTO();
	
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
	
		ServiceBase service = (ServiceBase)SpringApplicationContext.getApplicationContext().getBean("branchStoreService");
		Object object = executor.callService(service, "FetchBranchStore", dto);
		if(object instanceof BranchStoreDTO)
		{
			request.setAttribute("branches", ((BranchStoreDTO)object).getBranchDTO().getBranches());
			request.setAttribute("stroes", ((BranchStoreDTO)object).getStoreDTO().getStores());
			return (BranchStoreDTO)object;
			
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
		
	}
	
	

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		IResponseHandler response = addStore(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}
	
	protected IResponseHandler addStore(HttpServletRequest request)
	{
		String storeName = request.getParameter("storeName");
		String branchID = request.getParameter("branch");
		String branchStreet = request.getParameter("branchstreet");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String postal = request.getParameter("postal");
		
		
		StoreDTO inDTO= new StoreDTO ();
		inDTO.setStoreName(storeName);
		inDTO.setBranchID(Long.valueOf(branchID));
		inDTO.getAddress().setStreet(branchStreet);
		inDTO.getAddress().setCity(city);
		inDTO.getAddress().setCountry(country);
		inDTO.getAddress().setPostalCode(postal);
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new StoreService();
		Object object = executor.callService(service, "SaveStore", inDTO);
		
		if(object instanceof StoreDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getStores(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
	}


	
	protected String getNavUrl (HttpServletRequest request)
	{
		
		String navUrl = FrameNames.ADD_STORE+".jsp";
		return navUrl;
		
	}

	@Override
	public IResponseHandler executeDelete(HttpServletRequest request) {
		
		IResponseHandler response = deleteStore(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}
	
	protected IResponseHandler deleteStore(HttpServletRequest request) 
	{
		String sstoreID = request.getParameter("selectedID");
		sstoreID =sstoreID == null ? "-1" : sstoreID;
		StoreDTO dto = new StoreDTO();
		dto.setStoreID(Long.valueOf(sstoreID));
		
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new StoreService();
		Object object = executor.callService(service, "DeleteStore", dto);
		if(object instanceof StoreDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getStores(request);
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