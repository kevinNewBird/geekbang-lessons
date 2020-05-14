package org.geekbang.spring.bean.definition;

import org.geekbang.spring.bean.factory.DefaultUserFactory;
import org.geekbang.spring.bean.factory.UserFactory;
import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Description: Bean 实例化示例 <BR>
 * 1.常规方式
 * 2.特殊方式
 * <p>
 * <p>
 * 2.特殊方式:
 * 通过ServiceLoaderFactoryBean（配置元信息：XML、Java 注解和Java API ）--本类实现的特殊方式示例
 * <p>
 * 说明:ServiceLoader为jdk所特有的一个类(对应META-INF/services) , ServiceLoaderFactoryBean是Spring参考jdk做的
 *
 * @Author: zhao.song
 * @Date: 2020/5/4 10:59
 * @Version: 1.0
 */
public class SpecialBeanInstantiationDemo {


    /**
     * Description: 2.特殊方式 <BR>
     * a).{@link:org.geekbang.spring.bean.definition.AnnotationBeanDefinitionDemo}
     * --通过BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
     * b).通过ServiceLoaderFactoryBean（配置元信息：XML、Java 注解和Java API ）
     * c).通过AutowireCapableBeanFactory#createBean(java.lang.Class, int, boolean)
     *
     * @param args:
     * @return void
     * @author zhao.song    2020/5/6 20:44
     */
    public static void main(String[] args) {

        //b).通过ServiceLoaderFactoryBean（配置元信息：XML、Java 注解和Java API ）
        //创建BeanFactory
/*        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        getInstance(serviceLoader);

        //ServiceLoader的实现
        getInstanceByJdkServiceLoader();*/


        //----------------------------------------
        //c).通过AutowireCapableBeanFactory#createBean(java.lang.Class, int, boolean)
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        AutowireCapableBeanFactory autowireBeanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> serviceLoader = autowireBeanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        getInstance(serviceLoader);

        //ServiceLoader的实现
        getInstanceByJdkServiceLoader();
        //创建Bean
        UserFactory userFactory = autowireBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());

    }


    /**
     * Description: JDK的ServiceLoader的实现 <BR>
     * <p>
     * JDK中的反向控制
     *
     *
     * @param :
     * @return void
     * @author zhao.song    2020/5/6 23:33
     */
    public static void getInstanceByJdkServiceLoader() {
        //通过JDK的ServiceLoader加载实例(META-INF/services)
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader
                .load(UserFactory.class, SpecialBeanInstantiationDemo.class.getClassLoader()/*Thread.currentThread().getContextClassLoader()*/);
        getInstance(serviceLoader);

    }

    public static void getInstance(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().createUser());
        }
    }

}
