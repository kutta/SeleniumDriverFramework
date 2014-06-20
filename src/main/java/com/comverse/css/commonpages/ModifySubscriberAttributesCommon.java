/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifySubscriberAttributesCommon extends CommonMenu {

    public ModifySubscriberAttributesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Subscriber Attributes";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getBirthday() throws Exception {
        return tool.getAttributeUsingId("p-param-L4:90070", "value");
    }

    public String getSecurityWord() throws Exception {
        return tool.getAttributeUsingId("p-param-L4:91070", "value");
    }

    public String getLanguage() throws Exception {
        return tool.searchUsingIDandGetTextUsingXpath("p-param-L4:80000", ".//option[@selected='selected']");
    }

    public String getHappyHourStart() throws Exception {
        return tool.getAttributeUsingId("p-param-L4:91170", "value");
    }

    public String getHappyHourEnd() throws Exception {
        return tool.getAttributeUsingId("p-param-L4:91180", "value");
    }

    public void enterBirthday(String birthday) throws Exception {

        tool.enterStringUsingId("p-param-L4:90070", birthday);
    }

    public void enterSecurityWord(String securityWord) throws Exception {

        tool.enterStringUsingId("p-param-L4:91070", securityWord);

    }

    public void enterLanguage(String language) throws Exception {
        tool.selectVisibleTextByID("p-param-L4:80000", language);
    }

    public void enterHappyHourStart(String happyHourStart) throws Exception {

        tool.enterStringUsingId("p-param-L4:91170", happyHourStart);

    }

    public void enterHappyHourEnd(String happyHourEnd) throws Exception {

        tool.enterStringUsingId("p-param-L4:91180", happyHourEnd);

    }

    public RequestSubmissionCommon clickModifyAttributes() throws Exception {

        tool.clickUsingXPath("//input[@value='Modify Attributes']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RequestSubmissionCommon(tool, test, user);
    }
}
