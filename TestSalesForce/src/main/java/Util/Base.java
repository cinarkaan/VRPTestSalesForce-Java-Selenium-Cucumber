package Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class Base {

    private File file;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor javascriptExecutor;

    public Base (String Key,String driverName) {
        file = new File(driverName);
        System.setProperty(Key,file.getAbsolutePath());
    }

    private String getRelativePath () {
        String path = System.getProperty("user.dir");
        return path;
    }

    public void tearDown () {
        webDriver.quit();
    }

    public void getCurrentPage (int handleNum) {
        String handles[] = webDriver.getWindowHandles().toArray(new String[webDriver.getWindowHandles().size()]);
        webDriver.switchTo().window(handles[handleNum]);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor;
    }

    public String getTime () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        String time = dtf.format(localTime).substring(0,5);
        System.out.println("System : "  + time);
        return time;
    }

}
