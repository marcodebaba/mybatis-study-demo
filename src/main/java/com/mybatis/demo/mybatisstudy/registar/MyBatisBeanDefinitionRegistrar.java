package com.mybatis.demo.mybatisstudy.registar;

import com.mybatis.demo.mybatisstudy.annotation.MapperScan;
import com.mybatis.demo.mybatisstudy.scanner.MyBatisBeanDefinitionScanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyBatisBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
    * Description：扫描并注册MapperScan标签的接口
    * @param importingClassMetadata AnnotationMetadata
    * @param registry BeanDefinitionRegistry
    * @param importBeanNameGenerator BeanNameGenerator
    * @author marcopan
    * @date 2026/4/9 10:16
    **/
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        Map<String, Object> mapperAnno = importingClassMetadata.getAnnotationAttributes(MapperScan.class.getName());
        MyBatisBeanDefinitionScanner scanner = new MyBatisBeanDefinitionScanner(registry);
        // 设置扫描器，让mapper能够被scanner扫描到(Spring默认只会扫描到带有@Component的类)
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
        assert mapperAnno != null;
        // 扫描Mapper，生成BeanDefinition
        scanner.scan((String) mapperAnno.get("value"));
    }
}
