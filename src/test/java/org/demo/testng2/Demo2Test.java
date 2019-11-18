package org.demo.testng2;

import org.testng.annotations.Test;

public class Demo2Test {

    @Test(groups = "Sanity")
    public void test1()throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Demo2Test test1");
        //Assert.fail();
    }

    @Test(groups = "Sanity")
    public void test2(){
        String s1 = "Bob";
                String s2 = new String("Bob");
        System.out.println("Demo2Test test2");
        //Assert.assertEquals("One", "Two");
        //Assert.assertSame(s1, s2);
    }

    //@Test(dependsOnGroups = "Sanity")
    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Demo2Test test3");
    }

    @Test
    public void abc(){
        System.out.println("Demo2Test abc");
    }
}
