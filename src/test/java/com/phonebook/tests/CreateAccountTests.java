package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {
//останавливает выполнение теста при первой ошибке
    SoftAssert softAssert = new SoftAssert();

    //int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        //click on Login Link
        app.getUser().clickOnLoginLink();

        //enter Email to email field
        //click, ochishenie, dannie
        //randomniy email
        //type(By.name("email"), "1a" + i + "@1b.com");
        app.getUser().fillRegisterLoginForm(new User().setEmail("1a@1b.com").setPassword("Aa12345$"));

        //click on Registration button
        app.getUser().clickOnRegistratoin();

        //verify SingOut Link is displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }


    @Test
    public void existedUserRegistrationNegativeTest() {
        //click on Login Link
        app.getUser().clickOnLoginLink();

        //enter Email to email field
        //click, ochishenie, dannie
        app.getUser().fillRegisterLoginForm(new User().setEmail("1a@1b.com").setPassword("Aa12345$"));

        //click on Registration button
        app.getUser().clickOnRegistratoin();

        //verify SingOut Link is displayed
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();

    }

}

