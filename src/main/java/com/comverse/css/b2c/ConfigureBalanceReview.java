package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureBalanceReview extends B2CMenu {

    public ConfigureBalanceReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Configure balance - Review";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureBalanceConfirm clickConfirm() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='button'][value='Confirm']");
        return new ConfigureBalanceConfirm(tool, test, user);

    }

    public ViewBalances clickBack() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Back']");
        return new ViewBalances(tool, test, user);

    }
}
