package com.pwi.factory.interfaces;

import com.pwi.domain.address.Address;
import com.pwi.domain.branch.Branch;
import com.pwi.domain.brand.Brand;
import com.pwi.domain.brand.product.BrandProduct;
import com.pwi.domain.company.Company;
import com.pwi.domain.product.Product;
import com.pwi.domain.product.store.StoreProduct;
import com.pwi.domain.store.Store;

public interface IDomainFactory 
{
	Address newAddress();
	
	Branch newBranch(Address address);
	
	Brand newBrand();
	
	Product newProduct();
	
	Store newStore(Address address, Branch branch);
	
	StoreProduct newStoreProduct(Store store, Product product);
	
	BrandProduct newBrandProduct(Brand brand, Product product);
	
	Company newCompany();
	
	

}
