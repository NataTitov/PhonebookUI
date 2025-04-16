package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    //precondition
    @BeforeMethod
    public void precondition() {
        //login
        clickOnLoginLink();
        fillRegisterLoginForm("1a@1b.com", "Aa12345$");
        clickOnLoginButton();
        clickOnAdd();
        //add contact
        fillContactForm("John", "Doe", "1234567890", "jk@kl.com", "123 Main St, New York, NY 10001", "test");
        clickOnSaveButton();

    }
    //test
    @Test
    public void deleteContactTest(){
        int sizeBefor = sizeOfContacts();
        //click on the card
        //click on remove button
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        //verify contact is deleted(by size)
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefor - 1);

    }

    public int sizeOfContacts() {
        if(isElementLocator(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
