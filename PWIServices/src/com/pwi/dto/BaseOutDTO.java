package com.pwi.dto;

import com.pwi.constants.FrameworkReasonCodes;

public class BaseOutDTO extends BaseDTO{

	public BaseOutDTO()
	{
		setErrorCode(FrameworkReasonCodes.EXECUTION_ERROR);
		
	}
}
