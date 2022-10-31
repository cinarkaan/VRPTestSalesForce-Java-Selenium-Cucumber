package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    JavascriptExecutor javascriptExecutor;

    @FindBy(xpath = "//a[@title='Accounts']")
    private WebElement accounts;

    @FindBy(xpath = "//*[@id='detailTab__item']")
    private WebElement accountDetail;

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-account_-record_-page___-account___-v-i-e-w/forcegenerated-flexipage_account_record_page_account__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___view___recordlayout2/records-record-layout-block/slot/records-record-layout-section[4]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[1]/div/div/div[2]/span/slot[1]/records-modstamp/lightning-formatted-text")
    private WebElement createdDate;

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-account_-record_-page___-account___-v-i-e-w/forcegenerated-flexipage_account_record_page_account__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___view___recordlayout2/records-record-layout-block/slot/records-record-layout-section[4]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[2]/div/div/div[2]/span/slot[1]/records-modstamp/lightning-formatted-text")
    private WebElement editedDate;

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a")
    private WebElement selectData;

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-account_-record_-page___-account___-v-i-e-w/forcegenerated-flexipage_account_record_page_account__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[2]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-page-reference/slot/slot/lightning-button/button")
    private WebElement editButton;

    public HomePage(WebDriver webDriver, JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
        PageFactory.initElements(webDriver, this);
    }

    public void getAccounts() {
        javascriptExecutor.executeScript("arguments[0].click();",accounts);
    }

    public void getAccountDetails () {
        javascriptExecutor.executeScript("arguments[0].click();",accountDetail);
    }

    public void selectData () {
        selectData.click();
    }

    public void clickEdit () {
        editButton.click();
    }

    public String getCreatedDate () {
        String dateOfCreate = createdDate.getText();
        dateOfCreate = dateOfCreate.substring(dateOfCreate.length() - 5, dateOfCreate.length());
        return dateOfCreate;
    }

    public String getEditedDate () {
        String dateOfCreate = editedDate.getText();
        dateOfCreate = dateOfCreate.substring(dateOfCreate.length() - 5, dateOfCreate.length());
        return dateOfCreate;
    }

}
