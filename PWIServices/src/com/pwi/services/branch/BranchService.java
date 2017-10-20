package com.pwi.services.branch;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pwi.constants.PWICodes;
import com.pwi.dao.branch.BranchDAO;
import com.pwi.dao.company.CompanyDAO;
import com.pwi.domain.address.Address;
import com.pwi.domain.branch.Branch;
import com.pwi.domain.product.store.StoreProduct;
import com.pwi.domain.store.Store;
import com.pwi.factory.DomainFactory;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.branch.dto.BranchDTO;
import com.pwi.services.branch.dto.BranchOutDTO;
import com.pwi.services.branch.dto.BranchStoreProductOutDTO;
import com.pwi.services.framework.annotations.ServiceMethod;
@Service
public class BranchService extends ServiceBase{

	/***
	 * This method called to fetch the information of branch 
	 * 
	 * @param none
	 *            
	 * @return BranchOutDTO (which contain all company branches)
	 */
	@ServiceMethod(name = "FetchBranch")
	public IResponseHandler fetchBranch()
	{
		BranchOutDTO outDTO = new BranchOutDTO();
		
		
		List<Branch> branches =	BranchDAO.getInstance(getSession()).readBranches();
		
		for(Branch branch : branches)
		{
				
			outDTO.getBranches().add(new BranchDTO().assemble(branch));
		}	
	
		return outDTO;
	}
	
	
	/***
	 * This method called to save information of branch 
	 * 
	 * @param BranchDTO which contain branch information + branch address
	 *            
	 * @return IResponseHandler to check either request completed successfully or not
	 */
	@ServiceMethod(name = "SaveBranch")
	public IResponseHandler SaveBranch(BranchDTO dto)
	{
	
		Address address = DomainFactory.getInstance().newAddress();
		address.setCity(dto.getCity());
		address.setCountry(dto.getCountry());
		address.setPostCode(dto.getPostalCode());
		address.setStreet(dto.getStreet());
		getSession().persist(address);
		
		Branch branch = DomainFactory.getInstance().newBranch(address);
		branch.setBranchName(dto.getBranchName());
		branch.setCompany(CompanyDAO.getInstance(getSession()).findByPrimaryKey(PWICodes.DEFAULT_COMPANY));
		
		
		getSession().persist(branch);
		
		
		return dto;
	}
	
	/***
	 * This method called to delete branch information
	 * 
	 * @param BranchDTO information which required to delete
	 *            
	 * @return IResponseHandler to check either record deleted successfully or not
	 */
	@ServiceMethod(name = "DeleteBranch")
	public IResponseHandler deleteBranch(BranchDTO dto)
	{
	
		Branch branch = BranchDAO.getInstance(getSession()).findByPrimaryKey(dto.getBranchID());
		
		getSession().delete(branch);
		
		getSession().delete(branch.getAddress());
		
		for(Store store :branch.getStores())
		{
			if(store.getStoreProduct().size()>0)
				getSession().delete(store.getStoreProduct());
			getSession().delete(store);
		}
		
		
		
		
		return dto;
	}
	
	/***
	 * This method called to update branch information
	 * 
	 * @param BranchDTO information which required to update
	 *            
	 * @return IResponseHandler to check either record deleted successfully or not
	 */
	@ServiceMethod(name = "UpdateBranch")
	public IResponseHandler updateBranch(BranchDTO dto)
	{
	
		Branch branch = BranchDAO.getInstance(getSession()).findByPrimaryKey(dto.getBranchID());
		
		branch.getAddress().setCity(dto.getCity());
		branch.getAddress().setCountry(dto.getCountry());
		branch.getAddress().setPostCode(dto.getPostalCode());
		branch.getAddress().setStreet(dto.getStreet());
		getSession().update(branch.getAddress());
		
		branch.setBranchName(dto.getBranchName());
		
		getSession().update(branch);
		
		
		return dto;
	}
	
	
	/***
	 * This method called from web service to retrieved branch store and product 
	 * 
	 * @param BranchDTO information which required to update
	 *            
	 * @return BranchStoreProductOutDTO which contain branch store and product
	 */
	@ServiceMethod(name = "webServiceBranch")
	public IResponseHandler webServiceBranch(BranchDTO dto)
	{
		BranchStoreProductOutDTO outDTO = new BranchStoreProductOutDTO();
		
		Branch branch=null; 
		
		if(dto.getBranchID() !=null && dto.getBranchID() >0)
			branch=	BranchDAO.getInstance(getSession()).findByPrimaryKey(dto.getBranchID());
		
		else if(dto.getBranchName()!=null && dto.getBranchName().length()>0)
			branch=	BranchDAO.getInstance(getSession()).readByBranchName(dto.getBranchName());
		
		
		if(branch !=null)
		{
			for (Store store : branch.getStores())
			{
				for (StoreProduct sp : store.getStoreProduct())
				{
					
					outDTO.getQuantitySize().add(outDTO.newStoreProductQuantitySize().assmeble(sp));
				}
			}
		}
		
		return outDTO;
	}
}
