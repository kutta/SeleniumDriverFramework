package com.comverse.css.pos.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.data.SO.SO_2010WorldCupSoccerNews;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PRS0110_Browse_and_select_subscriber_offers extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testPRS0110_Browse_and_select_subscriber_offers() throws Exception {

        try {
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            SO_2010WorldCupSoccerNews so_2010WorldCupSoccerNews = new SO_2010WorldCupSoccerNews();
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();

            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();

            myBasket.assign3InventoriesFirstOffer(subscriber);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = myBasket.clickAddSO();

            selectOffersForYourSubscriber.selectOffersForSubscriber(so_2010WorldCupSoccerNews.getOfferName());
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            configureBalance = configureOffers.clickContinue();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            ServiceConnectionDetails serviceConnectionDetails = configureBalance.clickContinueExpectingServiceConnectionDetails();
            serviceConnectionDetails.clickOk();
            Common.assertTextOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            Common.storeLastNamePostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), "Created by -" + this.getClass().getSimpleName());
            searchOrders.clickHomeMenu();
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.searchByAccountLastNameSinglePerson(enterIdentificationData.getAccount().getBillingLastNameProperty());
            accountDetails.selectFirstSubscriberFromNavigationPanel();
            Common.assertTextOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());

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