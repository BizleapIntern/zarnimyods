package com.bizleap.training.ds.loader.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import com.bizleap.commons.domain.Employee;
import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.impl.test.ServiceTest;

public class EmployeeServiceImplTest extends ServiceTest {
	
	static Logger logger=Logger.getLogger(EmployeeServiceImplTest.class);
	
	//@Ignore
	@Test
	public void testFindByEmployeeBoId() throws ServiceUnavailableException {
		
		List<Employee> employeeList=employeeService.findByEmployeeBoId("PER01");
		assertNotNull(employeeList);
		logger.info("Employee List: "+employeeList);
		assertTrue(CollectionUtils.isNotEmpty(employeeList));
	}
	
	//@Ignore
	@Test
	public void testGetAllEmployee() throws ServiceUnavailableException {
	
		assertEquals(8,employeeService.getAllEmployee().size());
		//logger.info(employeeService.getAllEmployee().size());
	}
}
