package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.RoleAddBo;
import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.bo.RoleUpdateBo;
import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.mapper.RoleMapper;
import com.bwf.shop.admin.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService implements IRoleService {

    //依赖数据访问层
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoleList() {
        return roleMapper.getAllRoleList();
    }

    @Override
    public List<Role> getRoleList(RoleSearchBo bo) {
        return roleMapper.getRoleList(bo);
    }

    @Override
    @Transactional( rollbackFor = Exception.class)
    public boolean addRole(RoleAddBo bo) {
        //先添加记录 得到role_id
        int a = roleMapper.addRole(bo);
        //然后给 角色权限关系表添加 该角色 选中的权限 记录
        int b = roleMapper.addRolePermissions(bo.getRole_id(),bo.getPermissionList());

        return a>0 && b>0 ;

    }

    @Override
    public Role getRoleById(Integer role_id) {
        return roleMapper.getRoleById(role_id);
    }

    @Override
    @Transactional( rollbackFor = Exception.class )
    public boolean updateRole(RoleUpdateBo bo) {

        // 修改 role 角色表中的信息(角色名)
        int a = roleMapper.updateRole(bo);

        //  修改角色权限 先 删除所有权限 再 根据选择项重新添加权限
        //  先 删除 该角色的所有权限
        int b = roleMapper.deleteRolePermissions( bo.getRole_id() );

        // 重新 给 该角色 添加 权限
        int c = roleMapper.addRolePermissions( bo.getRole_id() , bo.getPermissionList() );

        return a > 0 || b > 0 || c > 0;
    }



}
