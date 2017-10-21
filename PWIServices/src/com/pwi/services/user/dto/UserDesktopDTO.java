package com.pwi.services.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.domain.branch.Branch;
import com.pwi.domain.product.store.StoreProduct;
import com.pwi.domain.store.Store;

public class UserDesktopDTO {

	private String branchName;

	private List<BranchInformation> branchInformation = new ArrayList<BranchInformation>();

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<BranchInformation> getBranchInformation() {
		return branchInformation;
	}

	public void setBranchInformation(List<BranchInformation> branchInformation) {
		this.branchInformation = branchInformation;
	}

	public UserDesktopDTO newBranchInformation(Branch branch) {

		this.branchName = branch.getBranchName();
		for (Store store : branch.getStores()) {
			for (StoreProduct sp : store.getStoreProduct())
				getBranchInformation().add(new BranchInformation().assemble(store, sp));
		}

		return this;
	}

	public class BranchInformation {

		private String storeName;
		private String productName;
		private String productType;
		private Integer size;
		private boolean inStock;
		private Integer inTransit;
		private Integer MOQ;
		private Integer QPB;
		private Integer recordPoint;
		private Integer availableQuantity;

		public String getStoreName() {
			return storeName;
		}

		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}

		public String getProductType() {
			return productType;
		}

		public void setProductType(String productType) {
			this.productType = productType;
		}

		public Integer getSize() {
			return size;
		}

		public void setSize(Integer size) {
			this.size = size;
		}

		public boolean getInStock() {
			return inStock;
		}

		public void setInStock(boolean inStock) {
			this.inStock = inStock;
		}

		public Integer getInTransit() {
			return inTransit;
		}

		public void setInTransit(Integer inTransit) {
			this.inTransit = inTransit;
		}

		public Integer getMOQ() {
			return MOQ;
		}

		public void setMOQ(Integer mOQ) {
			MOQ = mOQ;
		}

		public Integer getQPB() {
			return QPB;
		}

		public void setQPB(Integer qPB) {
			QPB = qPB;
		}

		public Integer getRecordPoint() {
			return recordPoint;
		}

		public void setRecordPoint(Integer recordPoint) {
			this.recordPoint = recordPoint;
		}

		public Integer getAvailableQuantity() {
			return availableQuantity;
		}

		public void setAvailableQuantity(Integer availableQuantity) {
			this.availableQuantity = availableQuantity;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public BranchInformation assemble(Store store, StoreProduct sp) {

			this.storeName = store.getName();
			this.availableQuantity = 0;
			this.inStock = sp.getInstock();
			this.inTransit = sp.getInTransit();
			this.recordPoint = sp.getReorderPoint();
			this.MOQ = sp.getProduct().getMOQ();
			this.QPB = sp.getProduct().getQPB();
			this.productName = sp.getProduct().getProductName();
			return this;

		}
	}
}
