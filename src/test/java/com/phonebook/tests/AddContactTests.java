package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    //login
    @BeforeMethod
    public void precondition() {
        // precondition -> login
        // berem is class LoginTest
        clickOnLoginLink();
        fillRegisterLoginForm("1a@1b.com", "Aa12345$");
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on Add link
        clickOnAdd();
        //enter name
        fillContactForm("John", "Doe", "1234567890", "jk@kl.com", "123 Main St, New York, NY 10001", "test");
        //click on Save button
        clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(isContaktAdded("John"));
    }

    @AfterMethod
    public void postCondition() {
        deleteContact();
    }
}
