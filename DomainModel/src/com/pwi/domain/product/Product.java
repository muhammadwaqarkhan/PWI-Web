package com.pwi.domain.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.pwi.domain.brand.product.BrandProduct;
import com.pwi.domain.product.store.StoreProduct;

/**
 * Holds all data which is relevant to Product
 * 
 * @author Waqar Contact 03346100977
 */

@NamedQueries({
		@NamedQuery(name = Product.Queries.READ_BY_PRIMARY_KEY, query = "from com.pwi.domain.product.Product where productID=:productID"),//
		@NamedQuery(name = Product.Queries.READ_BY_ALL_PRODUCTS, query = "from com.pwi.domain.product.Product"),//
		@NamedQuery(name = Product.Queries.READ_BY_SIZE_NAME_TYPE, query = "from com.pwi.domain.product.Product where  productName=:productName and size=:size and productType=:productType"),//
		@NamedQuery(name = Product.Queries.READ_BY_NAME, query = "from com.pwi.domain.product.Product where  productName=:productName") })
@Entity()
@Table(name = "product", schema = "pwi")
public class Product {

	public static class Queries {
		public static final String READ_BY_PRIMARY_KEY = "Product.ReadPrimaryKey";
		public static final String READ_BY_ALL_PRODUCTS = "Product.ReadProducts";
		public static final String READ_BY_SIZE_NAME_TYPE = "Product.readBySizeNameAndType";
		public static final String READ_BY_NAME = "Product.readByName";

	}

	private static final int PRODUCT_CODE_LENGTH = 45;
	private static final int PRODUCT_TYPE_LENGTH = 45;

	@Column(name = "productID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long productID;

	@Size(max = PRODUCT_CODE_LENGTH, message = "productName")
	@Column(name = "productName", length = PRODUCT_CODE_LENGTH)
	private String productName;

	@Size(max = PRODUCT_TYPE_LENGTH, message = "productType")
	@Column(name = "productType", length = PRODUCT_TYPE_LENGTH)
	private String productType;

	@Column(name = "MOQ", updatable = true)
	private Integer MOQ;

	@Column(name = "Size", updatable = true)
	private Integer size;

	@Column(name = "QPB", updatable = true)
	private Integer QPB;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StoreProduct> storeProduct = null;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BrandProduct> brandProduct = null;

	/**
	 * Initializer for use by application code when constructing a new object
	 * for insertion into persistent store.
	 * 
	 * @param Address
	 *            The address of branch
	 */
	public void init() {
		// this.address=address;
		// this.status= PWICodes.INDICATOR_TRUE;
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
	 *            set Key of productID
	 * @see #set productID
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	/**
	 * Returns product Code
	 * 
	 * @return key
	 */

	public String getProductName() {
		return productName;
	}

	/**
	 * @param code
	 *            set Key of code
	 * @see #set code
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Returns product Type
	 * 
	 * @return productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            set Key of productType
	 * @see #set productType
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * Returns MOQ
	 * 
	 * @return is MOQ
	 */
	public Integer getMOQ() {
		return MOQ;
	}

	/**
	 * @param mOQ
	 *            set Key of mOQ
	 * @see #set mOQ
	 */
	public void setMOQ(Integer mOQ) {
		MOQ = mOQ;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getQPB() {
		return QPB;
	}

	public void setQPB(Integer qPB) {
		QPB = qPB;
	}

	public List<StoreProduct> getStoreProduct() {
		return storeProduct;
	}

	public List<BrandProduct> getBrandProduct() {
		return brandProduct;
	}

	public void setBrandProduct(List<BrandProduct> brandProduct) {
		this.brandProduct = brandProduct;
	}

	public void setStoreProduct(List<StoreProduct> storeProduct) {
		this.storeProduct = storeProduct;
	}

}
