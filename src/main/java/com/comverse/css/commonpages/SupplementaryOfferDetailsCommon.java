/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SupplementaryOfferDetailsCommon extends CommonMenu {

    public SupplementaryOfferDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Supplementary Offer Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SelectOffersForYourSubscriberCommon clickReturnToList() throws Exception {
        tool.driver.findElement(By.name("select")).click();
        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }
}
