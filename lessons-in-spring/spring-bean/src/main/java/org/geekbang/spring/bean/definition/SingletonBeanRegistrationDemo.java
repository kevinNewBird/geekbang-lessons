package org.geekbang.spring.bean.definition;

import org.geekbang.spring.bean.factory.DefaultUserFactory;
import org.geekbang.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: 单体Bean注册示例<BR>
 *
 * @Author: zhao.song
 * @Date: 2020/5/14 15:01
 * @Version: 1.0
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //创建 一个 外部单例对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //注册外部单例对象
        beanFactory.registerSingleton("userFactory", userFactory);

        //启动容器
        context.refresh();

        //依赖查找
        UserFactory userFactoryByLookUp = beanFactory.getBean("userFactory", UserFactory.class);
        //关闭容器
        context.close();


        System.out.println("userFactory == userFactoryByLookUp:" + (userFactory == userFactoryByLookUp));
    }
}
