import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MyProfileTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();

    @Epic(value = "AuthorizationPage")
    @Feature("Profile.")
    @Story("Information about my profile.")
    @Description("Getting information on my profile")

    @Test
    public void MyProfile()  {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.getInfoMyProfilePage().shouldBe(Condition.visible);
    }
}
