import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UpdateUserTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void updateUser() {
        open(BASE_URL);
        authorizationPage.authorizationUser();
        authorizationPage.infoMyProfile();
        myProfile.updateUser();
    }
    @Test
    public void negativeUpdateUser() throws InterruptedException {
        open(BASE_URL);
        authorizationPage.authorizationUser();
        authorizationPage.infoMyProfile();
        myProfile.negativeUpdateUser();
        Thread.sleep(5000);
    }
}

