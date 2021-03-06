import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Rule;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest extends BaseTest {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();
    String avatar = "src/main/resources/avatar.jpeg";
    File file = new File(new File(avatar).getAbsolutePath());

    @Epic(value = "AuthorizationPage")
    @Feature("Authorization.")
    @Story("Valid authorization.")
    @Description("user authentication")

    @Test
    public void authorizationTest() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.getHelloHeader().shouldBe(text("Hello,"), text("123456"));
    }
    @Test
    public void negativeAuthorizationTest() {
        open(BASE_URL);
        authorizationPage.negativeRegistrationForm();
        authorizationPage.getAlertError().shouldBe(Condition.visible).shouldHave(text("password not valid"));
    }
}





