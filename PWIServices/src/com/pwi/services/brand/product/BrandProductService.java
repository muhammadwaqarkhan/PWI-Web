package com.pwi.services.brand.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pwi.dao.brand.BrandDAO;
import com.pwi.dao.brand.product.BrandProductDAO;
import com.pwi.dao.product.ProductDAO;
import com.pwi.domain.brand.Brand;
import com.pwi.domain.brand.product.BrandProduct;
import com.pwi.domain.product.Product;
import com.pwi.factory.DomainFactory;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.brand.BrandService;
import com.pwi.services.brand.dto.BrandOutDTO;
import com.pwi.services.brand.product.dto.BrandProductDTO;
import com.pwi.services.brand.product.dto.BrandProductOutDTO;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.product.ProductService;
import com.pwi.services.product.dto.ProductOutDTO;
@Service
public class BrandProductService extends ServiceBase
{
	
	/***
	 * This method called retrieved information of brand product 
	 * 
	 * @param none
	 *            
	 * @return BrandProductOutDTO which contain which brand associate with which product
	 */
	@ServiceMethod(name = "FetchBrandProduct")
	public IResponseHandler fetchBrandProduct()
	{	
		BrandProductOutDTO outDTO = new BrandProductOutDTO();
		
		List<BrandProduct> sps= BrandProductDAO.getInstance(getSession()).readBrandProduct();
		
		for(BrandProduct sp :sps)
		{
			outDTO.getBrandProducts().add(new BrandProductDTO().assemble(sp));
		}
		
		BrandService brandService = (BrandService)newInstance(new BrandService());
		outDTO.setBrand((BrandOutDTO)brandService.fetchBrand ());
		
		ProductService productService = (ProductService)newInstance(new ProductService());
		outDTO.setProducts((ProductOutDTO)productService.fetchProduct());
		
		return outDTO;
	}
	
	/***
	 * This method called to save brand product
	 * 
	 * @param BrandProductDTO which contain brand information and product information
	 *            
	 * @return IResponseHandler which contain request status
	 */
	@ServiceMethod(name = "SaveBrandProduct")
	public IResponseHandler saveBrandProduct(BrandProductDTO dto)
	{	
		Brand brand = BrandDAO.getInstance(getSession()).findByPrimaryKey(dto.getBrandID());
		Product product = ProductDAO.getInstance(getSession()).findByPrimaryKey(dto.getProductID());
		BrandProduct bp = DomainFactory.getInstance().newBrandProduct(brand, product);
		
		getSession().persist(bp);
		
		return dto;
	}
	
	
	
}
