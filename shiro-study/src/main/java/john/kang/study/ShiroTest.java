package john.kang.study;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTest {

    private Logger logger = LoggerFactory.getLogger(ShiroTest.class);

    @Test
    public void testUser(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try{
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("is authenticated: " + subject.isAuthenticated());
        System.out.println("is authenticated: " + subject.isAuthenticated());
        Assert.assertEquals(true, subject.isAuthenticated());

        //logout
        subject.logout();
    }
}
