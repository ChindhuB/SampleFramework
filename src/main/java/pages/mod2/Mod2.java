package pages.mod2;

import models.FrameworkWrapper;
import org.openqa.selenium.By;
import pages.BasePage;


//Home page after Log IN
public class Mod2 extends BasePage {
    private By profileIconelem= By.xpath("//a[@id='profile__dropdown']");
    private By profLogoutelem=By.xpath("//a[@id='app__logout']");
    public Mod2(FrameworkWrapper wrapper) {
        super(wrapper);
    }

    public boolean valHomepageafterlogin() {
        elemUtil.pageLoadwait();
        return elemUtil.getTitle().matches("Welcome - (.*)Test");
    }
    public void clickProficon(){
        if(elemUtil.isElementVisible(profileIconelem)){
            elemUtil.mouseOver(profileIconelem);
            elemUtil.findElement(profileIconelem).click();
        }
    }
    public void clickProflogout(){
        if(elemUtil.isElementVisible(profLogoutelem)){
            elemUtil.mouseOver(profLogoutelem);
            elemUtil.findElement(profLogoutelem).click();
        }
    }
}
