package com.bwf.shop.admin.service;


import com.bwf.shop.admin.bean.po.Permission;
import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.bean.vo.PermissionRoleVo;

import java.util.List;

public interface IPermissionService {

    /**
     * 获取所有权限列表
     * */
    List<Permission> getAll();


    /**
     * 带有角色判断的查询所有权限列表
     * */
    List<PermissionRoleVo> getAllPermissionWithRole(Integer role_id );




}
