package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合,junit启动时加载springioc容器
 * spring-test，junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecKillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SecKillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }
    /*1000元秒杀iphone6
    Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Sep 01 17:41:45 CST 2017}*/

    @Test
    public void queryAll() throws Exception {
        /*Caused by: org.apache.ibatis.binding.BindingException: Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
        * java没有记录形参的记录  --->  quertAll(arg0,arg1)
        * @Param() 给mybatis进行传递参数名
        * */
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill : seckills ) {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        /*
        0
         */
        Date killDate = new Date();
        int updateCount = seckillDao.reduceNumber(1000, killDate);
        System.out.println(updateCount);
    }



}