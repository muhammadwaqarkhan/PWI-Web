package com.pwi.services.product.validate;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dao.product.ProductDAO;
import com.pwi.domain.product.Product;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.product.dto.ProductDTO;

public abstract class ProductValidator extends ServiceBase
{
	
	
	public boolean validate(ProductDTO dto)
	{
		
		Product product = ProductDAO.getInstance(getSession()).readBySizeNameAndType(dto.getSize(),dto.getProductName(), dto.getProductType());
		
		if(product ==null)
			return true;
		dto.setErrorCode(FrameworkReasonCodes.VALIDATION_ERROR);
		dto.setErrorString("product already exist with given information");
		return false;
	}

}
