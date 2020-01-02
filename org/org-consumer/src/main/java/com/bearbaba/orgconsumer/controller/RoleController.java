package com.bearbaba.orgconsumer.controller;

import com.bearbaba.orginterface.bean.Role;
import com.bearbaba.orginterface.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXiong
 * @date 2020/1/2
 */
@RestController
public class RoleController {
	@Autowired
	RoleService roleService;

	@RequestMapping("/createRole")
	public Integer createRole(Role role){
		return roleService.createRole(role);
	}

	@RequestMapping("/updateRole")
	public boolean updateRole(Role role){
		return roleService.updateRole(role);
	}

	@RequestMapping("/freezeRole")
	public boolean freezeRole(Long id){
		return roleService.freezeRole(id);
	}
}
