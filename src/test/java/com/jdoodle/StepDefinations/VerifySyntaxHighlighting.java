package com.jdoodle.StepDefinations;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BaseTest.BaseTest;

public class VerifySyntaxHighlighting extends BaseTest {
	String javaCodeWithSyntaxElements = "public class Main {\n" +
            "  public static void main(String[] args) {\n" +
            "    // This is a comment\n" +
            "    int num = 5;\n" +
            "    String message = \"Hello, JDoodle!\";\n" +
            "    System.out.println(message + num);\n" +
            "  }\n" +
            "}";
	
    @Test(description = "Verify Syntax Highlighting")
    public void verifySyntaxHighlighting() {
    	homePage.enterCodeAndRun(javaCodeWithSyntaxElements);

    	SoftAssert softAssert = new SoftAssert();

    	boolean syntaxHighlightingVerified = homePage.verifySyntaxHighlighting();
    	softAssert.assertTrue(syntaxHighlightingVerified, "Syntax highlighting verification failed");

    	softAssert.assertAll();
    }
}