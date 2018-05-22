package com.bizleap.training.ds.loader.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.impl.test.ServiceTest;

public class DataManagerImplTest extends ServiceTest{		
	
	/*@Autowired
	@Qualifier("dataManager")
	private DataManager dataManager;*/
	
	static Logger logger=Logger.getLogger(DataManagerImplTest.class);
	
	@Ignore
	@Test
	public void testLoad() throws IOException, ServiceUnavailableException {		
		dataManager.load();
		
		assertNotNull(dataManager.getEmployeeList());
		assertTrue(CollectionUtils.isNotEmpty(dataManager.getEmployeeList()));
		assertEquals(8,dataManager.getEmployeeList().size());
		
		assertNotNull(dataManager.getCompanyList());
		assertTrue(CollectionUtils.isNotEmpty(dataManager.getCompanyList()));
		assertEquals(3,dataManager.getCompanyList().size());
	}
	
	@Ignore
	@Test
	public void testLoadFalse() {
		assertTrue(false);
	}

}
