package com.pages.herokapp;

import com.qa.util.ConfigJsonFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BaseClass_AvailableExamples {

    WebDriver driver;
    WebElement element;

    //read selectors from json file object
    ConfigJsonFileReader readSelectorsFromJson = new ConfigJsonFileReader("./src/main/java/com/pages/herokapp/DynamicLoadingPageSelectors.json");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    //used json to populate selectors
    public void clickExampleOne() throws Exception {
//        clickAnElement(getElementByLinkText(exampleOneLinkTextElement));
        clickAnElement(getElementByLinkText(readSelectorsFromJson.getSelectorFromJson("links", "exampleOneLinkTextElement")));
    }


    public void clickStartButton() throws Exception {
        clickAIfClickable(getElementByCssSelector(readSelectorsFromJson.getSelectorFromJson("buttons", "start")));
    }

    public String getHelloWorldText() throws Exception {
        element = waitExplicitly().until(ExpectedConditions.visibilityOf(getElementByCssSelector(readSelectorsFromJson.getSelectorFromJson("pageText", "exampleOneFinish_HelloWord"))));
        return element.getText();
    }
}
