package com.jdoodle.StepDefinations;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BaseTest.BaseTest;

public class ShareCodeLink extends BaseTest {

    @Test(description = "Share Code via Link")
    public void shareCode() {
    	String javaCode = "public class Main {\n  public static void main(String[] args) {\n    System.out.println(\"Hello, JDoodle!\");\n  }\n}";
    	homePage.enterCodeAndRun(javaCode);
    	homePage.clickShareButton();
    }

    @Test(dependsOnMethods = "shareCode",description = "Share Code via Link")
    public void verifySharedCode() {
    	SoftAssert softAssert = new SoftAssert();
    	String sharedLink = homePage.getSharedLink();
    	softAssert.assertNotNull(sharedLink, "Shared link is null");
    	softAssert.assertAll();
    }
}