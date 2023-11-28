import myPages.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class LoginTests extends TestBase {

    private LoginPOM login;// 'login' is a map of the shopping bag page.
    private BagPOM bag; // 'bag' is a map of the shopping bag page.

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
        System.out.println("Running locked_out_user");
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
        System.out.println("Running standard_user_logout");
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
        System.out.println("Running nearlybuyAbag");
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
        System.out.println("Running buyAbag");

        bag = new BagPOM(driver); // Initialize the bag object
        //add to cart button
        standard_user();
        bag.addToCart();

        //just delaying the page for a second and allowing the item to be added to cart
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
        bag.checkTax();
        bag.checkFinalPrice();
        bag.clickFinishButton();
        bag.checkOrderMessage();

    }

    @Test
    void buyAProduct(){
        System.out.println("Running buyAProduct");

        bag = new BagPOM(driver); // Initialize the bag object
        standard_user();
        bag.addToCart();

        //just delaying the page for a second and allowing the item to be added to cart
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
        bag.checkTax();
        bag.checkFinalPrice();
        bag.clickFinishButton();
        bag.checkOrderMessage();

    }


}

