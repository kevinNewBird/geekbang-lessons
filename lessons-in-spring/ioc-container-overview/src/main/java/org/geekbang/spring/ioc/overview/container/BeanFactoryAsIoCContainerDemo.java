package org.geekbang.spring.ioc.overview.container;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Description: {@link:BeanFactory} 作为IoC容器示例 <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/23 23:27
 * @Version: 1.0
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载资源
        // XML 配置文件的 Classpath路径
        String location = "classpath:META-INF/dependency-lookup-context.xml";
        int beanDefinitionCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 加载的数量:" + beanDefinitionCount);
        // 依赖查找集合对象
        lookupCollectionType(beanFactory);
    }

    private static void lookupCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有的User 集合对象:" + users);
        }
    }

}
