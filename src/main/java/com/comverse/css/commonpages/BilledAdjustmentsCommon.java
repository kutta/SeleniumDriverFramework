package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class BilledAdjustmentsCommon extends CommonMenu {
    static String expectedScreen = "Billed adjustments";

    public BilledAdjustmentsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewInvoiceDetailsCommon clickBack() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }
}
