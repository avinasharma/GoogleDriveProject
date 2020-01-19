package pages;

import drivers.Utils;
import org.openqa.selenium.By;
/*
 * In this Class, We are Implementing the Locators,
 * We can add multiple pages as the Scalability increases.
 */

public class Locators extends Utils {

    protected By SignUpByGitHub = By.xpath("(//*[@id='app']//span[2])[1]");
    protected By Username = By.xpath("//*[@id='login_field']");
    protected By Password = By.xpath("//*[@id='password']");
    protected By Submit = By.xpath("//*[@id='login']//input[8]");

    protected By AcceptCookies = By.xpath("//*[@id='hs-eu-confirmation-button']");

    protected By InstanceTab = By.xpath("//*[@id='primary-nav-item-/instances']/div");
    protected By CreateInstance= By.xpath("//*[@id='app']//div[4]/button");

    protected By AppSelectInputBox= By.xpath("//*[@id='chooser-list-container']//input");
    protected By GoogleDriveApp= By.xpath("//*[@id='chooser-list-item-0']/div");

    protected By InstanceNameField = By.xpath("//*[@id='provision-name-field']");
    protected By SubmitButton = By.xpath("//*[@id='createinstance-button']");

    protected By GmailUsername = By.xpath("//*[@id='identifierId']");
    protected By Next = By.xpath("//*[@id='identifierNext']/span/span");
    protected By password = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
    protected By PasswordNext = By.xpath("//*[@id='passwordNext']/span/span");

    protected By AllowAccess = By.xpath("//*[@id='submit_approve_access']/span");

    protected By Cancel = By.xpath("//*[@id='submit_deny_access']/span/span");

    protected By NameFilter = By.xpath("//*[@id='app']//div[4]/div/div");






}




