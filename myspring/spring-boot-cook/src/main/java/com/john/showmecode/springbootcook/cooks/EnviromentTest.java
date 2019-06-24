package com.john.showmecode.springbootcook.cooks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: kangq
 * @Date: 2019/6/24 16:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnviromentTest {

    @Autowired
    Environment environment;

    @Test
    public void testGetEnvironment(){
        String property = environment.getProperty("test.environment");
        System.out.println("property is: " + property);
    }
}
