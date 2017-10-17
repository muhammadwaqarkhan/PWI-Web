package com.pwi.rest.store.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.domain.product.store.StoreProduct;
import com.pwi.dto.BaseDTO;
import com.pwi.services.branch.dto.BranchStoreProductOutDTO;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RestBranchStoreProductDTO extends BaseDTO 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("RestStoreDTO")
	List<StoreProductQuantitySize> quantitySize = new ArrayList<RestBranchStoreProductDTO.StoreProductQuantitySize>();
	
	

	public List<StoreProductQuantitySize> getQuantitySize() {
		return quantitySize;
	}


	public StoreProductQuantitySize newStoreProductQuantitySize()
	{
		return new StoreProductQuantitySize();
	}

	public void setQuantitySize(List<StoreProductQuantitySize> quantitySize) {
		this.quantitySize = quantitySize;
	}
	
	public void assemble(BranchStoreProductOutDTO outDTO)
	{
		
		
	}
	public class StoreProductQuantitySize
	{
		@XStreamAlias("branchName")
		private String branchName;
		
		@XStreamAlias("storeName")
		private String storeName;
		
		@XStreamAlias("size")
		private Integer size;
		
		@XStreamAlias("quantity")
		private Integer quantity;
		
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		
		public StoreProductQuantitySize assmeble(StoreProduct sp)
		{
			
			StoreProductQuantitySize dto = new StoreProductQuantitySize();
			dto .setBranchName(sp.getStore().getBranch().getBranchName());
			dto .setStoreName(sp.getStore().getName());
			dto .setSize(sp.getProduct().getSize());
			dto .setQuantity(sp.getQuantity());
			
			return dto;
		}
	}




	
}
