public class NtlmTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeClass() {
        String path = "src/test/resources";
        File file = new File(path);

        String firefoxAbsolutePath = file.getAbsolutePath() + "\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxAbsolutePath);

        String ieAbsolutePath = file.getAbsolutePath() + "\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", ieAbsolutePath);

        String absolutePath = file.getAbsolutePath() + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", absolutePath);
        /*ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});*/

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new InternetExplorerDriver();
        //driver.get("http://localhost:8080/BNP");
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }


    @Test
    public void ntlmTest() throws Exception {
        
        driver.get("http://dt01070415.technologic.com:8080/bn");

        //new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());

        //driver.get("http://the-internet.herokuapp.com/basic_auth");
        Thread.sleep(5000);

        ((JavascriptExecutor)driver).executeScript("window.focus();");
        String userName = "gajanan";
        StringSelection stringSelection = new StringSelection(userName);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Thread.sleep(2000);
        robot.delay(2000);
        String password = "NtlmTesting123";
        StringSelection stringSelection1 = new StringSelection(password);
        Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard1.setContents(stringSelection1, stringSelection1);


        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        /*robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);*/

        //Thread.sleep(2000);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Thread.sleep(25000);
    }

    @AfterMethod
    public void closeDriver() {
        /*if (driver != null)
            driver.quit();*/
    }
}
