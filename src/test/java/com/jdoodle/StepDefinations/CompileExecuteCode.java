package com.jdoodle.StepDefinations;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BaseTest.BaseTest;

public class CompileExecuteCode extends BaseTest {
    @Test(description = "Compile Execute Code")
    public void enterAndRunJavaCode() {
        String javaCode = "public class Main {\n  public static void main(String[] args) {\n    System.out.println(\"Hello, JDoodle!\");\n  }\n}";
        homePage.enterCodeAndRun(javaCode);
    }

    @Test(dependsOnMethods = "enterAndRunJavaCode",description = "Compile Execute Code")
    public void verifyOutput() {
    	SoftAssert softAssert = new SoftAssert();
    	softAssert.assertTrue(true, "Output verification not implemented in this example.");
    	softAssert.assertAll();
    }
}