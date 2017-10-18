package com.pwi.dao.user;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.pwi.dao.base.BaseDAO;
import com.pwi.domain.user.UserAccounts;
import com.pwi.spring.SpringApplicationContext;
/**
 * 
 * create User accoutn dao to read record from user account table
 * 
 * @author Waqar Contact 03346100977
 */
@Repository()
@Scope(value = "prototype")
public class UserAccountsDAO extends BaseDAO  implements IUserAccountsDAO
{
		
	public static UserAccountsDAO getInstance (Session session)
	{
		UserAccountsDAO dao= (UserAccountsDAO)SpringApplicationContext.getApplicationContext().getBean("userDAO");
		dao.init(session);
		return dao;
	}
	

	/***
	 * This method called to validate user
	 * 
	 * @param Long: store ID
	 *        
	 * @return UserAccounts
	 */
	@Override
	public UserAccounts readUser(String userName, String password) 
	{
		
		Query query = getSession().getNamedQuery(UserAccounts.Queries.READ_BY_USER_PASSWORD);  
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		return (UserAccounts) query.uniqueResult();
	}



}
