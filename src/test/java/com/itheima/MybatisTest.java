package com.itheima;

import com.itheima.dao.IUserdao;
import com.itheima.domin.User;
import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.sqlsession.SqlSession;
import com.itheima.mybatis.sqlsession.SqlSessionFactory;
import com.itheima.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

/**
 * @author zhuwei
 * @createdate 2020/12/6 - 12:18
 */
public class MybatisTest {
    /**
     * 利用主函数来测试相关的mybatis配置文件（利用的是xml文件）
     */

    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserdao userdao = session.getMapper(IUserdao.class);
        //5.使用代理对象执行方法
        List<User> users = userdao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        inputStream.close();

//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(inputStream);
//        IUserdao userdao = new UserDaoImpl(factory);//使用工厂方法进行查询
//        List<User> users = userdao.findAll();
//        for (User user : users){
//            System.out.println(user);
//        }
//        //释放io资源
//        inputStream.close();


    }
}
