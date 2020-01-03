package com.bearbaba.orgprovider.mapper;

import com.bearbaba.orgprovider.model.StaffRoleRel;

import java.util.List;

public interface StaffRoleRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StaffRoleRel record);

    int insertSelective(StaffRoleRel record);

    StaffRoleRel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StaffRoleRel record);

    int updateByPrimaryKey(StaffRoleRel record);


    List<StaffRoleRel> selectByRoleId(Long roleId);
}