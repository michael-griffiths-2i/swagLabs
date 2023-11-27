import myPages.LoginPOM;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class LogoutTests extends TestBase {

    private LoginPOM login;

    @Test
    void standard_user_logout() {
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
        login.burgerButtonClick();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        login.logoutButtonClick();



    }






}//end of HelloWebDriver

