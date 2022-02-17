package com.controller;


import com.domain.Resource;
import com.domain.ResourceVO;
import com.domain.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @RequestMapping("findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO){
        PageInfo<Resource> allResourceByPage = resourceService.findAllResourceByPage(resourceVO);
        return new ResponseResult(true,200,"查询所有资源成功",allResourceByPage);
    }
}
