package com.service;

import com.domain.Menu;

import java.util.List;

public interface MenuService {
    /*
        查询所有菜单（父子关系）
     */
    public List<Menu> findSubMenuListByPid(Integer pid);
}
