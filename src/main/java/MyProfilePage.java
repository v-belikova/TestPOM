import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;

public class MyProfilePage {
    public String getMyProfileURL() {
        return myProfileURL;
    }
    public void setMyProfileURL(String myProfileURL) {
        this.myProfileURL = myProfileURL;
    }
    private String myProfileURL = "https://news-feed-2.dunice-testing.com/profile/";
    String avatar1 = "src/main/resources/avatar1.png";
    String picture = "src/main/resources/picture.jpeg";
    File file = new File(new File(avatar1).getAbsolutePath());
    File file1 = new File(new File(picture).getAbsolutePath());
    private SelenideElement updateUser = Selenide.$x("*//button[contains(text(),'Update')]");
    private SelenideElement emailNew = Selenide.$(By.name("email"));
    private SelenideElement loginNew = Selenide.$(By.name("name"));
    private SelenideElement avatarInputNew = Selenide.$(By.name("avatar"));
    private SelenideElement buttonSave = Selenide.$x("*//button[contains(text(),'Save')]");
    private SelenideElement stringError = Selenide.$(By.cssSelector(".alert-danger"));
    private SelenideElement newPost = Selenide.$x("*//button[contains(text(),'New Post')]");
    private SelenideElement deleteUser = Selenide.$x("*//button[contains(text(),'Delete profile')]");
    private SelenideElement createNewUserPost = Selenide.$(By.cssSelector(".modal-content"));
    private SelenideElement postTitle = Selenide.$(By.name("title"));
    private SelenideElement postBody = Selenide.$(By.name("body"));
    private SelenideElement pictureBody = Selenide.$(By.name("picture"));
    private SelenideElement postTags = Selenide.$(By.name("tags"));

    private SelenideElement updateUserPost = Selenide.$(By.cssSelector(".UpdatePost_button__2Hgrx"));
    private SelenideElement stringErrorTags = Selenide.$(By.cssSelector(".alert-danger"));

    private SelenideElement deleteUserPost = Selenide.$x("*//button[contains(text(),'Update')]");


    private SelenideElement quitSingOut = Selenide.$x("*//button[contains(text(),'Sing Out')]");


    public  void updateUser(){
        updateUser.click();
        emailNew.setValue("losk@mail.ru");
        loginNew.setValue("222222");
        avatarInputNew.shouldBe(Condition.visible).uploadFile(file);
        buttonSave.click();
    }
    public  void negativeUpdateUser(){
        updateUser.click();
        emailNew.setValue("losk");
        loginNew.setValue("222222");
        avatarInputNew.shouldBe(Condition.visible).uploadFile(file);
        buttonSave.click();
        stringError.shouldBe(Condition.visible).shouldHave(text("unknown"));

    }
    public  void deleteUser(){
        deleteUser.click();
        Selenide.switchTo().alert().accept();

    }
    public void createNewPost() {
        newPost.click();
        createNewUserPost.shouldBe(Condition.visible);
        postTitle.sendKeys("Hello!");
        postBody.sendKeys("Hello, world!");
        pictureBody.shouldBe(Condition.visible).uploadFile(file1);
        postTags.sendKeys("#world");
        buttonSave.click();
    }
    public void negativeCreateNewPost() {
        newPost.click();
        createNewUserPost.shouldBe(Condition.visible);
        postTitle.sendKeys("Hello!");
        postBody.sendKeys("Hello, world!");
        pictureBody.shouldBe(Condition.visible).uploadFile(file1);
        postTags.sendKeys("    ");
        buttonSave.click();
        stringError.shouldBe(Condition.visible).shouldHave(text("TAGS_NOT_VALID"));

    }
    public void updatePost(){
        updateUserPost.click();
        postBody.sendKeys("Hello!");
        buttonSave.click();
        updateUserPost.click();
    }
    public void negativeUpdatePost() {
        updateUserPost.click();
        postTags.sendKeys("    ");
        buttonSave.click();
        stringError.shouldBe(Condition.visible).shouldHave(text("TAGS_NOT_VALID"));
    }

    public void deletePost(){
        deleteUserPost.click();
    }

}
