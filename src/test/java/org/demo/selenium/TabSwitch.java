import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * This is an utility class to deal with tabs in a browser
 *
 */
class Tab {

	private Tab() {
	}

	public static void openNewTab(WebDriver driver, Logger logger) {
		logger.info("Opening a new tab");
		((JavascriptExecutor) driver).executeScript("window.open()");
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(Integer.valueOf(tabs.size() - 1)));
	}

	public static void closeTab(String tabIndex, WebDriver driver, Logger logger) {
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		int currentTabIndex = getCurrentTabIndex(driver, tabs);
		
		if(Objects.isNull(tabIndex)) {
			logger.info("Closing current tab");
			
			//driver.switchTo().window(String.valueOf(currentTabIndex - 1));
			//driver.close();
			((JavascriptExecutor) driver).executeScript("window.close()");
			//driver.switchTo().window(String.valueOf(currentTabIndex - 1));
			driver.switchTo().window(tabs.get(Integer.valueOf(tabs.size() - 2)));
			logger.info("Current tab title is " + driver.getTitle());
		} else {
			logger.info("Closing tab at index: " + tabIndex);
			driver.switchTo().window(tabs.get(Integer.valueOf(tabIndex)));
			((JavascriptExecutor) driver).executeScript("window.close()");
			if(Integer.valueOf(tabIndex) < currentTabIndex)
				currentTabIndex--;
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(currentTabIndex));
			logger.info("Current tab title is " + driver.getTitle());
		}
	}
	
	public static void switchToTab(String tabIndex, WebDriver driver, Logger logger) {
		logger.info("Switching to tab at index : " + tabIndex);

		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		logger.info("Tabs count is " + tabs.size());
		driver.switchTo().window(tabs.get(Integer.valueOf(tabIndex)));
	}

	public static void duplicateTab(WebDriver driver, Logger logger) {
		String urlToOpen = driver.getCurrentUrl();

		logger.info("Opening duplicate tab for : " + urlToOpen);
		((JavascriptExecutor) driver).executeScript("window.open()");

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> tabs = new ArrayList<String>(windowHandles);

		driver.switchTo().window(tabs.get(getCurrentTabIndex(driver, tabs)));
		driver.get(urlToOpen);
	}

	private static int getCurrentTabIndex(WebDriver driver, List<String> tabs) {
		String currentWindowHandle = driver.getWindowHandle();
		int currentTabIndex = 0;

		for (String tab : tabs) {
			if (currentWindowHandle.equals(tab))
				break;
			currentTabIndex++;
		}
		return currentTabIndex;
	}
}
