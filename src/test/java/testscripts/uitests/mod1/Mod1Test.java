package testscripts.uitests.mod1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.mod1.Mod1;
import pages.mod1.sub1.Mod1sub1;
import pages.mod1.sub2.Mod1sub2;
import pages.mod2.Mod2;
import testscripts.uitests.TestBase;

public class Mod1Test extends TestBase {

    Mod1 mod;


    Mod1Test() {
        mod = new Mod1(wrapper);
        mod.exitAllowcookie();
        mod.exitdefaultPopUp();
    }

    @DisplayName("Validate SignUpFree button")
    @Test
    public void clickSignUpFreeButton() {
        createLog();
        lognode = logger.createNode("Logging into XXXXXX  Selenium PlayGround page");
        setNodeStartTime(lognode);
        Assertions.assertTrue(mod.signupFreebutton());
        setNodeEndTime(lognode);
        lognode = logger.createNode("Clicked on the Get Checked Value button");
        setNodeStartTime(lognode);
        setNodeEndTime(lognode);
        driver.navigate().to(URL);
    }

    @Test
    @DisplayName("Validate Login button")
    public void clickLoginButton() {
        createLog();
        Assertions.assertTrue(mod.loginButton());
        driver.navigate().to(URL);
    }

    @Test
    @DisplayName("Validate SignUp button")
    public void clickSignUpButton() {
        createLog();
        Assertions.assertTrue(mod.signupButton());
        driver.navigate().to(URL);
    }

    @Test
    @DisplayName("Validate Book Demo button")
    public void clickBookDemoButton() {
        createLog();
        Mod1sub1 s=mod.bookdemoButton();
        boolean b= s.valbookDemoform();
        s.valbookDemoexit();
        Assertions.assertTrue(b);
        driver.navigate().to(URL);
    }

    @Test
    @DisplayName("Book A Demo ")
    public void bookDemo() {
        Mod1sub1 modsub1 =  mod.bookdemoButton();
        createLog();
        modsub1.setFirstname("ww");
        modsub1.setLastname("ff");
        modsub1.setEmail("sdf@gg.com");
        modsub1.setCountry("Bahrain (+973)");
        modsub1.setPhonenum(6256757531L);
        modsub1.setTesttype("On-premise Selenium Grid");
        modsub1.setMessage("ttt");
        modsub1.clickScheddemobtnbtn();
        Assertions.assertTrue(modsub1.valThankimg());
        driver.navigate().to(URL);
    }
    @Test
    @DisplayName("Valid/Invalid Email")
    public void valEmail(){
        createLog();
        mod.loginButton();
        Assertions.assertTrue(new Mod1sub2(wrapper).valEmail("avhvhh#$maria9ed2@dmail.com.edu.in")==0);
        driver.navigate().to(URL);
    }
    @Test
    @DisplayName("Valid/Invalid Password")
    public void valPassword(){
        createLog();
        mod.loginButton();
        Assertions.assertTrue(new Mod1sub2(wrapper).valPswd("243535hhj!$@SFF")==0);
        driver.navigate().to(URL);
    }
    @Test
    @DisplayName("Log In with Valid Email/Password")
    public void login(){
        createLog();
        mod.loginButton();
        Mod2 mod2=new Mod1sub2(wrapper).valSignIn("axx656512@dvmail.com","Cxxxxxx@68686");
        Assertions.assertTrue(mod2.valHomepageafterlogin());
        mod2.clickProficon();
        mod2.clickProflogout();
        driver.navigate().to(URL);
    }
}
