package com.pwi.services.ui.pageHandlers.brand;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.pwi.constants.FrameNames;
import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.BranchService;
import com.pwi.services.branch.dto.BranchDTO;
import com.pwi.services.branch.dto.BranchOutDTO;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;

public class BrandPageHandler  implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request)
	{
		IResponseHandler response = getBrands(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getBrands(HttpServletRequest request) 
	{

		
	
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new BranchService();
		Object object = executor.callService(service, "FetchBranch", new BranchDTO());
		if(object instanceof BranchOutDTO)
		{
			request.setAttribute("companyName", ((BranchOutDTO)object).getCompanyName());
			request.setAttribute("branches", ((BranchOutDTO)object).getBranches());
			return (BranchOutDTO)object;
			
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
		
	}
	
	

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		IResponseHandler response = addBrand(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}
	
	protected IResponseHandler addBrand(HttpServletRequest request)
	{
		String branchName = request.getParameter("branchName");
		String branchStreet = request.getParameter("branchstreet");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String postal = request.getParameter("postal");
		
		BranchDTO inDTO= new BranchDTO();
		inDTO.setBranchName(branchName);
		inDTO.setStreet(branchStreet);
		inDTO.setCity(city);
		inDTO.setCountry(country);
		inDTO.setPostalCode(postal);
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new BranchService();
		Object object = executor.callService(service, "SaveBranch", inDTO);
		
		if(object instanceof BranchDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getBrands(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
	}


	
	protected String getNavUrl (HttpServletRequest request)
	{
		
		String navUrl = FrameNames.ADD_BRANCH+".jsp";
		return navUrl;
		
	}

	@Override
	public IResponseHandler executeDelete(HttpServletRequest request) {
		
		IResponseHandler response = deleteBrand(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}
	
	protected IResponseHandler deleteBrand(HttpServletRequest request) 
	{
		String sBranchID = request.getParameter("selectedbranchId");
		sBranchID =sBranchID == null ? "-1" : sBranchID;
		BranchDTO dto = new BranchDTO();
		dto.setBranchID(Long.valueOf(sBranchID));
		
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new BranchService();
		Object object = executor.callService(service, "DeleteBranch", dto);
		if(object instanceof BranchDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getBrands(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {
		
		IResponseHandler response = updateBrand(request);
		response.setNavURL(getNavUrl(request));
		return response;
	
	}
	protected IResponseHandler  updateBrand(HttpServletRequest request) 
	{
		String sBranchID = request.getParameter("selectedbranchId");
		sBranchID =sBranchID == null ? "-1" : sBranchID;
		BranchDTO dto = new BranchDTO();
		dto.setBranchID(Long.valueOf(sBranchID));
		
		String branchName = request.getParameter("branchName");
		String branchStreet = request.getParameter("branchstreet");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String postal = request.getParameter("postal");
		
		
		dto.setBranchName(branchName);
		dto.setStreet(branchStreet);
		dto.setCity(city);
		dto.setCountry(country);
		dto.setPostalCode(postal);
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new BranchService();
		Object object = executor.callService(service, "UpdateBranch", dto);
		if(object instanceof BranchDTO && ((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			return getBrands(request);
		}
		else
		{
			BaseOutDTO errorOutDTO = new BaseOutDTO();
			return errorOutDTO;
		}
	}
}