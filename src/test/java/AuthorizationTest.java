import com.codeborne.selenide.junit.SoftAsserts;
import org.junit.Rule;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest extends BaseTest {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();
    @Rule
    public SoftAsserts softAsserts = new SoftAsserts();

    @Test
    public void authorizationTest() {
        open(BASE_URL);
        authorizationPage.registrationForm();
    }
    @Test
    public void negativeAuthorizationTest() {
        open(BASE_URL);
        authorizationPage.negativeRegistrationForm();
    }
}





