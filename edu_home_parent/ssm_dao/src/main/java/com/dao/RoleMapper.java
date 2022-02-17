package com.dao;

import com.domain.Role;
import com.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {
    /*
        查询所有角色&条件查询
     */
    public List<Role> findAllRole(Role role);

    /*
        根据角色ID查询其关联的菜单信息（三表联查）
    */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /*
        根据传递过来的ID去清空中间表的关联关系（这是多对多修改时的思想，先清空再添加）
     */
    public void deleteRoleContextMenu(Integer rid);

    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation relation);
}
