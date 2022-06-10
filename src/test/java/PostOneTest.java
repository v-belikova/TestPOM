import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class PostOneTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void postOne() {
        open(BASE_URL);
        authorizationPage.postOne();
    }
    @Test
    public void negativePostOne() throws InterruptedException {
        open(BASE_URL);
        authorizationPage.negativePostOne();
    }

}
