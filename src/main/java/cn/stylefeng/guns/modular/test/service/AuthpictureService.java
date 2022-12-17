package cn.stylefeng.guns.modular.test.service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.config.YamlMapFactoryBean;

import java.rmi.MarshalledObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author xh
 */
public class AuthpictureService {
    /**
     * 生成学生信息截图
     *
     * @param schoolName
     */
    public void shotStuInfo(String schoolName,Integer number) {
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
            String image_name = image_dir + "\\" + "always" + ".png";
            getPicture(url, schoolName, submitDate);

        }


    }

    private void getPicture(String url, String schoolName, String submitDate) {

    }


}
