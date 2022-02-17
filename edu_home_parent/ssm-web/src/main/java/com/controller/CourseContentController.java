package com.controller;


import com.domain.CourseSection;
import com.domain.ResponseResult;
import com.service.CourseContentService;
import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {
    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId){
        List<CourseSection> courseSectionList = courseContentService.findSectionAndLessonByCourseId(courseId);
        return new ResponseResult(true,200,"响应成功",courseSectionList);
    }

    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer courseId){
        return new ResponseResult(true,200,"查询课程信息成功",courseContentService.findCourseById(courseId));
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        if(courseSection.getId() == null){ //新增
            courseContentService.saveSection(courseSection);
            return new ResponseResult(true,200,"新增章节成功",null);
        }else {//否则就是更新
            courseContentService.updateSection(courseSection);
            return new ResponseResult(true,200,"修改章节成功",null);
        }
    }

    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(Integer id, Integer status){
        courseContentService.updateSectionStatus(id,status);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("status",status);
        return new ResponseResult(true,200,"响应成功",stringIntegerHashMap);
    }
}
