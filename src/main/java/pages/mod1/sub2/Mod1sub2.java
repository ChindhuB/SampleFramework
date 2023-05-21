package pages.mod1.sub2;

import models.FrameworkWrapper;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.mod2.Mod2;

/* Login Page*/
public class Mod1sub2 extends BasePage {
    private By emailelem = By.xpath("//input[@id='email']");
    private By pswdelem = By.xpath("//input[@id='password']");
    private By loginBtnelem = By.xpath("//button[@id='login-button']");
    private By loginGoogleelem = By.xpath("//a[contains(@href,'/login/google')][contains(@class,'googleSignInBtn')]");
    private By loginSSOelem = By.xpath("//a[contains(@href,'/sso')][contains(@class,'googleSignInBtn')]");
    private By valEmailtxtelem=By.xpath("//p[contains(text(),'Email must be a valid email address')]");
    private By valPswdtxtelem=By.xpath("//p[contains(text(),'Password must be a valid passowrd')]");
    public Mod1sub2(FrameworkWrapper wrapper) {
        super(wrapper);
        if (!valLoginpage()) {
//Log in Report
            log.error("Log in page not loaded/displayed");
        }


    }

    public boolean valLoginpage()  {
        elemUtil.pageLoadwait();
        return getWebDriver().getTitle().contains("Log in");
    }

    public Mod2 valSignIn(String email, String pswd) {
        Mod2 m2=null;
        try {
            setEmail(email);
            setPswd(pswd);
            clickLoginbtn();
            m2=new Mod2(getWrapper());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return m2;
    }

    private void setEmail(String email) {
    elemUtil.findElement(emailelem).sendKeys(email);
    }

    private void setPswd(String pswd) {
        elemUtil.findElement(pswdelem).sendKeys(pswd);
    }

    private void clickLoginbtn() {
        elemUtil.findElement(loginBtnelem).click();
    }
    /*
    At least one lower case English letter, (?=.*?[a-z])
    At least one @ character, (?=.*?[@])
    No Whitespaces
    Dot followed by @
    @return TRUE
   */
    public int valEmail(String email){
         setEmail(email);
         setPswd("pswd");
         clickLoginbtn();
         boolean exp=email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
         return Boolean.compare((!elemUtil.isElementVisible(valEmailtxtelem)),exp);
    }
   /* At least 8 characters long;
    One lowercase, one uppercase, one number and one special character;
    No whitespaces
    @return TRUE
    */
    public int valPswd(String pswd){
        setEmail("xxxx@ggg.co.in");
        setPswd(pswd);
        clickLoginbtn();
        boolean exp=pswd.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])([a-zA-Z0-9@$!%*?&]{8,16})$");
        return Boolean.compare((!elemUtil.isElementVisible(valPswdtxtelem)),exp);
    }
}

