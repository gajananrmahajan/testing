package org.demo.allure1;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class Allure1Test {

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
    @Story("Search Item")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void test2(){
        step1();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.MINOR)
    @Story("Make Payment")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void test3(){
        step1();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.CRITICAL)
    @Story("345")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void test4(){
        step1();
    }

    @Step
    public  void step1(){}

    @Step
    public  void step2(){}
}
