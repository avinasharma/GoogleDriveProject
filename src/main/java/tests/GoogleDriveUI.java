package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseMethods;
import pages.Locators;


import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 * In this Test Specification :
 * We will navigate to CloudElements SignUp Page,
 * SignUp using GitHub Email Id and Password,
 * Navigate to Elements SubTab and Click on Create Instance,
 * Approve it by logging through Email,
 * And Verify that the Instance creation got Successful.
 *
 * The Base Implementation fo the Methods used can be found under BaseMethods Class.
 */

public class GoogleDriveUI extends Locators{
    protected static WebDriver driver ;
    private String driverType = "webdriver.chrome.driver";
    private String driverPath = "\\resources\\chromedriver.exe";


    @BeforeMethod
    public void setUp(){
        // We will setUp the Browser Instance,
        System.setProperty( driverType, System.getProperty("user.dir")+driverPath );
        driver = new ChromeDriver();
        System.out.println("Opening the browser : Chrome ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public  void tearDown(){
        // & Implement TearDown Method for closing the Browser Instance,
        System.out.println("Closing the browser ");
        driver.close();

    }

//  Positive Scenario : Creation of Google Drive Instance through CloudElements.
    @Test
    public void GoogleDriveUiAutomation(){
        BaseMethods operation = new BaseMethods();
        try {
            // We will navigate to CloudElements SignUp Page,
            operation.getURL(CloudElementSignUpLink);
            String parentWindow = operation.getWindowHandle();
            operation.doWait(2);
            operation.click(SignUpByGitHub);

            // We will signUp using GitHub Credentials to CloudElements ,
            operation.setValue( Username, GithubUsername);
            operation.setPassword( Password, GithubPassword);
            operation.click( Submit);
            operation.switchToWindow(parentWindow);
            operation.doWait(10);
            operation.click(AcceptCookies);
            operation.getWindowHandle();

            // We will create a Google Drive Instance in CloudElements ,
            Thread.sleep(5000L);
            operation.waitForElementPresent(InstanceTab);
            operation.click(InstanceTab);
            Thread.sleep(15000L);
            operation.waitForElementPresent(CreateInstance);
            operation.click(CreateInstance);
            Thread.sleep(15000L);
            operation.setValue(AppSelectInputBox,Application);
            operation.click(GoogleDriveApp);

            // We will approve the signup instance through email,
            String Name = operation.getRandomName();
            Thread.sleep(5000L);
            operation.setValue(InstanceNameField,Name);
            String parentWindow2 = operation.getWindowHandle();
            operation.click(SubmitButton);

            Set<String> Windows2 = operation.getWindowHandles();
            for (String window:Windows2) {
                if (!window.contains(parentWindow2)){
                    operation.switchToWindow(window);
                }
            }
            // Signin to Gmail
            operation.setValue(GmailUsername,EmailUsername);
            operation.click(Next);
            operation.setPassword(password,EmailPassword);
            operation.click(PasswordNext);

            operation.click(AllowAccess);

            operation.switchToWindow(parentWindow);
            Thread.sleep(10000L);
            operation.waitForElementPresent(InstanceTab);
            operation.click(InstanceTab);
            Thread.sleep(12000L);
            String Actual = driver.findElement(By.xpath("//*[contains(text(),'"+Name+"')]")).getText();
            System.out.println();
            operation.assertValue(Actual,Name);


        }
        catch (Exception e){
            System.out.println("Test Case Terminated");
            System.out.println(e);
            Assert.assertEquals(false,true);
        }

    }

    //  Negative Scenario : Creation of Google Drive Instance through CloudElements without approving from Gmail.
    @Test
    public void GoogleDriveUiAutomationNegative(){
        BaseMethods operation = new BaseMethods();
        try {
            // We will navigate to CloudElements SignUp Page,
            operation.getURL(CloudElementSignUpLink);
            String parentWindow = operation.getWindowHandle();
            operation.doWait(2);
            operation.click(SignUpByGitHub);

            // We will signUp using GitHub Credentials to CloudElements ,
            operation.setValue( Username, GithubUsername);
            operation.setPassword( Password, GithubPassword);
            operation.click( Submit);
            operation.switchToWindow(parentWindow);
            operation.doWait(10);
            operation.click(AcceptCookies);
            operation.getWindowHandle();

            // We will create a Google Drive Instance in CloudElements ,
            Thread.sleep(5000L);
            operation.waitForElementPresent(InstanceTab);
            operation.click(InstanceTab);
            Thread.sleep(15000L);
            operation.waitForElementPresent(CreateInstance);
            operation.click(CreateInstance);
            Thread.sleep(15000L);
            operation.setValue(AppSelectInputBox,Application);
            operation.click(GoogleDriveApp);

            // We will approve the signup instance through email,
            String Name = operation.getRandomName();
            Thread.sleep(5000L);
            operation.setValue(InstanceNameField,Name);
            String parentWindow2 = operation.getWindowHandle();
            operation.click(SubmitButton);

            Set<String> Windows2 = operation.getWindowHandles();
            for (String window:Windows2) {
                if (!window.contains(parentWindow2)){
                    operation.switchToWindow(window);
                }
            }
            // Signin to Gmail
            operation.setValue(GmailUsername,EmailUsername);
            operation.click(Next);
            operation.setPassword(password,EmailPassword);
            operation.click(PasswordNext);

            operation.click(Cancel);

            operation.switchToWindow(parentWindow);
            Thread.sleep(10000L);
            operation.waitForElementPresent(InstanceTab);
            operation.click(InstanceTab);
            Thread.sleep(12000L);
            String Actual = driver.findElement(By.xpath("//*[contains(text(),'"+Name+"')]")).getText();
            System.out.println();
            operation.assertValue(Actual,Name);

        }
        catch (Exception e){
            System.out.println("Test Case Terminated");
            System.out.println(e);
            Assert.assertEquals(false,true);
        }

    }
}
