package util;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class elementHelper {
    AppiumDriver driver;
    WebDriverWait wait;
    public elementHelper(AppiumDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public WebElement checkElement(WebElement key){
        return wait.until(ExpectedConditions.visibilityOf(key));
    }

    public  void click(WebElement key){
        WebElement element = checkElement(key);
        element.click();
    }


    public  void sendKey(WebElement key, String txt){
        WebElement element= checkElement(key);
        element.sendKeys(txt);
    }

}
