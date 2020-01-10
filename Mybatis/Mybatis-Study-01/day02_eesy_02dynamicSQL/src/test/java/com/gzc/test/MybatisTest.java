package com.gzc.test;

import com.gzc.dao.IUserDao;
import com.gzc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
        }

     @After
     public void destroy()throws Exception{
     //提交事务
     session.commit();
     //6.释放资源
     session.close();
      in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }
    /**
     * 测试根据id查询操作
     */
    @Test
    public void testFindOne(){
        User user=userDao.findById(48);
        System.out.println(user);
    }
    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindByCondition(){
        User u = new User();
        u.setUserName("老王");
        //5.执行查询所有方法
        List<User> users = userDao.findUserByCondition(u);
        for(User user : users){
            System.out.println(user);
        }

    }
}
