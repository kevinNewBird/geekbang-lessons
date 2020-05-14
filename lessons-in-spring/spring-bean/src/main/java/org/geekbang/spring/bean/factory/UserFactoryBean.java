package org.geekbang.spring.bean.factory;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/5/6 20:32
 * @Version: 1.0
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
