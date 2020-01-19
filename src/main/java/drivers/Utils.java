package drivers;

import org.openqa.selenium.WebDriver;

/*
 * This is the Utility Class :
 * Here we are following the Singleton Design Pattern,
 * So that we have a single Driver Instance through our Project
 * Access Specifier is protected so that Only Sub classes extending Utils can use the Variables.
 */

public class Utils {
    protected static WebDriver driver ;

    protected String CloudElementSignUpLink = "http://my.cloudelements.io/";
    protected String GithubUsername = "avinashsharma68@gmail.com";
    protected String GithubPassword = "c2hhcm1hMDFA";
    protected String Application = "Google Drive";
    protected String EmailUsername = "avinashkmr0111";
    protected String EmailPassword = "YXZpbmFzaDY4Lg==";



}
