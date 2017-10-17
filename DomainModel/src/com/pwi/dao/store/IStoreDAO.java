	package com.pwi.dao.store;

import java.util.List;

import com.pwi.domain.store.Store;



public interface IStoreDAO 
{
	Store findByPrimaryKey(Long storeID);	
	List<Store> readStores();
}
