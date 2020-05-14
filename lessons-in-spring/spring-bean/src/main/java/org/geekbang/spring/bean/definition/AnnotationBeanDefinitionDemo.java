package org.geekbang.spring.bean.definition;

import lombok.Data;
import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Description: 注册Spring Bean <BR>
 * 1.XML配置, <bean name="..."  .../>
 * 2.Java注解配置元信息
 * -@Bean
 * -@Component
 * -@Import
 * 3.Java API配置元信息
 * <p>
 * <p>
 * 2.特殊方式:
 * 通过BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
 *
 * @Author: zhao.song
 * @Date: 2020/5/3 22:31
 * @Version: 1.0
 */
// 3.通过@Import来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)  //通过@Import来进行导入
public class AnnotationBeanDefinitionDemo {

    /**
     * Description: 2.特殊实现方式 <BR>
     * a).通过BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
     *
     * @param args:
     * @return void
     * @author zhao.song    2020/5/6 20:42
     */
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 2.Java注解配置元信息
        // 2.1.将当前Config类作为配置类并通过@Bean方式定义
//        context.register(Config.class);
        context.register(AnnotationBeanDefinitionDemo.class); // 结合@Import才生效
        // 2.2.通过@Component
        // 2.3.通过@Import来进行导入


        // 3.Java API配置元信息
        // 3.1.通过BeanDefinition注册API实现
        // 命名Bean方式
        registerBeanDefinition(context, "mercyblitz-user", User.class);
        // 非命名Bean方式
        registerBeanDefinition(context, User.class);
        //启动上下文
        context.refresh();
        // 按照类型依赖查找
        Map<String, Config> configBeans = context.getBeansOfType(Config.class);
        Map<String, User> userBeans = context.getBeansOfType(User.class);
        System.out.println("Config Bean 的所有实例:" + configBeans);
        System.out.println("User Bean 的所有实例:" + userBeans);

        // 关闭Spring上下文
        context.close();
    }

    /**
     * Description: 命名Bean 的注册方式 <BR>
     *
     * @param registry:
     * @param beanName:
     * @param beanClass:
     * @return void
     * @author zhao.song    2020/5/3 23:45
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        builder.addPropertyValue("id", 1).addPropertyValue("name", "beanDefiniton");
        //获取BeanDefinition实例
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        //注册BeanDefinition
        if (StringUtils.hasText(beanName)) {
            //命名Bean方式
            registry.registerBeanDefinition(beanName, beanDefinition);
            return;
        }
        //非命名Bean方式
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass) {
        registerBeanDefinition(registry, null, beanClass);
    }

    //2.通过 @Component 方式( 可能未生效? )
//    @Component  //定义当前类作为 Spring Bean(组件) ==等同于context.register(Config.class)
    public static class Config {
        /**
         * Description: 注册的Bean以方法名作为唯一标识,也支持自定义<BR>
         *
         * @param :
         * @return org.geekbang.spring.ioc.overview.domain.User
         * @author zhao.song    2020/5/3 22:42
         */
        @Bean(name = {"user", "cususer"})
        public User buildUser() {
            User user = new User();
            user.setId(1);
            user.setName("kevin");
            return user;
        }

    }


}


