package pages.mod1.sub2;

import models.FrameworkWrapper;
import org.openqa.selenium.By;
import pages.BasePage;
/* Other Mode of Login */
public class Mod1sub2_1 extends BasePage {
    private By ssoBtnelem= By.xpath("//button[@id='login-button'][contains(text(),'Continue with SSO')]");
    protected Mod1sub2_1(FrameworkWrapper wrapper) {
        super(wrapper);
    }

    public boolean valGoogleSignInpage(){
        return getWebDriver().getTitle().contains("Sign in - Google Accounts");
    }
    public boolean valSSOSignInpage(){
        boolean b=false;
        try {
           b=elemUtil.findElement(ssoBtnelem).isDisplayed();
        }catch(Exception e)
    {
        e.printStackTrace();
    }
        return b;
    }
}
