package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RemoveSupplementaryOffer extends B2CMenu {

    public RemoveSupplementaryOffer(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Remove supplementary offer";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public MyBasket ClickYes() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingCssSelector("input[type='submit'][value='Yes']");
        return new MyBasket(tool, test, user);
    }

}
