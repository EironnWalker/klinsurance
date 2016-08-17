package com.ht;

import com.ht.klsync.user.mapper.UserMapper;
import com.ht.klsync.user.model.User;
import com.ht.klsync2.user.mapper.UserHahaMapper;
import com.ht.klsync2.user.model.UserHaha;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class LoadServiceImpl implements ILoadService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserHahaMapper userHahaMapper;

    @Override
    public void test() {
        User user = new User();
        user.setUserId("1");
        user.setLoginName("1");
        user.setLoginPwd("1");
        user.setName("1");
        user.setNamePinyin("1");
        user.setCreateTime(new Date());
        userMapper.insert(user);

        UserHaha userHaha = new UserHaha();
        userHaha.setUserId("1");
        userHaha.setLoginName("1");
        userHaha.setLoginPwd("1");
        userHaha.setName("1");
        userHaha.setNamePinyin("1");
        userHaha.setCreateTime(new Date());
        userHahaMapper.insert(userHaha);
    }
}
