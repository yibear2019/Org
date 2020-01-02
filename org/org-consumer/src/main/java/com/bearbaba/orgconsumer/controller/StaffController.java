package com.bearbaba.orgconsumer.controller;

import com.bearbaba.orginterface.bean.Staff;
import com.bearbaba.orginterface.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

	@RequestMapping("/addStaff")
	public int addStaff(Staff staff){
		return staffService.addStaff(staff);
	}

	@RequestMapping("/updateStaffInfo")
	public boolean updateStaffInfo(Staff staff){
		return staffService.updateStaffInfo(staff);
	}

	@RequestMapping("/authorizeStaff")
	public boolean authorizeStaff(List<Long> roleList, Long staffId){
		return staffService.authorizeStaff(roleList,staffId);
	}

	@RequestMapping("/freezeStaff")
	public boolean freeStaff(Long id){
		return staffService.freeStaff(id);
	}

	@RequestMapping("/unfreezeStaff")
	public boolean unfreezeStaff(Long id){
		return staffService.unfreezeStaff(id);
	}

	@RequestMapping("/deleteStaff")
	public boolean deleteStaff(Long id){
		return staffService.deleteStaff(id);
	}

	@RequestMapping("/batchDeleteStaff")
	public boolean batchDeleteStaff(List<Long> ids){
		return staffService.batchDeleteStaff(ids);
	}
}
