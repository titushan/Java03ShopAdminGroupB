package com.bwf.shop.admin.mapper;


import com.bwf.shop.admin.bean.po.Permission;
import com.bwf.shop.admin.bean.vo.PermissionRoleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    /**
     * 获取所有权限列表
     * */
    List<Permission> getAll();

    /**
     * 带有角色判断的查询所有权限列表
     * @param role_id 要拥有权限的角色编号
     * @return 带有角色判断的权限列表
     * */
    List<PermissionRoleVo> getAllPermissionWithRole(@Param("role_id") Integer role_id );


}
