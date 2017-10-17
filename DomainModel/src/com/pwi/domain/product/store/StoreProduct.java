package com.pwi.domain.product.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pwi.constants.PWICodes;
import com.pwi.domain.product.Product;
import com.pwi.domain.store.Store;
/**
 * Holds all data which is relevant to StoreProduct 
 *  @author Waqar Contact 03346100977
 */
@Entity()
@Table(name = "StoreProduct", schema = "pwi")
public class StoreProduct {

	private static final int	INSTOCK_LENGTH					= 1;
	
	@Column(name = "STOREPRODUCTID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long storeProductID;
	
	
	@Column(name = "productID", insertable = false, updatable = false, nullable = false)
	private Long productID;
	
	@Column(name = "storeID", insertable = false, updatable = false, nullable = false)
	private Long storeID;
	
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "productID", referencedColumnName = "productID")
	private Product				product					= null;
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "storeID", referencedColumnName = "storeID")
	private Store				store					= null;
	
	
	
	@Column(name = "instock", updatable = true,length = INSTOCK_LENGTH)
	private Integer instock;
	
	
	@Column(name = "quantity",updatable = true)
	private Integer quantity;
	
	@Column(name = "InTransit", updatable = true)
	private Integer InTransit;
	
	
	@Column(name = "reorderPoint",  updatable = true)
	private Integer reorderPoint;

	
	
	public void init(Store store,Product product)
	{
		this.store=store;
		this.product=product;
	}

	
	
	/**
	 * Returns the primary key of the object
	 * 
	 * @return key
	 */
	public Long getStoreProductID() {
		return storeProductID;
	}

	/**
	 * @param storeProductID
	 *            set Key
	 * @see #set storeProductID
	 */
	public void setStoreProductID(Long storeProductID) {
		this.storeProductID = storeProductID;
	}

	/**
	 * Returns productID
	 * 
	 * @return key
	 */
	public Long getProductID() {
		return productID;
	}
	/**
	 * @param productID
	 *            set Key
	 * @see #set productID
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	/**
	 * Returns StoreID
	 * 
	 * @return key
	 */
	public Long getStoreID() {
		return storeID;
	}
	/**
	 * @param storeID
	 *            set Key
	 * @see #set storeID
	 */
	public void setStoreID(Long storeID) {
		this.storeID = storeID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public boolean getInstock() {
		if( this.instock != null && instock.intValue() == PWICodes.INDICATOR_TRUE)
			return true;
		else
			return false;
		
	}

	public void setInstock(Boolean instock) {
		if(instock)
			this.instock = PWICodes.INDICATOR_TRUE;
		else
			this.instock = PWICodes.INDICATOR_FALSE;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getInTransit() {
		return InTransit;
	}

	public void setInTransit(Integer inTransit) {
		InTransit = inTransit;
	}

	public Integer getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(Integer reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	

	
}
