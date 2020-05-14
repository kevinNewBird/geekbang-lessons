package org.geekbang.spring.ioc.overview.domain;

import lombok.*;

import java.util.ArrayList;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/9 23:22
 * @Version: 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Integer id;
    private String name;

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.size());

        list.clear();
        System.out.println(list.size());
        for (Object o : list) {
            System.out.println("+++++++");
        }
        list.add(1);
        System.out.println(list);
    }


    /**
     * Description: 通过静态方法创建Bean(第四章) <BR>
     *
     * @param :
     * @return org.geekbang.spring.ioc.overview.domain.User
     * @author zhao.song    2020/5/4 10:57
     */
    public static User createUser() {
        User user = new User();
        user.setId(11);
        user.setName("test factory bean");
        return user;
    }
}
