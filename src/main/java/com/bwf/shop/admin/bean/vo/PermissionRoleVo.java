package com.bwf.shop.admin.bean.vo;

/**
 * 权限角色关联视图模型对象
 * */
public class PermissionRoleVo {

    private Integer permission_id;  // 权限编号

    private String permission_name; // 权限名称

    private Integer pid;            // 父级权限编号

    private Integer role_id;        // null 当前角色没有该权限  not null 当前角色有该权限

    // getters and setters
    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
