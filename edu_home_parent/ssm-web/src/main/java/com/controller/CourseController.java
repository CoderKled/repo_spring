package com.controller;


import com.domain.Course;
import com.domain.CourseVO;
import com.domain.ResponseResult;
import com.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /*
        多条件列表查询
     */
    @RequestMapping("/findCourseByCondition")
    //@RequestBody的作用就是让前台传过来的JSON解析封装到courseVO
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){
        List<Course> courseList = courseService.findCourseByCondition(courseVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseList);
        return responseResult;
    }


    /*
        图片上传
     */
    @RequestMapping("/courseUpload")
    //这里的参数名称不能随便乱起，因为不是以JSON的形式传过来的不能用@RequestBody封装，所以这里要与请求参数的名称保持一致，在接口文档里请求参数就是file
    //但是也可以用@RequestParam来明确到底要用哪个传来的参数，这样形参的名字就可以乱取了，所以为了规范也添加上@ResquestParam
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //1.判断接收到的文件是否为空
        if (file.isEmpty()){
            throw new RuntimeException();
        }

        //2.获取项目部署路径(具体是在磁盘的哪个位置，这样才能把上传的文件保存下来)
        //这里得到的地址应该是E:\JavaProjects\SSM_Project_Lagou\edu_home_parent\ssm-web\target\ssm-web-1.0-SNAPSHOT\
        String realPath = request.getServletContext().getRealPath("/");
        //为了规范，把上传的文件全部上传到一个upLoad文件夹，所以先把ssm-web以及其之后的内容删掉
        //E:\JavaProjects\SSM_Project_Lagou\edu_home_parent\
        String substring = realPath.substring(0, realPath.indexOf("ssm-web"));



        //3.获取上传文件的文件名
        String originalFilename = file.getOriginalFilename();

        //4.为了保存下来后防止重复，生成新的文件名
        //假设原文件名是 xxx.jpg，那么新文件名就是   当前时间.jpg
        //                  获取当前时间戳（反正为了防重复，其他也行命名）                     获取上传文件名的后缀名
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5.将上传的文件保存到服务端（本地）

        String upLoadPath = substring + "upload\\";
        File filePath = new File(upLoadPath, newFileName);
        //如果这个upload文件夹不存在，那就要创建一个
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("已经创建目录：" + filePath);
        }
        //到这里，图片就进行了真正的上传
        file.transferTo(filePath);


        //6.完成任务，那就向客户端响应
        HashMap<String, String> map = new HashMap<>();
        map.put("fileName",newFileName);
        map.put("filePath","http://loacalhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "上传成功", map);
        return responseResult;
    }

    /*
        新增课程信息及其讲师信息
        新增和修改课程信息可以写在同一个方法中
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        //如果传过来的JSON里的id是空的话，说明这次是要做新增课程信息的操作（因为在新增入数据库库之后才会把自增ID放到course对象里）
        //如果ID不为空（前端是把courseID放在隐藏域中），说明这时已经在指定要修改的course了，就进行更新操作
        if (courseVO.getId() == null){
            courseService.saveCourseOrTeacher(courseVO);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增成功", null);
            return responseResult;
        }else {
            courseService.updateCourseOrTeacher(courseVO);
            ResponseResult responseResult = new ResponseResult(true, 200, "修改成功", null);
            return responseResult;
        }
    }

    /*
        根据ID查询具体的课程信息及关联的讲师信息（可用于回显）
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(@RequestParam("id") Integer idddd){
        CourseVO courseVO = courseService.findCourseById(idddd);
        return new ResponseResult(true,200,"根据ID查询成功",courseVO);
    }

    /*
        课程状态修改
     */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam("status") Integer status,@RequestParam("id") Integer id){
        courseService.updateCourseStatus(id,status);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true,200,"课程状态变更成功",map);
    }






















}
