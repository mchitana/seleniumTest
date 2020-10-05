package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public static WebDriver driver;

    public BrowserFactory(){

    }

    public static WebDriver startBrowser(String browserName, String url){
        if(driver==null){
            if(browserName.equalsIgnoreCase("firefox")){
                Path firefox = Paths.get("./src/main/resources/geckodriver");
                firefox.toFile().setExecutable(true);
                System.setProperty("webdriver.gecko.driver", firefox.toAbsolutePath().toString());
                driver=new FirefoxDriver();
            }else if(browserName.equalsIgnoreCase("chrome")){
                 Path chrome = Paths.get("./src/main/resources/chromedriver");
                chrome.toFile().setExecutable(true);
                System.setProperty("webdriver.chrome.driver", chrome.toAbsolutePath().toString());
                driver=new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("IE")){
                Path ie = Paths.get("./src/main/resources/iedriver");
                ie.toFile().setExecutable(true);
                System.setProperty("webdriver.ie.driver", ie.toAbsolutePath().toString());
                driver=new InternetExplorerDriver();
            }
            else {
                throw new IllegalArgumentException("Unsupported browser");
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
            driver.get(url);

        }
        return driver;
    }
}
