package com.comverse.css.bct;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;

public class BCT003_PO_Residential_Notification_POS extends CSSTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
    }

    @Test
    public void testBCT003_PO_Residential_Notification_POS() throws Exception {
        launchCSSApplication();
        String uniqueTimeStamp = Common.generateTimeStamp();
        String accountLastName = Common.getLastNameRechargableAccount();
        MyShapeChannel myShapeChannel = new MyShapeChannel(driver);
        WorkSpace workSpace = myShapeChannel.loginToPOS(user);

        IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

        AccountDetails accountDetails = identifyCustomer.searchByAccountLastNameSinglePerson(accountLastName);

        ModifyContactInformation modifyContactInformation = accountDetails.clickModifyBillingContact();

        modifyContactInformation.enterFirstName("fn" + uniqueTimeStamp);
        ModifyContactInformationConfirmation modifyContactInformationConfirmation = modifyContactInformation.clickOk();
        RequestSubmission requestSubmission = modifyContactInformationConfirmation.clickOk();

        accountDetails = requestSubmission.clickOkModifyRequestGoTOAccountDashboard();
        RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
        requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
        accountDetails = requestsForCustomer.clickAccounts();
        accountDetails.clickRefreshThisAccount();
        modifyContactInformation = accountDetails.clickModifyBillingContact();
        assertEquals("fn" + uniqueTimeStamp, modifyContactInformation.getFirstName());

        test.setResult("pass");

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}