import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


abstract class BaseTest {

    @BeforeAll //метод запускается перед всеми тестовыми методами
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach //запускается перед каждым тестовым методом
    public void start() {
        Configuration.startMaximized = true; //настройка  окна браузера
        Configuration.timeout = 10000;
        Configuration.headless = false;
    }

    @AfterEach  //метод запускается после каждого тестового метода
    public void tearDown() {
        WebDriverRunner.closeWebDriver();   //метод настройки браузера закрывается
    }
}

// allure generate --clean --output /Users/dunice/Desktop/NewsFeedAutotests/allure-results
// allure serve -h localhost