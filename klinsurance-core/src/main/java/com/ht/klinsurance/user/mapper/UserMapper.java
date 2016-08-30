package com.ht.klinsurance.user.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    User selectByPrimaryKey(String userId);

    List<User> findListByParam(User user);

    List<User> findList(Map<String, Object> parameter);

    List<User> findUserByUserNameLogin(Map<String, Object> parameter);


    /**
     * 批量查询用户
     * @param ids
     * @return
     */
    List<User> findByIds(String[] ids);

    /**
     * 分页查询用户信息
     * @param parameter
     * @param pageBounds
     * @return
     */
    List<User> findUserPageList(Map<String, Object> parameter,PageBounds pageBounds);

    int addUser(User record);

    int addUserList(List<User> list);

    int updateUser(User record);

    int deleteByPrimaryKey(String userId);

    int deleteAll();

    int saveorupdateUser(User user);
}