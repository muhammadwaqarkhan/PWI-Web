package com.pwi.rest.store;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.rest.store.dto.RestStoreOutDTO;
import com.pwi.rest.store.dto.RestStoreQuantityDTO;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.store.StoreService;
import com.pwi.services.store.dto.StoreDTO;
import com.pwi.services.store.dto.StoreOutDTO;
import com.pwi.services.store.product.StoreProductService;
import com.pwi.services.store.product.dto.StoreProductDTO;
import com.pwi.services.store.product.dto.StoreProductOutDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;

@Path("/Stores")
public class RestStoreService 
{
	
	 @POST
	 @Produces(MediaType.TEXT_XML)
	 @Path("/getStore") 
	 public String getStore ()
	 {
		 
		 	ServiceExecutor executor= BasePageHandler.getServiceExecutor();
			ServiceBase base = new StoreService();
			Object object = executor.callService(base, "FetchStore", new StoreDTO());
			
			if(object instanceof StoreOutDTO )
			{
				return new RestStoreOutDTO().dissambletoSILXML((StoreOutDTO)object);
			}
			return "";
			
	 }
	 
	 @POST
	 @Produces(MediaType.TEXT_XML)
	 @Path("/addStore") 
	 public String addStore (@QueryParam("branchID") String branchID,
				@QueryParam("storeName") String storeName, 
				@QueryParam("city") String city,
				@QueryParam("country") String country,
				@QueryParam("postalCode") String postalCode,
				@QueryParam("street") String street)
	 {
		 
		 StoreDTO dto = new StoreDTO();
		 dto.getAddress().setCity(city);
		 dto.getAddress().setCountry(country);
		 dto.getAddress().setPostalCode(postalCode);
		 dto.getAddress().setStreet(street);
		 dto.setStoreName(storeName);
		 dto.setBranchID(Long.valueOf(branchID));
		 ServiceExecutor executor= BasePageHandler.getServiceExecutor();
			ServiceBase base = new StoreService();
			Object object = executor.callService(base, "SaveStore", dto);
			
			if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
			{
				return "<success>true</success>";
			}

			return "<success>false</success>";

			
			
	 }
	 
	 @POST
	 @Produces(MediaType.TEXT_XML)
	 @Path("/updateStore") 
	 public String updateStore (@QueryParam("branchID") String branchID,
				@QueryParam("storeName") String storeName, 
				@QueryParam("city") String city,
				@QueryParam("country") String country,
				@QueryParam("postalCode") String postalCode,
				@QueryParam("street") String street)
	 {
		 
		 StoreDTO dto = new StoreDTO();
		 dto.getAddress().setCity(city);
		 dto.getAddress().setCountry(country);
		 dto.getAddress().setPostalCode(postalCode);
		 dto.getAddress().setStreet(street);
		 dto.setStoreName(storeName);
		 dto.setBranchID(Long.valueOf(branchID));
		 ServiceExecutor executor= BasePageHandler.getServiceExecutor();
		 ServiceBase base = new StoreService();
		 Object object = executor.callService(base, "UpdateStore", dto);
			
		 if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		 {
			return "<success>true</success>";
		 }

		 return "<success>false</success>";

			
			
	 }
	 @POST
	 @Produces(MediaType.TEXT_XML)
	 @Path("/deleteStore") 
	 public String deleteStore(@QueryParam("storeID") String storeID) 
	 {
		 	
		 	StoreDTO dto = new StoreDTO();
		 	dto .setStoreID(Long.valueOf(storeID));
			ServiceExecutor executor= BasePageHandler.getServiceExecutor();
			ServiceBase base = new StoreService();
			Object object = executor.callService(base, "DeleteStore", dto);
			
			if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
			{
				return "<success>true</success>";
			}

			 return "<success>false</success>";
	}
	 
	 @POST
	 @Produces(MediaType.TEXT_XML)
	 @Path("/getStoreQuantity") 
	 public String getStoreQuantity(@QueryParam("storeID") String storeID,@QueryParam("productID") String productID) 
	 {
		 
		 	storeID = storeID == null ?  "0" : storeID;
		 	productID = productID == null ?  "0" : productID;
		 	StoreProductDTO dto = new StoreProductDTO();
			dto .setStoreID(Long.valueOf(storeID));
			dto .setProductID(Long.valueOf(productID));
			
			ServiceExecutor executor= BasePageHandler.getServiceExecutor();
			ServiceBase base = new StoreProductService();
			Object object = executor.callService(base, "WebServiceStoreProduct", dto);
			
			if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
			{
				return new RestStoreQuantityDTO( ).dissambletoSILXML((StoreProductOutDTO)object);
			}

			return "<success>false</success>";
		}
	 
	 
	 @POST
	 @Produces(MediaType.TEXT_XML)
	 @Path("/updateStoreQuantity") 
	 public String updateStoreItemQuantity(
			 @QueryParam("storeID") String storeID,
			 @QueryParam("productID") String productID,
			 @QueryParam("quantity") String quantity)
	 {
		 
		storeID = storeID == null ?  "0" : storeID;
		productID = productID == null ?  "0" : productID;
		quantity = quantity == null ?  "0" : quantity;
		StoreProductDTO dto = new StoreProductDTO();
		dto .setStoreID(Long.valueOf(storeID));
		dto .setProductID(Long.valueOf(productID));
		dto.setQuantity(Integer.valueOf(quantity));
			
			
		 
		 
		ServiceExecutor executor= BasePageHandler.getServiceExecutor();
		ServiceBase base = new StoreProductService();
		Object object = executor.callService(base, "updateStoreProductQuantity", dto);
			
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return "<success>true</success>";
		}

		return "<success>false</success>";
			

	}
	 
	 
	 /*public List<JaxBranchOutDTO> getBranchStoreQuantity( @QueryParam("branchID") String branchID,
			 @QueryParam("branchName") String branchName) 
		{
		 branchID = branchID == null ?  "0" : branchID;
		 branchName = branchName == null ?  "0" : branchName;
		 
			BranchDTO dto = new BranchDTO();
			dto.setBranchName(branchName);
			dto.setBranchID(Long.valueOf(branchID));
			
			
			List<JaxBranchOutDTO> outDTO = new ArrayList<JaxBranchOutDTO>();
			ServiceExecutor executor= BasePageHandler.getServiceExecutor();
			ServiceBase base = new BranchService();
			Object object = executor.callService(base, "webServiceBranch", dto);
			
			
			if(object instanceof BranchStoreProductOutDTO )
			{
				for(StoreProductQuantitySize branch : ((BranchStoreProductOutDTO)object).getQuantitySize())
				{
					JaxBranchOutDTO dto = new JaxBranchOutDTO();
					dto.setBranchName(branch.getBranchName());
					dto.setStoreName(branch.getStoreName());
					dto.setQuantity(branch.getQuantity());
					dto.setSize(branch.getSize());
					
					outDTO.add(dto);
				}
			}
			
			return outDTO;
		}*/


}
