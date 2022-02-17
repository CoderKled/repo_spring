package com.service.impl;

import com.dao.UserMapper;
import com.domain.User;
import com.domain.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import com.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVO userVO) {
        PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
        List<User> userList = userMapper.findAllUserByPage(userVO);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);

        return userPageInfo;
    }

    @Override
    public User login(User user) throws Exception {
        User user1 = userMapper.login(user);
        if(user1 != null && Md5.verify(user.getPassword(),"lagou",Md5.md5(user1.getPassword(),"lagou"))){
            return user1;
        }else {
            return null;
        }
    }
}
