package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account {

    JavascriptExecutor javascriptExecutor;

    @FindBy(xpath = "//a[@title='New']")
    private WebElement newAccount;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div[1]/div/input")
    private WebElement accountNameInput;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[1]/div[1]/div/div/div/input")
    private WebElement editedNameInput;

    @FindBy (xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/a")
    private WebElement typeBox;

    @FindBy (xpath = "/html/body/div[11]/div/ul/li[3]/a")
    private WebElement selectedOnly;

    @FindBy (xpath = "/html/body/div[11]/div/ul/li[6]/a")
    private WebElement editedSelect;

    @FindBy (xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/button[3]")
    private WebElement save;

    @FindBy (xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[2]/div/div/div/div[1]/div/div/fieldset/div/div[1]/button")
    private WebElement clickAddress;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/input")
    private WebElement enterAddress;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/ul/li[2]/a")
    private WebElement address;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[3]/div[2]/div/div/div/input")
    private WebElement phone;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[3]/div[1]/div/div/div/input")
    private WebElement website;

    public Account (WebDriver webDriver, JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
        PageFactory.initElements(webDriver, this);
    }

    public void newAccount() {
        javascriptExecutor.executeScript("arguments[0].click();",newAccount);
    }

    public void fillInformation (String accountName) throws InterruptedException {
        if (accountName == "") {
            accountNameInput.sendKeys("TestAccount");
            Thread.sleep(2000);
            selectType();
            phone.sendKeys("+48511464442");
            Thread.sleep(1500);
            website.sendKeys("http://www.kaancinar.ml");
            Thread.sleep(1500);
            selectAddress();
        } else {
            editedNameInput.clear();
            editedNameInput.sendKeys(accountName);
            javascriptExecutor.executeScript("arguments[0].click();",typeBox);
            javascriptExecutor.executeScript("arguments[0].click();",editedSelect);
        }

    }

    public void selectAddress () throws InterruptedException {
        clickAddress.click();
        Thread.sleep(2000);
        enterAddress.sendKeys("Lubin");
        Thread.sleep(1000);
        javascriptExecutor.executeScript("arguments[0].click();",address);
    }

    public void selectType () {
        javascriptExecutor.executeScript("arguments[0].click();",typeBox);
        javascriptExecutor.executeScript("arguments[0].click();",selectedOnly);
    }

    public void saveInfo () {
        save.click();
    }

}
