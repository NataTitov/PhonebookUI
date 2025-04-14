package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href='/login']")).click();

        //enter Email to email field
        //click, ochishenie, dannie
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("1a@1b.com");

        //enter Password to password field
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Aa12345$");

        //click on Registration button
        driver.findElement(By.name("registration")).click();

        //verify SingOut Link is displayed
        Assert.assertTrue(isElementLocator(By.xpath("//button[.='Sign Out']")));

    }@Test
    public void existedUserRegistrationNegativeTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href='/login']")).click();

        //enter Email to email field
        //click, ochishenie, dannie
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("1a@1b.com");

        //enter Password to password field
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Aa12345$");

        //click on Registration button
        driver.findElement(By.name("registration")).click();

        //verify SingOut Link is displayed
        Assert.assertTrue(isElementLocator(By.xpath("//button[.='Sign Out']")));

    }
}
