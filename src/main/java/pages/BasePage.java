package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BasePage<T extends BasePage<T>> {
    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        this.driver.get(url);
    }

    public void switchToTab(int index) {
        ArrayList<String> tabs = new ArrayList<>(this.driver.getWindowHandles());
        this.driver.switchTo().window(tabs.get(index));
    }

    protected void waitForElementVisibility(By selector) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected void waitForElementExist(By selector) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    protected WebElement getWebElement(By selector) {
        this.waitForElementVisibility(selector);
        return driver.findElement(selector);
    }

    protected List<WebElement> getWebElements(By selector) {
        return driver.findElements(selector);
    }

    protected void clickOnElement(By selector) {
        this.getWebElement(selector).click();
    }

    protected void typeText(By selector, String text) {
        WebElement inputField = this.getWebElement(selector);
        scrollInToView(selector);
        String currentText = inputField.getAttribute("value");
        inputField.click();
        if (currentText != null && !currentText.isEmpty()) {
            inputField.clear();
        }
        inputField.sendKeys(text);
    }

    public void selectRandomDropdownOption(By dropdown, By option) {
        Random random = new Random();
        clickOnElement(dropdown);
        var options = getWebElements(option);
        int index = random.nextInt(options.size());
        if (index == 1) index += 1;
        options.get(index).click();
    }

    protected String getPageTitle() {
        return this.driver.getTitle().toString();
    }

    protected void verifyPageTitle(String title) {
        var actualTitle = getPageTitle();
        Assert.assertEquals(actualTitle, title);
    }

    public void shouldBeVisible(By selector) {
        var element = getWebElement(selector);
        Assert.assertTrue(element.isDisplayed());
    }

    public void compareStrings(By selector, String string) {
        var text = getWebElement(selector).getText();
        Assert.assertEquals(text, string);
    }

    protected void scrollInToView(By selector) {
        var elementToScroll = getWebElement(selector);
        if (!(boolean) ((JavascriptExecutor) driver).executeScript("var rect = arguments[0].getBoundingClientRect(); return (rect.top < 0 || rect.bottom > window.innerHeight);", elementToScroll)) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
        }
    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    protected boolean isElementExists(By locator) {
        try {
            getWebElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void closePoUpIfNeeded(By iframe, By selector) {
        try {
            var frame = getWebElement(iframe);
            this.driver.switchTo().frame(frame);
            clickOnElement(selector);
            this.driver.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            e.getStackTrace();
        }
    }

    protected void clickOnPageLeftSide(WebDriver driver) {

        int windowWidth = driver.manage().window().getSize().getWidth();
        int xCoordinate = (int) (windowWidth * 0.2);

        Actions actions = new Actions(driver);
        actions.moveByOffset(xCoordinate, 0).click().perform();
    }

    protected void compareTextLists(By elementsList1, By elementsList2, int startIndex) {
        var list1 = getWebElements(elementsList1);
        var list2 = getWebElements(elementsList2);
        for (int i = startIndex; i < list1.size(); i++) {
            String textFromList1 = list1.get(i).getText();
            String textFromList2 = list2.get(i).getText();
            Assert.assertEquals(textFromList1, textFromList2);
        }
    }
}
