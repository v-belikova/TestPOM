import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UpdatePostTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void updatePost() {
        open(BASE_URL);
        authorizationPage.authorizationUser();
        authorizationPage.infoMyProfile();
        myProfile.createNewPost();
        myProfile.updatePost();
    }
    @Test
    public void negativeUpdatePost() {
        open(BASE_URL);
        authorizationPage.authorizationUser();
        authorizationPage.infoMyProfile();
        myProfile.createNewPost();
        myProfile.negativeUpdatePost();
    }
}
