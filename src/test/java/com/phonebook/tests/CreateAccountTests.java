package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        //click on Login Link
        clickOnLoginLink();

        //enter Email to email field
        //click, ochishenie, dannie
        //randomniy email
        //type(By.name("email"), "1a" + i + "@1b.com");
        fillRegisterLoginForm("1a@1b.com", "Aa12345$");

        //click on Registration button
        clickOnRegistratoin();

        //verify SingOut Link is displayed
        Assert.assertTrue(isSignOutButtonPresent());

    }


    @Test
    public void existedUserRegistrationNegativeTest() {
        //click on Login Link
        clickOnLoginLink();

        //enter Email to email field
        //click, ochishenie, dannie
        fillRegisterLoginForm("1a@1b.com", "Aa12345$");

        //click on Registration button
        clickOnRegistratoin();

        //verify SingOut Link is displayed
        Assert.assertTrue(isAlertDisplayed());

    }

}

