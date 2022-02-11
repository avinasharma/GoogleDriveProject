package tests;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locators;

import java.io.File;

/*
 * In this Test Specification :
 * We will Create a Folder, Create a File, Get File, Delete the File & Delete the Folder
 * Please Update the Element part of the token as it expires.

 */

public class API_Automation extends Locators{
    private String token = "User , " +
            "Organization , " +
            "Element ";


    @Test(priority = 1)
    public void folderCreation(){
        try {
            RequestSpecification request = RestAssured.given().header("Authorization", token);

            request.header("Content-Type","application/json");

            JSONObject json = new JSONObject();
            json.put("name","TestFolder");
            json.put("path","/TestFolder");
            json.put("properties",json.put("<field_key","point"));
            json.put("size","1");
            request.body(json.toJSONString());

            Response response = request.post("https://api.cloud-elements.com/elements/api-v2/folders");
            int code = response.getStatusCode();
            System.out.println("The Response Code is :"+code);
            Assert.assertEquals(code,200);
        }
        catch (Exception e){
            System.out.println("Test Case Terminated");
            System.out.println(e);
            Assert.fail();
        }

    }

    @Test(priority = 2)
    public void fileCreation(){
        try {

            RequestSpecification request = RestAssured.given().header("Authorization", token)
                    .queryParam("path","/TestFolder/test.txt")
                    .queryParam("overwrite","true").multiPart(new File(System.getProperty("user.dir")+"\\resources\\Demo.txt"));

            request.header("Content-Type","multipart/form-data");


            Response response = request.post("https://api.cloud-elements.com/elements/api-v2/files");
            int code = response.getStatusCode();
            System.out.println("The Response Code is :"+code);
            Assert.assertEquals(code,200);
        }
        catch (Exception e){
            System.out.println("Test Case Terminated");
            System.out.println(e);
            Assert.fail();
        }

    }

    @Test(priority = 3)
    public void getFile(){
        try {
            RequestSpecification request = RestAssured.given().header("Authorization", token)
                    .queryParam("path","/TestFolder/test.txt");

            request.header("Content-Type","application/json");

            Response response = request.get("https://api.cloud-elements.com/elements/api-v2/files");
            int code = response.getStatusCode();
            System.out.println("The Response Code is :"+code);
            Assert.assertEquals(code,200);

        }
        catch (Exception e){
            System.out.println("Test Case Terminated");
            System.out.println(e);
            Assert.fail();
        }

    }

    @Test(priority = 4)
    public void deleteFile(){
        try {
            RequestSpecification request = RestAssured.given().header("Authorization", token)
                    .queryParam("path","/TestFolder/Test.txt")
                    .queryParam("emptyTrash","true");

            request.header("Content-Type","application/json");

            Response response = request.delete("https://api.cloud-elements.com/elements/api-v2/files");
            int code = response.getStatusCode();
            System.out.println("The Response Code is :"+code);
            Assert.assertEquals(code,200);

        }
        catch (Exception e){
            System.out.println("Test Case Terminated");
            System.out.println(e);
            Assert.fail();
        }

    }

    @Test(priority = 5)
    public void deleteFolder() {
        try {
            RequestSpecification request = RestAssured.given().header("Authorization", token)
                    .queryParam("path", "/TestFolder")
                    .queryParam("emptyTrash", "true");

            request.header("Content-Type", "application/json");

            Response response = request.delete("https://api.cloud-elements.com/elements/api-v2/folders");
            int code = response.getStatusCode();
            System.out.println("The Response Code is :"+code);
            Assert.assertEquals(code,200);

        } catch (Exception e) {
            System.out.println("Test Case Terminated");
            System.out.println(e);
            Assert.fail();
        }
    }
}
