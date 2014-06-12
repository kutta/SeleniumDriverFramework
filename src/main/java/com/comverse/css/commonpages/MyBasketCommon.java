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
import com.comverse.css.common.Person;
import com.comverse.css.common.Subscriber;

/**
 * 
 * @author iphilli
 */
public class MyBasketCommon extends CommonMenu {

    public MyBasketCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "My Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public MyBasketCommon clickViewBasket() throws Exception {
        super.clickViewBasket();
        return new MyBasketCommon(tool, test, user);
    }

    public CheckoutReviewCommon clickCheckOut() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutReviewCommon(tool, test, user);
    }

    public CheckoutDeliveryAddressCommon clickCheckOutWithGoods() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutDeliveryAddressCommon(tool, test, user);
    }

    public TermsAndConditionsCommon clickCheckOutWithTermsAndConditions() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new TermsAndConditionsCommon(tool, test, user);
    }

    public ShoppingCommon clickContinueShopping() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue Shopping']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickFirstActionsIcon() throws Exception {
        tool.driver.findElement(By.cssSelector("img[title=\"Configure Service Connection Details\"]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickSecondActionsIcon() throws Exception {
        tool.driver.findElement(By.cssSelector("#modify_lines_2 > img[title=\"Configure Service Connection Details\"]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public String getTypeRole() throws Exception {
        return tool.driver.findElement(By.xpath("//td[2]/div/p")).getText();
    }

    public String getAddress() throws Exception {
        String address = tool.driver.findElement(By.xpath("//td[4]/div/p")).getText();
        return address.replaceAll("[^\\p{L}\\p{N}]", " ");
    }

    public String getOfferName() throws Exception {
        return tool.driver.findElement(By.xpath("//tr[9]/td")).getText();
    }

    public String getRecurringCharge() throws Exception {
        return tool.driver.findElement(By.xpath("//tr[9]/td[4]")).getText();
    }

    public String getUpfrontCharge() throws Exception {
        return tool.driver.findElement(By.xpath("//tr[9]/td[5]")).getText();
    }

    public String getQuantity() throws Exception {
        return tool.driver.findElement(By.xpath("//tr[9]/td[2]")).getText();
    }

    public RemoveBasketCommon clickClear() throws Exception {
        tool.driver.findElement(By.name("clear")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveBasketCommon(tool, test, user);
    }

    public void clickAcceptTermsAndConditions() throws Exception {
        tool.driver.findElement(By.id("termsandconditionscheck")).click();
    }

    public RemoveSelectionCommon removeSecondItemFromBasket() throws Exception {
        tool.driver.findElement(By.id("remove_1")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveSelectionCommon(tool, test, user);
    }

    public RemoveSelectionCommon removeFirstItemFromBasket() throws Exception {
        tool.driver.findElement(By.linkText("Remove")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveSelectionCommon(tool, test, user);
    }

    public void clickAddPersonOrRole() throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.id("pm-button-add-person")).click();
    }

    public void clickUserOfNewSubscriber1() throws Exception {
        tool.driver.findElement(By.xpath("//td[@id='pm-role-fields']/p[2]/input")).click();
    }

    public void clickOrdering() throws Exception {
        tool.driver.findElement(By.name("role_radio_group_selection_0")).click();
    }

    public void selectTitle(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("pm-field-title"))).selectByVisibleText(value);
    }

    public void setFirstName(String value) throws Exception {
        tool.driver.findElement(By.id("pm-field-fname")).clear();
        tool.driver.findElement(By.id("pm-field-fname")).sendKeys(value);
    }

    public void setLastName(String value) throws Exception {
        tool.driver.findElement(By.id("pm-field-lname")).clear();
        tool.driver.findElement(By.id("pm-field-lname")).sendKeys(value);
    }

    public void setAddressLine1(String value) throws Exception {
        tool.driver.findElement(By.id("pm-field-address1")).clear();
        tool.driver.findElement(By.id("pm-field-address1")).sendKeys(value);
    }

    public void setPostalCode(String value) throws Exception {
        tool.driver.findElement(By.id("pm-field-zip")).clear();
        tool.driver.findElement(By.id("pm-field-zip")).sendKeys(value);
    }

    public void setCity(String value) throws Exception {
        tool.driver.findElement(By.id("pm-field-city")).clear();
        tool.driver.findElement(By.id("pm-field-city")).sendKeys(value);
    }

    public void selectCountry(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("pm-field-country"))).selectByVisibleText(value);
    }

    public void selectRegion(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("pm-field-region"))).selectByVisibleText(value);
    }

    public void selectFirstUserinDropDown() throws Exception {
        new Select(tool.driver.findElement(By.id("subscriber"))).selectByIndex(1);
    }

    public void clickAddRole() {
        tool.driver.findElement(By.id("add_role")).click();
    }

    public void clickAdd() throws Exception {
        tool.driver.findElement(By.id("pm-button-add")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public ShoppingCommon changePrimaryOffer() throws Exception {
        tool.driver.findElement(By.id("add_pp_0")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickAddSO() throws Exception {
        tool.driver.findElement(By.linkText("Add Supplementary Offer(s)")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickChangeSO() throws Exception {
        tool.driver.findElement(By.id("add_srv_1")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public SelectOffersForYourAccountCommon clickAddAO() throws Exception {
        tool.driver.findElement(By.id("add_srv_ACCOUNT_LEVEL_SELECTION")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public Person addConsumerUserPersonOrdering() throws Exception {

        String CUPUniqueString = Common.generateTimeStamp();
        Person person2 = new Person(CUPUniqueString);

        person2.setPersonLastNameProperty("CUPLN" + CUPUniqueString);
        person2.setPersonFirstNameProperty("CUPFN" + CUPUniqueString);
        person2.setPersonTitleProperty("Mrs.");
        person2.setPersonHomeCountryProperty("United States");
        person2.setPersonHomeStateProperty("Florida");
        person2.setPersonStreetNumberProperty("CUPUniqueString");
        person2.setPersonStreetNameProperty("CUPAdd1-");
        person2.setPersonCityProperty("CUPcity");
        person2.setPersonPostCodeProperty("CUPPostCode");

        this.clickAddPersonOrRole();
        this.selectTitle(person2.getPersonTitleProperty());
        this.setFirstName(person2.getPersonFirstNameProperty());
        this.setLastName(person2.getPersonLastNameProperty());
        this.setAddressLine1(person2.getPersonStreetNameProperty() + person2.getPersonStreetNumberProperty());
        this.setPostalCode(person2.getPersonPostCodeProperty());
        this.setCity(person2.getPersonCityProperty());
        this.selectCountry(person2.getPersonHomeCountryProperty());
        this.selectRegion(person2.getPersonHomeStateProperty());
        this.clickUserOfNewSubscriber1();
        this.clickOrdering();
        this.clickAdd();

        setPerson2(person2);

        return person2;
    }

    public void assign3InventoriesFirstOffer(Subscriber subscriber) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickFirstActionsIcon();
        serviceConnectionDetails.clickSetIMSIInventory(subscriber);
        serviceConnectionDetails.clickSetSIMInventory(subscriber);
        serviceConnectionDetails.clickSetMSISDNInventory(subscriber);
        serviceConnectionDetails.clickOk();
    }

    public void assign1InventoryFirstOffer(Subscriber subscriber) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickFirstActionsIcon();
        serviceConnectionDetails.clickSetIMSIInventory(subscriber);
        serviceConnectionDetails.clickOk();
    }

    public void assignEmailInventory(String email) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickFirstActionsIcon();
        serviceConnectionDetails.SetEmailInventory(email);
        serviceConnectionDetails.clickOkAfterSetEmailInventory();
    }

    public void assign3InventoriesSecondOffer(Subscriber subscriber) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickSecondActionsIcon();
        serviceConnectionDetails.clickSetIMSIInventory(subscriber);
        serviceConnectionDetails.clickSetSIMInventory(subscriber);
        serviceConnectionDetails.clickSetMSISDNInventory(subscriber);
        serviceConnectionDetails.clickOk();
    }

    public ParkTheCurrentBasketCommon clickParkBasket() throws Exception {
        tool.driver.findElement(By.id("lnk_SBE.PARK.ADD")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ParkTheCurrentBasketCommon(tool, test, user);
    }
}
