package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureContractDetailsCommon extends CommonMenu {

    public ConfigureContractDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Configure Contract Details";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {
        tool.driver.findElement(By.id(limitName + "_limit")).clear();
        tool.driver.findElement(By.id(limitName + "_limit")).sendKeys(limitAmount);
    }

    public void setLang(String lang) throws Exception {
        new Select(tool.driver.findElement(By.id("p-param-L4:80000"))).selectByVisibleText(lang);
    }

    public ConfigureBalanceCommon clickContinueExpectingConfigureBalance() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureBalanceCommon(tool, test, user);
    }

}
