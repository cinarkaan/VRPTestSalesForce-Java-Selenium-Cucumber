package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final String userName = "kcnr97-bemj@force.com";
    private final String password = "Lchkdr2016++";

    private final String url = "https://testautomationforinterview.my.salesforce.com/";

    @FindBy(how = How.ID , using = "username")
    private WebElement userNameField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "Login")
    private WebElement login;

    public LoginPage(WebDriver webDriver) {
        webDriver.get(url);
        PageFactory.initElements(webDriver, this);
    }

    public void loginInformation () {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void clickLogin () {
        login.click();
    }


}
