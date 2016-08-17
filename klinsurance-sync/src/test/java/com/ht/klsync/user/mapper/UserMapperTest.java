package com.ht.klsync.user.mapper;

import com.ht.ILoadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-context.xml")
@Component
public class UserMapperTest {

    @Resource
    private ILoadService loadService;

    @Test
    public void test() {
        loadService.test();
    }
}