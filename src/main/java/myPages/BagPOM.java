package myPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
    public boolean checkCartBadge() {
        String spanText = badgeValue.getText();
        if (spanText=="1"){
            System.out.println("Badge value is 1");
            return true;
        }
        else return false;
    }
    //click on cart
    @FindBy(className="shopping_cart_link")
    WebElement shoppingCartLink;
    public void clickOnCart() {
        shoppingCartLink.click();

    }

    @FindBy(className = "inventory_item_price")
    WebElement itemPrice;
    public boolean checkPrice() {
        //check value
        String spanText = itemPrice.getText();
        if(spanText=="$29.99"){
            System.out.println("Item value is $29.99");
            return true;
        }
        else{
            return false;
        }
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
    @FindBy(className = "summary_subtotal_label")
    WebElement taxContent;
    public boolean checkTax() {
        String myTax=taxContent.getText();
        if(myTax=="Tax: $2.40"){
            return true;
        }
        else return false;
    }

    @FindBy(className = "summary_total_label")
    WebElement totalContent;
    public boolean checkFinalPrice() {
        if(totalContent.getText()=="Total: $32.39"){
            return true;
        }
        else return false;
    }

    @FindBy(id="finish")
    WebElement finishButton;
    public void clickFinishButton() {
        finishButton.click();
    }

    @FindBy(className="complete-header")
    WebElement thanksOrder;
    public boolean checkOrderMessage() {
        String orderMessage = thanksOrder.getText();
        if (orderMessage=="Thank you for your order!"){
            return true;
        }
        else return false;
    }
}
