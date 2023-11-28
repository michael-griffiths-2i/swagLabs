package myPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;



public class BagPOM {

    WebDriver driver;

    //constructor
    public BagPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    //Locators

    //add to cart button
    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    WebElement AddToCart;
    public void addToCart() {

        AddToCart.click();

    }



    //shopping cart badge should have value of 1
    @FindBy(className="shopping_cart_badge")
    WebElement badgeValue;
    public void checkCartBadge() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // wait up to 10 seconds
        wait.until(ExpectedConditions.visibilityOf(badgeValue));
        String spanText = badgeValue.getText();
        assertThat(spanText, is("1"));
    }
    //click on cart
    @FindBy(className="shopping_cart_link")
    WebElement shoppingCartLink;
    public void clickOnCart() {
        shoppingCartLink.click();

    }

    @FindBy(className = "inventory_item_price")
    WebElement itemPrice;
    public void checkPrice() {
        //check value
        String spanText = itemPrice.getText();
        assertThat(spanText, is("$29.99"));

    }
    //buttonclass.linktext should have Remove
    @FindBy(name = "remove-sauce-labs-backpack")
    WebElement removeItem;
    public void removeFromCart() {
        removeItem.click();
    }

    @FindBy(id = "checkout")
    WebElement checkoutButton;
    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    @FindBy(id="first-name")
    WebElement firstNameBox;
    public void addFirstName() {
        firstNameBox.click();
        firstNameBox.sendKeys("Michael");
    }
    @FindBy(id="last-name")
    WebElement lastNameBox;
    public void addLastName() {
        lastNameBox.click();
        lastNameBox.sendKeys("Mouse");
    }
    @FindBy(id="postal-code")
    WebElement postCodeBox;
    public void addPostCode() {
        postCodeBox.click();
        postCodeBox.sendKeys("G1");
    }

    @FindBy(id="continue")
    WebElement continueButton;
    public void clickContinue() {
        continueButton.click();
    }
    @FindBy(className = "summary_tax_label")
    WebElement taxContent;
    public void checkTax() {
        String myTax=taxContent.getText();
        assertThat(myTax, is("Tax: $2.40"));

    }

    @FindBy(className = "summary_total_label")
    WebElement totalContent;
    public void checkFinalPrice() {

        assertThat(totalContent.getText(), is("Total: $32.39"));

    }

    @FindBy(id="finish")
    WebElement finishButton;
    public void clickFinishButton() {
        finishButton.click();
    }

    @FindBy(className="complete-header")
    WebElement thanksOrder;
    public void checkOrderMessage() {
        String orderMessage = thanksOrder.getText();
        assertThat(orderMessage, is("Thank you for your order!"));
    }
}
