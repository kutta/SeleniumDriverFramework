package com.comverse.css.pos.uam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoAdmin;

public class UAM0020_Edit_login_information extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoAdmin();
    }

    @Test
    public void testUAM0020_Edit_login_information() throws Exception {

        try {
            String uniqueCode = Common.generateTimeStamp();

            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            loginPage.clickAdminLogin(application);
            WelcomeToYourWorkspace welcomeToYourWorkspace = loginPage.loginToPOSAsTelcoAdmin(user);

            SearchRetailer searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            ViewHierarchy viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");
            viewHierarchy.addEmployeeTelcoRetailerAdministrator(uniqueCode);
            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            assertEquals("Telco Retailer Administrator", loginInformation.getCurrentRoleFromPage());

            ChangeRoles changeRoles = loginInformation.clickChangeRoles();
            changeRoles.clickRadioButtonRetailerSubscriber();
            changeRoles.clickOk();
            assertEquals("Please confirm the change of roles for login " + uniqueCode + " of user FN" + uniqueCode + " LN" + uniqueCode, changeRoles.getConfirmationMessage());

            ModifyLoginRoles modifyLoginRoles = changeRoles.clickConfirm();
            loginInformation = modifyLoginRoles.clickVeiwLoginInformationLink();
            assertEquals("Telco Retailer Subscriber", loginInformation.getCurrentRoleFromPage());

            test.setResult("pass");

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
