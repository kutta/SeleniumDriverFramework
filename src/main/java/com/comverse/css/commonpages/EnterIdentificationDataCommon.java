/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.Application;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;
import com.comverse.css.common.Person;
import com.comverse.css.common.Subscriber;

public class EnterIdentificationDataCommon extends CommonMenu {

    public EnterIdentificationDataCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Customer Acquisition - Identification Data";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setGender(String gender) throws Exception {

        boolean correctGender = false;

        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(By.id("sex_male")).click();
            correctGender = true;
        }

        if (gender.equalsIgnoreCase("female")) {
            driver.findElement(By.id("sex_fem")).click();
            correctGender = true;
        }

        if (!correctGender) {
            throw new IllegalStateException("Gender not recognised - male or female: " + gender);

        }
    }

    public void setNationality(String title) throws Exception {
        new Select(driver.findElement(By.id("nationality"))).selectByVisibleText(title);
    }

    public void setLanguage(String title) throws Exception {
        new Select(driver.findElement(By.id("language"))).selectByVisibleText(title);
    }

    public void setEmailAddress(String email) throws Exception {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void setPhoneNumber(String phonenumber) throws Exception {
        driver.findElement(By.id("home_phone")).clear();
        driver.findElement(By.id("home_phone")).sendKeys(phonenumber);
    }

    public void setMobileNumber(String mobile_phone) throws Exception {
        driver.findElement(By.id("mobile_phone")).clear();
        driver.findElement(By.id("mobile_phone")).sendKeys(mobile_phone);
    }

    public void setFaxNumber(String fax) throws Exception {
        driver.findElement(By.id("fax")).clear();
        driver.findElement(By.id("fax")).sendKeys(fax);
    }

    public void setNationalID(String national_id) throws Exception {
        driver.findElement(By.id("national_id")).clear();
        driver.findElement(By.id("national_id")).sendKeys(national_id);
    }

    public void setDateOfBirth(String date_of_birth) throws Exception {
        driver.findElement(By.id("date_of_birth")).clear();
        driver.findElement(By.id("date_of_birth")).sendKeys(date_of_birth);
    }

    public void setBillingTitle(String title) throws Exception {
        new Select(driver.findElement(By.id("billing_title"))).selectByVisibleText(title);
    }

    public void setBusinessTitle(String title) throws Exception {
        new Select(driver.findElement(By.id("contact_title_field"))).selectByVisibleText(title);
    }

    public void setBillingFirstName(String billing_first_name) throws Exception {
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys(billing_first_name);
    }

    public void setBusinessFirstName(String biz_first_name) throws Exception {
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys(biz_first_name);
    }

    public void setBillingLastName(String billing_last_name) throws Exception {
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys(billing_last_name);
    }

    public void setBusinessLastName(String biz_last_name) throws Exception {
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys(biz_last_name);
    }

    public void setBillingStreetName(String billing_streetName) throws Exception {
        driver.findElement(By.id("billing_streetName")).clear();
        driver.findElement(By.id("billing_streetName")).sendKeys(billing_streetName);
    }

    public void setBillingStreetSuffix(String billing_streetSuffix) throws Exception {
        new Select(driver.findElement(By.id("billing_streetSuffix"))).selectByVisibleText(billing_streetSuffix);
    }

    public void setBillingStreetNumber(String billing_streetNumber) throws Exception {
        driver.findElement(By.id("billing_streetNumber")).clear();
        driver.findElement(By.id("billing_streetNumber")).sendKeys(billing_streetNumber);
    }

    public void enterBillingPostCode(String billing_zip_code) throws Exception {
        driver.findElement(By.id("billing_zip_code")).clear();
        driver.findElement(By.id("billing_zip_code")).sendKeys(billing_zip_code);
    }

    public void enterBillingHomeCountry(String billing_country) throws Exception {
        new Select(driver.findElement(By.id("billing_country"))).selectByVisibleText(billing_country);
    }

    public void enterBillingHomeState(String billing_state) throws Exception {
        new Select(driver.findElement(By.id("billing_state"))).selectByVisibleText(billing_state);
    }

    public void enterBillingCity(String billing_city) throws Exception {

        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys(billing_city);
    }

    public void enterBusinessPostCode(String billing_zip_code) throws Exception {

        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(billing_zip_code);
    }

    public void enterBusinessHomeCountry(String billing_country) throws Exception {
        new Select(driver.findElement(By.id("home_country"))).selectByVisibleText(billing_country);
    }

    public void enterBusinessHomeState(String billing_state) throws Exception {
        new Select(driver.findElement(By.id("home_state"))).selectByVisibleText(billing_state);
    }

    public void enterBusinessCity(String billing_city) throws Exception {
        driver.findElement(By.id("home_city")).clear();
        driver.findElement(By.id("home_city")).sendKeys(billing_city);
    }

    public void setCustomerTitle(String title) throws Exception {
        new Select(driver.findElement(By.id("contact_title_field"))).selectByVisibleText(title);
    }

    public void setCustomerFirstName(String firstname) throws Exception {
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys(firstname);
    }

    public void setCustomerLastName(String lastname) throws Exception {
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys(lastname);
    }

    public void setCustomerStreetName(String streetName) throws Exception {
        driver.findElement(By.id("streetName")).clear();
        driver.findElement(By.id("streetName")).sendKeys(streetName);
    }

    public void setCustomerStreetSuffix(String streetSuffix) throws Exception {
        new Select(driver.findElement(By.id("streetSuffix"))).selectByVisibleText(streetSuffix);
    }

    public void setCustomerStreetNumber(String streetNumber) throws Exception {
        driver.findElement(By.id("streetNumber")).clear();
        driver.findElement(By.id("streetNumber")).sendKeys(streetNumber);
    }

    public String getCustomerStreetName() throws Exception {
        return driver.findElement(By.id("streetName")).getAttribute("value");
    }

    public void enterCustomerPostCode(String postCode) throws Exception {
        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(postCode);
    }

    public String getCustomerPostCode() throws Exception {
        return driver.findElement(By.id("home_zip")).getAttribute("value");
    }

    public void enterCustomerHomeCountry(String homeCountry) throws Exception {
        new Select(driver.findElement(By.id("home_country"))).selectByVisibleText(homeCountry);
    }

    public String getCustomerHomeCountry() throws Exception {
        return new Select(driver.findElement(By.id("home_country"))).getFirstSelectedOption().getText();
    }

    public void enterCustomerHomeState(String homeState) throws Exception {
        new Select(driver.findElement(By.id("home_state"))).selectByVisibleText(homeState);
    }

    public void enterCustomerCity(String city) throws Exception {
        driver.findElement(By.id("home_city")).clear();
        driver.findElement(By.id("home_city")).sendKeys(city);
    }

    public String getCustomerCity() throws Exception {
        return driver.findElement(By.id("home_city")).getAttribute("value");
    }

    public void setServiceTitle(String service_title) throws Exception {
        new Select(driver.findElement(By.id("service_title"))).selectByVisibleText(service_title);
    }

    public void setServiceFirstName(String service_first_name) throws Exception {
        driver.findElement(By.id("service_first_name")).clear();
        driver.findElement(By.id("service_first_name")).sendKeys(service_first_name);
    }

    public void setServiceLastName(String service_last_name) throws Exception {
        driver.findElement(By.id("service_last_name")).clear();
        driver.findElement(By.id("service_last_name")).sendKeys(service_last_name);
    }

    public void setServiceStreetName(String service_streetName) throws Exception {
        driver.findElement(By.id("service_streetName")).clear();
        driver.findElement(By.id("service_streetName")).sendKeys(service_streetName);
    }

    public void setServiceSteetSuffix(String service_streetSuffix) throws Exception {
        new Select(driver.findElement(By.id("service_streetSuffix"))).selectByVisibleText(service_streetSuffix);
    }

    public void setServiceStreetNumber(String service_streetNumber) throws Exception {
        driver.findElement(By.id("service_streetNumber")).clear();
        driver.findElement(By.id("service_streetNumber")).sendKeys(service_streetNumber);
    }

    public void enterServicePostCode(String service_home_zip) throws Exception {
        driver.findElement(By.id("service_home_zip")).clear();
        driver.findElement(By.id("service_home_zip")).sendKeys(service_home_zip);
    }

    public void enterServiceHomeCountry(String service_home_country) throws Exception {
        new Select(driver.findElement(By.id("service_home_country"))).selectByVisibleText(service_home_country);
    }

    public void enterServiceHomeState(String service_home_state) throws Exception {
        new Select(driver.findElement(By.id("service_home_state"))).selectByVisibleText(service_home_state);
    }

    public void enterServiceCity(String service_home_city) throws Exception {
        driver.findElement(By.id("service_home_city")).clear();
        driver.findElement(By.id("service_home_city")).sendKeys(service_home_city);
    }

    public UpdateAccountBillingAddressInformationsCommon clickEnterAdressButtonSelect() throws Exception {
        driver.findElement(By.id("enter_address")).click();
        return new UpdateAccountBillingAddressInformationsCommon(driver);
    }

    public void clickCopyFromCustomerAddressButton() throws Exception {
        driver.findElement(By.xpath("//input[@value='Copy from Customer Address']")).click();
    }

    public void clickCopyFromBillingAddressButton() throws Exception {
        driver.findElement(By.xpath("//input[@value='Copy from Billing Address']")).click();
    }

    public void uncheckSameAsCustomerAddress() throws Exception {
        driver.findElement(By.id("link_addresschecked")).click();
    }

    public void clickPaymentMethodCheck() throws Exception {
        driver.findElement(By.xpath("(//input[@name='method'])[2]")).click();
    }

    public void setBillingCompanyName(String companyName) throws Exception {
        driver.findElement(By.id("company_name")).clear();
        driver.findElement(By.id("company_name")).sendKeys(companyName);
    }

    public void setBankCode(String bankcode) throws Exception {
        driver.findElement(By.id("p-L1:1-L3:1360")).clear();
        driver.findElement(By.id("p-L1:1-L3:1360")).sendKeys(bankcode);
    }

    public void setBankAgencyCode(String bankagencycode) throws Exception {
        driver.findElement(By.id("p-L1:1-L3:1370")).clear();
        driver.findElement(By.id("p-L1:1-L3:1370")).sendKeys(bankagencycode);
    }

    public void setBankAccountNumber(String bankaccountnumber) throws Exception {
        driver.findElement(By.id("p-L1:1-L3:1380")).clear();
        driver.findElement(By.id("p-L1:1-L3:1380")).sendKeys(bankaccountnumber);
    }

    public void setBankLastName(String banklastname) throws Exception {
        driver.findElement(By.id("p-L1:1-L3:1270")).clear();
        driver.findElement(By.id("p-L1:1-L3:1270")).sendKeys(banklastname);
    }

    public ShoppingCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ShoppingCommon(driver);
    }

    public SearchAddressCommon clickSearchAddress() throws Exception {
        driver.findElement(By.id("search_address")).click();
        return new SearchAddressCommon(driver);
    }

    public Account enterDefaultIdentificationData() throws Exception {
        Account account = new Account(uniqueTimeStamp);
        Person person = new Person(uniqueTimeStamp);
        Subscriber subscriber = new Subscriber(uniqueTimeStamp);

        // Customer details
        this.setGender(person.getPersonGenderProperty());
        this.setCustomerTitle(person.getPersonTitleProperty());
        this.setCustomerFirstName(person.getPersonFirstNameProperty());
        this.setCustomerLastName(person.getPersonLastNameProperty());
        this.enterCustomerHomeCountry(person.getPersonHomeCountryProperty());
        this.enterCustomerHomeState(person.getPersonHomeStateProperty());
        this.setCustomerStreetNumber(person.getPersonStreetNumberProperty());
        this.setCustomerStreetName(person.getPersonStreetNameProperty());
        this.enterCustomerCity(person.getPersonCityProperty());
        this.enterCustomerPostCode(person.getPersonPostCodeProperty());
        this.setNationality(person.getPersonNationalityProperty());
        this.setLanguage(person.getPersonLanguageProperty());
        this.setNationalID(person.getPersonNationalIDProperty());
        this.setDateOfBirth(person.getPersonDateOfBirthProperty());
        this.setEmailAddress(person.getPersonEmailAddressProperty());
        this.setPhoneNumber(person.getPersonPhoneNumberProperty());
        this.setMobileNumber(person.getPersonMobileNumberProperty());
        this.setFaxNumber(person.getPersonFaxNumberProperty());

        // Billing Account details
        driver.findElement(By.id("link_addresschecked")).click();
        this.setBillingTitle(account.getBillingTitleProperty());
        this.setBillingFirstName(account.getBillingFirstNameProperty());
        this.setBillingLastName(account.getBillingLastNameProperty());
        this.enterBillingHomeCountry(account.getBillingHomeCountryProperty());
        this.enterBillingHomeState(account.getBillingHomeStateProperty());
        this.setBillingStreetNumber(account.getBillingStreetNumberProperty());
        this.setBillingStreetName(account.getBillingStreetNameProperty());
        this.enterBillingCity(account.getBillingCityProperty());
        this.enterBillingPostCode(account.getBillingPostCodeProperty());

        // Service Address details
        this.setServiceTitle(subscriber.getSubscriberTitleProperty());
        this.setServiceFirstName(subscriber.getSubscriberLastNameProperty());
        this.setServiceLastName(subscriber.getSubscriberFirstNameProperty());
        this.enterServiceHomeCountry(subscriber.getSubscriberHomeCountryProperty());
        this.enterServiceHomeState(subscriber.getSubscriberHomeStateProperty());
        this.setServiceStreetNumber(subscriber.getSubscriberStreetNumberProperty());
        this.setServiceStreetName(subscriber.getSubscriberStreetNameProperty());
        this.enterServiceCity(subscriber.getSubscriberCityProperty());
        this.enterServicePostCode(subscriber.getSubscriberPostCodeProperty());

        this.clickPaymentMethodCheck();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        return account;
    }

    public Account enterBusinessAccountIdentificationData() throws Exception {
        String uniqueTimeStamp = Common.generateTimeStamp();
        Account account = new Account(uniqueTimeStamp);

        // Billing Account details
        this.setBillingCompanyName(account.getBillingCompanyNameProperty());
        this.setBusinessTitle(account.getBillingTitleProperty());
        this.setBusinessFirstName(account.getBillingFirstNameProperty());
        this.setBusinessLastName(account.getBillingLastNameProperty());
        this.enterBusinessHomeCountry(account.getBillingHomeCountryProperty());
        this.enterBusinessHomeState(account.getBillingHomeStateProperty());
        this.enterBusinessCity(account.getBillingCityProperty());
        this.enterBusinessPostCode(account.getBillingPostCodeProperty());

        this.clickPaymentMethodCheck();

        setAccount(account);

        return account;
    }

    public ClearTheCurrentBasketCommon enterCTIURL(Application application, String External_id) throws Exception {
        driver.get(application.appURL() + "ctiAccess?subscriberExternalId=" + External_id + "&subscriberExternalIdType=3&ctiSessionId=123456");
        return new ClearTheCurrentBasketCommon(driver);
    }
}
