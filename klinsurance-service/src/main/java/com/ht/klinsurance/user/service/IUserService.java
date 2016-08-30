package com.ht.klinsurance.user.service;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
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
    List<User> findUserByUserNameLogin(Map<String, Object> parameter);


    /**
     * 分页查询用户信息
     * @param parameter
     * @return
     */
    List<User> findUserPageList(Map<String, Object> parameter,PageBounds pageBounds);

    /**
     * 用户列表查询
     * 用于验证账号唯一性
     * @param parameter
     * @return
     */
    List<User> findUserList(Map<String, Object> parameter);

    /**
     * 设置是否禁用用户
     */
    int updateUser(User user);

    /**
     * 添加系统用户
     * @param user
     * @return
     */
    int addSysUser(User user);

}
