/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyItemOfSubscriber extends B2CMenu {

    public ModifyItemOfSubscriber(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Item of Subscriber";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public ModifyItem clickConfirm() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Confirm']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyItem(tool, test, user);
    }
}
