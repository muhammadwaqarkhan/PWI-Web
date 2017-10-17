package com.pwi.dao.company;

import com.pwi.domain.company.Company;

public interface ICompanyDAO {

	Company findByPrimaryKey(Long companyID);
}
