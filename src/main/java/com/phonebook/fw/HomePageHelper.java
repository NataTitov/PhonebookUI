package com.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent(){
        //XPath -> //div[2]/div/div/h1
        return isElementLocator(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }

    public void clickOnHomeLink() {
        click(By.cssSelector("[href='/home']"));
    }
}
