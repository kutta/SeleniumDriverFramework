package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class DisconnectSubscriberRequestForDetailsCommon extends CommonMenu {
    static String expectedScreen = "Disconnect subscriber - Request for details";

    public DisconnectSubscriberRequestForDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickCheckBoxUnlockNow() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingID("propertyNow");

    }

    public void setReason(String reason) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.selectVisibleTextByID("reason", reason);
    }

    public void setAnnotation(String annotation) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("annotation", annotation);
    }

    public DisconnectSubscriberImpactsCommon clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectSubscriberImpactsCommon(tool, test, user);
    }
}
