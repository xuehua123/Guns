package cn.stylefeng.guns.modular.test.service;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YAMLParser {

    public static void main(String[] args) throws Exception {
        // Read YAML file
        InputStream input = new FileInputStream("C:\\Users\\xh\\Guns\\src\\main\\resources\\stuAuthInfo.yml");
        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(input);

        // Generate Java class
        generateClass("MyClass", map);
    }

    private static void generateClass(String className, Map<String, Object> map) throws Exception {
        StringBuilder sb = new StringBuilder();

        // Generate class declaration
        sb.append("public class " + className + " {\n");

        // Generate fields
        for (String key : map.keySet()) {
            sb.append("\tprivate Object " + key + ";\n");
        }

        sb.append("\n");

        // Generate getters and setters
//        for (String key : map.keySet()) {
//            // Generate getter
//            sb.append("\tpublic Object get" + capitalize(key) + "() {\n");
//            sb.append("\t\treturn " + key + ";\n");
//            sb.append("\t}\n\n");
//
//            // Generate setter
//            sb.append("\tpublic void set" + capitalize(key) + "(Object " + key + ") {\n");
//            sb.append("\t\tthis." + key + " = " + key + ";\n");
//            sb.append("\t}\n\n");
//        }
//
        sb.append("}\n");
//
//        // Print generated class
        System.out.println(sb);
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
