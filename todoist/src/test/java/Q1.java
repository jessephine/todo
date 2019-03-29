//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Q1  {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "3ST0219301001652");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.todoist");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activity.HomeActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void Q1() {
        driver.findElement(By.xpath("//*[@text='Continue with email']")).click();
        driver.findElement(By.xpath("//*[@text='NONE OF THE ABOVE']")).click();
        driver.findElement(By.xpath("//*[@id='email_exists_input']")).sendKeys("jessephine.lee@gmail.com");
        driver.findElement(By.xpath("//*[@text='Continue with email']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='log_in_password']")));
        driver.findElement(By.xpath("//*[@id='log_in_password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id='btn_log_in']")).click();

        driver.findElement(By.xpath("//*[@contentDescription='Change the current view']")).click();
        driver.findElement(By.xpath("//*[@id='collapse' and (./preceding-sibling::* | ./following-sibling::*)[@text='Projects']]")).click();
        driver.findElement(By.xpath("//*[@text='Add project']")).click();
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("test question 1");
//        driver.findElement(By.xpath("//*[@contentDescription='test']")).click();
        driver.findElement(By.xpath("//*[@id='menu_form_submit']")).click();

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}