package com.mybatis.demo.mybatisstudy.registar;

import com.mybatis.demo.mybatisstudy.annotation.MyBatisMapperScan;
import com.mybatis.demo.mybatisstudy.scanner.MyBatisBeanDefinitionScanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyBatisBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyBatisMapperScan.class.getName());
        MyBatisBeanDefinitionScanner scanner = new MyBatisBeanDefinitionScanner(registry);
        // 设置扫描器，让mapper能够被scanner扫描到(Spring默认只会扫描到带有@Component的类)
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
        assert annotationAttributes != null;
        // 扫描Mapper，生成BeanDefinition
        scanner.scan((String) annotationAttributes.get("value"));
    }
}
