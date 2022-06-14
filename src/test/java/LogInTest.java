import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class LogInTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();
    LogInTest login = new LogInTest();


    @Epic(value = "AuthorizationPage")
    @Feature("Login.")
    @Story("Valid Login.")
    @Description("Validating an authorized user's input")

    @Test
    public void loginIn() {
        open(BASE_URL);
        authorizationPage.authorizationUser();
        authorizationPage.getHelloHeader().shouldHave(text("Hello,"), text("1234567"));
    }
    @Test
    public void negativeAuthorizationTest(){
        open(BASE_URL);
        authorizationPage.authorizationUserNegative();
        authorizationPage.getAlertError().shouldBe(Condition.visible).shouldHave(text("Password not valid"));
    }
}



