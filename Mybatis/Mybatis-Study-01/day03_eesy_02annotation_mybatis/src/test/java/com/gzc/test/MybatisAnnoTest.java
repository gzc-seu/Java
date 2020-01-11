package com.gzc.test;

import com.gzc.dao.IUserDao;
import com.gzc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws  Exception{
        //1.获取字节输入流
        InputStream rs = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流构建sqlsessionfactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(rs);
        //3.得到sqlsession
        SqlSession sqlSession = factory.openSession();
        //4.根据sqlsession得到dao的代理对象
        IUserDao userdao = sqlSession.getMapper(IUserDao.class);
        //5.执行代理对象的方法
        List<User> users =userdao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
