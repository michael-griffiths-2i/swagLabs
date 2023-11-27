import myPages.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class LoginTests extends TestBase {

    private LoginPOM login;
    private BagPOM bag;

    @Test
    public void standard_user() {
        System.out.println("Running standard user");
        login = new LoginPOM(driver);

        //input the username : standard_user & pwd secret_sauce
        login.addUserName("standard_user");
        login.addPassword("secret_sauce");
        login.login();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished standard user");

    }

    @Test
    void locked_out_user() {
        //input the username : locked_out_user & pwd secret_sauce
        login = new LoginPOM(driver);
        login.addUserName("locked_out_user");
        login.addPassword("secret_sauce");
        login.login();
        login.loginError();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void standard_user_logout() {
        login = new LoginPOM(driver);
        standard_user();
        login.burgerButtonClick();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        login.logoutButtonClick();



    }
    @Test
    void nearlybuyAbag(){
        bag = new BagPOM(driver); // Initialize the bag object
        //add to cart button
        standard_user();
        bag.addToCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //shopping cart badge should have value of 1
        bag.checkCartBadge();

        //click on cart
        bag.clickOnCart();
        //check value
        bag.checkPrice();
        //remove
        bag.removeFromCart();

    }

    @Test
    void buyAbag(){
        bag = new BagPOM(driver); // Initialize the bag object
        //add to cart button
        standard_user();
        bag.addToCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //shopping cart badge should have value of 1
        bag.checkCartBadge();

        //click on cart
        bag.clickOnCart();
        //check value
        bag.checkPrice();
        //checkout
        bag.clickCheckoutButton();
        //enter details Michael Mouse
        bag.addFirstName();
        bag.addLastName();
        bag.addPostCode();
        bag.clickContinue();
        //check tax
        bag.checkTax();
        //check price
        bag.checkFinalPrice();
        //finish
        bag.clickFinishButton();
        //check order message
        bag.checkOrderMessage();

    }

}

