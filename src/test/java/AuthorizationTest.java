import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest extends BaseTest {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void authorizationTest() {
        open(BASE_URL);
        authorizationPage.registrationForm();
    }
    @Test
    public void negativeAuthorizationTest(){
        open(BASE_URL);

    }
}





