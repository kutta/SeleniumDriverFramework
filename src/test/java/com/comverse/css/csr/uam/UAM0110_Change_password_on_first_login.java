package com.comverse.css.csr.uam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.ContactInformation;
import com.comverse.css.csr.LoginInformation;
import com.comverse.css.csr.ViewHierarchy;
import com.comverse.css.csr.WelcomeToYourPersonalizedWorkspace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.TelcoAdmin;

public class UAM0110_Change_password_on_first_login extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new TelcoAdmin();
    }

    @Test
    public void testUAM0110_Change_password_on_first_login() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();
            String role = "OCM Publisher";

            WelcomeToYourPersonalizedWorkspace personalizedWorkSpace = new WelcomeToYourPersonalizedWorkspace(tool, test, user);
            ViewHierarchy viewHierarchy = personalizedWorkSpace.clickManageTelco();

            viewHierarchy.addEmployee(uniqueCode, role);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            assertEquals(role, loginInformation.getCurrentRoleFromPage());
            loginInformation.clickLogoutExpectingSSO();
            // myshapeCSRPortal.successfulLogin(uniqueCode, tempPassword);
            //
            // myshapeCSRPortal.setYourPassword(tempPassword);
            // myshapeCSRPortal.setNewPassword("Passw0rd!");
            // myshapeCSRPortal.setConfirmNewPassword("Passw0rd!");
            // myshapeCSRPortal.setSecretAnswer("Passw0rd!");
            // myshapeCSRPortal.clickChange();

            // test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
