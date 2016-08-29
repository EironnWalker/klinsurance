package com.ht.klinsurance.synce.impl;

import com.ht.klinsurance.synce.ISynceDataService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author feicy
 * @date 2016/8/20
 */
@Service
@Transactional
public class TaskService {

    @Resource
    private ISynceDataService synceDataService;
    /**
     * 定时任务每天凌晨执行
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void task(){
        synceDataService.synceUser();
        synceDataService.synceCustomer();
        synceDataService.synceLossItem();
        synceDataService. synceHistoryPriceInfo();
    }
}
