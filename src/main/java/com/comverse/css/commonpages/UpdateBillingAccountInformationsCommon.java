/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UpdateBillingAccountInformationsCommon extends CommonMenu {

    public UpdateBillingAccountInformationsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Update administrative account information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public EnterIdentificationDataCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        return new EnterIdentificationDataCommon(tool, test, user);
    }

}
