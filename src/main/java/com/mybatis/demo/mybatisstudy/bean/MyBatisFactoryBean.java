package com.mybatis.demo.mybatisstudy.bean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author marco pan
 * @ClassName MyBatisFactoryBean
 * @Description 因为Spring无法把接口放到IOC容器中，所以通过FactoryBean将Mapper代理对象放到IOC容器中
 * @date 2021年10月01日 10:26 上午
 */
public class MyBatisFactoryBean implements FactoryBean {
    //private Logger logger = LoggerFactory.getLogger(MyBatisFactoryBean.class);
    /**
     * 实际上传进来的是mapper接口
     */
    private Class mapperInterface;

    private SqlSession sqlSession;

    public MyBatisFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() {
        // 返回MyBatis为mapper接口生成的代理对象
        return sqlSession.getMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
