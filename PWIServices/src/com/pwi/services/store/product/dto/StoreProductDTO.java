package com.pwi.services.store.product.dto;

import org.springframework.stereotype.Component;

import com.pwi.domain.product.store.StoreProduct;
import com.pwi.dto.BaseDTO;
import com.pwi.interfaces.IRequestHandler;

@Component
public class StoreProductDTO extends BaseDTO implements IRequestHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long storeProductID;
	private Long productID;
	private Long storeID;
	private Integer quantity;
	private Integer reorderPoint;
	private Integer inTransit;
	private boolean instock;

	private String storeName;
	private String productName;

	public Long getStoreProductID() {
		return storeProductID;
	}

	public void setStoreProductID(Long storeProductID) {
		this.storeProductID = storeProductID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
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

	public Integer getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(Integer reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public Integer getInTransit() {
		return inTransit;
	}

	public void setInTransit(Integer inTransit) {
		this.inTransit = inTransit;
	}

	public boolean isInstock() {
		return instock;
	}

	public void setInstock(boolean instock) {
		this.instock = instock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProductName() {
		return productName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public StoreProductDTO assemble(StoreProduct sp) {
		this.instock = sp.getInstock();
		this.inTransit = sp.getInTransit();
		this.productID = sp.getProductID();
		this.quantity = sp.getQuantity();
		this.reorderPoint = sp.getReorderPoint();
		this.storeID = sp.getStoreID();
		this.storeProductID = sp.getStoreProductID();
		this.storeName = sp.getStore().getName();
		this.productName = sp.getProduct().getProductName();
		return this;

	}
}
