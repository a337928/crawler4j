package edu.uci.ics.crawler4j.download.config;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by wangtao on 2017/7/8.
 */
public class DataConfig {
    public void init(){
        String resource = "mybatis-config.xml"; //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = DataConfig.class.getClassLoader().getResourceAsStream(resource); //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();


    }

    public static void main (String args[]){
        DataConfig dc = new DataConfig();
        dc.init();
    }
}
