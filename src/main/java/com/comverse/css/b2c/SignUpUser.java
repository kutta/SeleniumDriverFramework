/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SignUpUser extends B2CMenu {

    public SignUpUser(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Sign Up User";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAddressLineOne(String addressLine1) throws Exception {

        
        tool.enterStringUsingId("address_line_1", addressLine1);

    }

    public void enterAddressLineTwo(String addressLine2) throws Exception {

        
        tool.enterStringUsingId("address_line_2", addressLine2);

    }

    public void enterAddressLineThree(String addressLine3) throws Exception {

        
        tool.enterStringUsingId("address_line_3", addressLine3);

    }

    public void enterAddressLineFour(String addressLine4) throws Exception {

        
        tool.enterStringUsingId("address_line_4", addressLine4);

    }

    public void enterZipCode(String zipCode) throws Exception {

        
        tool.enterStringUsingId("zip", zipCode);

    }

    public void enterCity(String city) throws Exception {

        
        tool.enterStringUsingId("city", city);

    }

    public void selectState(String state) throws Exception {

        tool.selectVisibleTextByName("state", state);

    }

    public void enterFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId("first_name", firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId("last_name", lastName);

    }

    public void enterEmailAddress(String emailAddress) throws Exception {

        
        tool.enterStringUsingId("company_email", emailAddress);

    }

    public void enterLogin(String uniqueTimeStamp) throws Exception {

        
        tool.enterStringUsingId("login", uniqueTimeStamp);
        System.out.println("Login - " + uniqueTimeStamp);

    }

    public void enterPassword(String password) throws Exception {

        
        tool.enterStringUsingId("password", password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        
        tool.enterStringUsingId("confirm_password", confirmPassword);

    }

    public void selectSecretQuestion(String secretQuestion) throws Exception {

        tool.selectVisibleTextByName("secret_question", secretQuestion);

    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {

        
        tool.enterStringUsingId("secret_answer", secretAnswer);
    }

    public void enterNationalId(String national_id) throws Exception {

        
        tool.enterStringUsingId("national_id", national_id);
    }

    public void enterDateOfBirth(String dob) throws Exception {

        
        tool.enterStringUsingId("date_of_birth", dob);
    }

    public CustomerDetails clickSignMeUp() throws Exception {

        tool.clickUsingName("signmeup");
        return new CustomerDetails(tool, test, user);
    }

    public CustomerDetails enterMandatoryFieldsOnlyAndClickSignMeUp(String uniqueTimeStamp) throws Exception {

        this.enterFirstName("FN" + uniqueTimeStamp);
        this.enterLastName("LN" + uniqueTimeStamp);
        this.enterAddressLineOne("Address Line One");
        this.enterZipCode("12345");
        this.enterCity("City1");
        this.selectState("Alabama");
        this.enterEmailAddress("email@comverse.com");
        this.enterLogin(uniqueTimeStamp);
        this.enterPassword("0123456");
        this.enterConfirmPassword("0123456");
        this.selectSecretQuestion("When did you kiss for the first time?");
        this.enterSecretAnswer("20 Nov 2012");
        this.enterDateOfBirth("12/12/1975");
        this.enterNationalId(uniqueTimeStamp);
        return this.clickSignMeUp();
    }

    public void uncheckSameAsCustomerAddress() throws Exception {

        tool.clickUsingID("linkAddress");

    }

    public void enterBillingAddressLineOne(String addressLine1) throws Exception {

        
        tool.enterStringUsingId("billingAddressLine1", addressLine1);

    }

    public void enterBillingAddressLineTwo(String addressLine2) throws Exception {

        
        tool.enterStringUsingId("billingAddressLine2", addressLine2);

    }

    public void enterBillingAddressLineThree(String addressLine3) throws Exception {

        
        tool.enterStringUsingId("billingAddressLine3", addressLine3);

    }

    public void enterBillingAddressLineFour(String addressLine4) throws Exception {

        
        tool.enterStringUsingId("billingAddressLine4", addressLine4);

    }

    public void enterBillingZipCode(String zipCode) throws Exception {

        
        tool.enterStringUsingId("billingZip", zipCode);

    }

    public void enterBillingCity(String city) throws Exception {

        
        tool.enterStringUsingId("billingCity", city);

    }

    public void selectBillingState(String state) throws Exception {

        tool.selectVisibleTextByName("billingState", state);

    }

    public void selectBillingTitle(String title) throws Exception {

        tool.selectVisibleTextByID("billingTitle", title);

    }

    public void enterBillingFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId("billingFirstName", firstName);

    }

    public void enterBillingLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId("billingLastName", lastName);

    }
}
