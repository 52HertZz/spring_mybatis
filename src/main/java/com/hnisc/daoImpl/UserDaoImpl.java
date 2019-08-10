package com.hnisc.daoImpl;

import com.hnisc.dao.UserDao;
import com.hnisc.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;


import java.util.List;

/**
 * @author lh141
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    //按id查询
    public User findUserById(Integer id) {
        //sqlSesion是线程不安全的,所以它的最佳使用范围在方法体内
        SqlSession session = this.getSqlSession();
        User user= session.selectOne("test.findUserById",id);
        return user;
    }

    //按用户名查询
    public List<User> findUserByUserName(String userName) {
        SqlSession session = this.getSqlSession();
        List<User> list = session.selectList("findUserByUserName",userName);
        return list;
    }
}
