package com.itheima.mybatis.cfg;

/**
 * @author zhuwei
 * @createdate 2020/12/6 - 18:47
 * 用于封装执行的SQL语句和结果的全限定类名
 */
public class Mapper {
    private String queryString;//SQL
    private String resultType;//实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
