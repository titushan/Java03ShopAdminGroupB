package com.bwf.shop.admin.bean.bo;

import com.bwf.shop.admin.bean.po.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加角色业务模型对象
 * */
public class RoleAddBo {

    private Integer role_id;    // 角色编号

    private String role_name;   // 角色名称

    private List<Permission> permissionList = new ArrayList<Permission>();  // 权限列表

    // getters and setters
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
