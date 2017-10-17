package com.pwi.ajax.branch;

import com.pwi.ajax.beans.StructAjaxResponse;
import com.pwi.constants.ApplicationCodes;
import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.BranchService;
import com.pwi.services.branch.dto.BranchDTO;
import com.pwi.services.branch.dto.BranchOutDTO;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;

public class BranchAjaxHandler
{
	public StructAjaxResponse deleteBranch (Long branchID)
	{
		StructAjaxResponse ajaxResponse = new StructAjaxResponse();
		try
		{

			
			BranchDTO dto = new BranchDTO();
			dto.setBranchID(branchID);
			
			ServiceExecutor executor=BasePageHandler.getServiceExecutor();
			ServiceBase service = new BranchService();
			Object object = executor.callService(service, "DeleteBranch", dto);
			
			if(object instanceof BranchDTO)
			{
				if(((IResponseHandler)object).getErrorCode() == FrameworkReasonCodes.ERROR_NO)
				{
					IResponseHandler response = getBranches();
					
					ajaxResponse.setHtmlString(makeBranchTable((BranchOutDTO)response));
				}
			}
				
		}
		catch (Exception e)
		{
			System.out.println(e.getStackTrace());
			ajaxResponse.setError(ApplicationCodes.AJAX_ERROR);

		}
		return ajaxResponse;

	}

	private IResponseHandler getBranches()
	{
		ServiceExecutor executor=BasePageHandler.getServiceExecutor();
		ServiceBase service = new BranchService();
		Object object = executor.callService(service, "FetchBranch", new BranchDTO());
		if(object instanceof IResponseHandler)
			return (IResponseHandler)object;
		else
			return new BaseOutDTO();
	}
	




	private String makeBranchTable (BranchOutDTO outDTO)
	{
		StringBuffer branchTable = new StringBuffer();

		branchTable.append("<table id=\"branchesTable\" align=\"right\" class=\"table table-responsive table-bordered table-hover\">");
		branchTable.append("<thead><tr>");

		StringBuffer tableHeaders = new StringBuffer();

		tableHeaders.append("<th><u>Branch Code</u></th>");
		tableHeaders.append("<th><u>Branch Name</u></th>");
		tableHeaders.append("<th><u>Company Name</u></th>");
		tableHeaders.append("<th><u>Street</u></th>");
		tableHeaders.append("<th><u>City</u></th>");
		tableHeaders.append("<th><u>Postal Code</u></th>");
		tableHeaders.append("<th><u>Country</u></th>");

		branchTable.append(tableHeaders);
		branchTable.append("</tr></thead>");

		branchTable.append("<tbody>");

		if (outDTO !=null)
		{
			for (BranchDTO branch : outDTO.getBranches())
			{
				branchTable.append("<tr>");
				branchTable.append("<td>").append(branch.getBranchID()).append("</td>");
				branchTable.append("<td>").append(branch.getBranchName()).append("</td>");
				branchTable.append("<td>").append(branch.getCompanyName()).append("</td>");
				branchTable.append("<td>").append(branch.getStreet()).append("</td>");
				branchTable.append("<td>").append(branch.getCity()).append("</td>");
				branchTable.append("<td>").append(branch.getPostalCode()).append("</td>");
				branchTable.append("<td>").append(branch.getCountry()).append("</td>");
				
				branchTable.append("</tr>");
			}
		}
		branchTable.append("</tbody></table>");

		return branchTable.toString();
	}

	
}
