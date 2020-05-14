package org.geekbang.spring.bean.definition;

import org.geekbang.spring.bean.factory.DefaultUserFactory;
import org.geekbang.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/5/13 0:11
 * @Version: 1.0
 */
@Configuration // Configuration Class
public class BeanInitializationDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册Configuration 配置类
        context.register(BeanInitializationDemo.class);

        //启动容器
        context.refresh();

        //非延迟初始化在Spring 应用上下文启动完成后 , 被初始化
        System.out.println("-> Spring 应用上下文已启动\n");
        //依赖查找
        UserFactory userFactory = context.getBean(UserFactory.class);
        System.out.println(userFactory);
//        System.out.println(userFactory.createUser());

        System.out.println("\n-> Spring 应用上下文准备关闭...\n");
        //关闭容器
        context.close();

        System.out.println("\n-> Spring 应用上下文已关闭...\n");
    }


    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
//    @Lazy   //延迟初始化Bean
    public UserFactory userFactory() {
        return new DefaultUserFactory();

    }
}
