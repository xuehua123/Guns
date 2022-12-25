package cn.stylefeng.guns.modular.util;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author li.qing
 * @date 2022年12月25日 13:55
 */
public class FileUtils {

    public static void main(String[] args) throws IOException {
        System.out.println(getFileContent("/github/temp.html"));
    }

    /**
     * 直接使用getResourceAsStream方法获取流
     * springboot项目中需要使用此种方法，因为jar包中没有一个实际的路径存放文件
     *
     * @param fileName
     * @throws IOException
     */
    public static String getFileContent(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        InputStream inputStream = classPathResource.getInputStream();
        return getFileContent(inputStream);
    }

    /**
     * 根据文件路径读取文件内容
     *
     * @param fileInPath
     * @throws IOException
     */
    public static String getFileContent(Object fileInPath) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        if (fileInPath == null) {
            return sb.toString();
        }
        if (fileInPath instanceof String) {
            br = new BufferedReader(new FileReader(new File((String) fileInPath)));
        } else if (fileInPath instanceof InputStream) {
            br = new BufferedReader(new InputStreamReader((InputStream) fileInPath));
        }
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        br.close();

        return sb.toString();
    }


}
