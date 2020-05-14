package org.geekbang.spring.bean.factory;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/5/4 12:00
 * @Version: 1.0
 */
//3.实现InitializingBean
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    @Override
    public User createUser() {
        User user = new User();
        user.setId(1);
        user.setName("alienware");
        return user;
    }

    /**
     * 1.@PostConstruct说明
     *      被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的inti()方法。
     * 被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
     * <p>
     * 2.@PreDestroy说明
     *      被@PreDestroy修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。
     * 被@PreDestroy修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前。
     */

    //1.基于@PostConstruct注解 ,jdk的基本注解
    @PostConstruct
    public void init() {
        System.out.println("Bean初始化: @PostConstruct注解UserFactory 初始化中...");
    }


    //2.自定义初始化方法
    public void initUserFactory() {
        System.out.println("自定义初始化Bean: UserFactory 初始化中...");
    }


    //1.基于@PreDestroy注解 的 Bean 销毁
    @PreDestroy
    public void preDestroy() {
        System.out.println("Bean销毁: 基于@PreDestroy注解实现");
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean初始化: 实现InitializingBean接口");
    }

    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */

    //2.基于实现DisposableBean完成Bean的销毁
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean销毁: 基于实现DisposableBean接口...");
    }

    public void doDestroy() {
        System.out.println("自定义Bean销毁: destroyMethod...");
    }


    @Override
    protected void finalize() throws Throwable{
        System.out.println("当前 DefaultUserFactory 对象正在被垃圾回收...");
    }
}
