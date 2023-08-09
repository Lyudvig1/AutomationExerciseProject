package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import testdata.StaticData;
import static testdata.DynamicData.*;

public class Helper {

    public static Faker faker = new Faker();
    public static String randomName = faker.name().firstName();
    public static String randomEmail = faker.internet().emailAddress();
    public static String randomLastName = faker.name().lastName();
    public static String randomCompanyName = faker.company().name();
    public static String randomAddressName = faker.address().streetAddress();
    public static String randomStateName = faker.address().state();
    public static String randomCityName = faker.address().cityName();
    public static String randomZipcode = faker.address().zipCode();
    public static String randomMobileNumber = faker.phoneNumber().phoneNumber();
    public static String randomNumber = faker.idNumber().toString();


    public static void setDynamicData() {
        setUserName(randomName);
        setEmailAddress(randomEmail);
        setPassword(emailAddress);
        setLastName(randomLastName);
        setCompanyName(randomCompanyName);
        setAddress(randomAddressName);
        setStateName(randomStateName);
        setCityName(randomCityName);
        setZipcode(randomZipcode);
        setMobileNumber(randomMobileNumber);
        setRandomNumber(randomNumber);
    }

    public static void sendCreateAccountAPIRequest(String email, String password) throws Exception {
        String apiUrl = StaticData.BASE_URL+"api/createAccount";

        // Form data parameters
        String formData = "name=llllllllpp"
                + "&email=" + email
                + "&password=" + password
                + "&title=Mr"
                + "&birth_date=15"
                + "&birth_month=August"
                + "&birth_year=1985"
                + "&firstname=John"
                + "&lastname=Doe"
                + "&company=ABC Corporation"
                + "&address1=123 Main Street"
                + "&address2=Apt 456"
                + "&country=United States"
                + "&zipcode=12345"
                + "&state=California"
                + "&city=Los Angeles"
                + "&mobile_number=+1 123-456-7890";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = formData.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        var responseCode = connection.getResponseCode();

        System.out.println(responseCode);
        connection.disconnect();
    }

    public static void sendDeleteAccountAPIRequest(String email, String password) throws Exception {
        String apiUrl = StaticData.BASE_URL+"api/deleteAccount";

        String formData = "email=" + email + "&password=" + password;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("DELETE");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = formData.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        var responseCode = connection.getResponseCode();

        System.out.println(responseCode);
        connection.disconnect();
    }

    public static ChromeOptions setAdBlock() {
        ChromeOptions options = new ChromeOptions();
        return options.addExtensions(new File("src/main/resources/extensions/AdBlock.crx"));
    }

}
