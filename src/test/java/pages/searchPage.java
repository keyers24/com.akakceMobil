package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.elementHelper;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class searchPage extends basePage{
    WebDriverWait wait;
    elementHelper helper;
    Actions action;
    private static final Logger log = Logger.getLogger("searchPage");
    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.akakce.akakce:id/searchTextView\"]")
    public WebElement homePage;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/announcementTextView\"]")
    public WebElement continueWithoutMembership;

    @AndroidFindBy(id="com.akakce.akakce:id/searchTextView")
    public WebElement searchBox;

    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.akakce.akakce:id/searchTextView\").instance(1)")
    public WebElement searchBox2;

    @AndroidFindBy(id="com.akakce.akakce:id/filterText")
    public WebElement filter;

    @AndroidFindBy(id="com.akakce.akakce:id/applyFilterTextView")
    public WebElement productResult;

    @AndroidFindBy(id="com.akakce.akakce:id/detailBtnLayout")
    public WebElement goToProduct;

    public searchPage(AppiumDriver driver) {
        super(driver);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.helper=new elementHelper(driver);
        action= new Actions(driver);
    }

    public void AkakceApplicationOpensPage(){
        helper.checkElement(homePage);
        helper.checkElement(continueWithoutMembership);
    }

    public void continueWithoutSigningUpPage(){
        helper.click(continueWithoutMembership);
    }
    public void searchForLaptopInTheSearchBarPage(){
        helper.click(searchBox);
        helper.sendKey(searchBox2,"Laptop");
        action.sendKeys(Keys.ENTER).perform();
    }
    public void filteredPage(){
        helper.click(filter);
    }
    public void categorySelectionIsMadePage(){
        helper.click(productResult);
    }
    public void theProductWithTheHighestPriceIsSelectedPage() {

        List<WebElement> productElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.view.ViewGroup[@resource-id='com.akakce.akakce:id/cellContainer']")));
        double maxPrice = 0;
        WebElement highestPricedProduct = null;

        for (WebElement product : productElements) {
            try {
                List<WebElement> priceElements = product.findElements(By.xpath("//android.widget.TextView[@resource-id='com.akakce.akakce:id/price']"));

                if (!priceElements.isEmpty()) {
                    WebElement priceElement = priceElements.get(0);
                    String priceText = priceElement.getText();
                    String digits = priceText.replaceAll("[^0-9]", "");
                    if (!digits.isEmpty()) {
                        double price = Double.parseDouble(digits);
                        if (price > maxPrice) {
                            maxPrice = price;
                            highestPricedProduct = product;

                            log.info("Highest Price: " + price);
                        }
                    }
                } else {
                    log.info(" ");
                }
            } catch (Exception e) {
                log.info("Error: " + e.getMessage());
            }
        }

        if (highestPricedProduct != null) {
            WebElement productLink = highestPricedProduct.findElement(By.xpath(".//android.widget.Button | .//android.widget.TextView"));
            try {
                helper.click(productLink);
                Thread.sleep(1000);
            } catch (Exception e) {
                log.info("Not Clicked");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productLink);
            }
        } else {
            log.info("Not Found ");
        }
    }

    public void goToSellerButtonIsVerifiedPage(){
        helper.checkElement(goToProduct);
    }
}
