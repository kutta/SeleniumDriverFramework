/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifySubscriberAttributesCommon extends CommonMenu {

    public ModifySubscriberAttributesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Subscriber Attributes";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getBirthday() throws Exception {
        return tool.driver.findElement(By.id("p-param-L4:90070")).getAttribute("value");
    }

    public String getSecurityWord() throws Exception {
        return tool.driver.findElement(By.id("p-param-L4:91070")).getAttribute("value");
    }

    public String getLanguage() throws Exception {
        return tool.driver.findElement(By.id("p-param-L4:80000")).findElement(By.xpath(".//option[@selected='selected']")).getText();
    }

    public String getHappyHourStart() throws Exception {
        return tool.driver.findElement(By.id("p-param-L4:91170")).getAttribute("value");
    }

    public String getHappyHourEnd() throws Exception {
        return tool.driver.findElement(By.id("p-param-L4:91180")).getAttribute("value");
    }

    public void enterBirthday(String birthday) throws Exception {
        tool.driver.findElement(By.id("p-param-L4:90070")).clear();
        tool.driver.findElement(By.id("p-param-L4:90070")).sendKeys(birthday);
    }

    public void enterSecurityWord(String securityWord) throws Exception {
        tool.driver.findElement(By.id("p-param-L4:91070")).clear();
        tool.driver.findElement(By.id("p-param-L4:91070")).sendKeys(securityWord);

    }

    public void enterLanguage(String language) throws Exception {
        new Select(tool.searchUsingID(tool, "p-param-L4:80000")).selectByVisibleText(language);
    }

    public void enterHappyHourStart(String happyHourStart) throws Exception {
        tool.driver.findElement(By.id("p-param-L4:91170")).clear();
        tool.driver.findElement(By.id("p-param-L4:91170")).sendKeys(happyHourStart);

    }

    public void enterHappyHourEnd(String happyHourEnd) throws Exception {
        tool.driver.findElement(By.id("p-param-L4:91180")).clear();
        tool.driver.findElement(By.id("p-param-L4:91180")).sendKeys(happyHourEnd);

    }

    public RequestSubmissionCommon clickModifyAttributes() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Modify Attributes']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RequestSubmissionCommon(tool, test, user);
    }
}
