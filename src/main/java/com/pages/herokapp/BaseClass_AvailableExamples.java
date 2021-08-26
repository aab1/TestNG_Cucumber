package com.pages.herokapp;

import com.qa.util.ElementUtil;
import org.openqa.selenium.WebDriver;

public class BaseClass_AvailableExamples extends ElementUtil {

    WebDriver driver;
    public BaseClass_AvailableExamples(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public DynamicLoadingPage clickDynamicLoading(String linkText) throws Exception {
        clickAnElement(getElementByLinkText(linkText));
        return new DynamicLoadingPage(driver);
    }
}
