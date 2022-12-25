package cn.stylefeng.guns.modular.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li.qing
 * @date 2022年12月25日 14:12
 */
public class ScreenUtils {

    /**
     * 截图
     * @param htmlPath html文件路径
     * @param jpgFilePath 文件路径，包含图片名称
     */
    public static void createScreen(String htmlPath, String jpgFilePath) {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--enable-extensions");
            options.addArguments("--use-fake-ui-for-media-stream");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--incognito");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.managed_default_content_settings.geolocation", 1);
            options.setExperimentalOption("prefs", prefs);
            // options.addArguments("load-extension=C:\\Users\\xh\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\Extensions\\lanfdkkpgfjfdikkncbnojekcppdebfp\\0.2.0_0\\");
            System.out.println("启动认证浏览器...");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("file://" + htmlPath);
            Thread.sleep(3000);

            elementSnapshot(driver, jpgFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void elementSnapshot(WebDriver driver, String filePath) {
        try {
            WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]"));
            File screenShot = element.getScreenshotAs(OutputType.FILE);
            ImageIO.write(ImageIO.read(screenShot), "png", new File(filePath));
            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
