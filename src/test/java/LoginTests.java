import myPages.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class LoginTests extends TestBase {

    private LoginPOM login;

    @Test
    void standard_user() {
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




}//end of HelloWebDriver

