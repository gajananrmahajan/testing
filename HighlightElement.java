package org.test.selenium;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HighlightSurroundingElement {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath() + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", absolutePath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/teams/customers");
    }

    @Test
    public void test(){

        try {
            //By xpath = By.xpath("//div[@role='menubar']/li[contains(@class,'youarehere')]");
            //String xpath = "//div[@role='menubar']//li[contains(@class,'youarehere')]//li/a/h";
            //String xpath = "//ol[@class='list-reset grid gs4']/a[text()='Use cases']/li/a//b/c";
            //String xpath = "//body[contains(@class,'home-page')]//div[@id='content']//a[contains(text(), 'For developers')]";
            //String xpath = "//div[@role='menubar1']";
            String xpath = "//div1[contains(@class, 'mb32')]/a1[contains(@href, 'hippo')]/div1[@class='grid--cell']/span1[text()='View case study']";
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            String locator = e.getMessage().split("Unable to locate element: ")[1];
            JSONObject jsonObject = new JSONObject(locator);
            String method = jsonObject.getString("method");
            String selector = jsonObject.getString("selector");
            int lastIndex = selector.lastIndexOf("/");
            int firstIndex = selector.indexOf("/");

            /*if((lastIndex - firstIndex) == 1) {
                throw e;
            }*/

            boolean flag = false;
            while ((lastIndex - firstIndex) != 1) {
                selector = selector.substring(0, lastIndex);
                if(selector.endsWith("/"))
                    selector = selector.substring(0, lastIndex - 1);
                lastIndex = selector.lastIndexOf("/");
                firstIndex = selector.indexOf("/");
                System.out.println("New selector is " + selector);
                if (isElementPresent(By.xpath(selector))) {
                    //for(int i = 1; i <=10; i++) {
                        highlightElement(By.xpath(selector));
                    //}
                    flag = true;
                    break;
                }
            }
            //if(!flag)
                throw e;
        }

        driver.quit();
    }

    @Test(enabled =  false)
    public void parseString(){
        String str = "//div[@role='menubar']/li[contains(@class,'youarehere')]";
        int index = str.lastIndexOf("/");
        String l1 = str.substring(0, index);
        System.out.println(l1);

    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult){
        if(iTestResult.getStatus() == ITestResult.FAILURE){
           takeScreenShot(iTestResult);
        }
    }

    private void takeScreenShot(ITestResult iTestResult) {
        String folderPath = System.getProperty("user.dir");
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String filePath = folderPath + "\\screenshots\\" + iTestResult.getMethod().getQualifiedName()
                + System.currentTimeMillis() + ".png";
        File destFile=new File(filePath);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return  false;
        }
        return true;
    }

    private void highlightElement(By by) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].style.border='5px solid red'", driver.findElement(by));
        System.out.println("*************Element was highlighted " + by.toString());
    }

}
