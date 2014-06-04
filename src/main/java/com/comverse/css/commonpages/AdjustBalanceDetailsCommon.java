package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdjustBalanceDetailsCommon extends CommonMenu {
    static String expectedScreen = "Adjust balance - details";

    public AdjustBalanceDetailsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterAdjustmentAmount(String amount) throws Exception {

        driver.findElement(By.id("adjustmentValue")).clear();
        driver.findElement(By.id("adjustmentValue")).sendKeys(amount);
    }

    public AdjustBalanceReviewCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new AdjustBalanceReviewCommon(driver);
    }
}
