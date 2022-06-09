import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AllPostsTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void allPost() {
        open(BASE_URL);
        authorizationPage.allPost();
    }
}
