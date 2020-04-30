package org.geekbang.html2txt;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/29 13:41
 * @Version: 1.0
 */
public class Html2TextDemoTest {

    public static void main(String[] args) throws Exception {

/*        String originContent="<p>&nbsp; 测试新闻稿</p><p>阿斯 蒂 芬</p><p>水电费</p><p><br/></p><p class=\"app_image_wrap\" type=\"app_image_wrap\" style=\"text-align:center\">" +
                "<img src=\"http://172.16.25.100/media_resource/img/xjbucket3/5664d744-43d7-4557-b050-d3e40149e5a5.jpg?image&action=resize:w_671,h_671\" imagesource=\"personal\" meiziid=\"3085\" uploadpic=\"5664d744-43d7-4557-b050-d3e40149e5a5.jpg?image&amp;action=resize:w_671,h_671\" relationid=\"2712\" style=\"display: block; clear: both; margin: 0px auto; max-width: 640px;\" class=\"app_image\" type=\"app_image\"/></p>" +
                "<p type=\"imagenote\" class=\"imagenote\" imagekey=\"3085\" style=\"margin-top: 1px; padding-top: 1px; font-size: 14px; height: auto; color: rgb(138, 147, 158); padding-bottom: 6px; text-align: center; box-sizing: initial; line-height: 1.5em;\">图说搜索</p>" +
                "<p type=\"imagenote\" class=\"imagenote\" imagekey=\"3085\" style=\"margin-top: 1px; padding-top: 1px; font-size: 14px; height: auto; color: rgb(138, 147, 158); padding-bottom: 6px; text-align: center; box-sizing: initial; line-height: 1.5em;\">图说搜索2</p>" +
                "<p class=\"imagenotePlace\"><br/></p><p><br/></p><p>身上发生</p>";*/

        String originContent = "<p>\n" +
                "    &nbsp; 测试新闻稿\n" +
                "</p>\n" +
                "<p>\n" +
                "    阿斯 蒂 芬\n" +
                "</p>\n" +
                "<p>\n" +
                "    水电费\n" +
                "</p>\n" +
                "<p>\n" +
                "    <br/>\n" +
                "</p>\n" +
                "<p class=\"app_image_wrap\" type=\"app_image_wrap\" style=\"text-align:center\">\n" +
                "    <img src=\"http://172.16.25.100/media_resource/img/xjbucket3/5664d744-43d7-4557-b050-d3e40149e5a5.jpg?image&action=resize:w_671,h_671\" imagesource=\"personal\" meiziid=\"3085\" uploadpic=\"5664d744-43d7-4557-b050-d3e40149e5a5.jpg?image&amp;action=resize:w_671,h_671\" relationid=\"2712\" style=\"display: block; clear: both; margin: 0px auto; max-width: 640px;\" class=\"app_image\" type=\"app_image\"/>\n" +
                "</p>\n" +
                "<p type=\"imagenote\" class=\"imagenote\" imagekey=\"3085\" style=\"margin-top: 1px; padding-top: 1px; font-size: 14px; height: auto; color: rgb(138, 147, 158); padding-bottom: 6px; text-align: center; box-sizing: initial; line-height: 1.5em;\">\n" +
                "    图说搜索\n" +
                "</p>\n" +
                "<p class=\"imagenotePlace\">\n" +
                "    <br/>\n" +
                "</p>\n" +
                "<p>\n" +
                "    杀杀杀\n" +
                "</p>";
//        originContent = originContent.replaceAll("[\\s\r\n\t]","");
//        originContent = originContent.replaceAll("　","");
//        System.out.println(originContent);
        originContent = originContent.replaceAll("[\\s\r\n\t]", "");

        String regix = "<(p|P)[^>]*type=(\"|')imagenote(\"|')(.*?)>(.*?)</(p|P)>";
        Pattern pattern = Pattern.compile(regix);
        Matcher matcher = pattern.matcher(originContent);
        while (matcher.find()) {
            String group = matcher.group(0);
            originContent = originContent.replace(group, "");
            System.out.println(matcher.group(0));
        }
        String content = Html2Text.getInstance().parse(originContent);
        int contentLength = content.trim().length();
        System.out.println(content);
    }
}
