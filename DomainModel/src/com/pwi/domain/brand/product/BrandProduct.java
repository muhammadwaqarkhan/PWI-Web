package com.pwi.domain.brand.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pwi.domain.brand.Brand;
import com.pwi.domain.product.Product;
/**
 * Holds all data which is relevant to StoreProduct 
 *  @author Waqar Contact 03346100977
 */
@Entity()
@Table(name = "brandproduct", schema = "pwi")
public class BrandProduct {


	
	@Column(name = "brandproductID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long brandProductID;
	
	
	@Column(name = "productID", insertable = false, updatable = false, nullable = false)
	private Long productID;
	
	@Column(name = "brandID", insertable = false, updatable = false, nullable = false)
	private Long brandID;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "productID", referencedColumnName = "productID")
	private Product				product					= null;


	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "brandID", referencedColumnName = "brandID")
	private Brand				brand					= null;
	
	
	
	public void init(Brand brand,Product product)
	{
		this.brand=brand;
		this.product=product;
	}




	public Long getBrandProductID() {
		return brandProductID;
	}




	public void setBrandProductID(Long brandProductID) {
		this.brandProductID = brandProductID;
	}




	public Long getProductID() {
		return productID;
	}




	public void setProductID(Long productID) {
		this.productID = productID;
	}




	




	public Product getProduct() {
		return product;
	}




	public void setProduct(Product product) {
		this.product = product;
	}




	public Brand getBrand() {
		return brand;
	}




	public void setBrand(Brand brand) {
		this.brand = brand;
	}




	public Long getBrandID() {
		return brandID;
	}




	public void setBrandID(Long brandID) {
		this.brandID = brandID;
	}





	
	

	
}
