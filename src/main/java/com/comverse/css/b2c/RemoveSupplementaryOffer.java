package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RemoveSupplementaryOffer extends B2CMenu {

    public RemoveSupplementaryOffer(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Remove supplementary offer";

        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket ClickYes() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Yes']");
        return new MyBasket(tool, test, user);
    }

}
