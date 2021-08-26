package com.pages.login;

import com.qa.util.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageSelectors extends ElementUtil {

    private static WebElement element;

    public LoginPageSelectors(WebDriver driver) {
        super(driver);
    }

    public static WebElement getUserNameElement() throws Exception {
         element =  waitExplicitly().until(ExpectedConditions.visibilityOf(getElementById("email")));
         return element;
    }
}
