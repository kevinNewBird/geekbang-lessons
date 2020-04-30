package org.geekbang.spring.ioc.overview.dependency;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/28 0:22
 * @Version: 1.0
 */
public class FactoryBeanServiceImpl implements FactoryBeanService {
    @Override
    public void testFactoryBean() {
        System.out.println("我是FactoryBean的一个测试类!");
    }
}
