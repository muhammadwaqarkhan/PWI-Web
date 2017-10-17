package com.pwi.factory;

import com.pwi.domain.address.Address;
import com.pwi.domain.branch.Branch;
import com.pwi.domain.brand.Brand;
import com.pwi.domain.brand.product.BrandProduct;
import com.pwi.domain.company.Company;
import com.pwi.domain.product.Product;
import com.pwi.domain.product.store.StoreProduct;
import com.pwi.domain.store.Store;
import com.pwi.factory.interfaces.IDomainFactory;
/**
 *its a signalton class which is responsiable for create new domain object 
 *  @author Waqar Contact 03346100977
 */
public class DomainFactory implements IDomainFactory 
{
	private static final IDomainFactory	FACTORY	= new DomainFactory ();


	/**
	 * Returns an instance of the factory
	 * 
	 * @return
	 */
	public static IDomainFactory getInstance ()
	{
		return FACTORY;
	}

	private DomainFactory ()
	{
	}



	@Override
	public Branch newBranch(Address address) {

		Branch branch = new Branch();
		branch.init(address);
		
		return branch;
	}

	@Override
	public Brand newBrand() {
		Brand brand = new Brand();
		brand.init();
		
		return brand;
	}

	@Override
	public Product newProduct() 
	{
		Product product = new Product();
		return product;
	}

	@Override
	public Store newStore(Address address,Branch branch) {
		Store store = new Store();
		store.init(address, branch);
		return store;
	}

	@Override
	public StoreProduct newStoreProduct(Store store, Product product) {
		StoreProduct sp = new StoreProduct();
		sp.init(store, product);
		return sp;
	}

	@Override
	public Company newCompany() {
		Company company = new Company();
		return company;
	}

	@Override
	public Address newAddress() {
		Address address = new Address();
		
		return address;
	}

	@Override
	public BrandProduct newBrandProduct(Brand brand, Product product) {
		BrandProduct bp = new BrandProduct();
		bp.init(brand, product);
		return bp;
	}
	

}
