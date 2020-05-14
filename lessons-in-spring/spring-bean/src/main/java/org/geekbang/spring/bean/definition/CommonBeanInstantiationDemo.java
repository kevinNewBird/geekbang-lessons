package org.geekbang.spring.bean.definition;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: Bean 实例化示例 <BR>
 * 1.常规方式
 * 2.特殊方式
 *
 * @Author: zhao.song
 * @Date: 2020/5/4 10:59
 * @Version: 1.0
 */
public class CommonBeanInstantiationDemo {


    //1.常规方式
    public static void main(String[] args) {
        //创建BeanFactory
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        //通过静态方法
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean",User.class);
        System.out.println(user);
        System.out.println(userByFactoryBean);
        //通过工厂方式
        User userFactory = beanFactory.getBean("user-by-factory", User.class);

        System.out.println(userFactory);
    }

}
