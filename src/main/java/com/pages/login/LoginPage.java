package com.pages.login;

import com.pages.account.AccountsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LoginPageSelectors {

    private WebDriver driver;

    // 1. By Locators: OR
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");

    // 2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
//        typeGivenTextInto(getUserNameElement(), username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    /*
     * Assertions should be written in the test classes and not in page class
     * I can also create waitTime in config properties and create explicit
     * wait in the constructor for each page or keep it in the util class
     */
    public AccountsPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
//        try {
//            typeGivenTextInto(getUserNameElement(), un);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }

}
