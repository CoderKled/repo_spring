package com.service;

import com.domain.Resource;
import com.domain.ResourceVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ResourceService {
    /*
    资源分页&多条件查询
 */
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
