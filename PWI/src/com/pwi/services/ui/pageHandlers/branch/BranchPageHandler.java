package com.pwi.services.ui.pageHandlers.branch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.pwi.constants.FrameNames;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.dto.BranchDTO;
import com.pwi.services.branch.dto.BranchOutDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;

@Component
public class BranchPageHandler extends BasePageHandler implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request) {
		IResponseHandler response = getBranch(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getBranch(HttpServletRequest request) {

		IResponseHandler response = getServiceExecutor().callService(getService(), "FetchBranch", new BranchDTO());
		if (isSuccess(response, request)) {
			request.setAttribute("companyName", ((BranchOutDTO) response).getCompanyName());
			request.setAttribute("branches", ((BranchOutDTO) response).getBranches());
			return (BranchOutDTO) response;

		} else
			return response;

	}

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		IResponseHandler response = addBranch(request);

		response.setNavURL(getNavUrl(request));

		return response;
	}

	protected IResponseHandler addBranch(HttpServletRequest request) {
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

		if (isSuccess(response, request, true)) {
			return getBranch(request);
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

		IResponseHandler response = deleteBranch(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler deleteBranch(HttpServletRequest request) {
		String sBranchID = request.getParameter("selectedbranchId");
		sBranchID = sBranchID == null ? "-1" : sBranchID;
		BranchDTO dto = new BranchDTO();
		dto.setBranchID(Long.valueOf(sBranchID));

		IResponseHandler response = getServiceExecutor().callService(getService(), "DeleteBranch", dto);
		if (isSuccess(response, request, true)) {
			return getBranch(request);
		} else {
			return response;
		}
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {

		IResponseHandler response = updateBranch(request);
		response.setNavURL(getNavUrl(request));
		return response;

	}

	protected IResponseHandler updateBranch(HttpServletRequest request) {
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
		if (isSuccess(response, request, true)) {
			return getBranch(request);
		} else {

			return response;
		}
	}

	@Override
	protected ServiceBase getService() {
		return (ServiceBase) SpringApplicationContext.getBean("branchService");
	}
}