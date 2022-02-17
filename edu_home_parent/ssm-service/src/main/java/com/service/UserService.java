package com.service;

import com.domain.User;
import com.domain.UserVO;
import com.github.pagehelper.PageInfo;

public interface UserService {
    /*
        用户分页以及多条件查询
     */
    public PageInfo findAllUserByPage(UserVO userVO);

    /*
        登陆
     */
    public User login(User user) throws Exception;
}
