package com.bwf.shop.admin.bean.po;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 员工类
 * */
public class Admin implements UserDetails {

    private Integer admin_id;       // 员工编号

    private String admin_name;      // 登录账户名称

    private String admin_pass;      // 登录账户密码

    private String admin_nickname;  // 员工昵称

    private List<Role> roleList = new ArrayList<Role>();    // 员工的角色列表

    private List<Menu> menuList = new ArrayList<Menu>();    // 员工的菜单列表

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoleList();
    }

    @Override
    public String getPassword() {
        return getAdmin_pass();
    }

    @Override
    public String getUsername() {
        return getAdmin_name();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // getters and setters
    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getAdmin_nickname() {
        return admin_nickname;
    }

    public void setAdmin_nickname(String admin_nickname) {
        this.admin_nickname = admin_nickname;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
