package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isHomeComponentPresent(){
        //XPath -> //div[2]/div/div/h1
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1")).size()>0;
    }

    public boolean isElementLocator(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) { //bil private, rename an public
        driver.findElement(locator).click();
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        //WebDriver будет ожидать появления всплывающего окна (alert) на странице до 20 секунд
        if (alert == null) {
            return false;
        } else {
            System.out.println(alert.getText());
            return true;
        }

    }

    public void fillRegisterLoginForm(String email, String password) {
        type(By.name("email"), email);
        type(By.name("password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnRegistratoin() {
        click(By.name("registration"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementLocator(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(String name, String lastName, String phone, String email, String address, String description) {
        type(By.cssSelector("input[placeholder='Name']"), name);
        //enter last name
        type(By.cssSelector("input[placeholder='Last Name']"), lastName);
        //enter phone
        type(By.cssSelector("input[placeholder='Phone']"), phone);
        //enter email
        type(By.cssSelector("input[placeholder='email']"), email);
        //enter address
        type(By.cssSelector("input[placeholder='Address']"), address);
        //enter description
        type(By.cssSelector("input[placeholder='description']"), description);
    }

    public void clickOnAdd() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContaktAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
            return false;
    }

    public void deleteContact() {
        click(By.xpath("(//div[@class='contact-item_card__2SOIM'])[last()]"));
        //click(By.cssSelector(".contact-item_card__2SOIM"));(//div[@class='contact-item_card__2SOIM'])[last()]
        click(By.xpath("//button[.='Remove']"));
    }
}
