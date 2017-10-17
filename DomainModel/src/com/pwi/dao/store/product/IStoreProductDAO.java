	package com.pwi.dao.store.product;

import java.util.List;

import com.pwi.domain.product.store.StoreProduct;



public interface IStoreProductDAO {
	StoreProduct findByPrimaryKey(Long storeProductID);
	
	List<StoreProduct> readStoresProduct();
	
	List<StoreProduct> readByStoreID(Long storeID);
	List<StoreProduct> readByProductID(Long productID);
	List<StoreProduct> readByStoreIDProductID(Long productID,Long storeID);
}
