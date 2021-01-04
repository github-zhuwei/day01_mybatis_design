package com.itheima.mybatis.sqlsession;

/**
 * @author zhuwei
 * @createdate 2020/12/6 - 18:21
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
