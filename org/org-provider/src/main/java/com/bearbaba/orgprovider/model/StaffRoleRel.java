package com.bearbaba.orgprovider.model;

import java.io.Serializable;

public class StaffRoleRel implements Serializable {
    private Long id;

    private Long roleId;

    private Long staffId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}