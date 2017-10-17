package com.pwi.services.store;

import java.util.List;

import com.pwi.dao.branch.BranchDAO;
import com.pwi.dao.store.StoreDAO;
import com.pwi.domain.address.Address;
import com.pwi.domain.branch.Branch;
import com.pwi.domain.store.Store;
import com.pwi.factory.DomainFactory;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.store.dto.StoreDTO;
import com.pwi.services.store.dto.StoreOutDTO;

public class StoreService  extends ServiceBase
{
	/***
	 * This method called to fetch the information of store
	 * 
	 * @param none
	 *            
	 * @return StoreOutDTO (which contain all store information )
	 */
	@ServiceMethod(name = "FetchStore")
	public IResponseHandler fetchStore()
	{
		StoreOutDTO outDTO = new StoreOutDTO ();
		
		
		List<Store> stores =	StoreDAO.getInstance(getSession()).readStores();
		
		for(Store store : stores)
		{
			
			outDTO.getStores().add(new StoreDTO().assemble(store));
		}	
		
		return outDTO;
	}
	
	/***
	 * This method called to save information of store
	 * 
	 * @param StoreDTO which contain store information came from user end
	 *            
	 * @return IResponseHandler contain request status
	 */
	@ServiceMethod(name = "SaveStore")
	public IResponseHandler saveStore(StoreDTO dto)
	{
		Branch branch =BranchDAO.getInstance(getSession()).findByPrimaryKey(dto.getBranchID());
		
		Address address = DomainFactory.getInstance().newAddress();
		address.setCity(dto.getAddress().getCity());
		address.setCountry(dto.getAddress().getCountry());
		address.setPostCode(dto.getAddress().getPostalCode());
		address.setStreet(dto.getAddress().getStreet());
		getSession().persist(address);

		Store store= DomainFactory.getInstance().newStore(address,branch);
		store.setName(dto.getStoreName());
		getSession().persist(store);
	
		return dto;
	}
	
	/***
	 * This method called to UpdateStore information of store
	 * 
	 * @param StoreDTO which contain store information came from user end
	 *            
	 * @return IResponseHandler contain request status
	 */
	@ServiceMethod(name = "UpdateStore")
	public IResponseHandler updateStore(StoreDTO dto)
	{
		Store store= StoreDAO.getInstance(getSession()).findByPrimaryKey(dto.getStoreID());
	
		
		Address address = store.getAddress();
		address.setCity(dto.getAddress().getCity());
		address.setCountry(dto.getAddress().getCountry());
		address.setPostCode(dto.getAddress().getPostalCode());
		address.setStreet(dto.getAddress().getStreet());
		getSession().update(address);
		getSession().update(store);
	
		return dto;
	}
	
	/***
	 * This method called to Delete Store information of store
	 * 
	 * @param StoreDTO which contain store information came from user end
	 *            
	 * @return IResponseHandler contain request status
	 */
	@ServiceMethod(name = "DeleteStore")
	public IResponseHandler deleteStore(StoreDTO dto)
	{
	
		Store store = StoreDAO.getInstance(getSession()).findByPrimaryKey(dto.getStoreID());
		
		getSession().delete(store );
		getSession().delete(store.getAddress());
		return dto;
	}
}
