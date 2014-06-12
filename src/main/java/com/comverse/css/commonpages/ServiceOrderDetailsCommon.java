/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Account;

public class ServiceOrderDetailsCommon extends CommonMenu {

    public ServiceOrderDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Service Order Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void getAccountID(Account account) throws Exception {
        String accountID = tool.driver.findElement(By.xpath("//td[2]/a")).getText();
        System.out.println("AccountID = " + accountID);
        account.setBillingAccountIDProperty(accountID);
    }

    public SearchOrdersCommon clickBack() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='submit'][value='Back']")).click();
        return new SearchOrdersCommon(tool, test, user);
    }
}
