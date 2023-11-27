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

    //setUp BeforeEach
    @BeforeEach
    void setUp(){

        driver = new ChromeDriver();
        driver.get(baseUrl);
        login = new LoginPOM(driver);
    }

    //setUp AfterEach
    @AfterEach
    void tearDown(){

        driver.quit();
    }
}
