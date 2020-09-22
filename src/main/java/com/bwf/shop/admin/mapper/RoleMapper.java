package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.RoleAddBo;
import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.bo.RoleUpdateBo;
import com.bwf.shop.admin.bean.po.Permission;
import com.bwf.shop.admin.bean.po.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    /**
     * 获取所有角色列表
     * @return 系统中所有角色
     */
    List<Role> getAllRoleList();


    /**
     * 根据角色搜索业务模型对象查询满足条件的角色列表
     * */
    List<Role> getRoleList( @Param("bo") RoleSearchBo bo);


    /**
     * 添加角色
     * */
    int addRole(@Param("bo") RoleAddBo bo);



    /**
     * 给角色添加权限 (更新角色也用）
     * @param role_id 要添加权限的角色编号
     * @param permissionList 该角色拥有的权限列表
     * @return 数据库受影响的行数
     * */
    int addRolePermissions( @Param("role_id") Integer role_id , @Param("permissionList") List<Permission> permissionList);


    /**
     * 根据编号查询角色
     * */
    Role getRoleById( @Param("role_id") Integer role_id );

    /**
     * 修改角色名称
     * */
    int updateRole( @Param("bo") RoleUpdateBo bo);


    /**
     * 根据编号删除所有权限(修改权限第一步)
     * */
    int deleteRolePermissions( @Param("role_id") Integer role_id );







}
