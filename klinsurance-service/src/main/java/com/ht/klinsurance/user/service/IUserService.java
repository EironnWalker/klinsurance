package com.ht.klinsurance.user.service;


import com.ht.klinsurance.user.model.User;

import java.util.List;
import java.util.Map;

/**
 * 用户信息（主要是包含登录信息）
 * @author liuqi
 * @date 2016/7/18
 */
public interface IUserService {

    /**
     * 
     * 登录(弃用)
     * @author liuqi
     * @date 2016/7/18
     */
    Map<String,Object> findUserLogin(User user);

    /**
     * 根据用户名查询用户信息（用于登录后的信息查询）
     * @param parameter
     * @return
     */
    List<User> findUserByUserName(Map<String, Object> parameter);

    int addUser(User user);

}
