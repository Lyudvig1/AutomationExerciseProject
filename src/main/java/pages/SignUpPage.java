package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SignUpPage extends BasePage<SignUpPage> {

    private final By accountInfoHeader = By.xpath("//b[contains(text(), 'Enter Account')]");
    private final By nameInput = By.cssSelector("[data-qa='name']");
    private final By emailInput = By.cssSelector("[data-qa='email']");
    private final By passwordInput = By.cssSelector("[data-qa='password']");
    private final By newsletterCheckbox = By.cssSelector("#newsletter");
    private final By receivePartnersCheckbox = By.cssSelector("#optin");
    private final By firstNameInput = By.cssSelector("[data-qa='first_name']");
    private final By lastNameInput = By.cssSelector("[data-qa='last_name']");
    private final By companyInput = By.cssSelector("[data-qa='company']");
    private final By addressInput = By.cssSelector("[data-qa='address']");
    private final By address2Input = By.cssSelector("[data-qa='address2']");
    private final By countryDropdown = By.cssSelector("[data-qa='country']");
    private final By countryDropdownOptions = By.cssSelector("[data-qa='country']>option");
    private final By stateInput = By.cssSelector("[data-qa='state']");
    private final By cityInput = By.cssSelector("[data-qa='city']");
    private final By zipcodeInput = By.cssSelector("[data-qa='zipcode']");
    private final By mobileNumberInput = By.cssSelector("[data-qa='mobile_number']");
    private final By createAccountBtn = By.cssSelector("[data-qa='create-account']");

    private By genderRadioButtons(int index) {
        return By.xpath("//input[@id='id_gender" + index + "']");
    }

    private By dateDropdown(String date) {
        return By.cssSelector("[data-qa='" + date + "']");
    }

    private By dateDropdownOptions(String date) {
        return By.cssSelector("[data-qa='" + date + "']>option");
    }

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage verifyAccountInfoHeaderVisibility() {
        waitForElementVisibility(accountInfoHeader);
        shouldBeVisible(accountInfoHeader);
        return this;
    }

    public SignUpPage selectGender() {
        Random random = new Random();
        int index = random.nextInt(2) + 1;
        clickOnElement(genderRadioButtons(index));
        return this;
    }

    public SignUpPage selectDay() {
        scrollInToView(dateDropdown("days"));
        waitForElementVisibility(dateDropdown("days"));
        selectRandomDropdownOption(dateDropdown("days"), dateDropdownOptions("days"));
        return this;
    }

    public SignUpPage selectMonth() {
        scrollInToView(dateDropdown("months"));
        waitForElementVisibility(dateDropdown("months"));
        selectRandomDropdownOption(dateDropdown("months"), dateDropdownOptions("months"));
        return this;
    }

    public SignUpPage selectYear() {
        scrollInToView(dateDropdown("years"));
        waitForElementVisibility(dateDropdown("years"));
        selectRandomDropdownOption(dateDropdown("years"), dateDropdownOptions("years"));
        return this;
    }

    private void fillInDisabledEmailField(String value) {
        String emailValue = value;
        var emailField = getWebElement(emailInput);

        String script = "arguments[0].setAttribute('value', arguments[1]);";
        ((JavascriptExecutor) driver).executeScript(script, emailField, emailValue);
    }

    public SignUpPage fillAccountDetails(String name, String email, String password) {
        selectGender();
        typeText(nameInput, name);
        fillInDisabledEmailField(email);
        typeText(passwordInput, password);
        selectDay();
        selectMonth();
        selectYear();
        clickOnElement(newsletterCheckbox);
        clickOnElement(receivePartnersCheckbox);
        return this;
    }

    public SignUpPage fillAddressDetails(String firstName, String lastname, String companyName,String address, String state,String city,String zipcode,String mobileNumber) {
        typeText(firstNameInput,firstName);
        typeText(lastNameInput,lastname);
        typeText(companyInput,companyName);
        selectRandomDropdownOption(countryDropdown, countryDropdownOptions);
        typeText(addressInput,address);
        typeText(address2Input,address);
        typeText(stateInput,state);
        typeText(cityInput,city);
        typeText(zipcodeInput,zipcode);
        typeText(mobileNumberInput,mobileNumber);
        clickOnElement(createAccountBtn);
        return this;
    }
}
