package org.geekbang.html2txt;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.*;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/29 13:39
 * @Version: 1.0
 */
public class Html2Text extends HTMLEditorKit.ParserCallback {

    private StringBuilder s;

    public String parse(String str) throws Exception{

        InputStream iin = null;
        Reader in = null;
        try {
            iin = new ByteArrayInputStream(str.getBytes());
            in = new InputStreamReader(iin);
            s = new StringBuilder();
            ParserDelegator delegator = new ParserDelegator();
            // the third parameter is TRUE to ignore charset directive
            delegator.parse(in, this, Boolean.TRUE);
            int i = 1 / 0;
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        } finally {
            //关闭流
            if (iin != null) {
                iin.close();
            }
            if (in != null) {
                in.close();
            }
        }

        return s.toString();
    }

    @Override
    public void handleText(char[] text, int pos) {
        s.append(text);
    }

    private Html2Text() {
    }

    public static Html2Text getInstance() {
        return new Html2Text();
    }
}
