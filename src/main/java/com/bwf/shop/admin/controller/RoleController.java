package com.bwf.shop.admin.controller;


import com.bwf.shop.admin.bean.bo.RoleAddBo;
import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.bo.RoleUpdateBo;
import com.bwf.shop.admin.bean.po.Permission;
import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.bean.vo.PermissionRoleVo;
import com.bwf.shop.admin.service.IPermissionService;
import com.bwf.shop.admin.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {


    //依赖业务逻辑层
    @Resource
    private IRoleService roleService;
    @Resource
    private IPermissionService permissionService;



    //角色管理
    @RequestMapping("/admin")
    public String admin(RoleSearchBo bo , Model model){

        // 根据 角色搜索业务模型对象 查询 满足条件的角色列表
        List<Role> roleList = roleService.getRoleList(bo);

        // 添加model模型数据
        model.addAttribute("roleList",roleList);

        return null;
    }

    //添加角色表单页面
    @RequestMapping( "/add" )
    public String add( Model model ){

        // 获取 所有的 权限列表
        List<Permission> permissionList = permissionService.getAll();

        // 填充model模型数据
        model.addAttribute("permissionList",permissionList);

        return null;
    }


    // 添加角色执行
    @RequestMapping( "/save" )
    public String save(RoleAddBo bo, Model model){

        // 执行添加角色业务
        boolean result = roleService.addRole(bo);

        // 判断 添加角色是否成功
        if( result ){
            model.addAttribute("messages",new String[]{"角色添加执行成功！"});
            model.addAttribute("back","/role/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"角色添加执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/role/add");
            return "common/error";
        }
    }


    // 修改角色表单页面
    @RequestMapping( "/update" )
    public String update( Integer role_id , Model model ){

        // 根据 要修改的角色编号 查询角色对象
        Role role = roleService.getRoleById(role_id);

        // 根据 要修改的角色编号 查询所有的带有角色判断的权限列表
        List<PermissionRoleVo> permissionRoleVoList = permissionService.getAllPermissionWithRole(role_id);

        // 填充model模型数据
        model.addAttribute("role",role);
        model.addAttribute( "permissionList", permissionRoleVoList );

        return null;
    }




    // 修改角色执行
    @RequestMapping("/alter")
    public String alter(RoleUpdateBo bo , Model model ){

        // 执行 修改角色 操作
        boolean result = roleService.updateRole(bo);


        // 判断 修改角色是否成功
        if( result ){
            model.addAttribute("messages",new String[]{"角色修改执行成功！"});
            model.addAttribute("back","/role/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"角色修改执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/role/update");
            return "common/error";
        }
    }














}
