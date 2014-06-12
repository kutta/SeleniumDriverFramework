package com.comverse.css.commonpages;

import java.util.Calendar;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewHierarchyCommon extends CommonMenu {

    public ViewHierarchyCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Hierarchy";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickWeeklyLevel() throws Exception {

        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        String weeklyLevelName = "level" + week + "a";

        tool.driver.findElement(By.linkText(weeklyLevelName)).click();

    }

    public void clickLevelLink(String linkName) throws Exception {

        tool.driver.findElement(By.linkText(linkName)).click();
    }

    public String getRootLevel() throws Exception {
        System.out.println("Root Level " + tool.driver.findElement(By.xpath("//div[@id='mainContents']/div/table/tbody/tr/td/a")).getText());
        return tool.driver.findElement(By.xpath("//div[@id='mainContents']/div/table/tbody/tr/td/a")).getText();

    }

    public ContactInformationCommon clickEmployeeNameLink(String firstName, String lastName) throws Exception {

        tool.driver.findElement(By.linkText(firstName + " " + lastName)).click();
        return new ContactInformationCommon(tool, test, user);
    }

}
