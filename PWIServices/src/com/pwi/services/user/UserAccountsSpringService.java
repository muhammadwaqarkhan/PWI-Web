package com.pwi.services.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.pwi.dao.user.UserAccountsDAO;
import com.pwi.domain.user.UserAccounts;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.SpringServiceBase;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.user.dto.UserAccountsInDTO;
import com.pwi.services.user.dto.UserAccountsOutDTO;

import org.springframework.jdbc.core.RowMapper;
public class UserAccountsSpringService extends SpringServiceBase{

	
	@ServiceMethod(name = "VarifedUser")
	public IResponseHandler varifedUser(UserAccountsInDTO o) 
	{
			UserAccountsOutDTO outDTO = new UserAccountsOutDTO();
			UserAccountsInDTO dto = (UserAccountsInDTO) o;
			String userName = dto.getUsername( );
			String password = dto.getPassword( );
			
			UserAccounts product = jdbcTemplate.queryForObject("SELECT * FROM useraccounts WHERE userid = ? ", new Object[]{new Integer(1)},
				       new RowMapper<UserAccounts>() {
				          @Override
				          public UserAccounts mapRow(ResultSet rs, int row)
				          throws SQLException {
				        	  UserAccounts user = new UserAccounts();
				        	  user.setUserId(rs.getLong("userid"));
				        	  
				            return user;
				         }

				
						
				      } ); 
			
			
			
		
		return outDTO;
	}

	@Override
	public IResponseHandler execute(IRequestHandler o) 
	{
		
		if (o instanceof UserAccountsInDTO)
		{
			UserAccountsOutDTO outDTO = new UserAccountsOutDTO();
			UserAccountsInDTO dto = (UserAccountsInDTO) o;
			String userName = dto.getUsername( );
			String password = dto.getPassword( );

			UserAccounts product = jdbcTemplate.queryForObject("SELECT * FROM PRODUCTS WHERE ID = ? ", new Object[]{new Integer(1)},
				       new RowMapper<UserAccounts>() {
				          @Override
				          public UserAccounts mapRow(ResultSet rs, int row)
				          throws SQLException {
				        	  UserAccounts user = new UserAccounts();
				        	  user.setUserId(rs.getLong("userid"));
				            
				            return user;
				         }

				
						
				      } ); 
	
		              
			 
			
		
			if(dto.isIsthroughuser())
			{
			
				return outDTO;
			}
			
		}
		return null;
	}

}
