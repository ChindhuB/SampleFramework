/*Can design as model  / dto (Data Transfer Objective) package */
package config.model;

import config.Browser;
import config.ExecutionMode;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SeleniumTestParameters {
    private ExecutionMode mode;
    private Browser browser;
    private  String platform;
    private static final SeleniumTestParameters seleniumParam=new SeleniumTestParameters();
    SeleniumTestParameters(){

    }
    public SeleniumTestParameters(ExecutionMode mode, Browser browser, String platform){
        this.mode=mode;
        this.browser=browser;
        this.platform=platform;

    }
    public static SeleniumTestParameters getInstance() {
        return seleniumParam;
    }


}
