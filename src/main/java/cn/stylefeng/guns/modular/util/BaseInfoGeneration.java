package cn.stylefeng.guns.modular.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 72774
 */
public class BaseInfoGeneration {

    /**
     * 图片命名规则：年月日时分秒+随机数
     */
    public static String getfileNames() {
        //获取当前时间
        Date date = new Date();
        //获取年月日时分秒
        String fileNames = new SimpleDateFormat("yyyyMMdd").format(date);
        //获取随机数
        return fileNames;
    }

    /**
     * 根据当前时间生成更新时间，格式：December 16,2022
     * @return
     */
    public static String getUpdateTime() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        return getMonth(month) + " " + day + "," + year;
    }

    /**
     * 18位数字随机生成
     */
    public static String getCardNo() {
        String cardNo = "1";
        for (int i = 0; i < 17; i++) {
            cardNo += (int) (Math.random() * 10);
            if ((i + 1) % 4 == 3) {
                cardNo += " ";
            }
        }
        return cardNo;
    }

    /**
     * 姓名生成
     * @return
     */
    public static String getName() {
        String[] firstName = {"Zhao", "Qian", "Sun", "Li", "Zhou", "Wu", "Zheng", "Wang", "Feng", "Chen", "Chu", "Wei", "Jiang", "Shen", "Han", "Yang", "Zhu", "Qin", "You", "Xu", "He", "Lu", "Shi", "Zhang", "Kong", "Cao", "Yan", "Hua", "Jin", "Wei", "Tao", "Ginger", "Qi", "Xie", "Zou", "Yu", "Bai", "Water", "Dou", "Zhang", "Cloud", "Su", "Pan", "Ge", "Xi", "Fan", "Peng", "Lang", "Lu", "Wei", "Chang", "Ma", "Miao", "Feng", "Flower", "Fang", "Yu", "Ren", "Yuan", "Liu", "Feng", "Bao", "Shi", "Tang", "Fei", "Lian", "Cen", "Xue", "Lei", "He", "Ni", "Tang", "Teng", "Yin", "Luo", "Bi", "Hao", "Wu", "An", "Chang", "Le", "Yu", "Shi", "Fu", "Pi", "Bian", "Qi", "Kang", "Wu", "Yu", "Yuan", "Bu", "Gu", "Meng", "Ping", "Huang", "He", "Mu", "Xiao", "Yin", "Yao", "Shao", "Zhan", "Wang", "Qi", "Mao", "Yu", "Di", "Mi", "Bei", "Ming", "Zang", "Ji", "Fu", "Cheng", "Dai", "Tan", "Song", "Mao", "Pang", "Xiong", "Ji", "Shu", "Qu", "Xiang", "Wish", "Dong", "Liang", "Du", "Ruan", "Blue", "Min", "Xi", "Ji", "Ma", "Qiang", "Jia", "Lu", "Lou", "Danger", "Jiang", "Tong", "Yan", "Guo", "Mei", "Sheng", "Lin", "Diao", "Zhong", "Xu", "Qiu", "Luo", "Gao", "Xia", "Cai", "Tian", "Fan", "Hu", "Ling", "Huo", "Yu", "Wan", "Zhi", "Ke", "Zan", "Guan", "Lu", "Mo", "Jing", "Fang", "Qiu", "Miao", "Qian", "Solution", "Should", "Zong", "Ding", "Xuan", "Ben", "Deng", "Yu", "Dan", "Hang", "Hong", "Bao", "Zhu", "Zuo", "Shi", "Cui", "Ji", "Niu", "Gong", "Cheng", "Ji", "Xing", "Slide", "Pei", "Lu", "Rong", "Weng", "Xun", "Sheep", "Yu", "Hui", "Zhen", "Qu", "Home", "Feng", "Rui", "Yi", "Chu", "Jin", "Ji", "Bing", "Mi", "Song", "Well", "Duan", "Fu", "Wizard", "Wu", "Jiao", "Ba", "Bow", "Mu", " Kui", "Mountain", "Valley", "Che", "Hou", "Mi", "Peng", "Quan", "Xi", "Ban", "Yang", "Autumn", "Zhong", "Yi", "Gong", "Ning", "Chou", "Luan", "Violence", "Gan", "Ji", "Li", "Rong", "Ancestor", "Wu", " symbol"};
        String[] lastName = {"Zixuan", "Miao", "Guodong", "Master", "Ruitang", "Sweet", "Min", "Shang", "Guoxian", "He Xiang", "Chen Tao", "Hao Xuan", "Yi Xuan", "Yi Chen", "Yi Fan", "Yi Ran", "Jin Chun", "Jin Kun", "Chun Qi", "Yang", "Wen Hao", " Dongdong", "Xionglin", "Haochen", "Xihan", "Rongrong", "Bingfeng", "Xinxin", "Yihao", "Xinhui", "Jianzheng", "Meixin", "Shuhui", "Wenxuan", "Wenjie", "Xinyuan", "Zhonglin", "Rongrun", "Xinru", "Huijia", "New construction", "Jianlin", "Yifei", "Lin", "Bingjie", "Jiaxin", "Hanhan", "Yuchen", "Chunchun", "Jingyan", "Qinglian", "Quiet", " Huixin, Haojie, Mingcheng, Jiale, Xinwen, Jianhui, Xiujie, Zihan, Heyu, Hanyue, Han Yue", "Shuhua", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Ming", "Hui", "Yun Bin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Chang Chang", "Zixuan", "Minghui", "Yun Bin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Purple", " Xuan", "Minghui", "Yun Bin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", " Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", " Yun Bin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Hengxin", "Yixue", "Lin", "Hongbao", "Jing", "Jingying", "Qingyan", "Zichen", "Ruihan", "Changchang", "Zixuan", "Minghui", "Yunbin", "Heng"};
        //firstName和lastName随机组合生成一个姓名
        String name = firstName[(int) (Math.random() * firstName.length)] + " " + lastName[(int) (Math.random() * lastName.length)];
        return name;
    }

    /**
     * 随机生日 生成范围（2000-01-01~2002-12-31）
     */
    public static String randomBirthday() {
        //生日范围
        int startYear = 2000;
        int endYear = 2002;
        //随机年
        int year = startYear + (int) (Math.random() * (endYear - startYear));
        //随机月
        int monthInNo = 1 + (int) (Math.random() * 12);
        //随机日
        int day = 1 + (int) (Math.random() * 28);
        //生日
        String birthday = getMonth(monthInNo) + " "+ day + ", " + year;
        return birthday;
    }
    /**
     * 输出月份对应的英文
     */
    public static String getMonth(int month) {
        String monthStr = "";
        switch (month) {
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            case 12:
                monthStr = "December";
                break;
            default:
                break;
        }
        return monthStr;
    }

}
