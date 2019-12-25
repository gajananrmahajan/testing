public class ImplicitExplicitWaitTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath() + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", absolutePath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void waitTest() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("Start time: " + new Date());

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("id"))));
        } catch (Exception e) {
            System.out.println("Exception was thrown");
        }
        System.out.println("End time: " + new Date());
    }


    @AfterClass
    public void closeDriver() {

        if (driver != null)
            driver.quit();
    }
}
