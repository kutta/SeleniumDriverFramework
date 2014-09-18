package com.comverse.css.b2b.rch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class RCH0020_Non_voucher_recharge_by_credit_card_debit_card extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testRCH0020_Non_voucher_recharge_by_credit_card_debit_card() throws Exception {
        try {
            launchCSSApplication();

            String rechargeAmount = "1";
            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();

            ViewBalance viewBalance = subscriberDashboard.viewBalanceAndRecharge();

            Double coreBalanceBeforeRecharge = viewBalance.getCoreBalance();

            NonVoucherRecharge nonVoucherRecharge = viewBalance.clickNonVoucherRechargeFreeAmount();

            nonVoucherRecharge.enterRechargeAmount("1");
            nonVoucherRecharge.selectPaymentMethodCreditCard();
            nonVoucherRecharge.clickContinue();
            Common.assertTextOnPage(tool, "Please enter your credit card details to process the payment and confirm this recharge.");

            nonVoucherRecharge.enterCardNumber("4111111111111111");
            nonVoucherRecharge.enterCardExpDate("12/2014");
            nonVoucherRecharge.enterCardHolderLastName("LN");
            nonVoucherRecharge.enterCardHolderFirstName("FN");
            nonVoucherRecharge.enterCardSecretCode("123");
            NonVoucherRechargeReview nonVoucherRechargeReview = nonVoucherRecharge.clickSelect();

            Common.assertTextOnPage(tool, "Please review your credit card details to process the payment and confirm this recharge.");
            Common.assertTextOnPage(tool, "4111111111111111");
            RechargeSubscriber rechargeSubscriber = nonVoucherRechargeReview.confirmNonVoucherRechargeByCreditCard();

            Common.assertTextOnPage(tool, "Credit Card");

            viewBalance = rechargeSubscriber.clickViewBalances();

            Double expectedCoreBalanceAfterRecharge = coreBalanceBeforeRecharge + Double.parseDouble(rechargeAmount);

            Double coreBalanceAfterRecharge = viewBalance.getCoreBalance();

            Common.assertTextEquals(expectedCoreBalanceAfterRecharge, coreBalanceAfterRecharge);

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
