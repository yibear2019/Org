package com.bearbaba.orgprovider.serviceImpl;

import com.bearbaba.orginterface.bean.Staff;
import com.bearbaba.orgprovider.OrgProviderApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangXiong
 * @date 2020/1/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrgProviderApplication.class)
class StaffServiceImplTest {
	@Autowired
	StaffServiceImpl staffService;
	@Test
	void addStaff() {
		Staff staff = new Staff();
		staff.setSex(true);
		staff.setTelephoneNumber(111111111L);
		staff.setName("丹丹");
		staff.setIdCard("1111111111");
		staff.setOrgId(1L);
		staff.setEnterpriseId(2L);
		staff.setFreeze(false);
		System.out.println(staffService.addStaff(staff));
	}
}