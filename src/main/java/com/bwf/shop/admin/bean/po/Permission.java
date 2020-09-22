package com.bwf.shop.admin.bean.po;

/**
 * 权限模型对象
 * */
public class Permission {

    private Integer permission_id;  // 权限编号

    private String permission_name; // 权限名称

    private Integer pid;            // 父级权限编号

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
}
