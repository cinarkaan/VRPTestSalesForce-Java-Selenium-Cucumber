package Base;

import Util.Base;
import Util.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EdgeBase extends Base implements DriverManager {

    public EdgeBase () {
        super("webdriver.edge.driver","MSEdgeDriver.exe");
        initialDriver();
    }


    @Override
    public void initialDriver() {
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 30);
        javascriptExecutor =(JavascriptExecutor) webDriver;
     }

}
