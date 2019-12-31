package com.bearbaba.orgprovider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bearbaba.orginterface.bean.User;
import com.bearbaba.orginterface.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author YangXiong
 * @date 2019/12/22
 */
@Service
@Component
public class UserServiceImpl implements UserService {
	@Override
	public User getUser() {
		User user = new User();
		user.setId(1);
		System.out.println(user.getId());
		return user;
	}
}
