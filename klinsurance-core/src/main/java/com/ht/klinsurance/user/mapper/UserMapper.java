package com.ht.klinsurance.user.mapper;

import com.ht.klinsurance.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int deleteAll();

    int addUser(User record);

    int addUserList(List<User> list);

    User selectByPrimaryKey(String userId);

    int updateUser(User record);

    List<User> findListByParam(User user);

    List<User> findList(Map<String, Object> parameter);
}