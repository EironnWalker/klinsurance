package com.ht.klsync2.user.mapper;

import com.ht.klsync2.user.model.UserHaha;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHahaMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserHaha record);

    int insertSelective(UserHaha record);

    UserHaha selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserHaha record);

    int updateByPrimaryKey(UserHaha record);
}