package com.geekbang;


import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: zhao.song
 * @Date: 2020/4/3 12:23
 * @Version: 1.0
 */
public class DemoTest {

    /**
     * Description: <BR>
     *
     * @param :
     * @return void
     * @author zhao.song    2020/4/3 12:26
     */
    public static void print() {
        System.out.println("ssss");
    }

    public static void main(String[] args) {
       /* print();
        List<Integer> list = Stream.of(1, 2, 44, 4).collect(Collectors.toList());
        System.out.println(list);
        List<Integer> newList = JSON.parseArray(JSON.toJSONString(list), Integer.class);
        System.out.println(newList);

        System.out.println("=========================");
        newList.remove(0);
        System.out.println(newList);*/
        String json = "{\n" +
                "    \"uid\": 7395925079,\n" +
                "    \"appkey\": \"2910492351\",\n" +
                "    \"scope\": \"\",\n" +
                "    \"create_at\": 1585638918,\n" +
                "    \"expire_in\": 1849186\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        System.out.println(jsonObject);
        System.out.println(jsonObject.getLong("expire_in")<=0L);
        System.out.println(jsonObject.has("error2"));
//        System.out.println(jsonObject.getString("error2"));

    }
}
