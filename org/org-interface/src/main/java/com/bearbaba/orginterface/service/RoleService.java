package com.bearbaba.orginterface.service;

import com.bearbaba.orginterface.bean.Role;

/**
 * @author YangXiong
 * @date 2020/1/2
 */
public interface RoleService {
	/**
	 * 创建角色(可不附带权限)
	 * @param role
	 * @return
	 */
	public Integer createRole(Role role);

	/**
	 * 修改角色名和角色权限
	 * @param role
	 * @return
	 */
	public boolean updateRole(Role role);

	/**
	 * 停用角色
	 * 影响范围:所有授予角色的员工
	 * @param id
	 * @return
	 */
	public boolean freezeRole(Long id);
}
