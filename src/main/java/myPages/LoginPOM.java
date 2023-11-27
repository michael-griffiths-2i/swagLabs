package myPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPOM {

    WebDriver driver;

    //constructor
    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
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
        errorButton.isDisplayed();
    }

    @FindBy(id="react-burger-menu-btn")
    WebElement burgerButton;
    public void burgerButtonClick(){
        burgerButton.click();
    }
    @FindBy(linkText = "Logout")
    WebElement logoutButton;
    public void logoutButtonClick(){
        logoutButton.click();
        Login.isDisplayed();
    }









    /*
    @FindBy(linkText = "Dismiss")
    WebElement dismissLink;
    public void dismissWarning(){
        dismissLink.click();
        System.out.println("Demo store warning dismissed");

    }

    @FindBy(linkText = "Shop")
    WebElement shopLink;
    public void shopLink(){
        shopLink.click();
        System.out.println("Shop has been opened");
    }

    @FindBy(css = "a[aria-label='Add “Beanie” to your cart']")
    WebElement addBeanieToCart;
    public void addProductToCart() {
        addBeanieToCart.click();
        System.out.println("Beanie has been added to cart");
    }

    @FindBy(linkText ="Cart")
    WebElement viewCartLink;
    public void viewCartLink(){
        viewCartLink.click();
        System.out.println("Viewing cart");
    }
    */

}
