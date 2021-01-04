package com.itheima.mybatis.io;

/**
 * @author zhuwei
 * @createdate 2020/12/6 - 18:09
 */

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        //第一步拿到当前类的字节码文件，之后是获取这个类的字节码的类加载器，最后是根据类加载器读取相关的配置文件
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
