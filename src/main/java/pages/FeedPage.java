package pages;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

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

    public BasePage clickLogoutButton() {
        clickOnAccountButton();
        $(LOGOUT_BUTTON_CSS).click();
        return new BasePage();
    }

    public boolean iSVisibleLoginButton() {
        return $(LOGIN_LiNK_CSS).isDisplayed();
    }

    public FeedPage sendHug() {
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