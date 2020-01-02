package com.bearbaba.orgprovider.mapper;

import com.bearbaba.orgprovider.model.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    Permission queryByCode(String permissionCode);
}