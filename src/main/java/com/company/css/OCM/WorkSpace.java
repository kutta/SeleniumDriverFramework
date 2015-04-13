/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.css.OCM;

import com.framework.common.AutomationTool;
import com.framework.common.TestDetails;
import com.framework.common.User;
import com.company.css.commonpages.CommonMenu;

public class WorkSpace extends CommonMenu {

    public WorkSpace(AutomationTool tool, TestDetails test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Welcome to OCM!";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

}
