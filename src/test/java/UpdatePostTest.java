import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class UpdatePostTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void updatePost() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.createNewPost();
        myProfile.updatePost();
        myProfile.getPostBody().shouldBe(text("Hello!"));
    }
    @Test
    public void negativeUpdatePost() {
        open(BASE_URL);
        authorizationPage.registrationForm();
        authorizationPage.infoMyProfile();
        myProfile.createNewPost();
        myProfile.negativeUpdatePost();
        myProfile.getStringError().shouldBe(Condition.visible).shouldHave(text("TAGS_NOT_VALID"));
    }
}
