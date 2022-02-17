package com.dao;

import com.domain.Course;
import com.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {
    /*
        根据课程ID查询其关联的章节信息，以及各个章节关联的课时信息
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /*
        根据Id查找课程信息(用于回显)
     */
    public Course findCourseById(Integer courseId);

    /*
        添加保存的新章节
     */
    public void saveSection(CourseSection courseSection);

    /*
        更新课程信息
     */
    public void updateSection(CourseSection courseSection);

    /*
        修改章节状态
     */
    public void updateSectionStatus(CourseSection courseSection);





}
