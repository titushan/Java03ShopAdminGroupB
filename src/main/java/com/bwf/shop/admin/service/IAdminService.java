package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;

import java.util.List;

public interface IAdminService {

    Admin getAdminByName( String admin_name );




    List<Admin> getAdminList(AdminSearchBo bo);

/**
 * 添加员工是否成功
 * */
    boolean addAdmin(AdminAddBo bo);


    /**
     * 根据编号查询员工
     * */
    Admin getAdminById(Integer admin_id);

    /**
     * 修改员工
     * */
    boolean updateAdmin(AdminUpdateBo bo);


    /**
     * 删除单个员工
     * */
    boolean deleteOne(Integer admin_id);



    /**
     * 删除多个员工
     * */
    boolean deleteList(Integer[] ids);

    /**
     * 根据员工搜索业务模型对象查询满足条件的员工总记录数
     * */
    int getCount(AdminSearchBo bo);






}
