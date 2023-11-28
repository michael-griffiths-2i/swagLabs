package utilities;
import myPages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    private LoginPOM login;

    //set up the WebDriver which should be protected (requires org.openqa.selenium.WebDriver);
    protected WebDriver driver;
    //set up the baseUrl which should be protected
    protected String baseUrl ="https://www.saucedemo.com";

    // 'setUp' is a function that runs before each test
    @BeforeEach
    void setUp() {

        // We're setting up our remote to be the Chrome remote
        this.driver = new ChromeDriver();

        // We're telling our remote to go to our test website
        this.driver.get(this.baseUrl);

    }

    // 'tearDown' is a function that runs before each test
    @AfterEach
    void tearDown(){

        driver.quit();
    }
}
