package com.dao;

import com.domain.Course;
import com.domain.CourseVO;
import com.domain.Teacher;

import java.util.List;

public interface CourseMapper {

    /*
    多条件列表查询
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*
        新增课程信息（而且还要得到新增课程的自增ID给teacher填充所对应的course_id）
     */
    public void saveCourse(Course course);

    /*
        新增讲师（teacher）信息
     */
    public void saveTeacher(Teacher teacher);

    /*
        回显课程信息（根据课程ID查出课程信息及其关联的讲师）
        返回值要使用CourseVO，因为只有CourseVO才能既装课程信息又装讲师信息
     */
    public CourseVO findCourseById(Integer id);

    /*
        更新课程信息
     */
    public void updateCourse(Course course);

    /*
        更新讲师信息
     */
    public void updateTeacher(Teacher teacher);

    /*
        课程状态管理
     */
    public void updateCourseStatus(Course course);

    /*

     */
}
