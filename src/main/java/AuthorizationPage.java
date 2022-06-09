import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationPage {
    String avatar = "src/main/resources/avatar.jpeg";
    File file = new File(new File(avatar).getAbsolutePath());
    private SelenideElement buttonSign = Selenide.$x("*//button[contains(text(),'Sign Up')]");
    private SelenideElement regTitle = $(By.cssSelector(".modal-content"));
    private SelenideElement emailInput = Selenide.$(By.name("emailReg"));

    public SelenideElement getLoginInput() {
        return loginInput;
    }
    private SelenideElement loginInput = Selenide.$(By.name("loginReg"));
    private SelenideElement passwordInput = Selenide.$(By.name("passwordReg"));
    private SelenideElement avatarInput = Selenide.$(By.name("avatar"));
    private SelenideElement buttonSave = Selenide.$x("*//button[contains(text(),'Save')]");
    private SelenideElement emailInputUser = Selenide.$(By.name("email"));

    private SelenideElement passwordInputLoginUser = Selenide.$(By.name("password"));
    private SelenideElement buttonSingIn = Selenide.$x("*//button[contains(text(),'Log In')]");
    private SelenideElement stringMyProfile = Selenide.$x("*//a[contains(text(),'My profile')]");

    private SelenideElement buttonSearch = Selenide.$x("*//button[contains(text(),'Search')]");

    private SelenideElement inputSearch = Selenide.$(By.name("search"));

    private SelenideElement selectPost = Selenide.$(By.name("select"));

    //private SelenideElement selectPostAll = Selenide.$x("//option[contains(text(),'All')]");
    private final ElementsCollection postALL = $$(By.cssSelector(".MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root Post_posts__1Y3K- css-w88nxk"));

    private SelenideElement selectPostTeg = Selenide.$x("//option[contains(text(),'Tags')]");

    public SelenideElement getHelloHeader() {
        return helloHeader;
    }

    private SelenideElement helloHeader = $(By.cssSelector(".Header_header__greetings__3WI4_"));

    //private SelenideElement selectPostAuthor = Selenide.$x("//option[contains(text(),'Author')]");

    public void setEmailInput(SelenideElement emailInput) {
        this.emailInput = emailInput;
        emailInput.sendKeys();

    }

    public void setLoginInput(SelenideElement loginInput) {
        this.loginInput = loginInput;
    }

    public void setPasswordInput(SelenideElement passwordInput) {
        this.passwordInput = passwordInput;
    }

    public void registrationForm() {
        buttonSign.click();
        regTitle.shouldBe(Condition.visible);
        emailInput.setValue("123@mail.ru");
        loginInput.setValue("1234567");
        passwordInput.setValue("000000");
        avatarInput.shouldBe(Condition.visible).uploadFile(file);
        buttonSave.click();
    }

    public void authorizationUser() {
        emailInputUser.setValue("123@mail.ru");
        passwordInputLoginUser.setValue("000000");
        buttonSingIn.click();
        helloHeader.shouldHave(text("Hello,"), text("1234567"));

       // assertEquals(("Hello," + getLoginInput()),getHelloHeader().getText());
    }

    public void infoMyProfile() {
        stringMyProfile.click();
    }

    public void allPost() {
        for (int i = 0; i < 100; ++i) {
            postALL.get(i).scrollIntoView(true);
        }
    }

        public void postOne() {
            selectPost.click();
            selectPostTeg.click();
            inputSearch.setValue("#море");
            buttonSearch.click();
        }
    }





