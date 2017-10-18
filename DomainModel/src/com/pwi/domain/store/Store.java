package com.pwi.domain.store;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.pwi.domain.address.Address;
import com.pwi.domain.branch.Branch;
import com.pwi.domain.company.Company;
import com.pwi.domain.product.store.StoreProduct;

/**
 * Holds all data which is relevant to Store 
 *  @author Waqar Contact 03346100977
 */

@NamedQueries(  
	    {  
	        @NamedQuery(  
	    	        name = Store.Queries.READ_BY_PRIMARY_KEY,  
	    	        query = "from Store where storeID=:storeID"  
	    	  ),//
	    	        
	    	@NamedQuery(  
	    	     name = Store.Queries.READ_BY_ALL_STORE,  
	    	      query = "from Store"  
	    	 )         
	    }  
)
@Entity()
@Table(name = "Store", schema = "pwi")
public class Store {

	
	
	public static class Queries
	{
		public static final String	READ_BY_PRIMARY_KEY	= "Store.ReadPrimaryKey";
		public static final String	READ_BY_ALL_STORE= "Store.ReadStores";
		
	}
	
	private static final int	NAME_LENGTH				= 45;
	private static final int	STATUS_LENGTH			= 45;
	
	
	
	@Column(name = "STOREID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long storeID;
	
	
	/**
	 * Fore name.
	 * 
	 * The user's first name.
	 */
	@Size(max = NAME_LENGTH, message = "Name")
	@Column(name = "Name", length = NAME_LENGTH)
	private String Name;
	
	
	
	
	@Column(name = "STATUS", length = STATUS_LENGTH)
	private Integer status;
	
	
	@Column(name = "addressID", insertable = false, updatable = false, nullable = false)
	private Long addressID;
	
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "addressID", referencedColumnName = "addressID")
	private Address				address					= null;


	@Column(name = "branchID", insertable = false, updatable = false, nullable = false)
	private Long branchID;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "branchID", referencedColumnName = "branchID")
	private Branch				branch				= null;
	
	
	@OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StoreProduct> storeProduct				= null;
	
	
	/**
	 * Initializer for use by application code when constructing a new object for insertion into persistent store. 
	 * 
	 * @param Address
	 *            The address of branch 
	 */
	public void init(Address address,Branch branch)
	{
		this.address=address;
		this.branch=branch;
		this.status= new Integer(1);
	}
	

	/**
	 * Returns productID
	 * 
	 * @return key
	 */
	public Long getStoreID() {
		return storeID;
	}

	/**
	 * @param storeID
	 *            set Key of storeID
	 * @see #set storeID
	 */
	public void setStoreID(Long storeID) {
		this.storeID = storeID;
	}


	/**
	 * Returns StoreName
	 * 
	 * @return Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            set Key of name
	 * @see #set name
	 */
	public void setName(String name) {
		Name = name;
	}


	/**
	 * Returns Store Status
	 * 
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            set Key of status
	 * @see #set status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Returns addressID
	 * 
	 * @return addressID
	 */
	public Long getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID
	 *            set Key of addressID
	 * @see #set addressID
	 */
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getBranchID() {
		return branchID;
	}

	public void setBranchID(Long branchID) {
		this.branchID = branchID;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<StoreProduct> getStoreProduct() {
		return storeProduct;
	}

	public void setStoreProduct(List<StoreProduct> storeProduct) {
		this.storeProduct = storeProduct;
	}
	
	
	
}
