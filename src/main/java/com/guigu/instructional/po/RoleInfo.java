package com.guigu.instructional.po;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RoleInfo {
    private Integer roleId;
    
    @NotEmpty(message="{roleInfo.roleName.isnull}")
    @Size(max=30,message="{roleInfo.roleName.size}")
    private String roleName;
    
    @Size(max=500,message="{roleInfo.roleDesc.size}")
    private String roleDesc;

    @Size(max=5,message="{roleInfo.roleState.size}")
    private String roleState;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getRoleState() {
        return roleState;
    }

    public void setRoleState(String roleState) {
        this.roleState = roleState == null ? null : roleState.trim();
    }
}