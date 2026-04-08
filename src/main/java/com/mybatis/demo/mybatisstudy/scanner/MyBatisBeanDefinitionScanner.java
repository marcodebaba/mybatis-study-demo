package com.mybatis.demo.mybatisstudy.scanner;

import com.mybatis.demo.mybatisstudy.bean.MyBatisFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author marco pan
 * @ClassName MyBeanDefinitionScanner
 * @Description 自定义扫描器
 * @date 2021年10月01日 12:01 上午
 */
public class MyBatisBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public MyBatisBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * 扫描到的对象是否可以作为Bean放入容器
     * MyBatis扫描的mapper都是接口，所以要重写该方法，因为Spring默认的扫描器只扫描类
     *
     * @param beanDefinition
     * @return true or false
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        // 扫描指定路径下的接口
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();
            // 设置MyBatisFactoryBean的构造函数入参，给FactoryBean的mapperInterface赋值
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            // 设置BeanClassName为MyBatisFactoryBean
            beanDefinition.setBeanClassName(MyBatisFactoryBean.class.getName());
        }
        return beanDefinitionHolders;
    }
}
