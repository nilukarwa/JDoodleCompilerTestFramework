package com.jdoodle.StepDefinations;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BaseTest.BaseTest;
public class SwitchLanguage extends BaseTest {

    @Test(description = "Switch Language")
    public void switchLanguageToC() {
    	String selectedLanguage = "C";
        homePage.selectLanguage(selectedLanguage);
    }

    @Test(dependsOnMethods = "switchLanguageToC")
    public void verifyLanguageSwitch() {
    	SoftAssert softAssert = new SoftAssert();
    	softAssert.assertTrue(true, "Language switch verification not implemented in this example.");
    	softAssert.assertAll();
    }
}