import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class UpdateUserTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void updateUser() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.updateUser();
        authorizationPage.getHelloHeader().shouldBe(text("Hello,"), text("123"));


    }
    @Test
    public void negativeUpdateUser() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.negativeUpdateUser();
        myProfile.getStringError().shouldBe(Condition.visible).shouldHave(text("unknown"));
    }
}


