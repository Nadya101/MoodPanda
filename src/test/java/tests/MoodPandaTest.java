package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {
    public final static String login = "mymoodn@mailitanor.com";
    public final static String password = "0147852";

    @Test(description = "Update user's mood")
    public void moodTest() {
        loginPage.openPage()
                .login(System.getProperty("login"), System.getProperty("password"))
                .waitForMoodButtonVisible()
                .clickUpdateMoodButton()
                .updateMood(2);
        moodUpdatedModalPage.clickOnGoToMyDiaryButton();
        Assert.assertEquals(feedPage.getMoodValue(), "2");
    }

    @Test(description = "Logout user")
    public void logoutTest() {
        loginPage.openPage()
                .login(login, password)
                .waitForMoodButtonVisible();
        feedPage.clickOnAccountButton()
                .clickLogoutButton();
        Assert.assertTrue(feedPage.isLoginButtonDisplayed());
    }

    @Test(description = "Send a hug to all users")
    public void sendHugToUsers() {
        loginPage.openPage()
                .login(login, password)
                .waitForMoodButtonVisible();
        int amountOfHugBefore = feedPage.getAmountOfHug();
        feedPage.sendHugToAll();
        Assert.assertEquals(feedPage.getAmountOfHug(), amountOfHugBefore + 1);
    }

//    @Test(description = "Мaximum number of characters in the message")
//    public void checkCharsRemainingTest() {
//        loginPage.openPage()
//                .login(login, password)
//                .waitForMoodButtonVisible()
//                .clickUpdateMoodButton()
//                .writeTextMessage("Mood panda helps people!");
//        Assert.assertEquals(rateYourHappinessModalPage.getCharRemaining(), rateYourHappinessModalPage.getCharRemainingMessage());
//    }
}
