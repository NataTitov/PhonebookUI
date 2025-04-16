package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //
    @Test
    public void loginPositiveTest() {
        //click on Login Link
        clickOnLoginLink();

        //enter Email to email field
        //click, ochishenie, dannie
        fillRegisterLoginForm("1a@1b.com", "Aa12345$");

        //click Login button
        clickOnLoginButton();

        //verify SingOut Link is displayed
        Assert.assertTrue(isSignOutButtonPresent());
    }

}
