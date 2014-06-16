package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfirmOffersSelection extends B2CMenu {

    public ConfirmOffersSelection(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Confirm Offers Selection";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickConfirmOffer() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Confirm Offer Personalization']");
        return new MyBasket(tool, test, user);

    }

    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
        
        tool.enterStringUsingXPath(tool, "//label[contains(text(),'Voice Mail Size')]/../input", voiceMailSize);
    }

}
