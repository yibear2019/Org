package com.bearbaba.orgprovider.mapper;

import com.bearbaba.orgprovider.model.Role_Permission_Rel;

import java.util.List;

public interface Role_Permission_RelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role_Permission_Rel record);

    int insertSelective(Role_Permission_Rel record);

    Role_Permission_Rel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role_Permission_Rel record);

    int updateByPrimaryKey(Role_Permission_Rel record);

    List<Role_Permission_Rel> selectByCode(String permissionCode);
}