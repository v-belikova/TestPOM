import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    Method method = new Method();
    public String getBase_url() {
        return Base_url;
    }
    public void setBase_url(String base_url) {
        Base_url = base_url;
    }
    private  String Base_url = "https://news-feed-2.dunice-testing.com/";

    String avatar = "src/main/resources/avatar.jpeg";

    File file = new File(new File(avatar).getAbsolutePath());
    private SelenideElement buttonSign = Selenide.$x("*//button[contains(text(),'Sign Up')]");
    private SelenideElement regTitle = $(By.cssSelector(".modal-content"));

    private SelenideElement emailInput = $(By.name("emailReg"));
    public void setEmailInput(SelenideElement emailInput) {
        this.emailInput = emailInput;
    }
    private SelenideElement loginInput = Selenide.$(By.name("loginReg"));
    public void setLoginInput(SelenideElement loginInput) {
        this.loginInput = loginInput;
    }
    private SelenideElement passwordInput = Selenide.$(By.name("passwordReg"));
    public void setPasswordInput(SelenideElement passwordInput) {
        this.passwordInput = passwordInput;
    }
    private SelenideElement avatarInput = Selenide.$(By.name("avatar"));
    private SelenideElement buttonSave = Selenide.$x("*//button[contains(text(),'Save')]");
    private SelenideElement emailInputUser = Selenide.$(By.name("email"));


    public SelenideElement getButtonSign() {
        return buttonSign;
    }

    public SelenideElement getEmailInput() {
        return emailInput;
    }

    public SelenideElement getLoginInput() {
        return loginInput;
    }

    public SelenideElement getPasswordInput() {
        return passwordInput;
    }

    public SelenideElement getAvatarInput() {
        return avatarInput;
    }

    public SelenideElement getButtonSave() {
        return buttonSave;
    }

    public SelenideElement getEmailInputUser() {
        return emailInputUser;
    }

    public SelenideElement getPasswordInputLoginUser() {
        return passwordInputLoginUser;
    }

    public SelenideElement getInputSearch() {
        return inputSearch;
    }

    private SelenideElement passwordInputLoginUser = Selenide.$(By.name("password"));

    public SelenideElement getButtonLogin() {
        return buttonLogin;
    }

    private SelenideElement buttonLogin = Selenide.$x("*//button[contains(text(),'Log In')]");
    private SelenideElement stringMyProfile = Selenide.$x("*//a[contains(text(),'My profile')]");

    private SelenideElement buttonSearch = Selenide.$x("*//button[contains(text(),'Search')]");

    private SelenideElement inputSearch = Selenide.$(By.name("search"));

    private SelenideElement selectPost = Selenide.$(By.name("select"));

    public ElementsCollection getPostALL() {
        return postALL;
    }

    private final ElementsCollection postALL = Selenide.$$x("//*[@class ='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root Post_posts__1Y3K- css-w88nxk']");

    private SelenideElement selectPostTeg = Selenide.$x("//option[contains(text(),'Tags')]");

    public SelenideElement getAlertError() {
        return alertError;
    }

    private SelenideElement alertError = Selenide.$(By.cssSelector(".Authorization_danger__2stU0"));

    public SelenideElement getHelloHeader() {
        return helloHeader;
    }
    private SelenideElement helloHeader = Selenide.$(By.cssSelector(".Header_header__greetings__3WI4_"));

    private SelenideElement elementOnPage = Selenide.$(By.cssSelector(".MuiTypography-root"));




    public void registrationForm() {
        buttonSign.click();
        regTitle.shouldBe(Condition.visible);
        emailInput.setValue(method.generateRandomHexString( 5) +"@mail.ru");
        loginInput.setValue("123456");
        passwordInput.setValue("000000");
        avatarInput.shouldBe(Condition.visible).uploadFile(file);
        buttonSave.click();

    }
    public void registrationForm1() {
        buttonSign.click();
        regTitle.shouldBe(Condition.visible);
        emailInput.setValue("5236@mail.ru");
        loginInput.setValue("123456");
        passwordInput.setValue("000000");
        buttonSave.click();

    }
    public void negativeRegistrationForm() {
        buttonSign.click();
        regTitle.shouldBe(Condition.visible);
        emailInput.setValue(method.generateRandomHexString( 5) +"@mail.ru");
        loginInput.setValue("1234567");
        passwordInput.setValue("   ");
        avatarInput.shouldBe(Condition.visible).uploadFile(file);
        buttonSave.click();

    }

    public void authorizationUser() {
        emailInputUser.setValue(method.generateRandomHexString( 5) +"@mail.ru");
        passwordInputLoginUser.setValue("000000");
        buttonLogin.click();
    }

    public void authorizationUserNegative() {
        emailInputUser.setValue(method.generateRandomHexString( 5) +"@mail.ru");
        passwordInputLoginUser.setValue("000001");
        buttonLogin.click();
    }

    public void infoMyProfile() {
        stringMyProfile.click();
    }

    public void allPost() {
        for (int i = 0; i < 100; ++i) {
            getPostALL().get(i).scrollIntoView(true);
        }
    }
    public void postOne() {
        selectPost.click();
        selectPostTeg.click();
        inputSearch.setValue("#tag");
        buttonSearch.click();
    }
    public void negativePostOne() {
        selectPost.click();
        selectPostTeg.click();
        inputSearch.setValue("1b4f");
        buttonSearch.click();
    }
    /*public void allPostPagination(){
        selectPost.click();
        inputSearch.setValue("Header 1 sd");
        postALL.findBy(text("Header 1 sd")).click();
    }*/
}
