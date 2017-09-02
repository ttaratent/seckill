package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        /*
        第一次：insertCount=1
        第二次：insertCount=0
         */
        long id = 1000L;
        long phone = 13502181181L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone,0);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        /*
         SuccessKilled{seckillId=1000, userPhone=13502181181, state=-1, createTime=Sat Sep 02 11:07:25 CST 2017}
         Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Sep 01 17:41:45 CST 2017}
         */
        long id = 1000L;
        long phone = 13502181181L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}