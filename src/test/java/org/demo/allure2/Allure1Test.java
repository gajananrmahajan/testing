package org.demo.allure2;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class Allure1Test {

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Checkout Item")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test1(){
        step1();
        step2();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Checkout Item")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test2(){
        step1();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.MINOR)
    @Story("Search Item")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test3(){
        step1();
    }

    @Test
    @Description("Testing test1")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add to cart")
    @Issue("Bug-145")
    @TmsLink("TC-123")
    public void a2test4(){
        step1();
    }

    @Step
    public  void step1(){}

    @Step
    public  void step2(){}
}
