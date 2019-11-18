package org.demo.testng1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1Test {

    @Test(groups = "Sanity")
    public void test1(){
        System.out.println("Demo1Test test1");
        //Assert.fail();
    }

    @Test(groups = "Sanity")
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
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
}
