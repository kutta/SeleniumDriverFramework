package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SelectModeOfRecharge extends B2CMenu {

    public SelectModeOfRecharge(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Select mode of recharge";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectFreeAmount() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='freeAmount']")).click();
    }

    public RechargeWithFreeAmount clickSubmit() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new RechargeWithFreeAmount(tool, test, user);
    }
}
