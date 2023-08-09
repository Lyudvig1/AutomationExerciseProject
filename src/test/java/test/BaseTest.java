package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import share.App;

import testdata.StaticData;

import static utils.Helper.*;

public class BaseTest {
    protected WebDriver driver;
    protected App app;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver(setAdBlock());
        driver.manage().window().maximize();
        setDynamicData();
        this.app = new App(driver);
        sendCreateAccountAPIRequest(StaticData.DEFAULT_USER_EMAIL, StaticData.DEFAULT_USER_PASSWORD);
    }

    @BeforeMethod
    public void verifyHomePageVisibility() {
        app.homePage.open(StaticData.BASE_URL);
        app.homePage.switchToTab(0);
        app.homePage.verifyHomePageVisibility(StaticData.HOME_PAGE_TITLE);

    }

    @AfterClass
    public void tearDown() throws Exception {
        sendDeleteAccountAPIRequest(StaticData.DEFAULT_USER_EMAIL, StaticData.DEFAULT_USER_PASSWORD);
        if (driver != null) {
            driver.quit();
        }
    }
}
