import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class CreatePostTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();

    @Epic(value = "MyProfilePage")
    @Feature("Post.")
    @Story("New post created.")
    @Description("Create a post on my profile")

    @Test
    public void createPost() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.createNewPost();
        myProfile.getElementOnPage().shouldBe(Condition.visible);
    }
    @Test
    public void negativeCreatePost() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.negativeCreateNewPost();
        myProfile.getStringErrorTags().shouldBe(Condition.visible).shouldHave(text("TAGS_NOT_VALID"));
    }
}