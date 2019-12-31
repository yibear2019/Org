package com.bearbaba.orgconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bearbaba.orginterface.bean.User;
import com.bearbaba.orginterface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author YangXiong
 * @date 2019/12/22
 */
@RestController
public class UserController {
	/**
	 * 使用@Reference注解注入接口，@Refence一般用来注入分布式的远程服务对象，配合dubbo使用
	 */
	@Autowired
	//@Reference(version = "1.0.0")
	UserService userService;

	@RequestMapping("/getUser")
	public User getUser(){
		System.out.println("进来消费了");
		return userService.getUser();
	}
}
