package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //
    @Test
    public void loginPositiveTest() {
        //click on Login Link
        app.getUser().clickOnLoginLink();

        //enter Email to email field
        //click, ochishenie, dannie
        app.getUser().fillRegisterLoginForm(new User().setEmail("1a@1b.com").setPassword("Aa12345$"));

        //click Login button
        app.getUser().clickOnLoginButton();

        //verify SingOut Link is displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setPassword("Aa12345$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
