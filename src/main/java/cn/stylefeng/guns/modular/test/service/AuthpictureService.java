package cn.stylefeng.guns.modular.test.service;

import cn.stylefeng.guns.modular.util.BaseInfoGeneration;
import cn.stylefeng.guns.modular.util.JpgUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.bouncycastle.crypto.io.MacInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author xh
 */
public class AuthpictureService {


    public static void main(String[] args) {
        AuthpictureService authpictureService = new AuthpictureService();
        authpictureService.shotStuInfo("hhah", 1);
    }

    /**
     * 生成学生信息截图
     *
     * @param schoolName
     */
    public void shotStuInfo(String schoolName, Integer number) {
        YamlMapService yamlMapService = new YamlMapService();
        Map<String, Object> map = yamlMapService.returnYmlMap();
        Map<String,Object> authInfo = (Map<String, Object>) map.get("authInfo");
        //时间格式:Dec 16, 2022，英文
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String date = sdf.format(new Date());
        String submitDate = "Submitted " + date;
        System.out.println(submitDate);
        if (!StringUtils.isNotBlank(schoolName)) {
            schoolName = authInfo.get("schoolName").toString();
        }
        String url = "C:\\Users\\xh\\Guns\\src\\main\\resources\\info2.html";
        String image_dir = "D:\\jpg\\pyStuInfo";
        if (number == null) {
            number = 1;
        }
        for (int i = 0; i < number; i++) {
            String filePath = "/Users/liqing/Downloads/git";
            getPicture(schoolName, filePath);
        }
    }

    /**
     * 生成图片
     * @param schoolName 学校名称
     * @param filePath 生成图片路径，包含文件名
     * @throws IOException
     */
    private void getPicture(String schoolName, String filePath) {
        String studentName = BaseInfoGeneration.getName();
        String dateOfBirth = BaseInfoGeneration.randomBirthday();
        String certificateNo = BaseInfoGeneration.getCardNo();
        String updateTime = BaseInfoGeneration.getUpdateTime();

        try {
            JpgUtils.genJpgFromHtml(studentName, dateOfBirth, certificateNo, schoolName, updateTime, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
