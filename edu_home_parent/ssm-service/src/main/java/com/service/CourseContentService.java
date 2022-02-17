package com.service;

import com.domain.Course;
import com.domain.CourseSection;

import java.util.List;

public interface CourseContentService {
    /*
        根据课程ID查询课程内容（章节+课时）
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /*
      根据Id查找课程信息(用于回显)
   */
    public Course findCourseById(Integer courseId);

    /*
        新增章节信息
     */
    public void saveSection(CourseSection courseSection);

    /*
        更新章节信息
     */
    public void updateSection(CourseSection courseSection);

    /*
        修改章节状态
     */
    public void updateSectionStatus(Integer id, Integer status);
}
