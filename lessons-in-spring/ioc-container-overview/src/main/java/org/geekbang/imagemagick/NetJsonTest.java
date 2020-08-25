package org.geekbang.imagemagick;

import net.sf.json.JSONObject;

import java.util.Hashtable;

/**
 * Description: TODO <BR>
 *
 * @author: zhao.song
 * @date: 2020/6/12 14:24
 * @version: 1.0
 */
public class NetJsonTest {

    public static void main(String[] args) {
        Hashtable<String, Object> props = new Hashtable<>();
        props.put("a", "333");
        props.put("b", "333");
        props.put("c", "333");
        JSONObject jsonObject = JSONObject.fromObject(props);
        System.out.println(jsonObject.toString());

        Hashtable x = (Hashtable)JSONObject.toBean(jsonObject, Hashtable.class);
        System.out.println(x);
    }
}
