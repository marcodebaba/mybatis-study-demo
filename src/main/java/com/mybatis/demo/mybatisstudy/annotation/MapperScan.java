package com.mybatis.demo.mybatisstudy.annotation;

import com.mybatis.demo.mybatisstudy.registar.MyBatisBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyBatisBeanDefinitionRegistrar.class)

public @interface MapperScan {
    String value();
}
