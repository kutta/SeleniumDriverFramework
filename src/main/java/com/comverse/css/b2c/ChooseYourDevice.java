/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseYourDevice extends B2CMenu {

    public ChooseYourDevice(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Choose Your Device";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public EnterYourSubscriptionDetails clickNoThanks() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='No Thanks']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public ChooseYourHandset clickSelectVoiceDevices() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//form[@id = 'chooseHandset_Voice_Devices']//input");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourHandset(tool, test, user);
    }

}
