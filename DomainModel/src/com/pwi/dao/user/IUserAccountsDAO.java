package com.pwi.dao.user;

import com.pwi.domain.user.UserAccounts;
/**
 * 
 * create IUserAccountsDAO interface 
 * 
 * @author Waqar Contact 03346100977
 */
public interface IUserAccountsDAO {
	 UserAccounts readUser(String userName, String password);
}
