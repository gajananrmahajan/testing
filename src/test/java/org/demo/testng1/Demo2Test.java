package org.demo.testng1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo2Test {

    @Parameters({"browser", "server"})
    @Test
    public void testParameters(String browser, String server){
        System.out.println("Browser is " + browser);
        System.out.println("Server is " + server);
    }

    @Test(groups = "Sanity")
    public void test1(){
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
    @Test(groups = "regression")
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Demo2Test test3");
    }

    @Test
    public void abc()throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Demo2Test abc");
    }
}
