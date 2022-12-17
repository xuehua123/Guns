package cn.stylefeng.guns.modular.test.service;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

public class YamlMapService {
    public static void main(String[] args) {
        YamlMapService yamlMapService = new YamlMapService();
        yamlMapService.returnYmlMap();
    }

    public static Map<String, Object> returnYmlMap() {
        //加载yml文件
        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(new ClassPathResource("stuAuthInfo.yml"));
        //获取yml文件中的map
        Map<String, Object> map = yamlMapFactoryBean.getObject();
        System.out.println(map);
        //map转entity
        return map;
    }

}
