package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
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
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("1a@1b.com").setPassword("Aa12345$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on Add link
        app.getContact().clickOnAdd();
        //enter name
        app.getContact().fillContactForm(new Contact()
                .setName("John")
                .setLastName("Doe")
                .setPhone("1234567890")
                .setEmail("jk@kl.com")
                .setAddress("123 Main St, New York, NY 10001")
                .setDescription("test"));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(app.getContact().isContaktAdded("John"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().deleteContact();
    }
}
