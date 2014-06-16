package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewRechargeDetailsCommon extends CommonMenu {

    public ViewRechargeDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "View Recharge Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public ViewUnbilledRechargeCommon clickBack() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new ViewUnbilledRechargeCommon(tool, test, user);
    }

    public ViewBilledRechargesCommon clickBackToBiledRecharges() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new ViewBilledRechargesCommon(tool, test, user);
    }

}
