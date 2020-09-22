package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {


    Admin getAdminByName( @Param("amdin_name") String admin_name );


    /**
     * 根据业务模型对象查询员工列表
     * */
    List<Admin> getAdminList(@Param("bo") AdminSearchBo bo);

    /**
     * 添加员工
     * */
    int addAdmin (@Param("bo")AdminAddBo bo);


    /**
     * 给员工对象添加角色
     * */
    int addAdminRole(@Param("admin_id") Integer admin_id ,@Param("role_id") Integer role_id );


    /**
     * 根据编号查询员工
     * */
    Admin getAdminById(@Param("admin_id")Integer admin_id);


    /**
     * 修改员工
     * */
    int updateAdmin( @Param("bo") AdminUpdateBo bo);

    /**
     * 删除员工所有角色
     * */
    int deleteAdminRoles( @Param("admin_id") Integer admin_id );


    /**
     * 删除单个员工
     * */
    int deleteOne(@Param("admin_id")Integer admin_id);



    /**
     * 删除多个员工
     * */
    int deleteList(@Param("ids")Integer[] ids);




    /**
     * 根据员工搜索业务模型对象查询满足条件的员工总记录数
     * */
    int getCount( @Param("bo") AdminSearchBo bo );

}