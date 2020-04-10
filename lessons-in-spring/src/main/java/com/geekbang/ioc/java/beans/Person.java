package com.geekbang.ioc.java.beans;

import lombok.Data;

/**
 * Description: 描述人的pojo类
 * Setter/Getter方法
 * 可写方法(Writable)/ 可读方法(Readable)
 *
 * @Author: zhao.song
 * @Date: 2020/4/6 22:08
 * @Version: 1.0
 */
//@Data  不适用于内省技术
public class Person extends Object {

    //String to String
    String name;//Property
    //String to Integer
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
