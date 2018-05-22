package com.bizleap.training.ds.loader.impl.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import com.bizleap.commons.domain.Company;
import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.impl.test.ServiceTest;

public class CompanyServiceImplTest extends ServiceTest {
	
	static Logger logger=Logger.getLogger(CompanyServiceImplTest.class);
	
	//@Ignore
	@Test
	public void testFindByCompanyBoId() throws ServiceUnavailableException {
		
		List<Company> companyList=companyService.findByCompanyBoId("COMP01");
		assertNotNull(companyList);
		logger.info("Company List: "+companyList);
		assertTrue(CollectionUtils.isNotEmpty(companyList));
	}
	
	//@Ignore
	@Test
	public void testGetAllCompany() throws ServiceUnavailableException {
	
		assertEquals(3,companyService.getAllCompany().size());
	}
}