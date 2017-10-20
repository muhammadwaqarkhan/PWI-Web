package com.pwi.services.ui.pageHandlers.brand;

import javax.servlet.http.HttpServletRequest;

import com.pwi.constants.FrameNames;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.dto.BranchDTO;
import com.pwi.services.branch.dto.BranchOutDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;

public class BrandPageHandler extends BasePageHandler implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request) {
		IResponseHandler response = getBrands(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getBrands(HttpServletRequest request) {

		IResponseHandler response = getServiceExecutor().callService(getService(), "FetchBranch", new BranchDTO());
		if (isSuccess(response, request)) {
			request.setAttribute("companyName", ((BranchOutDTO) response).getCompanyName());
			request.setAttribute("branches", ((BranchOutDTO) response).getBranches());
			return (BranchOutDTO) response;

		} else {
			return response;
		}

	}

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		IResponseHandler response = addBrand(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}

	protected IResponseHandler addBrand(HttpServletRequest request) {
		String branchName = request.getParameter("branchName");
		String branchStreet = request.getParameter("branchstreet");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String postal = request.getParameter("postal");

		BranchDTO inDTO = new BranchDTO();
		inDTO.setBranchName(branchName);
		inDTO.setStreet(branchStreet);
		inDTO.setCity(city);
		inDTO.setCountry(country);
		inDTO.setPostalCode(postal);

		IResponseHandler response = getServiceExecutor().callService(getService(), "SaveBranch", inDTO);

		if (isSuccess(response, request)) {
			return getBrands(request);
		} else {
			return response;
		}
	}

	protected String getNavUrl(HttpServletRequest request) {

		String navUrl = FrameNames.ADD_BRANCH + ".jsp";
		return navUrl;

	}

	@Override
	public IResponseHandler executeDelete(HttpServletRequest request) {

		IResponseHandler response = deleteBrand(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler deleteBrand(HttpServletRequest request) {
		String sBranchID = request.getParameter("selectedbranchId");
		sBranchID = sBranchID == null ? "-1" : sBranchID;
		BranchDTO dto = new BranchDTO();
		dto.setBranchID(Long.valueOf(sBranchID));

		IResponseHandler response = getServiceExecutor().callService(getService(), "DeleteBranch", dto);
		if (isSuccess(response, request)) {
			return getBrands(request);
		} else {
			return response;
		}
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {

		IResponseHandler response = updateBrand(request);
		response.setNavURL(getNavUrl(request));
		return response;

	}

	protected IResponseHandler updateBrand(HttpServletRequest request) {
		String sBranchID = request.getParameter("selectedbranchId");
		sBranchID = sBranchID == null ? "-1" : sBranchID;
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

		IResponseHandler response = getServiceExecutor().callService(getService(), "UpdateBranch", dto);
		if (isSuccess(response, request)) {
			return getBrands(request);
		} else {
			return response;
		}
	}

	@Override
	protected ServiceBase getService() {
		return (ServiceBase) SpringApplicationContext.getBean("branchService");
	}
}