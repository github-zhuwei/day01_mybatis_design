package com.itheima.mybatis.sqlsession.defaults;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlsession.SqlSession;
import com.itheima.mybatis.sqlsession.proxy.MapperProxy;
import com.itheima.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author zhuwei
 * @createdate 2020/12/6 - 19:16
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession{
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     *
     *
     * 创建的代理对象：
     * 涉及的类：Proxy
     * 涉及的方法：newProxyInstance
     * 方法的参数：
     *      ClassLoader:类加载器，用于加载代理对象的字节码和被代理对象使用相同的类加载器。
     *      Class[]:字节码数组。用于让代理对象和被代理对象有相同的行为（具有相同的方法），和被代理对象实现相同的接口。
     *      InvocationHandler:增强的代码。需要使用者提供增强的代码。该代码是以接口的实现类方式提供的，通常会用匿名内部类的，但不绝对
     *
     *
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));

    }


    /**
     * 用于释放资源
     */
    @Override
    public void close() {

        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
