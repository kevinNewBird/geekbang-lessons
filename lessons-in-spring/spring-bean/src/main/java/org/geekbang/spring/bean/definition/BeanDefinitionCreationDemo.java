package org.geekbang.spring.bean.definition;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Description: BeanDefinition构建示例 <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/30 17:53
 * @Version: 1.0
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //1. 通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置(这种类似于xml配置的方式)
        builder.addPropertyValue("name", "小马哥")
                .addPropertyValue("id", 18);
        //获取BeanDefinition实例
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        //BeanDefinition并非 Bean 最终状态, 可以自定义修改

        //2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        //通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("name", "小马哥");
//        propertyValues.addPropertyValue("id", 18);
        propertyValues.add("name", "小马哥").add("id", 18);
        //通过 Set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
