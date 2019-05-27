package john.kang.study;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ShiroTest {

    @Test
    public void testUser(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath: shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try{
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated());
    }
}
