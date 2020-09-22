package com.bwf.shop.admin.bean.bo;

/**
 * 角色搜索业务模型对象
 * */
public class RoleSearchBo {

    private Integer role_id;    // 角色编号

    private String role_name;   // 角色名称

    private Integer start = 0;  // 起始记录索引

    private Integer length = 30; // 查询的记录数量

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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
