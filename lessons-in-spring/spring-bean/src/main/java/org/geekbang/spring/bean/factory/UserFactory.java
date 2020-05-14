package org.geekbang.spring.bean.factory;

import org.geekbang.spring.ioc.overview.domain.User;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/5/4 11:59
 * @Version: 1.0
 */
public interface UserFactory {

    public User createUser();
}
