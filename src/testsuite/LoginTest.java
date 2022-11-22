package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

  public static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("username"),"tomsmith");
//input[@id='username']
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        ////input[@id='password']
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String expectedM="Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(expectedM,getTextFromElement(By.xpath("//h4[@class='subheader']")));
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        sendTextToElement(By.id("username"),"tomsmith1");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String expectedM1="Your username is invalid!\n" +
                "×";
        Assert.assertEquals(expectedM1,getTextFromElement(By.xpath("//div[contains(text(),'Your username is invalid!')]")));
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"),"SuperSecretPassword");
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String expectedM2="Your password is invalid!\n" +
                "×";
        Assert.assertEquals(expectedM2,getTextFromElement(By.xpath("//div[contains(text(),'Your password is invalid!')]")));
    }
}



