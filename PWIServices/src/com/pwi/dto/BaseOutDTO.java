package com.pwi.dto;

import com.pwi.constants.FrameworkReasonCodes;

public class BaseOutDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8006470381020906006L;

	public BaseOutDTO() {
		setErrorCode(FrameworkReasonCodes.EXECUTION_ERROR);

	}
}
