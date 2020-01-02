package com.bearbaba.orgprovider.serviceImpl;

import com.bearbaba.orginterface.bean.Scope;
import com.bearbaba.orgprovider.mapper.PermissionMapper;
import com.bearbaba.orgprovider.mapper.Role_Permission_RelMapper;
import com.bearbaba.orgprovider.model.Role;
import com.bearbaba.orgprovider.mapper.RoleMapper;
import com.bearbaba.orgprovider.model.Role_Permission_Rel;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author YangXiong
 * @date 2020/1/2
 */
public class RoleServiceImpl implements com.bearbaba.orginterface.service.RoleService {

	@Autowired
	RoleMapper roleMapper;

	@Autowired
	Role_Permission_RelMapper role_permission_relMapper;

	@Autowired
	PermissionMapper permissionMapper;
	/**
	 * 创建角色(可不附带权限)
	 *
	 * @param role
	 * @return
	 */
	@Override
	public Integer createRole(com.bearbaba.orginterface.bean.Role role) {
		/**
		 * todo
		 * 同预先处理
		 */

		Role modelRole = new Role();
		convertToModel(role,modelRole);
		return roleMapper.insert(modelRole);
	}

	private void convertToModel(com.bearbaba.orginterface.bean.Role role, Role modelRole) {
		if(role == null || role.getOrganizationId() == null ||
				role.getName() == null){
			return ;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		modelRole.setCreateTime(new Date());
		// 默认 false,非冻结
		modelRole.setFreeze((byte) 1);
		modelRole.setOrganizationId(role.getOrganizationId());
		modelRole.setRoleName(role.getName());
		if(role.getId() != null){
			modelRole.setRoleId(role.getId());
		}
	}

	/**
	 * 修改角色名和角色权限
	 *
	 * @param role
	 * @return
	 */
	@Override
	public boolean updateRole(com.bearbaba.orginterface.bean.Role role) {
		if(role == null ){
			return false;
		}

		Long roleId = role.getId();
		Role domainRole = roleMapper.selectByPrimaryKey(roleId);
		if(domainRole == null){
			return false;
		}

		List<Scope> scopes = role.getScopes();

		for (Scope scope : scopes) {
			String curCode = scope.getPermissionCode();
			List<Role_Permission_Rel> relList = role_permission_relMapper.selectByCode(curCode);
			// flag 为 true,表明该角色不具备此授权关系
			boolean flag = true;
			for (Role_Permission_Rel rel : relList) {
				if(role.getId().equals(rel.getRoleId())){
					flag = false;
				}
			}
			// 该角色不具备此授权关系,建立此授权关系
			if(flag){
				Role_Permission_Rel domainRel = new Role_Permission_Rel();
				domainRel.setCreatTime(new Date());
				domainRel.setPermissionCode(curCode);
				domainRel.setRoleId(roleId);
				domainRel.setPermissionId(permissionMapper.queryByCode(curCode).getPermissionId());
				role_permission_relMapper.insert(domainRel);
			}
		}


		domainRole.setRoleName(role.getName());
		roleMapper.updateByPrimaryKey(domainRole);
		return true;
	}

	/**
	 * 停用角色
	 * 影响范围:所有授予角色的员工
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean freezeRole(Long id) {
		Role domainRole = roleMapper.selectByPrimaryKey(id);
		if(domainRole == null){
			return false;
		}
		domainRole.setFreeze((byte)0);
		roleMapper.updateByPrimaryKey(domainRole);
		return true;
	}
}
