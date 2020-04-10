package org.geekbang.spring.ioc.overview.dependency.lookup;

import org.geekbang.spring.ioc.overview.annotation.Super;
import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Description: 依赖查找示例<BR>
 * 1.通过名称的方式
 * 2.通过类型的方式
 *
 * @Author: zhao.song
 * @Date: 2020/4/9 23:11
 * @Version: 1.0
 */
public class DependencyLookupDemo {

    /**
     * BeanFactory、ObjectFactory、FactoryBean三者的区别：
     * <p>
     * FactoryBean留待自己去掘金
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 配置XML  配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        //1.通过名称的方式--实时查找/延迟查找
        lookupInLazy(beanFactory);
        lookupInRealTime(beanFactory);
        //2.通过类型的方式--查询单个或集合实例
        lookupByType(beanFactory);//单个实例
        lookupCollectionType(beanFactory);//集合实例
        //3.根据Bean 名称+类型 查找

        //4.通过注解的方式查找对象
        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的User 集合对象:" + beansWithAnnotation);
        }
    }
//    start--------------查询集合实例-----------------------------------

    /**
     * Description: 实时查找(类型)-- ListableBeanFactory测试<BR>
     *
     * @param beanFactory:
     * @return void
     * @author zhao.song    2020/4/10 17:11
     */
    private static void lookupCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有的User 集合对象:" + users);
        }
    }//    end--------------查询集合实例-----------------------------------




//    start--------------查询单个实例-----------------------------------

    /**
     * Description: 实时查找(类型)--BeanFactory测试  <BR>
     *
     * @param beanFactory:
     * @return void
     * @author zhao.song    2020/4/10 17:11
     */
    public static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找--类型:" + user);
    }

    /**
     * Description: 实时查找(名称)--BeanFactory测试 <BR>
     *
     * @param :
     * @return void
     * @author zhao.song    2020/4/9 23:47
     */
    public static void lookupInRealTime(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
//        user.setId(1);
//        user.setName("kevin");
        System.out.println("实时查找--名称:" + user);
    }

    /**
     * Description: 延迟查找(名称)--ObjectFactory测试 <BR>
     * {@link:org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean}
     *
     * @param :
     * @return void
     * @author zhao.song    2020/4/9 23:47
     */
    public static void lookupInLazy(BeanFactory beanFactory) {
        //ObjectFactory并没有生成新的对象
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找--名称:" + user);
    }//    end--------------查询单个实例-----------------------------------

    @Deprecated
    public static void lookupSelfByFactoryBean(BeanFactory beanFactory) throws Exception {
        FactoryBean bean =
                (FactoryBean) beanFactory.getBean("factoryBean");
        Object factoryBean = bean.getObject();
        System.out.println(bean.getObjectType().getName());
    }

}
