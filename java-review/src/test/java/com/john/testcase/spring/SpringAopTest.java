package com.john.testcase.spring;

import com.john.spring.aop.IGoodsDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopTest {

    @Test
    public void testAop(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        IGoodsDao goodsDao = (IGoodsDao)ac.getBean("goodsDao");
        goodsDao.addGoods();
        goodsDao.deleteGoods();
    }
}
