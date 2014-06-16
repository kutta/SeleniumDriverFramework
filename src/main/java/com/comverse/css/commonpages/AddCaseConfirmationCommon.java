/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddCaseConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Add case - confirmation";

    public AddCaseConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new AccountDetailsCommon(tool, test, user);
    }

    public String getConfirmationMessage() throws Exception {

        return tool.getTextUsingCssSelector(tool, "BODY");
    }

    public String getCaseID() throws Exception {

        String caseID = tool.getTextUsingCssSelector(tool, "div.txt > span");

        caseID = caseID.replaceAll("[a-zA-Z \\.]", "");
        System.out.println("New Case ID : " + caseID);
        return caseID;
    }
}
