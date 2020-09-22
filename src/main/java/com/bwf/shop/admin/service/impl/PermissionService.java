package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.po.Permission;
import com.bwf.shop.admin.bean.vo.PermissionRoleVo;
import com.bwf.shop.admin.mapper.PermissionMapper;
import com.bwf.shop.admin.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PermissionService implements IPermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> getAll() {
        return permissionMapper.getAll();


    }

    @Override
    public List<PermissionRoleVo> getAllPermissionWithRole(Integer role_id) {
        return permissionMapper.getAllPermissionWithRole(role_id);
    }
}
