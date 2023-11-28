package myPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class LoginPOM {

    WebDriver driver;

    //constructor
    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(id="user-name")
    WebElement usernameBox;
    public void addUserName(String username){
        usernameBox.click();
        usernameBox.sendKeys(username);
    }

    @FindBy(id="password")
    WebElement passwordBox;
    public void addPassword(String password){
        passwordBox.click();
        passwordBox.sendKeys(password);
    }
    @FindBy(id="login-button")
    WebElement Login;
    public void login(){
        Login.click();
        System.out.println("Login Attempted");
    }

    @FindBy(className = "error-button")
    WebElement errorButton;
    public void loginError(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // wait up to 10 seconds
        wait.until(ExpectedConditions.visibilityOf(errorButton));
        assertThat(errorButton.isDisplayed(),is(true));
    }

    @FindBy(id="react-burger-menu-btn")
    WebElement burgerButton;
    public void burgerButtonClick(){
        burgerButton.click();
    }
    @FindBy(linkText = "Logout")
    WebElement logoutButton;

    @FindBy(id="login-button")
    WebElement loginButton;

    public void logoutButtonClick(){
        logoutButton.click();
        // Hamcrest assertion to check that the login element is displayed
        assertThat(loginButton.isDisplayed(), is(true));
    }

}
