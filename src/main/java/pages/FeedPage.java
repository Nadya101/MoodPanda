package pages;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage{
    public static final String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";
    public static final String MOOD_VALUE_TEXT_CSS = ".media-heading>span";
    public static final String CLICK_ON_ACCOUNT_BUTTON_XPATH = "//span[contains(text(),'Account')]";
    public static final String LOGOUT_BUTTON_CSS = "a[href*='Logout']";
    public static final String LOGIN_LINK_CSS = "a[href*='Login']";
    public static final String HUG_BUTTON = ".ButtonHug";
    public static final String HUG_COUNT = "//*[@class='ButtonHug']/span";

    public FeedPage waitForMoodButtonVisible() {
        $(UPDATE_MOOD_BUTTON_CSS).shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappinessModalPage clickUpdateMoodButton() {
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModalPage();
    }

    public String getMoodValue() {
        return $(MOOD_VALUE_TEXT_CSS).getText();
    }

    public FeedPage clickOnAccountButton() {
        $(By.xpath(CLICK_ON_ACCOUNT_BUTTON_XPATH)).click();
        return this;
    }

    public LoginPage clickLogoutButton() {
        clickOnAccountButton();
        $(LOGOUT_BUTTON_CSS).click();
        return new LoginPage();
    }

    public boolean isLoginButtonDisplayed() {
        return $(LOGIN_LINK_CSS).isDisplayed();
    }

    public FeedPage sendHugToAll() {
        List<WebElement> hugButtons = WebDriverRunner.getWebDriver().findElements(By.cssSelector(HUG_BUTTON));
        for (WebElement hugButton : hugButtons) {
            $(hugButton).click();
        }
        return this;
    }

    public int getAmountOfHug() {
        return Integer.parseInt($(By.xpath(HUG_COUNT)).getText());
    }
}