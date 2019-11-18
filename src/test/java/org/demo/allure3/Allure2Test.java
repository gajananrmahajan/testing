package org.demo.allure3;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Allure2Test {

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("123")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void test1(){
        step1();
        step2();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("123")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void test2(){
        Assert.fail("Failing intentionally");
    }

    @Test(enabled = false)
    public void test3(){}

    @Test(enabled = false)
    public void test4(){}

    @Test
    public void test5(){}

    @Test
    @Flaky
    public void flakyTest(){
        Assert.fail("This is flaky test");
    }

    @Test
    public void test6(){Assert.fail("faiiling");}

    @Test(dependsOnMethods = "test6")
    public void test7(){}

    @Step("Doing step1")
    public  void step1(){}

    @Step("Doing step2")
    public  void step2(){}
}
