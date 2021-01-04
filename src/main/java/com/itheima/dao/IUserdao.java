package com.itheima.dao;

import com.itheima.domin.User;
import com.itheima.mybatis.annotations.Select;

import java.util.List;

/**
 * @author zhuwei
 * @createdate 2020/12/6 - 11:46
 */
public interface IUserdao {
    /**
     * 查询所有的操作
     */
    @Select("select * from user")
    List<User> findAll();
}
