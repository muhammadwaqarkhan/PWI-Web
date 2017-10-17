package com.pwi.rest.store.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.services.store.product.dto.StoreProductDTO;
import com.pwi.services.store.product.dto.StoreProductOutDTO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.StaxDriver;

@XStreamAlias("RestStoreOutDTO")

public class RestStoreQuantityDTO 
{
	@XStreamAlias("RestStoreDTO")
	public List<RestStorQuantityeDTO> restStoreQuantity = new ArrayList<RestStorQuantityeDTO>(); 
	
	
	

	
	

	public List<RestStorQuantityeDTO> getRestStoreQuantity() {
		return restStoreQuantity;
	}

	public void setRestStoreQuantity(List<RestStorQuantityeDTO> restStoreQuantity) {
		this.restStoreQuantity = restStoreQuantity;
	}

	public String dissambletoSILXML (StoreProductOutDTO outDTO)
	{
		for(StoreProductDTO dto :outDTO.getStoreProducts())
			getRestStoreQuantity().add(new RestStorQuantityeDTO().assemble(dto));
		
		
		XStream xstream = new XStream (new StaxDriver ());
		xstream.processAnnotations (RestStoreQuantityDTO.class);
		String xml = xstream.toXML (this);

		return xml;
	}
	
	@XStreamAlias("RestQuantityStore")
	public class RestStorQuantityeDTO
	{
		@XStreamAlias("storeName")
		private String 			storeName;
		
		@XStreamAlias("storeID")
		private Long 			storeID;
		
		@XStreamAlias("productName")
		private String 			productName;
		
		@XStreamAlias("productID")
		private Long 			productID;
		
		@XStreamAlias("quantity")
		private Integer 			quantity;
	
		
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		public Long getStoreID() {
			return storeID;
		}
		public void setStoreID(Long storeID) {
			this.storeID = storeID;
		}
		
		
		
		
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public Long getProductID() {
			return productID;
		}
		public void setProductID(Long productID) {
			this.productID = productID;
		}
		public RestStorQuantityeDTO assemble (StoreProductDTO dto)
		{
			this.productID = dto.getProductID();
			this.storeID=dto.getStoreID();
			this.storeName=dto.getStoreName();
			this.productName=dto.getProductName();
			this.quantity=dto.getQuantity();
			return this;
			
		}
	}



	
}
