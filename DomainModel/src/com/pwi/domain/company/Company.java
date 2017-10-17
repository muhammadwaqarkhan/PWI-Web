package com.pwi.domain.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
/**
 * Holds all data which is relevant to comapny 
 *  @author Waqar Contact 03346100977
 */
@Entity()
@Table(name = "Company", schema = "pwi")
public class Company 
{
	
	
	
	@Column(name = "COMPANYID", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long companyID;
	
	
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


}
