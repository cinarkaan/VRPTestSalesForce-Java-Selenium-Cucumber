package StepDefinitions;
import PageObject.Account;
import PageObject.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import Base.BaseFactory;
import PageObject.HomePage;
import Util.Base;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    BaseFactory baseFactory = new BaseFactory();
    Base base;

    public StepDefinitions () {
        this.base = baseFactory.getBase("Chrome");
        this.base.getWebDriver().manage().deleteAllCookies();
    }

    @Given("^: The User will be logged in$")
    public void loginPage () {
        LoginPage loginPage = new LoginPage(base.getWebDriver());
        loginPage.loginInformation();
        loginPage.clickLogin();
    }

    @When("^: Account will be got$")
    public void getAccount () throws InterruptedException {
        Thread.sleep(3000);
        HomePage homePage = new HomePage(base.getWebDriver(), base.getJavascriptExecutor());
        homePage.getAccounts();
        Thread.sleep(2000);
    }

    @And("^: New account will be created$")
    public void createAccount () throws InterruptedException {
        Account account = new Account(base.getWebDriver(), base.getJavascriptExecutor());
        Thread.sleep(3000);
        account.newAccount();
        Thread.sleep(3000);
        account.fillInformation("");
        account.saveInfo();

    }

    @And("^: Data will be \"([^\"]*)\" edited$")
    public void editAccount (String accountName) throws InterruptedException {
        HomePage homePage = new HomePage(base.getWebDriver(), base.getJavascriptExecutor());
        Account account = new Account(base.getWebDriver(), base.getJavascriptExecutor());
        homePage.getAccounts();
        Thread.sleep(3000);
        homePage.selectData();
        Thread.sleep(3000);
        homePage.clickEdit();
        Thread.sleep(3000);
        account.fillInformation(accountName);
        account.saveInfo();
    }

    @And("^: Created account will be verified$")
    public void verifyAccount () throws InterruptedException {
        HomePage homePage = new HomePage(base.getWebDriver(), base.getJavascriptExecutor());
        Thread.sleep(2000);
        homePage.getAccountDetails();
        Thread.sleep(2000);
        Assert.assertEquals("Verified has been created",base.getTime(),homePage.getCreatedDate());
    }

    @And("^: Edited data will be verified$")
    public void verifyEditedData () throws InterruptedException {
        HomePage homePage = new HomePage(base.getWebDriver(), base.getJavascriptExecutor());
        Thread.sleep(2000);
        homePage.getAccountDetails();
        Thread.sleep(2000);
        Assert.assertNotEquals("Verified has been edited",homePage.getCreatedDate(),homePage.getEditedDate());
    }


}
