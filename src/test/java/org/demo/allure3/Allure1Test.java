package org.demo.allure3;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Allure1Test {

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("123")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test1(){
        step1();
        step2();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Login")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test2(){
        step1();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.MINOR)
    @Story("345")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test3(){
        Assert.fail("Assertion did not match");
    }

    @Test(enabled = false)
    @Description("Testing test1")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test4(){
        step1();
    }

    @Test
    public void test5(){
        int number = 5;
        int newNumber = number/0;
    }
    @Step
    public  void step1(){}

    @Step
    public  void step2(){}
}
