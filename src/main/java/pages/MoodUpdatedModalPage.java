package pages;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModalPage extends BasePage{


    public FeedPage clickOnGoToMyDiaryButton(){
        $(GO_TO_MY_DIARY_BUTTON_CSS).click();
        return new FeedPage();
    }
}