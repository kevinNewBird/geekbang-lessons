package org.geekbang.spring.ioc.overview.repository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.geekbang.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;

/**
 * Description: 用户信息仓库 <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/16 15:01
 * @Version: 1.0
 */
@Data
public class UserRepository {

    private Collection<User> users;  // 自定义 Bean

    private BeanFactory beanFactory;  //内建的非 Bean 对象(依赖)

//    private ObjectFactory<User> objectFactory;

    private ObjectFactory<ApplicationContext> objectFactory;


    public static void main(String[] args) {
        String s = "素材3";
        String oFileNameOfServer = s.substring(0, s.lastIndexOf(".") > 0 ? s.lastIndexOf(".") : s.length());
        String oFileNamePostfixOfServer = s.substring(s.lastIndexOf(".") > 0 ? s.lastIndexOf(".") + 1 : s.length());
        System.out.println(oFileNameOfServer);
        System.out.println(oFileNamePostfixOfServer);
        File oFile = new File("E:\\deskFile\\trs_work\\工作任务\\新疆融媒体云--新疆日报\\素材\\picture");
        File[] files = oFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String substring = name.substring(0, name.lastIndexOf("."));
                if (s.equals(substring)) {
                    return true;
                }
                return false;
            }
        });
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
    }

}
