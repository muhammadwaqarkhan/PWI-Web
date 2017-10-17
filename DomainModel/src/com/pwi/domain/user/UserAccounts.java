package com.pwi.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pwi.domain.interfaces.IDomain;
/**
 * Holds all data which is relevant to UserAccounts 
 *  @author Waqar Contact 03346100977
 */
@Entity()
@Table(name = "UserAccounts", schema = "pwi")
public class UserAccounts implements IDomain{

	
	
	private static final int	USERNAME_LENGTH					= 100;
	private static final int	PASSWORD_LENGTH					= 45;
	private static final int	FIRST_NAME_LENGTH				= 45;
	private static final int	LAST_NAME_LENGTH				= 45;
	private static final int	ISLOCKED_LENGTH					= 1;

	@Column(name = "USERID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long userId;
	
	

	@NotNull(message = "USERNAME")
	@Size(max = USERNAME_LENGTH, message = "USERNAME")
	@Column(name = "USERNAME", nullable = false, length = USERNAME_LENGTH)
	private String userName;
	
	
	

	@Size(max = PASSWORD_LENGTH, message = "PASSWORD")
	@Column(name = "PASSWORD", length = PASSWORD_LENGTH)
	private String password;
	
	
	
	
	
	public static class Queries
	{
		public static final String	READ_BY_USER_PASSWORD	= "UserAccount.ReadByUserNamePass";
		
	}

	/**
	 * Returns userId
	 * 
	 * @return key
	 */
	@Override
	public Long getKey() {
		return getUserId();
	}


	
	/**
	 * Returns userName
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName
	 *            set Key of userName
	 * @see #set userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Returns password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            set Key of password
	 * @see #set password
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * Returns userId
	 * 
	 * @return key
	 */
	public Long getUserId() {
		return userId;
	}



	/**
	 * @param userId
	 *            set Key of userId
	 * @see #set userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	

	

}
