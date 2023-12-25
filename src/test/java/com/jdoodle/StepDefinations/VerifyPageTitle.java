package com.jdoodle.StepDefinations;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.BaseTest;

public class VerifyPageTitle extends BaseTest {
    @Test(description = "Verify Page Title")
    public void verifyPageTitle() {
    	String expectedTitle = "JDoodle Online Java Compiler";
    	String actualTitle = driver.getTitle();
    	Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
    }
}