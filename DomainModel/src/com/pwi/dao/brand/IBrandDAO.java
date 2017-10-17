package com.pwi.dao.brand;

import java.util.List;

import com.pwi.domain.brand.Brand;
/**
 * 
 * create IBrandDAO interface 
 * 
 * @author Waqar Contact 03346100977
 */
public interface IBrandDAO 
{
	List<Brand> readBrands();
	Brand findByPrimaryKey(Long key);
}
