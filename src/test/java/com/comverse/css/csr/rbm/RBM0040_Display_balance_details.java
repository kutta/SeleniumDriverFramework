package com.comverse.css.csr.rbm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.AB.AB_ResidentialEnhanceFamilyAccountBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class RBM0040_Display_balance_details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testRBM0040_Display_balance_details() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            AB_ResidentialEnhanceFamilyAccountBundle ab_AccountBundle = new AB_ResidentialEnhanceFamilyAccountBundle();
            String balanceNightWeekendName = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceName();
            String balanceNightWeekendValue = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceValue();
            String balanceAnytimeName = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceName();
            String balanceAnytimeValue = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceValue();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickAccountBundlesTab();
            ConfigureBalance configureBalance = shopping.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(ab_AccountBundle.getOfferName(), null,
                    null);

            configureBalance.setSpendingLimit(balanceNightWeekendName, balanceNightWeekendValue);
            ConfigureContractDetails configureContractDetails = configureBalance.clickContinueExpectingConfigureContractDetails();

            configureContractDetails.setSpendingLimit(balanceNightWeekendName, balanceNightWeekendValue);
            configureContractDetails.setSpendingLimit(balanceAnytimeName, balanceAnytimeValue);
            configureContractDetails.setSpendingLimit(ab_AccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceName(), ab_AccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceValue());

            String acctBalanceNightWeekendName = tool.getAttributeUsingId(tool, balanceNightWeekendName + "_target", "value");
            String acctBalanceAnytimeName = tool.getAttributeUsingId(tool, balanceAnytimeName + "_target", "value");
            MyBasket myBasket = configureContractDetails.clickContinue();

            myBasket.assign3InventoriesFirstOffer(subscriber);
            String firstSubscriberMSISDN = subscriber.getSubscriberMSISDNProperty();
            myBasket.assign3InventoriesSecondOffer(subscriber);
            String secondSubscriberMSISDN = subscriber.getSubscriberMSISDNProperty();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();

            SearchRequests searchRequests = workSpace.clickRequests();

            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());
            String accountID = enterIdentificationData.getAccount().getBillingAccountIDProperty();
            workSpace.clickHome();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.gotoAccountDashboardUsingAccountID(accountID);

            ViewBalance viewBalance = accountDetails.clickViewBalancesAndRecharge();

            Common.assertTextOnPage(tool, acctBalanceAnytimeName);
            Common.assertTextOnPage(tool, acctBalanceNightWeekendName);
            BalanceDetails balanceDetails = viewBalance.viewBalanceDetails(acctBalanceNightWeekendName);

            Common.assertTextOnPage(tool, "Subscribers using units from this balance");
            Common.assertTextOnPage(tool, "Subscriber " + firstSubscriberMSISDN);
            Common.assertTextOnPage(tool, "Subscriber " + secondSubscriberMSISDN);
            balanceDetails = balanceDetails.viewSubscriberBalanceDetails(balanceNightWeekendName);

            Common.assertTextOnPage(tool, Common.formatToHHmmss(balanceNightWeekendValue));
            viewBalance = balanceDetails.viewAccountBalances();

            Common.assertTextOnPage(tool, acctBalanceAnytimeName);
            Common.assertTextOnPage(tool, acctBalanceNightWeekendName);

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
