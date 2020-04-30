package org.geekbang.spring.ioc.overview.container;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Description: 注解能力 {@link:ApplicationContext} 作为IoC容器示例 <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/23 23:27
 * @Version: 1.0
 */
//@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类AnnotationApplicationContextAsIoCContainerDemo 作为配置类
        ((AnnotationConfigApplicationContext) applicationContext)
                .register(AnnotationApplicationContextAsIoCContainerDemo.class);
        //启动应用上下文
        ((AnnotationConfigApplicationContext) applicationContext)
                .refresh();
        // 依赖查找集合对象
        lookupCollectionType(applicationContext);

        //关闭或者停止应用上下文
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Bean
    public User user() {
        return User.builder().id(2).name("小马哥").build();
    }

    private static void lookupCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有的User 集合对象:" + users);
        }
    }

}
