package com.pwi.dao.store;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.store.Store;

public class StoreDAO extends BaseDAO implements IStoreDAO{

	public static StoreDAO getInstance (Session session)
	{
		StoreDAO singleton= new StoreDAO();
		singleton.init(session);
		return singleton;
	}
	
	
	/***
	 * This method called to get  Store entity
	 * 
	 * @param Long: store ID
	 *        
	 * @return Store
	 */
	@Override
	public Store findByPrimaryKey(Long storeID) {
	String hql = "from Store where storeID=:storeID";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("storeID", storeID);
		return (Store)query.uniqueResult();

	}

	/***
	 * This method called to get all Store entity
	 * 
	 * @param none
	 *        
	 * @return List<Store>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Store> readStores() 
	{
		String hql = "from Store ";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

}
