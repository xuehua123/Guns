package cn.stylefeng.guns.modular.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 生成图片工具类
 */
public class JpgUtils {

    /**
     *
     * @param name 姓名
     * @param dateOfBirth 出生日期
     * @param certificateNo 证书编号
     * @param schoolName 学校名称
     * @param updateTime 生成日期
     * @param filePath 生成路径，包含文件名
     */
    public static void genJpg(String name, String dateOfBirth, String certificateNo, String schoolName,
                              String updateTime, String filePath) throws IOException {
        int width = 1120; // 图片宽
        int height = 800;// 图片高
        String titleStr = "Ministry of Education Academic Certificate Electronic Registration";

        // 得到图片缓冲区
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// INT精确度达到一定,RGB三原色，高度70,宽度150

        // 得到它的绘制环境(这张图片的笔)
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setColor(Color.WHITE); // 设置背景颜色
        g2.fillRect(0, 0, width, height);// 填充整张图片(其实就是设置背景颜色)
        Color borderColor = new Color(206,222,228);
        g2.setColor(borderColor);// 设置字体颜色
        g2.setStroke(new BasicStroke(1.0f)); // 边框加粗
        // g2.drawRect(1, 1, width - 2, height - 2); // 画边框就是黑边框

        g2.drawLine(100, 165, 1020, 165); // 从上到下第一个横线(Name上面的横线)
        // g2.setStroke(new BasicStroke(0.0f)); // 边框不需要加粗
        g2.drawLine(100, 215, 820, 215); // 从上到下第二个横线(Gender上面的横线)
        g2.drawLine(100, 265, 820, 265); // 从上到下第三个横线
        g2.drawLine(100, 400, 820, 400); // 从上到下第四个横线
        g2.drawLine(100, 470, 1020, 470); // 从上到下第五个横线
        g2.drawLine(100, 550, 1020, 550); // 从上到下第六个横线
        g2.drawLine(100, 620, 1020, 620); // 从上到下第七个横线
        g2.drawLine(100, 700, 1020, 700); // 从上到下第八个横线
        g2.drawLine(100, 780, 1020, 780); // 从上到下第九个横线

        g2.drawLine(100, 165, 100, 780); // 从左到右第一个竖线
        g2.drawLine(250, 165, 250, 780); // 从左到右第二个竖线
        g2.drawLine(500, 215, 500, 470); // 从左到右第三个竖线
        g2.drawLine(650, 215, 650, 470); // 从左到右第四个竖线
        g2.drawLine(690, 470, 690, 700); // 从左到右第四.五个竖线
        g2.drawLine(820, 165, 820, 700); // 从左到右第五个竖线
        g2.drawLine(1020, 165, 1020, 780); // 从左到右第六个竖线

        // 设置标题的字体,字号,大小
        Font titleFont = new Font("宋体", Font.BOLD, 30);
        Color titleColor = new Color(97, 172, 184);
        g2.setColor(titleColor);
        g2.setFont(titleFont);
        String markNameStr = titleStr;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 抗锯齿
        // 计算文字长度,计算居中的X点坐标
        FontMetrics fm = g2.getFontMetrics(titleFont);
        int titleWidth = fm.stringWidth(markNameStr);
        int titleWidthX = (width - titleWidth) / 2;// 感觉不居中,向左移动35个单位
        g2.drawString(markNameStr, titleWidthX, 45);
        titleWidth = fm.stringWidth("Form");
        titleWidthX = (width - titleWidth) / 2;// 感觉不居中,向左移动35个单位
        g2.drawString("Form", titleWidthX, 95);
        Font dateFont = new Font("宋体", Font.PLAIN, 20);
        FontMetrics dateFm = g2.getFontMetrics(dateFont);
        titleWidth = dateFm.stringWidth("Update Date: August 29,2022");
        titleWidthX = ((width - titleWidth) - 80);
        g2.setFont(dateFont);
        Color bodyColor = new Color(0, 0, 0);
        g2.setColor(bodyColor);
        g2.drawString("Update Date: " + updateTime, titleWidthX, 135);
        // g2.setFont(new Font("宋体", Font.BOLD, 20));
        // 姓名
        g2.drawString("Name", 120, 200);
        // 姓名的值
        g2.drawString(name, 270, 200);
        // gender
        g2.drawString("gender", 120, 250);
        // gender的值
        g2.drawString("male", 270, 250);
        // date of birth
        g2.drawString("date of birth", 520, 250);
        g2.drawString(dateOfBirth, 660, 250);
        // Admission
        g2.drawString("Admission", 120, 325);
        // date
        g2.drawString("date", 140, 365);
        g2.drawString("September 9,2021", 270, 335);
        // Expected
        g2.drawString("Expected", 530, 295);
        g2.drawString("graduation", 520, 335);
        g2.drawString("time", 550, 375);
        g2.drawString("June 30,2025", 660, 335);
        // Education category
        g2.drawString("Education", 120, 430);
        g2.drawString("category", 130, 455);
        g2.drawString("general higher education", 260, 445);
        g2.drawString("level", 550, 445);
        g2.drawString("Undergraduate", 660, 445);
        g2.drawString("School Name", 110, 520);
        int schoolWidth = fm.stringWidth(schoolName);
        if (schoolWidth > 400) {
            String[] shcoolNameArray = schoolName.split(" ");
            int size = shcoolNameArray.length;
            int mid = size/2;
            String schoolName1 = "";
            String schoolName2 = "";
            for (int i = 0; i <= mid; i++) {
                schoolName1 = schoolName1 + shcoolNameArray[i] + " ";
            }
            for (int i = mid + 1; i < size; i++) {
                schoolName2 = schoolName2 + shcoolNameArray[i] + " ";
            }
            g2.drawString(schoolName1, 260, 505);
            g2.drawString(schoolName2, 260, 535);
        } else {
            g2.drawString(schoolName, 260, 520);
        }

        g2.drawString("Academic", 710, 510);
        g2.drawString("system", 720, 530);
        g2.drawString("4 years", 840, 520);
        g2.drawString("specialized", 120, 590);
        g2.drawString("computer science and Technology", 260, 590);
        g2.drawString("Ways of", 720, 580);
        g2.drawString("learning", 720, 610);
        g2.drawString("Regular full-time", 840, 590);
        g2.drawString("Certificate", 120, 650);
        g2.drawString("No", 150, 680);
        g2.drawString(certificateNo, 260, 670);
        g2.drawString("graduation", 710, 670);
        g2.drawString("Registered", 840, 670);

        g2.drawString("School (dean)", 110, 730);
        g2.drawString("name", 150, 760);

        g2.drawString(BaseInfoGeneration.getName(), 260, 750);

        g2.dispose(); // 释放对象

        BufferedImage bufferedImageNew = new BufferedImage(width * 2, height * 2, BufferedImage.TYPE_INT_RGB);
        bufferedImageNew.getGraphics().drawImage(bi, 0, 0, width * 2, height * 2, null);

        ImageIO.write(bufferedImageNew, "JPEG", new FileOutputStream(filePath));// 保存图片 JPEG表示保存格式
    }

    /**
     * 强化图片
     */
    public static void enhanceImg(String oldPath, String newPath){

        String path = oldPath;
        //如果路径不存在则创建
        if (!new File(newPath).exists()) {
            new File(newPath).mkdirs();
        }
        File file = new File(path);
        File[] files = file.listFiles();
        final CountDownLatch latch = new CountDownLatch((int) Arrays.stream(files).count());
        ExecutorService executorService = new ThreadPoolExecutor(17, 17, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100));
        for (File f : files) {
            executorService.execute(() -> {
                if (f.isFile()) {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(f);
                        int width = bufferedImage.getWidth();
                        int height = bufferedImage.getHeight();
                        BufferedImage bufferedImage1 = new BufferedImage(width * 5, height * 5, BufferedImage.TYPE_INT_RGB);
                        bufferedImage1.getGraphics().drawImage(bufferedImage, 0, 0, width * 5, height * 5, null);
                        ImageIO.write(bufferedImage1, "jpg", new File(newPath + f.getName()));
                        System.out.println("图片" + f.getName() + "处理完成");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除原始图片
     */
    public static void deleteOldImg(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            file1.delete();
        }
        //删除文件夹
        file.delete();
        System.out.println("原始图片已删除");
    }
}
