import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class PostOneTest extends BaseTest  {
    private final static String BASE_URL = "https://news-feed-2.dunice-testing.com/";
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MyProfilePage myProfile = new MyProfilePage();


    @Test
    public void postOne() {
        open(BASE_URL);
        authorizationPage.postOne();
        myProfile.getElementOnPage().shouldBe(Condition.visible);
    }
    @Test
    public void negativePostOne() {
        open(BASE_URL);
        authorizationPage.negativePostOne();
        myProfile.getElementOnPage().shouldNotBe(visible);
    }

}

