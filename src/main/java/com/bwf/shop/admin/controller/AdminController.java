package com.bwf.shop.admin.controller;


import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.service.IAdminService;
import com.bwf.shop.admin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    //依赖逻辑层对象
    @Autowired
    private IAdminService adminService;

    @Resource
    private IRoleService roleService;


    @RequestMapping("/admin")
    public String admin(AdminSearchBo bo , Model model){



        //根据业务模型对象查询总记录数
        int count = adminService.getCount(bo);
        //根据总记录数和每页显示记录数 计算总页数
        int total = count % bo.getLength() == 0 ?
                count / bo.getLength() :
                count / bo.getLength() + 1;
        // 控制 当前查询记录起始索引的范围
        if( bo.getStart() < 0 ){ bo.setStart(0); }
        if( bo.getStart() > (total - 1)*bo.getLength() ){ bo.setStart( (total - 1)*bo.getLength() ); }





        //调用业务逻辑层，根据模型对象，查询员工列表
        List<Admin> adminList = adminService.getAdminList(bo);
        // 获取 所有的角色列表
        List<Role> roleList = roleService.getAllRoleList();




        //满足条件的员工列表假如model模型数据中（给视图层使用）
        model.addAttribute("adminList",adminList);
        model.addAttribute("roleList",roleList);

        //留存模型对象，筛选员工之后输入框内保留上次输入
        model.addAttribute("bo",bo);

        //记录总页数
        model.addAttribute("total",total);

        return null;
    }

    // 添加员工表单
    @RequestMapping("/add")
    public String add( Model model ){


        //调用业务逻辑层获得所有员工列表
        List<Role> roleList = roleService.getAllRoleList();

        //所有列表添加到Model
        model.addAttribute("roleList",roleList);

        return null;
    }

    //验证账户名称是否存在
    @RequestMapping("/validAdminName")
    @ResponseBody
    public String validAdminName(String admin_name){
        //判断
        Admin admin = adminService.getAdminByName(admin_name);

        return admin == null?"1":"0";
    }


    // 添加员工执行
    @RequestMapping("/save")
    public String save(AdminAddBo bo , Model model){
        //执行添加员工
        boolean result = adminService.addAdmin(bo);

        //判断添加是否成功
        if( result ){
            model.addAttribute("messages",new String[]{"员工添加执行成功！"});
            model.addAttribute("back","/admin/admin");
            return "common/success";
        }else {
            model.addAttribute("messages", new String[]{"员工添加执行失败！"});
            model.addAttribute("solution", "请联系管理员！");
            model.addAttribute("back", "/admin/add");
            return "common/error";
        }
    }

    //修改员工表单
    @RequestMapping("/update")
    public String update (Integer admin_id , Model model){
        //调用 查询需要修改的员工
        Admin admin = adminService.getAdminById(admin_id);

        //调用业务逻辑层获得所有员工列表
        List<Role> roleList = roleService.getAllRoleList();

        //所有列表添加到Model
        model.addAttribute("roleList",roleList);

        model.addAttribute("admin",admin);

        return null;
    };

    //修改员工执行
    @RequestMapping("/alter")
    public String alter(AdminUpdateBo bo , Model model){
        // 调用业务逻辑层 完成员工修改操作
        boolean result = adminService.updateAdmin(bo);

        // 判断 修改员工是否成功
        if( result ){
            model.addAttribute("messages",new String[]{"员工修改执行成功！"});
            model.addAttribute("back","/admin/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"员工修改执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/admin/update?admin_id="+bo.getAdmin_id());
            return "common/error";
        }

    };


    //删除员工
    @RequestMapping( "/delete" )
    public String delete( Integer admin_id , Integer[] ids ,Model model ){
        boolean result = false;
        // 判断 当前删除操作 是 删除单个员工  还是 批量删除多个员工
        if( admin_id != null ){
            // 根据 id 删除 单个员工
            result = adminService.deleteOne(admin_id);
        }
        if( ids != null ){
            // 根据 id 数组 批量删除多个员工
            result = adminService.deleteList(ids);
        }
        // 判断 删除员工是否成功
        if( result ){
            model.addAttribute("messages",new String[]{"员工删除执行成功！"});
            model.addAttribute("back","/admin/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"员工删除执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/admin/admin");
            return "common/error";
        }
    }







}
