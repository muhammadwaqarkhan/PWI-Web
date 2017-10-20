package com.pwi.domain.company;

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

import com.pwi.domain.branch.Branch;
import com.pwi.domain.brand.Brand;
import com.pwi.domain.store.Store;
/**
 * Holds all data which is relevant to comapny 
 *  @author Waqar Contact 03346100977
 */

@NamedQueries(  
	    {  
	        @NamedQuery(  
	    	        name = Company.Queries.READ_BY_PRIMARY_KEY,  
	    	        query = "from com.pwi.domain.company.Company where companyID=:companyID"  
	    	        ) 
	    }  
)

@Entity()
@Table(name = "Company", schema = "pwi")
public class Company 
{
	
	public static class Queries
	{
		public static final String	READ_BY_PRIMARY_KEY	= "Company.ReadPrimaryKey";

		
	}
	
	
	@Column(name = "COMPANYID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long companyID;
	
	
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Branch> branches				= null;
	
	
	
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Brand> brands				= null;
	
	/**
	 * Fore name.
	 * 
	 * The user's first name.
	 */
	@Size(max = 45, message = "Name")
	@Column(name = "Name", length = 45)
	
	private String Name;
	
	@Size(max = 1, message = "status")
	@Column(name = "status", length = 1)
	private String status;

	/**
	 * Returns the primary key of the object
	 * 
	 * @return key
	 */
	public Long getCompanyID() {
		return companyID;
	}

	/**
	 * @param comapnyID
	 *            set Key
	 * @see #set CompanyID
	 */
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	/**
	 * Returns companyName
	 * 
	 * @return compantName
	 */
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * Returns Status of company
	 * 
	 * @return status
	 */

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}


}
