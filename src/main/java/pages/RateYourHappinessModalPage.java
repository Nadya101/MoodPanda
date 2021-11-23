package pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModalPage extends BasePage {
    int count = 0;

    public RateYourHappinessModalPage updateMood(int moodValue) {
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue) {
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue) {
            direction = Keys.ARROW_LEFT;
        }
        if (moodValue != defaultMoodValue) {
            for (int i = 0; i < Math.abs(moodValue - defaultMoodValue); i++) {
                $(SLIDER_CSS).sendKeys(direction);
            }
        }
        $(UPDATE_MOOD_BUTTON).click();
        return this;
    }


    public RateYourHappinessModalPage writeTextMessage(String text) {
        $(TEXT_BOX_CSS).clear();
        $(TEXT_BOX_CSS).sendKeys(text);
        count=text.length();
        return this;
    }

    public String getCharRemainingMessage() {
        return $(CHARACTER_COUNTER_CSS).getText();
    }

    public String getCharRemaining() {
        return 400 - count + " chars remaining";
    }

}