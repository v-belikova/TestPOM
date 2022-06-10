import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();
    LogInTest login = new LogInTest();

    @Test
    public void loginIn() {
        open(BASE_URL);
        authorizationPage.authorizationUser();
    }
    public void negativeLoginIn(){
        open(BASE_URL);
    }

}
