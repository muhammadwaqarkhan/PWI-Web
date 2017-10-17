	package com.pwi.dao.brand.product;

import java.util.List;

import com.pwi.domain.brand.product.BrandProduct;



public interface IBrandProductDAO 
{
	
	BrandProduct findByPrimaryKey(Long brandProductID);
	List<BrandProduct> readBrandProduct();
	List<BrandProduct> readByBrandID(Long BrandID);
	List<BrandProduct> readByProductID(Long productID);
	List<BrandProduct> readByBrandIDProductID(Long productID,Long brandID);
}
