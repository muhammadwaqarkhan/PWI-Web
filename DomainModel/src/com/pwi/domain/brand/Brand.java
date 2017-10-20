package com.pwi.domain.brand;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.pwi.domain.branch.Branch;
import com.pwi.domain.brand.product.BrandProduct;
import com.pwi.domain.company.Company;
/**
 * Holds all data which is relevant to Company 
 *  @author Waqar Contact 03346100977
 */

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = Brand.Queries.READ_BY_ALL_BRANDS,  
	        query = "from com.pwi.domain.brand.Brand"  
	        ) ,//
	        
	        @NamedQuery(  
	    	        name = Brand.Queries.READ_BY_PRIMARY_KEY,  
	    	        query = "from com.pwi.domain.brand.Brand where brandID=:brandID"  
	    	        ) 
	    }  
)


@Entity()
@Table(name = "Brands", schema = "pwi")
public class Brand {

	
	private static final int	BRAND_NAME_LENGTH				= 45;
	
	
	public static class Queries
	{
		public static final String	READ_BY_ALL_BRANDS= "Brand.ReadBrand";
		public static final String	READ_BY_PRIMARY_KEY	= "Brand.ReadPrimaryKey";
		
		
	}
	
	
	@Column(name = "brandID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long brandID;
	
	
	
	@Size(max = BRAND_NAME_LENGTH, message = "brandName")
	@Column(name = "BRANDNAME", length = BRAND_NAME_LENGTH)
	private String brandName;
	

	@Column(name = "COMPANYID", insertable = false, updatable = false, nullable = false)
	private Long companyID;

	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BrandProduct> brandProduct				= null;
	
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "companyID", referencedColumnName = "companyID")
	private Company				company					= null;
	
	/**
	 * Initializer for use by application code when constructing a new object for insertion into persistent store. 
	 * 
	 * @param Company
	 *            The Company of brand
	 */
	public void init()
	{
		
		
	}
	
	/**
	 * Returns the primary key of the object
	 * 
	 * @return key
	 */
	public Long getBrandID() {
		return brandID;
	}
	/**
	 * @param brandID
	 *            set brandID
	 * @see #set brandID
	 */
	public void setBrandID(Long brandID) {
		this.brandID = brandID;
	}

	/**
	 * Returns the BrandName
	 * 
	 * @return BrandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName
	 *            set brandName
	 * @see #set brandName
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<BrandProduct> getBrandProduct() {
		return brandProduct;
	}

	public void setBrandProduct(List<BrandProduct> brandProduct) {
		this.brandProduct = brandProduct;
	}

	public Long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}



	

	

	
}
