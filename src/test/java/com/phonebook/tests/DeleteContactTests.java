package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    //precondition
    @BeforeMethod
    public void precondition() {
        //login
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("1a@1b.com").setPassword("Aa12345$"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAdd();
        //add contact
        app.getContact().fillContactForm(new Contact()
                .setName("John")
                .setLastName("Doe")
                .setPhone("1234567890")
                .setEmail("jk@kl.com")
                .setAddress("123 Main St, New York, NY 10001")
                .setDescription("test"));
        app.getContact().clickOnSaveButton();

    }
    //test
    @Test
    public void deleteContactTest(){
        int sizeBefor = app.getContact().sizeOfContacts();
        //click on the card
        //click on remove button
        app.getContact().deleteContactFromTest();
        //verify contact is deleted(by size)
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefor - 1);
    }

}
