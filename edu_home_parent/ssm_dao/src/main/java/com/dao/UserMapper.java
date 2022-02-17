package com.dao;

import com.domain.User;
import com.domain.UserVO;

import java.util.List;

public interface UserMapper {

    /*
        用户分页&多条件组合查询
     */
    public List<User> findAllUserByPage(UserVO userVO);

    /*
    登陆
     */
    public User login(User user);

    
    public void aaaaaaaaaaaaaaaaaaaaaaa();

}
