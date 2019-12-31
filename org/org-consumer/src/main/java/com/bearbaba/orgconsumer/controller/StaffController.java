package com.bearbaba.orgconsumer.controller;

import com.bearbaba.orginterface.bean.Staff;
import com.bearbaba.orginterface.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXiong
 * @date 2019/12/31
 */
@RestController
public class StaffController {
	@Autowired
	StaffService staffService;

	@RequestMapping("/getStaff")
	public Staff getStaffById(){
		return staffService.getStaffInfo(1L);
	}
}
