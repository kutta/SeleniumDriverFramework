package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewBilledRCNRCTermDetailsCommon extends CommonMenu {

    public ViewBilledRCNRCTermDetailsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View billed RC/NRC term details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewBilledRCNRCTermsCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewBilledRCNRCTermsCommon(driver);
    }
}
