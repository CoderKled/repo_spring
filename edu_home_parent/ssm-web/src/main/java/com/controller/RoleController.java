package com.controller;


import com.domain.ResponseResult;
import com.domain.Role;
import com.domain.RoleMenuVO;
import com.service.MenuService;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        return new ResponseResult(true,200,"查询角色表成功",roleService.findAllRole(role));
    }

    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuService.findSubMenuListByPid(-1));
        return new ResponseResult(true,200,"查询父子菜单列表",map);
    }

    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(true,200,"查询角色关联菜单成功",menuByRoleId);
    }

    @RequestMapping("RoleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVO roleMenuVO){
        roleService.roleContextMenu(roleMenuVO);
        return new ResponseResult(true,200,"相应成功",null);

    }
}
