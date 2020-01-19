package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.GoogleDriveUI;

import java.util.Random;
import java.util.Set;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/*
 * This is the BaseMethods Implementation Class:
 * We have customized some basic methods as per our requirements,
 * We have implemented this so that we can achieve Abstraction in our Project,


 */

public class BaseMethods extends GoogleDriveUI {

    public void getURL(String URL) throws InterruptedException {
        driver.navigate().to(URL);
        System.out.println("Navigating to URL : "+URL);
        Thread.sleep(10000L);
    }

    public void click(By locator) throws InterruptedException {
        driver.findElement(locator).click();
        Thread.sleep(5000L);
    }

    public String getText(By locator){
        String text = driver.findElement(locator).getText();
        System.out.println("The Element Present is "+ text);
        return text;
    }

    public void setValue(By locator, String value) throws InterruptedException {
        driver.findElement(locator).sendKeys(value);
        System.out.println("Setting Value :  "+value);
        Thread.sleep(5000L);

    }

    public void setPassword(By locator, String value){
        String dStr = new String(Base64.getDecoder().decode(value));
        driver.findElement(locator).sendKeys(dStr);
        System.out.println("Setting Password Value ");

    }
    public String getWindowHandle(){
        String window = driver.getWindowHandle();
        System.out.println("Current Window :  "+window);
        return window;

    }

    public void switchToWindow(String Window){
        driver.switchTo().window(Window);
        System.out.println("Switching Windows");
    }

    public void elementDisplayed(By Value){
        driver.findElement(Value).isDisplayed();
    }

    public Set<String> getWindowHandles(){
        Set<String> windows = driver.getWindowHandles();
        for (String w :windows) {
            System.out.println("Current Window :  "+w);
        }
        return windows;
    }
    public void waitForElementPresent(By Locators) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(Locators));


    }


    public void doWait(int value){
        driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
    }

    public String getRandomName(){
        Random rand = new Random();
        int suffix = rand.nextInt(99999);
        String Number = "Test" + String.valueOf(suffix) ;
        System.out.println("The Random Instance Name Generated = "+Number);
        return Number;
    }

    public void assertValue(String actual,String expected){

        Assert.assertEquals(actual,expected);
        System.out.println("The Values are Actual|Expected : "+expected+"|"+actual);
    }

}
