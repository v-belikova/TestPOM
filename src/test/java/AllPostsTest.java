import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AllPostsTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();

    @Epic(value = "AuthorizationPage")
    @Feature("Post.")
    @Story("Get all posts.")
    @Description("Check posts receipt")

    @Test
    public void allPost() {
        open(BASE_URL);
        authorizationPage.allPost();
        myProfile.getElementOnPage().shouldBe(Condition.visible);
    }
    /*@Test
    public void allPost1() {
        open(BASE_URL);
        authorizationPage.allPostPagination();
        myProfile.getElementOnPage().shouldBe(Condition.visible);
    }*/

}



