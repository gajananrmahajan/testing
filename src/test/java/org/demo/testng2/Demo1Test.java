package org.demo.testng2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Demo1Test {

    @Test
    public void test(Method method){
        System.out.println("Method name is " + method.getName());
        System.out.println(this.getClass().getName());
        System.out.println(new Demo1Test(){}.getClass().getEnclosingMethod().getName());
    }
    @Test(groups = "Sanity")
    public void test1(){
        System.out.println("Demo1Test test1");
        //Assert.fail();
    }

    @Test(groups = "Sanity")
    public void test2(){
        String s1 = "Bob";
                String s2 = new String("Bob");
        System.out.println("Demo1Test test2");
        Assert.fail();
        //Assert.assertEquals("One", "Two");
        //Assert.assertSame(s1, s2);
    }

    //@Test(dependsOnGroups = "Sanity")
    @Test(groups = "regression")
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Demo1Test test3");
    }

    @Test(groups = "regression")
    public void abc(){
        System.out.println("Demo1Test abc");
    }

    @DataProvider(name = "testData")
    public Object[][] createTestData(){
        return new Object[][] {
                {"Bob", "Sesek"},
                {"Alan", "Richardson"},
                {"Angie", "Jones"}
        };
    }

    @Test(dataProvider = "testData")
    public void testData(String firstName, String lastName){
        System.out.println(String.format("Full name is %s %s", firstName, lastName));
    }
}
