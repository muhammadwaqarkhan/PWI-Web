package com.pwi.services.ui.pageHandlers.store;

import javax.servlet.http.HttpServletRequest;

import com.pwi.constants.FrameNames;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.store.dto.BranchStoreDTO;
import com.pwi.services.store.dto.StoreDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;

public class StorePageHandler extends BasePageHandler implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request) {
		IResponseHandler response = getStores(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler getStores(HttpServletRequest request) {

		StoreDTO dto = new StoreDTO();

		ServiceBase base = (ServiceBase) SpringApplicationContext.getBean("branchStoreService");
		IResponseHandler response = getServiceExecutor().callService(base, "FetchBranchStore", dto);
		if (isSuccess(response, request)) {
			request.setAttribute("branches", ((BranchStoreDTO) response).getBranchDTO().getBranches());
			request.setAttribute("stroes", ((BranchStoreDTO) response).getStoreDTO().getStores());
			return response;

		} else {

			return response;
		}

	}

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		IResponseHandler response = addStore(request);
		response.setNavURL(getNavUrl(request));

		return response;
	}

	protected IResponseHandler addStore(HttpServletRequest request) {
		String storeName = request.getParameter("storeName");
		String branchID = request.getParameter("branch");
		String branchStreet = request.getParameter("branchstreet");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String postal = request.getParameter("postal");

		StoreDTO inDTO = new StoreDTO();
		inDTO.setStoreName(storeName);
		inDTO.setBranchID(Long.valueOf(branchID));
		inDTO.getAddress().setStreet(branchStreet);
		inDTO.getAddress().setCity(city);
		inDTO.getAddress().setCountry(country);
		inDTO.getAddress().setPostalCode(postal);

		IResponseHandler response = getServiceExecutor().callService(getService(), "SaveStore", inDTO);

		if (isSuccess(response, request, true)) {
			return getStores(request);
		} else {
			return response;
		}
	}

	protected String getNavUrl(HttpServletRequest request) {

		String navUrl = FrameNames.ADD_STORE + ".jsp";
		return navUrl;

	}

	@Override
	public IResponseHandler executeDelete(HttpServletRequest request) {

		IResponseHandler response = deleteStore(request);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	protected IResponseHandler deleteStore(HttpServletRequest request) {
		String sstoreID = request.getParameter("selectedID");
		sstoreID = sstoreID == null ? "-1" : sstoreID;
		StoreDTO dto = new StoreDTO();
		dto.setStoreID(Long.valueOf(sstoreID));

		IResponseHandler response = getServiceExecutor().callService(getService(), "DeleteStore", dto);
		if (isSuccess(response, request, true)) {
			return getStores(request);
		} else {
			return response;
		}
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {
		return null;
	}

	@Override
	protected ServiceBase getService() {
		return (ServiceBase) SpringApplicationContext.getBean("storeService");
	}

}