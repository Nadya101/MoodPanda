package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class moodPandaTest extends BaseTest {
    public final static String login = "mymoodn@mailitanor.com";
    public final static String password = "0147852";

    @Test(description = "Update user's mood")
    public void moodTest() {
        loginPage.openPage()
                .login(login, password)
                .waitForMoodButtonVisible()
                .clickUpdateMoodButton()
                .updateMood(2);
        moodUpdatedModalPage.clickOnGoToMyDiaryButton();
        String moodValue = feedPage.getMoodValue();
        Assert.assertEquals(moodValue, "2");
    }

    @Test(description = "Logout user")
    public void logoutTest() {
        loginPage.openPage()
                .login(login, password)
                .waitForMoodButtonVisible();
        feedPage.clickOnAccountButton()
                .clickLogoutButton();
        boolean loginButtonPresent = feedPage.iSVisibleLoginButton();
        Assert.assertTrue(loginButtonPresent);
    }

    @Test(description = "Send a hug to all users")
    public void sendHugToUsers() {
        loginPage.openPage()
                .login(login, password)
                .waitForMoodButtonVisible();
        int amountOfHugBefore = feedPage.getAmountOfHug();
        feedPage.sendHug();
        int amountOfHugAfter = feedPage.getAmountOfHug();
        Assert.assertEquals(amountOfHugAfter, amountOfHugBefore + 1);
    }

    @Test(description = "Мaximum number of characters in the message")
    public void checkCharsRemainingTest() {
        loginPage.openPage()
                .login(login, password)
                .waitForMoodButtonVisible()
                .clickUpdateMoodButton()
                .writeTextMessage("Mood panda helps people!");
        String actualMessage = rateYourHappinessModalPage.getCharRemaining();
        String expectedMessage = rateYourHappinessModalPage.getCharRemainingMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
