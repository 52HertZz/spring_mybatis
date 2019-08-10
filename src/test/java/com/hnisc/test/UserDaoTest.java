package com.hnisc.test;

import com.hnisc.dao.UserDao;
import com.hnisc.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author lh141
 */
public class UserDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        //获取UserDao对象, getBean中的字符串是在ApplicationContext.xml中声明的
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
