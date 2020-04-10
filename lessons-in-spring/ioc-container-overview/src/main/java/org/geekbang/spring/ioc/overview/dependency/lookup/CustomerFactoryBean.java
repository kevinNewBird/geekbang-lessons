package org.geekbang.spring.ioc.overview.dependency.lookup;

import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/10 10:00
 * @Version: 1.0
 */
public class CustomerFactoryBean implements FactoryBean {
    private String type;


    @Override
    public Object getObject() throws Exception {
        if ("myuser".equalsIgnoreCase(type)) {
            return new User();
        } else {
            return new CustomerFactoryBean();
        }

    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
