package org.geekbang.imagemagick;

import org.im4java.core.ConvertCmd;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/27 10:46
 * @Version: 1.0
 */
public class ThumbnailConvert {

    private String CMYK_COMMAND = "mogrify -colorspace RGB -quality 80 file1";//转换cmyk格式

    public void setCMYK_COMMAND(String sourceFile1,String targetFile1) {
//        exeCommand(CMYK_COMMAND.replace("file1", file1));
        String[] cmd = new String[3];
        cmd[0] = "D:\\ImageMagick-7.0.10-Q16-HDRI\\magick";
        cmd[1] = sourceFile1;
        cmd[2] = "E:\\deskFile\\trs_work\\工作任务\\新疆融媒体云--新疆日报\\素材\\picture\\targetFile1"
                .replace("targetFile1", targetFile1);
        exeCommand(cmd);
    }

    public boolean exeCommand(String[] cmd) {
        InputStreamReader ir = null;
        LineNumberReader input = null;
        try {
            //linux下java执行指令：Runtime.getRuntime().exec (String str);
            Process process = Runtime.getRuntime().exec(cmd);
            ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);
            while ((input.readLine()) != null) {
            }
            ir.close();
            input.close();
        } catch (java.io.IOException e) {
            System.err.println("IOException " + e.getMessage());
            return false;
        }
        return true;
    }
}
