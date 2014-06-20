package com.comverse.css.pos.rbm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.AB.AB_ResidentialEnhanceFamilyAccountBundle;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

public class RBM0060_Reconfigure_shadow_balance extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testRBM0060_Reconfigure_shadow_balance() throws Exception {

        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            AB_ResidentialEnhanceFamilyAccountBundle ab_AccountBundle = new AB_ResidentialEnhanceFamilyAccountBundle();
            String balanceNightWeekendName = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceName();
            String balanceNightWeekendValue = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceValue();
            String balanceAnytimeName = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceName();
            String balanceAnytimeValue = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceValue();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
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

            String acctBalanceNightWeekendName = tool.getAttributeUsingId(balanceNightWeekendName + "_target", "value");
            String acctBalanceAnytimeName = tool.getAttributeUsingId(balanceAnytimeName + "_target", "value");
            MyBasket myBasket = configureContractDetails.clickContinue();

            myBasket.assign3InventoriesFirstOffer(subscriber);
            myBasket.assign3InventoriesSecondOffer(subscriber);
            // Offers ordered alphabetically - the 2nd offer is Ultra Postpaid
            String secondSubscriberMSISDN = subscriber.getSubscriberMSISDNProperty();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();

            SearchRequests searchRequests = workSpace.clickRequests();

            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            workSpace.clickHome();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            SubscriberDetails subscriberDetails = identifyCustomer.searchBySubscriberMSISDN(secondSubscriberMSISDN);

            ViewBalance viewBalance = subscriberDetails.viewBalanceAndRecharge();

            // Reconfigure Voice Night/Weekend Shared balance
            ReconfigureBalance reconfigureBalance = viewBalance.clickConfigureSharedBalance(balanceNightWeekendName);

            Common.assertTextOnPage(tool, "Next limit");
            Common.assertTextOnPage(tool, Common.formatToHHmmss(balanceNightWeekendValue));
            Common.assertTextOnPage(tool, "Use account units from");
            Common.assertTextOnPage(tool, acctBalanceNightWeekendName);
            Common.assertTextOnPage(tool, "Reconfigure balance");

            String newNightWeekendLimitValue = "1800";
            reconfigureBalance.setCreditSpendingLimit(newNightWeekendLimitValue);
            reconfigureBalance.selectUseAccountUnitsFrom(acctBalanceNightWeekendName);
            ReconfigureBalanceReview reconfigureBalanceReview = reconfigureBalance.clickReconfigureBalance();

            Common.assertTextOnPage(tool, Common.formatToHHmmss(newNightWeekendLimitValue));
            ReconfigureBalanceConfirm reconfigureBalanceConfirm = reconfigureBalanceReview.clickConfirm();

            Common.assertTextOnPage(tool, "Your request to configure balance has been processed successfully");
            viewBalance = reconfigureBalanceConfirm.clickBack();

            BalanceDetails balanceDetails = viewBalance.viewBalanceDetails(balanceNightWeekendName);

            Common.assertTextOnPage(tool, "Next limit");
            Common.assertTextOnPage(tool, Common.formatToHHmmss(newNightWeekendLimitValue));
            viewBalance = balanceDetails.clickGoToListOfBalances();

            // Authorize more units for this period for Voice Anytime Shared
            reconfigureBalance = viewBalance.clickConfigureSharedBalance(balanceAnytimeName);

            Common.assertTextOnPage(tool, "Next limit");
            Common.assertTextOnPage(tool, Common.formatToHHmmss(balanceAnytimeValue));
            Common.assertTextOnPage(tool, "Use account units from");
            Common.assertTextOnPage(tool, acctBalanceAnytimeName);
            Common.assertTextOnPage(tool, "Authorize more units for this period");

            String unitsToAdd = "900";
            reconfigureBalance.setMoreUnitsForThisPeriod(unitsToAdd);
            reconfigureBalanceReview = reconfigureBalance.clickAddUnits();

            Common.assertTextOnPage(tool, "Units to add for this period");
            Common.assertTextOnPage(tool, Common.formatToHHmmss(unitsToAdd));
            reconfigureBalanceConfirm = reconfigureBalanceReview.clickConfirm();

            Common.assertTextOnPage(tool, "Your request to configure balance has been processed successfully");
            viewBalance = reconfigureBalanceConfirm.clickBack();

            balanceDetails = viewBalance.viewBalanceDetails(balanceAnytimeName);
            Common.assertTextOnPage(tool, "Remaining units");
            Common.assertTextOnPage(tool, Common.formatToHHmmss(unitsToAdd));

            Common.storeLastNameAndAccountNumberPostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), enterIdentificationData.getAccount()
                    .getBillingAccountIDProperty(), "Created by " + this.getClass().getSimpleName());

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
