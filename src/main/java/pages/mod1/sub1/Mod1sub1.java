package pages.mod1.sub1;

import models.FrameworkWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

/* Book Demo Page*/
public class Mod1sub1 extends BasePage {
    private By bookDemoheaderelem = By.xpath("//div[@id='m_class']//div//div//div//h2[contains(text(),'Schedule Your Personal Demo')]");
   private By bookDemoformelem=By.xpath("//form[@id='demoForm']");
    private By firstnamelem = By.xpath("//input[@id='inputFirstName']");
    private By lastnamelem = By.xpath("//input[@id='inputLastName']");
    private By workmailelem = By.xpath("//input[@id='inputEmail']");
    private By countryelem = By.xpath("//select[@id='contrycode']");
    private By phonenumelem = By.xpath("//input[@id='mobileid']");
    private By testtypeelem = By.xpath("//select[@id='prod_type1']");
    private By otherelem = By.xpath("//textarea[@id='messageid']");
    private By schedDemobtnelem = By.xpath("//button[@id='contbtn']");
    private By thankimgelem = By.xpath("//img[contains(@src,'images/thankyou.svg')]");
    private By bookDemoexitelem = By.xpath("//span[contains(@class,'cursor-pointer close')]");
    private By lambdapopExitelem=By.xpath("//span[@id='exit_popup_close']");

    public Mod1sub1(FrameworkWrapper wrapper) {
        super(wrapper);
        elemUtil.pageLoadwait();
        if (!valbookDemoform()) {
//Log in Report
            log.error("Book Demo Form not Loaded/Displayed");
        }


    }

    public void setFirstname(String fname) {
        if(elemUtil.isElementVisible(firstnamelem)) {
            elemUtil.mouseOver(firstnamelem);
            elemUtil.findElement(firstnamelem).click();
            elemUtil.findElement(firstnamelem).sendKeys(fname);
        }
    }

    public void setLastname(String lname) {
        if(elemUtil.isElementVisible(lastnamelem)) {
            elemUtil.mouseOver(lastnamelem);
            elemUtil.findElement(lastnamelem).click();
            elemUtil.findElement(lastnamelem).sendKeys(lname);
        }

    }

    public void setEmail(String wrkemail) {
        if (elemUtil.isElementVisible(workmailelem)) {
            elemUtil.mouseOver(workmailelem);
            elemUtil.findElement(workmailelem).click();
            elemUtil.findElement(workmailelem).sendKeys(wrkemail);
        }
    }


    public void setCountry(String cntry) {
        if (elemUtil.isElementVisible(countryelem)) {
            elemUtil.findElement(countryelem).sendKeys(cntry);


        }

    }

    public void setTesttype(String testype) {
        if (elemUtil.isElementVisible(testtypeelem)) {
            elemUtil.findElement(testtypeelem).sendKeys(testype);

        }

    }
    public void setPhonenum(long phnnum) {
        if (elemUtil.isElementVisible(phonenumelem)) {
            elemUtil.findElement(phonenumelem).sendKeys(String.valueOf(phnnum));
        }

    }

    public void setMessage(String msg) {
        elemUtil.findElement(otherelem).sendKeys(msg);
    }

    public void clickScheddemobtnbtn() {
        if(elemUtil.isElementVisible(lambdapopExitelem)){
            elemUtil.findElement(lambdapopExitelem).click();
        }
        elemUtil.findElement(schedDemobtnelem).click();
    }

    public boolean valbookDemoform() {
        boolean b=false;
        if(elemUtil.isElementVisible(bookDemoheaderelem)){
            b=elemUtil.findElement(bookDemoheaderelem).isDisplayed();
        }
        return b;
    }

    public void valbookDemoexit() {
        elemUtil.findElement(bookDemoformelem).findElement(By.xpath(".."));
        elemUtil.findElement(bookDemoexitelem).click();
    }
    public boolean valThankimg(){
        boolean b=false;
        elemUtil.pageLoadwait();
        if(elemUtil.isElementVisible(thankimgelem)){
           b=elemUtil.findElement(thankimgelem).isDisplayed();
        }
        return b;
    }
}
