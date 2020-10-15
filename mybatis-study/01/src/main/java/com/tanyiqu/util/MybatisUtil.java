package com.tanyiqu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//import javax.annotation.Resources;

/**
 * mybatis工具类
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            InputStream inputStream = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
