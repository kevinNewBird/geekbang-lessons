package org.geekbang.imagemagick;

import io.vavr.control.Either;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/28 16:17
 * @Version: 1.0
 */
public class ImageMagicKTestDemo {

    private static List<String> PIC_FORMAT_LIST = null;

    //初始化常用的图片格式
    static {
        PIC_FORMAT_LIST = new ArrayList<>();
        Collections.addAll(PIC_FORMAT_LIST, "jpg", "png", "bmp", "gif");
    }


    public static void main(String[] args) throws IOException {
      /*  Either<Throwable, String> e = testEither(1);
        if (e.isLeft()) {
            System.out.println(e.getLeft().getMessage());
        } else {
            System.out.println(e.get());
        }*/

        Arrays.stream(getResult("C:\\Users\\Kevin\\Desktop\\xml\\兼容xml", "E_291482.xml")).forEach(file -> System.out.println(file.getName()));
        int i = 0;
//        readJPGImage();
    }

    private static void readJPGImage() throws IOException {

/*        FileInputStream is = new FileInputStream("E:\\deskFile\\trs_work\\工作任务\\新疆融媒体云--新疆日报\\素材\\picture\\W0202004266487465599431.jpg");;
        ImageInputStream iis = null;
        Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = it.next();
        iis = ImageIO.createImageInputStream(is);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rect = new Rectangle(0, 0, 100, 100);
        param.setSourceRegion(rect);
        BufferedImage image = reader.read(0, param);
        ImageIO.write(image, "jpg", new File("d://test_.jpg"));*/
        File oFile = new File("E:\\deskFile\\trs_work\\工作任务\\新疆融媒体云--新疆日报\\素材\\picture\\E_63250.xml");
//        File oFile = new File("E:\\deskFile\\trs_work\\工作任务\\新疆融媒体云--新疆日报\\素材\\picture\\sfasfdasfda.bmp");
//        File oFile = new File("E:\\deskFile\\trs_work\\工作任务\\新疆融媒体云--新疆日报\\素材\\picture\\14698306565.jpg");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(oFile.lastModified());
        System.out.println(format.format(cal.getTime()));
        FileInputStream fi = new FileInputStream(oFile);
        try {
            getImageFormat(oFile);
            BufferedImage bufferedImage = ImageIO.read(fi);//图片损坏获取结果为null
            int picWidth = bufferedImage.getWidth();
        } catch (IOException e) {

            try {
                ThumbnailConvert tc = new ThumbnailConvert();
                tc.setCMYK_COMMAND(oFile.getPath(), "sfasfdasfda.bmp");
                Image image = null;
                image = Toolkit.getDefaultToolkit().getImage(oFile.getPath());
                MediaTracker mediaTracker = new MediaTracker(new Container());
                mediaTracker.addImage(image, 0);
                mediaTracker.waitForID(0);
                image.getWidth(null);
                image.getHeight(null);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } finally {
            fi.close();
        }
    }


    private static String getImageFormat(Object obj) {
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(obj);
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);
            while (iterator.hasNext()) {
                ImageReader reader = (ImageReader) iterator.next();
                return reader.getFormatName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Either<Throwable, String> testEither(int i) {
        if (i > 0) {
            return Either.left(new RuntimeException("不支持的格式"));
        } else {
            return Either.right("sssssss");
        }
    }


    private static File[] getResult(String _filePath, String oXMlFileName) {
        File oFile = new File(_filePath);
        String oPicFileName = oXMlFileName.substring(0, oXMlFileName.lastIndexOf("."));
        //过滤出符合条件的文件
        File[] oFileArr = oFile.listFiles((File dir, String name) -> {
            int index = name.lastIndexOf(".");
            String oFilePostfixOfServer = name.substring(index + 1);
            String oFileNameOfServerWithNoPostFix = name.substring(0, index > 0
                    ? index : name.length());
            //判断xml是否有对应的图片文件
            long isContainPic = PIC_FORMAT_LIST.stream()
                    .filter((picFormat) -> oFileNameOfServerWithNoPostFix.equals(oPicFileName) && picFormat.equalsIgnoreCase(oFilePostfixOfServer)).count();
            if (isContainPic > 0) {
                return true;
            }
            return false;
        });
        return oFileArr;
    }
}
