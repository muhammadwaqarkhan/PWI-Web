package com.pwi.dao.product;

import java.util.List;

import com.pwi.domain.product.Product;

public interface IProductDAO {

	Product findByPrimaryKey(Long productID);
	List<Product> readProducts();
	List<Product> readByName(String Name);
	Product readBySizeNameAndType(Integer size, String Name, String type);
}
