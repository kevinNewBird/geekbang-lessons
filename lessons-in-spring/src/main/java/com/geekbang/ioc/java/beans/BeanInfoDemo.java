package com.geekbang.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * Description: <BR>
 * (@link:java.beans.BeanInfo)示例
 * @Author: zhao.song
 * @Date: 2020/4/6 22:20
 * @Version: 1.0
 */
public class BeanInfoDemo {


    public static void main(String[] args) throws IntrospectionException {
        //内省技术Introspector
//        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        //
        Stream.of(beanInfo.getPropertyDescriptors())
//                .filter(propertyDescriptor -> !propertyDescriptor.getName().equalsIgnoreCase("class"))
                .forEach(propertyDescriptor -> {

                    //PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    //GUI -> text(String) -> PropertyType
                    // name -> String
                    // age -> Integer
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    if ("age".equalsIgnoreCase(propertyName)) {
                        //String -> Integer
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor()
                    }
                });

    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            super.setAsText(text);
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
