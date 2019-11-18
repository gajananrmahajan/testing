package org.demo.allure1;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Allure2Test {

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Make Payment")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void test1(){
        step1();
        step2();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Search Item")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void test2(){
        Assert.fail("Failing intentionally");
    }

    @Step
    public  void step1(){}

    @Step
    public  void step2(){}
}
