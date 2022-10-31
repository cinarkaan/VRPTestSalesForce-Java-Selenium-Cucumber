package Base;

import Util.Base;
import Util.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeBase extends Base implements DriverManager {

    public ChromeBase () {
        super("webdriver.chrome.driver","chromedriver.exe");
        initialDriver();
    }


    @Override
    public void initialDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
        javascriptExecutor = (JavascriptExecutor) webDriver;
     }

}
