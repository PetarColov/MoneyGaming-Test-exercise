package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriver open(String browser) {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NONE);

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\WebDrivers\\chromedriver.exe");
            return new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\IdeaProjects\\WebDrivers\\IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\IdeaProjects\\WebDrivers\\msedgedriver.exe");
            return new EdgeDriver();
        }else {
            System.setProperty("webdriver.firefox.driver", "C:\\Users\\Admin\\IdeaProjects\\WebDrivers\\geckodriver.exe");
            return new FirefoxDriver();
        }
    }


}
