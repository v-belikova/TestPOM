import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

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

    public SelenideElement getStringError() {
        return stringError;
    }

    private SelenideElement stringError = Selenide.$(By.cssSelector(".alert-danger"));
    private SelenideElement newPost = Selenide.$x("*//button[contains(text(),'New Post')]");
    private SelenideElement deleteUser = Selenide.$x("*//button[contains(text(),'Delete profile')]");
    private SelenideElement createNewUserPost = Selenide.$(By.cssSelector(".modal-content"));
    private SelenideElement postTitle = Selenide.$(By.name("title"));

    public SelenideElement getPostBody() {
        return postBody;
    }

    private SelenideElement postBody = Selenide.$(By.name("body"));
    private SelenideElement pictureBody = Selenide.$(By.name("picture"));
    private SelenideElement postTags = Selenide.$(By.name("tags"));

    private SelenideElement updateUserPost = Selenide.$(By.cssSelector(".UpdatePost_button__2Hgrx"));

    public SelenideElement getStringErrorTags() {
        return stringErrorTags;
    }

    private SelenideElement stringErrorTags = Selenide.$(By.cssSelector(".alert-danger"));

    private SelenideElement deleteUserPost = Selenide.$x("*//button[contains(text(),'Update')]");


    private SelenideElement quitSingOut = Selenide.$x("*//button[contains(text(),'Sing Out')]");

    public SelenideElement getElementOnPage() {
        return elementOnPage;
    }

    private SelenideElement elementOnPage = Selenide.$(By.cssSelector(".MuiTypography-root"));

    public SelenideElement getInfoMyProfilePage() {
        return infoMyProfilePage;
    }

    private SelenideElement infoMyProfilePage = Selenide.$(By.cssSelector(".Profile_profile__posts__1-O3L"));

    public SelenideElement getUpdateProfilePage() {
        return updateProfilePage;
    }

    private SelenideElement updateProfilePage = Selenide.$x("//div//b[contains(text(),'User e-mail:')]");


    public  void updateUser(){
        updateUser.click();
        emailNew.setValue("tils@mail.ru");
        loginNew.setValue("123");
        avatarInputNew.uploadFile(file);
        buttonSave.click();
    }
    public  void negativeUpdateUser(){
        updateUser.click();
        emailNew.setValue("losk");
        loginNew.setValue("222222");
        avatarInputNew.uploadFile(file);
        buttonSave.click();

    }
    public  void deleteUser(){
        deleteUser.click();
        Selenide.switchTo().alert().accept();
    }
    public  void deleteUserNegative(){
        deleteUser.click();
        Selenide.switchTo().alert().dismiss();

    }

    public void createNewPost() {
        newPost.click();
        createNewUserPost.shouldBe(Condition.visible);
        postTitle.sendKeys("Hello!");
        postBody.sendKeys("Hello, world!");
        pictureBody.uploadFile(file1);
        postTags.sendKeys("#world");
        buttonSave.click();
    }
    public void negativeCreateNewPost() {
        newPost.click();
        createNewUserPost.shouldBe(Condition.visible);
        postTitle.sendKeys("Hello!");
        postBody.sendKeys("Hello, world!");
        pictureBody.uploadFile(file1);
        postTags.sendKeys("    ");
        buttonSave.click();
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

    }

    public void deletePost(){
        deleteUserPost.click();
    }

}

