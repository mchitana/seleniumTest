package steps;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utilities.BrowserFactory;
import utilities.PropertyLoader;

import java.io.File;
import java.io.IOException;

public class TestBase {

    private static final String SCREENSHOT_FOLDER = "target/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    private static String baseUrl = PropertyLoader.loadProperty("site.url");
    private static String BrowserName = PropertyLoader.loadProperty("browser.name");
    WebDriver driver;

    @BeforeClass
    public void setup() {
         driver = BrowserFactory.startBrowser(BrowserName, baseUrl);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (BrowserFactory.driver != null) {
            BrowserFactory.driver.quit();
        }
    }

    @AfterMethod
    public void setScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                WebDriver returned = new Augmenter().augment(BrowserFactory.driver);
                if (returned != null) {
                    File f = ((TakesScreenshot) returned).getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(f,
                                new File(SCREENSHOT_FOLDER + result.getName() + SCREENSHOT_FORMAT));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (ScreenshotException se) {
                se.printStackTrace();
            }
        }
    }
}
