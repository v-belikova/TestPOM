import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class DeleteMyProfileTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();

    @Test
    public void deleteProfile() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.deleteUser();
        authorizationPage.getHelloHeader().shouldBe(text("Hello,"));
    }
    @Test
    public void deleteProfileNegative() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.deleteUserNegative();
        // authorizationPage.getHelloHeader().shouldBe(text("Hello,"));
    }
}


