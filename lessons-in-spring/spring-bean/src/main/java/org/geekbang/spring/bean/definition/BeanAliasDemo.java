package org.geekbang.spring.bean.definition;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: 别名示例 <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/5/3 16:46
 * @Version: 1.0
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        //配置XML 配置文件
        //启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        // 通过别名xiaomage-user 获取曾用名user 的bean
        lookupInRealTime(beanFactory, "xiaomage-user");
        lookupInRealTime(beanFactory, "user");
    }

    public static void lookupInRealTime(BeanFactory beanFactory, String aliasName) {
        //别名获取Bean
        User user = beanFactory.getBean(aliasName, User.class);
//        user.setId(1);
//        user.setName("kevin");
        System.out.println("别名获取实时查找--名称:" + user);
    }
}
