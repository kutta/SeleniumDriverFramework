package com.comverse.css.common;

import org.junit.Before;

import com.comverse.common.*;

public class CSSTest extends Main {

    @Before
    public void setUp() throws Exception {
        tool = new Selenium();
        test = new Test();
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchCSSApplication() throws Exception {
        application.setVersion(tool);
        tool.driver.get(application.appURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchAnotherCSSApplication(Application application2) throws Exception {
        tool.driver.get(application2.appURL());
        Thread.sleep(1000);
    }

    public void launchCSSApplicationAndSSOLogin() throws Exception {
        tool.driver.get(application.appURL());
        loginSSOUser();
        application.setVersion(tool);
        tool.driver.navigate().back();
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
        Common.checkForExistingBasketAndDiscard(tool);
    }

    public void launchOCMApplicationAndGetBuildNumber() throws Exception {
        application.setVersion(tool);
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        tool.driver.get(application.appOCMURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchOCMApplication() throws Exception {
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        tool.driver.get(application.appOCMURL());
    }

    public void launchSecurityApplication() throws Exception {
        application.setVersion(tool);
        tool.driver.get(application.appFullURL());
    }

    public void launchOTGApplication() throws Exception {
        tool.driver.get(application.appFullURL());
        Thread.sleep(4000);
    }
}
