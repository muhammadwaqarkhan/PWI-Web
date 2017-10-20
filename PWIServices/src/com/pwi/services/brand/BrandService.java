package com.pwi.services.brand;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pwi.dao.brand.BrandDAO;
import com.pwi.domain.brand.Brand;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.brand.dto.BrandDTO;
import com.pwi.services.brand.dto.BrandOutDTO;
import com.pwi.services.framework.annotations.ServiceMethod;
@Service
public class BrandService extends ServiceBase 
{
	
	/***
	 * This method called to fetch 
	 * 
	 * @param none
	 *            
	 * @return BrandOutDTO which contain brand information
	 */
	
	@ServiceMethod(name = "FetchBrand")
	public IResponseHandler fetchBrand()
	{
		BrandOutDTO outDTO = new BrandOutDTO ();
		
		List<Brand> brands =	BrandDAO.getInstance(getSession()).readBrands();
		
		for(Brand brand : brands)
		{
			
			outDTO.getBrands().add(new BrandDTO().assemble(brand));
		}	
		
		return outDTO;
	}
}
