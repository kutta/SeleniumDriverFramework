package com.comverse.css.csr.pem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.AccountDetailsCommon;
import com.comverse.css.commonpages.PersonManagementCommon;
import com.comverse.css.csr.CustomerSearchResult;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PEM0100_Change_Owner extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testPEM0100_Change_Owner() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());
            AccountDetailsCommon accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            PersonManagementCommon personManagement = accountDetails.clickPersonManagement();

            personManagement.clickActionstoChangeOwner();
            personManagement.clickChangeOwner();
            personManagement.addCOP();
            personManagement.clickSwap();

            Common.assertTextOnPage(tool, "inactive");

            // Needs to check the owner has changed.

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
