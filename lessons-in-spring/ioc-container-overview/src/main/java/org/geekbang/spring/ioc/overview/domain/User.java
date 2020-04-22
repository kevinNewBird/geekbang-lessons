package org.geekbang.spring.ioc.overview.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
}
