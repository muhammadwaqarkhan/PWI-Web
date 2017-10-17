package com.pwi.services.branch.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.domain.product.store.StoreProduct;
import com.pwi.dto.BaseDTO;

public class BranchStoreProductOutDTO extends BaseDTO 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<StoreProductQuantitySize> quantitySize = new ArrayList<BranchStoreProductOutDTO.StoreProductQuantitySize>();
	
	

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
	
	public class StoreProductQuantitySize
	{
		private String branchName;
		private String storeName;
		private Integer size;
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
