import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeletePostTest extends BaseTest {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Epic(value = "MyProfilePage")
    @Feature("Post.")
    @Story("Deleted post.")
    @Description("Removed from my profile")
    @Test
    public void updatePost() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.deletePost();
        myProfile.getElementOnPage().shouldNot(Condition.visible);
    }
}
