package cn.stylefeng.guns.modular.test.service;


import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.tomcat.jni.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class StuAuthInfo {

    public void account(boolean isNew) throws InterruptedException{
        // 创建 ChromeDriver 实例
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-extensions");
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.geolocation", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("load-extension=C:\\Users\\xh\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\Extensions\\lanfdkkpgfjfdikkncbnojekcppdebfp\\0.2.0_0\\");
        System.out.println("启动认证浏览器...");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        if (isNew){
            System.out.println("新用户");
            //newAccount();
        }else {
            System.out.println("老用户");
            oldAccount(driver);
        }

    }

    private void oldAccount (WebDriver driver) throws InterruptedException {
        //解析yml文件
        Map<String, Object> map = YamlMapService.returnYmlMap();
        Map<String,Object> authInfo = (Map<String, Object>) map.get("authInfo");
        Map<String,Object> step1 = (Map<String, Object>) map.get("step1");
        Map<String,Object> step2 = (Map<String, Object>) map.get("step2");
        driver.get(step1.get("step1Url").toString());
        System.out.println("等待用户自行登录，直到进入步骤一或者进入了第二部");
        while (true){
            if (driver.getCurrentUrl().equals(step1.get("step1Url"))){
                System.out.println("进入步骤一");
                break;
            }else if (isElementExist(driver,step2.get("cancelButton").toString())){
                System.out.println("进入步骤二");
                break;
            }
            Thread.sleep(2);
        }
        //如果在步骤二则返回步骤一
        if(isElementExist(driver,step2.get("cancelButton").toString())){
            driver.findElement(By.xpath(step2.get("cancelButton").toString())).click();
            Thread.sleep(1);
            driver.switchTo().alert().accept();
            while (true){
                if (driver.getCurrentUrl().equals(step1.get("step1Url"))){
                    System.out.println("进入步骤一");
                    break;
                }
            }
        }
        //步骤一
        Thread.sleep(1);
        //选择邮箱
        driver.findElement(By.xpath(step1.get("choiceEmail").toString())).click();
        Thread.sleep(1);
        //输入学校
        driver.findElement(By.xpath(step1.get("schoolName").toString())).sendKeys(authInfo.get("schoolName").toString());
        Thread.sleep(1);
        //选择学校
        driver.findElement(By.xpath(step1.get("schoolNameButton").toString())).click();
        Thread.sleep(1);
        //输入理由
        driver.findElement(By.xpath(step1.get("planToUse").toString())).sendKeys(authInfo.get("planToUse").toString());
        Thread.sleep(1);
        //点击下一步
        driver.findElement(By.xpath(step1.get("nextButton").toString())).click();
        while (true){
            if (isElementExist(driver,step2.get("cancelButton").toString())){
                System.out.println("进入步骤二");
                break;
            }
        }
        //步骤二
        Thread.sleep(1);
        Select select = new Select(driver.findElement(By.xpath(step2.get("ProofType").toString())));
        select.selectByValue("1");
        Thread.sleep(1);
        System.out.println("开始上传图片");
        driver.findElement(By.xpath(step2.get("takePicture").toString())).click();
        Thread.sleep(1);
        while(isElementExist(driver,step2.get("takePictureButton").toString())){
             driver.findElement(By.xpath(step2.get("takePictureButton").toString())).click();
            break;
        }
        Thread.sleep(5);
        driver.findElement(By.xpath(step2.get("processButton").toString())).click();
        System.out.println("等待认证结果");
        //在浏览器的新标签页打开一个新页面（https://education.github.com）
        //1.新建标签页
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        //2.打开网址
        driver.get("https://education.github.com");
        //3.切换到新标签页
        driver.switchTo().window(driver.getWindowHandles().toArray()[-1].toString());
        //4.等待页面加载完成



    }

    /**
     * 确认元素是否存在
     */
    private boolean isElementExist(WebDriver driver, String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 确认元素是否存在,存在true，不存在false
     */


    public static void main(String[] args) throws InterruptedException {
        StuAuthInfo stuAuthInfo = new StuAuthInfo();
        stuAuthInfo.account(false);
    }
}
