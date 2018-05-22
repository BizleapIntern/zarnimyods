package com.bizleap.training.ds.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bizleap.commons.domain.Company;
import com.bizleap.commons.domain.enums.EntityType;
import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.service.CompanyService;
import com.bizleap.training.ds.service.EmployeeService;
import com.bizleap.training.ds.service.dao.CompanyDao;

@Service("companyService")
public class CompanyServiceImpl extends AbstractServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companyDao;

	@Autowired
	EmployeeService employeeService;

	@Override
	public List<Company> findByCompanyBoId(String boId) throws ServiceUnavailableException {
		String queryString = "from Company company where company.boId= :dataInput";
		List<Company> companies = companyDao.findByString(queryString, boId);
		hibernateInitializeCompanyList(companies);
		return companies;
	}

	public Company findByCompanyBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Company> companyList = findByCompanyBoId(boId);
		if (CollectionUtils.isNotEmpty(companyList) && companyList.size() > 0) {
			return companyList.get(0);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveCompany(Company company) throws IOException, ServiceUnavailableException {
		// TODO Auto-generated method stub
		if (company.isBoIdRequired()) {
			company.setBoId(getNextBoId());
		}
		companyDao.save(company);
	}

	@Override
	public List<Company> getAllCompany() throws ServiceUnavailableException {
		List<Company> companyList = companyDao.getAll("from Company company");
		hibernateInitializeCompanyList(companyList);
		return companyList;
	}

	@Override
	public long getCount() {
		return companyDao.getCount("select count(comp) from Company comp");
	}

	public String getNextBoId() {
		return getNextBoId(EntityType.COMPANY);
	}

	public void hibernateInitializeCompanyList(List<Company> companyList) throws ServiceUnavailableException {
		if(companyList==null)
			return;
		Hibernate.initialize(companyList);
		for (Company company : companyList)
			hibernateInitializeCompany(company);
	}

	public void hibernateInitializeCompany(Company company) throws ServiceUnavailableException {
		//Hibernate.initialize(company);
		//company.setEmployeeList(null);
		employeeService.hibernateInitializeEmployeeList(company.getEmployeeList());
	}
}
