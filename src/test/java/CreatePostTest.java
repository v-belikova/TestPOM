import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CreatePostTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void createPost() {
        open(BASE_URL);
        authorizationPage.authorizationUser();
        authorizationPage.infoMyProfile();
        myProfile.createNewPost();
    }
}

