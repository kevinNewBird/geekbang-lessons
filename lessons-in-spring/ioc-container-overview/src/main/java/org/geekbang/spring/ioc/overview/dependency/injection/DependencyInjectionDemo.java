package org.geekbang.spring.ioc.overview.dependency.injection;

import org.geekbang.spring.ioc.overview.annotation.Super;
import org.geekbang.spring.ioc.overview.domain.User;
import org.geekbang.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Map;

/**
 * Description: 依赖注入示例<BR>
 * 1.通过名称或类型的方式
 * 2.通过容器内建里面的Bean  或非容器内建里的Bean
 * 3.
 *
 * @Author: zhao.song
 * @Date: 2020/4/9 23:11
 * @Version: 1.0
 */
public class DependencyInjectionDemo {


    /**
     * Tip: 依赖注入的三种来源
     * <p>
     *     1.自定义的Bean, 如UserRepository
     *     2.依赖注入(内建依赖),如BeanFactory({@link:org.geekbang.spring.ioc.overview.repository.UserRepository})
     *     3.容器内建Bean , 如Environment
     * </p>
     *
     */

    /**
     * BeanFactory、ObjectFactory、FactoryBean三者的区别：
     * <p>
     *
     * </p>
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperties().getProperty("file.encoding"));
        // 配置XML  配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        // 依赖注入来源1:  自定义的Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository);
        // 依赖注入来源2:  依赖注入--获取到内建依赖
        System.out.println(userRepository.getBeanFactory());
//        System.out.println(userRepository.getBeanFactory() == beanFactory);
        //依赖查找--抛出错误,说明不是一个Bean对象(Spring内建的非Bean)
//        System.out.println(beanFactory.getBean(BeanFactory.class));
//        System.out.println(userRepository.getObjectFactory().getObject());//UserRepository注入的泛型为User
        System.out.println(userRepository.getObjectFactory()/*.getObject().getBean("user")*/);
        System.out.println(userRepository.getObjectFactory().getObject()/*.getBean("user")*/);
        System.out.println(userRepository.getObjectFactory().getObject() == beanFactory);

        // 依赖注入来源3: 容器内建Bean
        Environment env = beanFactory.getBean(Environment.class);
        System.out.println("Acquire Type of the Environment Bean: " + env);
    }

    private static void whoIsTrueContainer(UserRepository userRepository, BeanFactory beanFactory) {
        //这个表达式为什么不成立?
        //ConfigurableApplicationContext 继承ApplicationContext 继承 BeanFactory
        // ConfigurableApplicationContext#getBeanFactory
        Assert.isTrue(userRepository.getBeanFactory() == beanFactory, "是否成立?");

        //Application is BeanFactory
        //Official Spec:
        //1.The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object
        //2.ApplicationContext is a sub-interface of BeanFactory. It adds:
        //  1).Easier integration with Spring’s AOP features                //简化了和spring aop的整合
        //  2).Message resource handling (for use in internationalization)  //消息资源处理(用于国际化)
        //  3).Event publication                                            //事件发布
        //  4).Application-layer specific contexts such as the WebApplicationContext for use in web applications.
        //                                                                 //应用级别的上下文(如webapplicationContext,用于web使用场景)

        //Summary:
        //In short, the BeanFactory provides the configuration framework and basic functionality,
        // and the ApplicationContext adds more enterprise-specific functionality. The ApplicationContext
        // is a complete superset of the BeanFactory and is used exclusively in this chapter
        // in descriptions of Spring’s IoC container. For more information on using the BeanFactory
        // instead of the ApplicationContext, see The BeanFactory.

        //总结:
        //简言之, BeanFactory是提供一个配置的框架和基本的功能,而ApplicationContext提供更多的企业级特有的功能.
        //(换言之,BeanFactory是一个很基本的容器,而ApplicationContext是它的一个超集)
        //ApplicationContext是一个完整的
    }

}
