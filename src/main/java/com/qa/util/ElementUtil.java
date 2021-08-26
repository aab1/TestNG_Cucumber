package com.qa.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ElementUtil {


    public static WebDriver driver;
    private static Select select;
    private static Actions action;

    public ElementUtil(WebDriver driver) {
        ElementUtil.driver = driver;
    }

    static {
        select = null;
        action = null;
    }

    /**
     * @return -it returns wait
     * @method -This method initiate explicit wait
     */
    public static WebDriverWait waitExplicitly() {
        return new WebDriverWait(driver, 10);
    }
    /**
     * @method -This method waits for page to load at the set time
     */
    public void waitForThisPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(pageLoadCondition);
    }

    /**
     * This method helps to work with alert on page
     *
     * @method
     */
    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method helps to move to an element that is not in view
     *
     * @param element -it takes the string of element to move to
     * @method
     */
    public static void moveToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * This method simply refresh the current page displayed, and it helps to overcome the
     * stale element reference:element is not attached to the page document error
     *
     * @method
     */
    public static void refreshCurrentPage() throws Exception {
        driver.navigate().refresh();
    }

    /**
     * This method helps to switch to frame.
     *
     * @param{WebElement}
     * @method
     */
    public static void switchToFrame(WebElement element) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /**
     * This method helps to switch from current frame back to default window.
     *
     * @method
     */
    public static void switchOutOfFrame() throws Exception {
        driver.switchTo().defaultContent();
    }

    /**
     * This method helps mouse to hover over any element
     * @param element - It takes element as string
     */
    public static void hoverOver(WebElement element) {
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /**
     * @method -Clicks Element using the action class
     * @param element
     */
    public static void clickAIfClickable(WebElement element) {
        waitExplicitly().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    /**
     * @method - This method helps to click on an element of interest
     * @param element Is takes WebElement
     */
    public static void clickAnElement(WebElement element) throws Exception {
        element.click();
    }

    /**
     * @method -This moves the mouse to the middle of the element and click
     * it solves the element not clickable at point x, y  error
     * @param element -takes WebElement
     */
    public static void moveToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    /**
     * @method -This method helps to click an element when  exception is related to disable or visibility
     * @param element -takes WebElement
     */
    public static void forceClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * @method -This method helps to right-click an element
     * @param{WebElement} It takes the webElement
     */
    public static void rightClickAnElement(WebElement element) {
        action = new Actions(driver);
        action.contextClick(element).build().perform();
    }

    /**
     * @method -This method helps to type given value into a field
     * @param element Element of the text field
     * @param  text  - text to be entered to the text field
     */
    public static void typeGivenValueInto(WebElement element, String text) throws Exception {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * @method -This method helps to type given text into a text box using action class
     * @param element Element of the text field
     * @param text    text to be entered to the text field
     */
    public static void typeGivenTextInto(WebElement element, String text) throws Exception {
        action = new Actions(driver);
        action.moveToElement(element).sendKeys(element, text).build().perform();
    }

    /**
     * @method -This method helps to press keyboard enter key
     * @param element -It takes the WebElement of the point where the enter key should be pressed
     */
    public static void pressEnterKey(WebElement element) throws Exception {
        element.sendKeys(Keys.RETURN);
    }

    /**
     * @method - This method helps to select element from a dropdown by specifying the index of the item needed to be selected
     * @param  element- It takes in the dropdown as a WebElement
     * @param index -  the index as a number
     */
    public static void selectByIndex(WebElement element, int index) throws Exception {
        select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * @param element -Uses - This method helps to select element from a dropdown by specifying the index of the item needed to be selected
     * @param value} - It takes in the dropdown as a WebElement and the index as a number
     */
    public static void selectByValue(WebElement element, String value) throws Exception {
        select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * @param element - Uses - This method helps to select element from a dropdown by specifying the Text of the item needed to be selected
     * @param text - It takes in the dropdown as a WebElement and the Text as a String
     */
    public static void selectByText(WebElement element, String text) throws Exception {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * @method -This method helps to find element by specifying the Id of the element
     * @param id - It takes in the Id as a string
     */
    public static WebElement getElementById(String id) throws Exception {
        By locator = By.id(id);
        return getElement(locator);
    }

    /**
     * @method -This method helps to find List of elements by specifying the Id of the element
     * @param id -It takes in the Id of elements as a string
     * @return -returns list of elements
     */
    public static List<WebElement> getElementsById(String id) throws Exception {
        By locator = By.id(id);
        return getElements(locator);
    }

    /**
     * @method -This method helps to find element by specifying the classname of the element
     * @param className - It takes in the className as a string
     * @return - it returns element
     */
    public static WebElement getElementByClassName(String className) throws Exception {
        By locator = By.className(className);
        return getElement(locator);
    }

    /**
     * @method -This method helps to find elements by specifying the className of the element
     * @param className - It takes in the className as a string
     */
    public static List<WebElement> getElementsByClassName(String className) throws Exception {
        By locator = By.className(className);
        return getElements(locator);
    }

    /**
     * @method -This method helps to find element by specifying the cssSelector identifier of the element
     * @param cssSelector -  It takes in the cssSelector identifier as a string
     */
    public static WebElement getElementByCssSelector(String cssSelector) throws Exception {
        By locator = By.cssSelector(cssSelector);
        return getElement(locator);
    }

    /**
     * This method helps to find elements by specifying the cssSelector identifier of the element
     * @param{String} - It takes in the cssSelector identifier as a string
     */
    public static List<WebElement> getElementsByCssSelector(String cssSelector) throws Exception {
        By locator = By.cssSelector(cssSelector);
        return getElements(locator);
    }

    /**
     * This method helps to find element by specifying the XPath identifier of the element
     *
     * @param{String} - It takes in the XPath identifier as a string
     */
    public static WebElement getElementByXPath(String xpath) throws Exception {
        By locator = By.xpath(xpath);
        return getElement(locator);
    }

    /**
     * This method helps to find element by specifying the link text identifier of the element
     *
     * @param linkText - It takes in the link text identifier as a string
     * @return It returns the element.
     */

    public static WebElement getElementByLinkText(String linkText) throws Exception {
        By locator = By.linkText(linkText);
        return getElement(locator);
    }

    /**
     * This method helps to find elements by specifying the XPath identifier of the element
     *
     * @param{String} - It takes in the XPath identifier as a string
     */
    public static List<WebElement> getElementsByXPath(String xpath) throws Exception {
        By locator = By.xpath(xpath);
        return getElements(locator);
    }

    /**
     * @method -This method helps to retrieve text on a page
     */
    public String getPageSource() throws Exception {
        return driver.getPageSource();
    }

    /**
     * @method -This method helps to find element by specifying the name of the element
     * @param name - It takes in the name as a string
     * @return -it returns the element
     **/
    public static WebElement getElementByName(String name) throws Exception {
        By locator = By.name(name);
        return getElement(locator);
    }

    /**
     * This method helps to find elements by specifying the name of the element
     * @param name It takes in the name of the elements as a string
     * @return it returns list of elements
     * @method
     */
    public static List<WebElement> getElementsByName(String name) throws Exception {
        By locator = By.name(name);
        return getElements(locator);
    }

    private static WebElement getElement(By locator) throws Exception {
        WebElement element = null;
        int tryCount = 0;

        while (element == null) {
            try {
                element = driver.findElement(locator);
                return new WebDriverWait(driver, 1)
                        .until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                if (tryCount == 3) {
                    System.out.println(element.toString() + " cannot be found");
                    throw e;
                }

                tryCount++;
            }
        }
        System.out.println(element.toString() + " is now retrieved");
        return element;
    }

    private static List<WebElement> getElements(By locator) throws Exception {
        List<WebElement> element = null;
        int tryCount = 0;

        while (element == null) {
            try {
                element = driver.findElements(locator);
                return new WebDriverWait(driver, 1)
                        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            } catch (Exception e) {
                if (tryCount == 3) {
                    System.out.println(element.toString() + " cannot be found");
                    throw e;
                }

                tryCount++;
            }
        }
        System.out.println(element.toString() + " is now retrieved");
        return element;
    }


}
