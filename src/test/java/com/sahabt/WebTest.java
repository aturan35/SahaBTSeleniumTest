package com.sahabt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class WebTest {
    WebDriver driver;

    public String driverName = "webdriver.chrome.driver";
    public String driverPath = "driver/chromedriver.exe";
    public String url = "http://www.sahibinden.com";

    @Before
    public void setup() {
        System.setProperty(driverName, driverPath);
        driver = new ChromeDriver();
    }

    public WebElement find(By by) {
        return driver.findElement(by);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void sendKey(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }


    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void true_username_true_password() {

        driver.navigate().to(url);

        click(By.cssSelector(".login-text [rel]"));
        click(By.cssSelector(".qr-login-promotion .close"));
        sendKey(By.id("username"), "turanaykut35@gmail.com");
        sendKey(By.id("password"), "123456at");
        click(By.cssSelector("#loginForm button"));

        String title = driver.getTitle();
        Assert.assertTrue("login Success", title.contains("Bana Özel Özet"));


   /*     click(By.className("btn")); // enterlıyoruz ve aramayı yapıyor

        thread(1000);

        sendKey(By.id("firstName"),"Aykut");

        sendKey(By.id("lastName"),"Turan");

        sendKey(By.id("email"),"aykutturan@gmail.com");

        sendKey(By.id("password"),"13579");

        click(By.id("uploadPhotoButton"));

        String title = driver.getTitle();
        Assert.assertTrue("PAGE-2 Title içermiyor", title.contains("PAGE-2 Title"));

        driver.findElement(By.id("exampleSelect1")).sendKeys("4ömnb ");
       /* Select select=new Select(find(By.id("exampleSelect1")));
        select.selectByValue("4");

        click(By.id("uploadPhotoButton"));

        thread(100);

        String fN = driver.findElement(By.id("firstName")).getText();
        Assert.assertEquals(fN, "Aykut");
        */
    }

}

