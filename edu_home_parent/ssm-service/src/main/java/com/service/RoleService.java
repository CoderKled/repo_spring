package com.service;

import com.domain.Role;
import com.domain.RoleMenuVO;

import java.util.List;

public interface RoleService {
    /*
     查询所有角色&条件查询
  */
    public List<Role> findAllRole(Role role);

    /*
       根据角色ID查询其关联的菜单信息（三表联查）
   */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /*
        为角色分配菜单
     */
    public void roleContextMenu(RoleMenuVO roleMenuVO);
}
