package com.ylzInfo;

import com.ylzInfo.bean.Message;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**********************************************************
 * 摘 要： []
 * 初始版本：1.0.0
 * @author LQC
 * 创建日期： 2020/01/08
 *****************************************************************/
public class Test {
    public static void main(String[] args) throws IOException {

        //mybatis的配置文件
        String resource = "mappingConf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）

        InputStream is = Resources.getResourceAsStream(resource);
        //构建sqlSession的工厂

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */

        /* 根据——key查找 */
        String statement = "com.ylzInfo.mapping.MessageMapping.getMessageList";
        //映射sql的标识字符串，getUser与映射文件中配置select标签id一致
        //执行查询返回一个唯一user对象的sql
        List<Message> user = session.selectList(statement);
        System.out.println(user);
    }
}
