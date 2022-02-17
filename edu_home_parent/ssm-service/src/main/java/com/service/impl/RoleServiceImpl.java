package com.service.impl;

import com.dao.RoleMapper;
import com.domain.Role;
import com.domain.RoleMenuVO;
import com.domain.Role_menu_relation;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {

        return roleMapper.findMenuByRoleId(roleId);
    }

    @Override
    public void roleContextMenu(RoleMenuVO roleMenuVO) {
        roleMapper.deleteRoleContextMenu(roleMenuVO.getRoleId());

        for (Integer menuId : roleMenuVO.getMenuIdList()) {
            Date date = new Date();
            Role_menu_relation role_menu_relation = new Role_menu_relation();

            role_menu_relation.setMenuId(menuId);
            role_menu_relation.setRoleId(roleMenuVO.getRoleId());

            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);

            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedBy("system");
            roleMapper.roleContextMenu(role_menu_relation);
        }


    }
}
