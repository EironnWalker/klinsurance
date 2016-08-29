package com.ht.klinsurance.user.service.impl;

import com.ht.klinsurance.user.mapper.UserMapper;
import com.ht.klinsurance.user.model.User;
import com.ht.klinsurance.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户信息（主要是包含登录信息）
 * @author liuqi
 * @date 2016/7/18
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{
    @Resource
    private UserMapper userMapper;
    /**
     *
     * 登录
     * @author liuqi
     * @date 2016/7/18
     */
    @Override
    public Map<String, Object> findUserLogin(User user) {
        Map<String,Object> returnMap = new HashMap<>();
        List<User> list = userMapper.findListByParam(user);
        if (list.size() == 1) {
            returnMap.put("result","1");
            returnMap.put("data",list.get(0));
        }else if(list.size() > 1){
            returnMap.put("result","账号重复");
        }else{
            returnMap.put("result","账号或者密码错误");
        }
        return returnMap;
    }

    /**
     * 根据用户名查询用户信息（用于登录后的信息查询）
     *
     * @param parameter
     * @return
     */
    @Override
    public  List<User> findUserByUserNameLogin(Map<String, Object> parameter) {
        return userMapper.findUserByUserNameLogin(parameter);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
