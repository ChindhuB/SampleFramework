package pages.mod1;

import models.FrameworkWrapper;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.mod1.sub1.Mod1sub1;
import pages.mod1.sub2.Mod1sub2;

public class Mod1 extends BasePage {
    private By popupelem=By.xpath ("//span[@id='exit_popup_close']");
    private By allowcookelem=By.xpath("//span[contains(@class,'cookie__bar__close hover')]");
    private By signUpFreebtnelem= By.xpath("//div[contains(@class,'flex items-center ')]//a[contains(@href,'accounts.xxxxx.com/register')][contains(text(),'Signup for free')]");
    private By signUpbtnelem= By.xpath("//div[contains(@class,'text-right desktop:text-left desktop:w-full desktop')]//a[contains(@href,'accounts.xxxx.com/register')][contains(text(),'Sign Up')]");
    private By loginbtnelem=By.xpath("//div[contains(@class,'text-right desktop:text-left desktop:w-full desktop')]//a[contains(@href,'accounts.xxxx.com/login')][contains(text(),'Login')]");

   private By bookDemobtnelem=By.xpath("//div[contains(@class,'text-right desktop:text-left desktop:w-full desktop')]//button[contains(@class,'text-black demo_btn')][contains(text(),'Book a Demo')]");


 public Mod1(FrameworkWrapper wrapper){
     super(wrapper);
    if(!title.toString().contains("Most Powerful Cross Browser Testing Tool Online"))
    {
     //Log in Report
        log.error("Base URL not verified");
     }

 }

public boolean signupFreebutton() {

    try {
            if (elemUtil.isElementVisible(signUpFreebtnelem)) {
                elemUtil.findElement(signUpFreebtnelem).click();
            }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return getWebDriver().getTitle().contains("Sign up for free | Cross <> Tool | <>");


}
    public boolean signupButton() {

        try {
            if (elemUtil.isElementVisible(signUpbtnelem)) {
                elemUtil.findElement(signUpbtnelem).click();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getWebDriver().getTitle().contains("Sign up for free | Cross <> Tool | <>");


    }
    public boolean loginButton() {
     boolean ms1=false;
        try {
            if (elemUtil.isElementVisible(loginbtnelem)) {
                elemUtil.findElement(loginbtnelem).click();
                ms1=new Mod1sub2(super.getWrapper()).valLoginpage();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms1;
    }
    public Mod1sub1 bookdemoButton() {
     Mod1sub1 ms1=null;
        try {
            if (elemUtil.isElementVisible(bookDemobtnelem)) {
                elemUtil.findElement(bookDemobtnelem).click();
                ms1=new Mod1sub1(super.getWrapper());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms1;

    }
public void exitAllowcookie(){
    if (elemUtil.isElementVisible(allowcookelem)) {
        elemUtil.findElement(allowcookelem).click();

    }
}
public void exitdefaultPopUp(){
    if (elemUtil.isElementVisible(popupelem)) {
        elemUtil.findElement(popupelem).click();
    }
}
}

