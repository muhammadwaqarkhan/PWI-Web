package com.pwi.domain.branch;

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

import com.pwi.domain.address.Address;
import com.pwi.domain.company.Company;
import com.pwi.domain.store.Store;

/**
 * Holds all data which is relevant to Branch
 * 
 * @author Waqar Contact 03346100977
 */
@NamedQueries({
		@NamedQuery(name = Branch.Queries.READ_BY_ALL_BRANCHS, query = "from com.pwi.domain.branch.Branch where status=:status"),//

		@NamedQuery(name = Branch.Queries.READ_BY_PRIMARY_KEY, query = "from com.pwi.domain.branch.Branch where branchID=:branchID"),//

		@NamedQuery(name = Branch.Queries.READ_BY_BRANCH_NAME, query = "from com.pwi.domain.branch.Branch where branchName=:branchName")

})
@Entity()
@Table(name = "Branch", schema = "pwi")
public class Branch {

	private static final int BRANCH_LENGTH = 45;

	public static class Queries {
		public static final String READ_BY_ALL_BRANCHS = "Branch.ReadBranches";
		public static final String READ_BY_PRIMARY_KEY = "Branch.ReadPrimaryKey";
		public static final String READ_BY_BRANCH_NAME = "Branch.ReadBranchName";

	}

	@Column(name = "BRANCHID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long branchID;

	@Size(max = BRANCH_LENGTH, message = "branchName")
	@Column(name = "BRANCHNAME", length = BRANCH_LENGTH)
	private String branchName;

	@Column(name = "addressID", insertable = false, updatable = false, nullable = false)
	private Long addressID;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "addressID", referencedColumnName = "addressID", insertable = true, updatable = true)
	private Address address = null;

	@Column(name = "STATUS")
	private Integer status;

	@Column(name = "COMPANYID", insertable = false, updatable = false, nullable = false)
	private Long companyID;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "companyID", referencedColumnName = "companyID")
	private Company company = null;

	@OneToMany(mappedBy = "branch", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Store> stores = null;

	/**
	 * Initializer for use by application code when constructing a new object
	 * for insertion into persistent store.
	 * 
	 * @param Address
	 *            The address of branch
	 */
	public void init(Address address) {
		this.address = address;
		this.status = new Integer(1);
	}

	/**
	 * Returns the primary key of the object
	 * 
	 * @return key
	 */
	public Long getBranchID() {
		return branchID;
	}

	/**
	 * @param branchID
	 *            set branchID
	 * @see #set branchID
	 */
	public void setBranchID(Long branchID) {
		this.branchID = branchID;
	}

	/**
	 * @return branch name
	 * @see #Branch name
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            set branchNameh
	 * @see #set branchName
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return address Key
	 * @see #address Key
	 */
	public Long getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID
	 *            set addressID of branch
	 * @see #set addressID of branch
	 */
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	/**
	 * @return Address of branch
	 * @see #Address of branch
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param Address
	 *            set Address of branch
	 * @see #set Address of branch
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return status of branch
	 * @see #status of branch
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            set branch status
	 * @see #set branch status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Returns the key of companyID
	 * 
	 * @return company key
	 */
	public Long getCompanyID() {
		return companyID;
	}

	/**
	 * @param companyID
	 *            set companyID
	 * @see #set companyID
	 */
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	/**
	 * Returns the Company object
	 * 
	 * @return company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param Company
	 *            set Company object
	 * @see #set Company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}
