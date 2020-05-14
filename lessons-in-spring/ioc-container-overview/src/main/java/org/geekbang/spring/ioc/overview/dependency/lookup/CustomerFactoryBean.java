package org.geekbang.spring.ioc.overview.dependency.lookup;

import org.geekbang.spring.ioc.overview.dependency.FactoryBeanService;
import org.geekbang.spring.ioc.overview.dependency.FactoryBeanServiceImpl;
import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Description: FactoryBean简单使用 <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/10 10:00
 * @Version: 1.0
 */
//@Component(通过注解方式或者通过XML引入)
public class CustomerFactoryBean implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        //这个Bean是我们自己new的，这里我们就可以控制Bean的创建过程了
        return new FactoryBeanServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
