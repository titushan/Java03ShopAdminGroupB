package com.bwf.shop.admin.service.impl;


import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.mapper.AdminMapper;
import com.bwf.shop.admin.service.IAdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService2 implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByName(String admin_name) {
        return adminMapper.getAdminByName(admin_name);
    }


    @Override
    public List<Admin> getAdminList(AdminSearchBo bo) {
        return adminMapper.getAdminList(bo);
    }

    @Override
    @Transactional( rollbackFor = Exception.class)
    public boolean addAdmin(AdminAddBo bo) {

        //验证添加员工是否存在（服务器验证，前为客户端验证）
        Admin admin = adminMapper.getAdminByName(bo.getAdmin_name());
        if (admin == null) {
            bo.setAdmin_pass(new BCryptPasswordEncoder().encode("123456"));
            int a = adminMapper.addAdmin(bo);
            int b = adminMapper.addAdminRole(bo.getAdmin_id(), bo.getRole_id());
            return a > 0 && b > 0;
        } else {
            return false;
        }
    }

    @Override
    public Admin getAdminById(Integer admin_id) {
        return adminMapper.getAdminById(admin_id);
    }

    @Override
    @Transactional( rollbackFor = Exception.class )
    public boolean updateAdmin(AdminUpdateBo bo) {
        //加密填写
        if( bo.getAdmin_pass() != null && ! bo.getAdmin_pass().isEmpty() ){
            bo.setAdmin_pass(
                    new BCryptPasswordEncoder().encode(  bo.getAdmin_pass() )
            );
        }
        // 首先 修改昵称和密码
        int a = adminMapper.updateAdmin(bo);
        // 修改员工角色
        // 第一步 删除原角色
        int b = adminMapper.deleteAdminRoles( bo.getAdmin_id() );
        // 第二步 添加新角色
        int c = adminMapper.addAdminRole( bo.getAdmin_id() , bo.getRole_id() );
        // 三个步骤的受影响行数都有
        return a > 0 && b >0 && c > 0;
    }

    @Override
    public boolean deleteOne(Integer admin_id) {
        return adminMapper.deleteOne(admin_id) > 0 ;
    }

    @Override
    public boolean deleteList(Integer[] ids) {
        return adminMapper.deleteList(ids) > 0;
    }

    @Override
    public int getCount(AdminSearchBo bo) {
        return adminMapper.getCount(bo);
    }


}
