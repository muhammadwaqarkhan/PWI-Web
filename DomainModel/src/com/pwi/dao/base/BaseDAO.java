package com.pwi.dao.base;

import org.hibernate.Session;

/**
 * 
 * create abstract class each DAO must extend to BaseDAO to get session
 * 
 * @author Waqar Contact 03346100977
 */
public abstract class BaseDAO {

	private Session session;

	protected void init(Session session) {
		this.session = session;

	}

	/***
	 * This method called get hibernate session
	 * 
	 * @param none
	 * 
	 * @return session
	 */

	protected Session getSession() {
		return this.session;
	}

}
