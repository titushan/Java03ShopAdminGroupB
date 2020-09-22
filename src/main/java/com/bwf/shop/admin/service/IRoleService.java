package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.RoleAddBo;
import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.bo.RoleUpdateBo;
import com.bwf.shop.admin.bean.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleService {

    List<Role> getAllRoleList();





    /**
     * 根据角色搜索业务模型对象查询满足条件的角色列表
     * */
    List<Role> getRoleList( RoleSearchBo bo);




    /**
     * 添加角色
     * */
    boolean addRole(RoleAddBo bo);



    /**
     * 根据编号查询角色
     * */
    Role getRoleById(Integer role_id );



    /**
     * 修改角色名称
     * */
    boolean updateRole(RoleUpdateBo bo);



























}
