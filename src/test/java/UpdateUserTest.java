import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class UpdateUserTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();

    @Epic(value = "MyProfilePage")
    @Feature("Profile.")
    @Story("Update my profile.")
    @Description("Update my profile information")

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


