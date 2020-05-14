package org.geekbang.spring.bean.definition;

import org.geekbang.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: 垃圾回收 GC <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/5/14 14:20
 * @Version: 1.0
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册Configuration 配置类
        context.register(BeanInitializationDemo.class);

        //启动容器
        context.refresh();
//        context.getBean(UserFactory.class);
        //关闭容器
        context.close();

        //强制触发GC(不一定一定被执行)
        System.gc();

        Thread.sleep(5_000);//确保对象被垃圾回收
    }
}
