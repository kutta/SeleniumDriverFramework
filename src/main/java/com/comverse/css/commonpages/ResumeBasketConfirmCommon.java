/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ResumeBasketConfirmCommon extends CommonMenu {

    public ResumeBasketConfirmCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Resume Basket Confirm";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickOk() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");
        return new MyBasketCommon(tool, test, user);
    }
}
