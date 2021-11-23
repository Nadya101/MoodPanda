package locators;

public interface Locator {
    String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";
    String MOOD_VALUE_TEXT_CSS = ".media-heading>span";
    String CLICK_ON_ACCOUNT_BUTTON_XPATH = "//span[contains(text(),'Account')]";
    String LOGOUT_BUTTON_CSS = "a[href*='Logout']";
    String LOGIN_LiNK_CSS = "a[href*='Login']";
    String LOGIN_URL = "https://www.moodpanda.com/Login/";
    String EMAIL_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    String PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";
    String SLIDER_CSS = ".ui-slider-handle";
    String UPDATE_MOOD_BUTTON = ".ButtonUpdate";
    String GO_TO_MY_DIARY_BUTTON_CSS = ".ButtonMyDiary ";
    String HUG_BUTTON = ".ButtonHug";
    String HUG_COUNT = "//*[@class='ButtonHug']/span";
    String TEXT_BOX_CSS = "#TextBoxUpdateMoodTag";
    String CHARACTER_COUNTER_CSS = "#CharacterCounter";

}