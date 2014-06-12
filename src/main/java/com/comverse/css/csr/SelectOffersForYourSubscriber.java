/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SelectOffersForYourSubscriberCommon;

public class SelectOffersForYourSubscriber extends SelectOffersForYourSubscriberCommon {

    public SelectOffersForYourSubscriber(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public SupplementaryOfferDetails clickOfferDetail(String SOName) throws Exception {
        super.clickOfferDetail(SOName);
        return new SupplementaryOfferDetails(tool, test, user);
    }

    @Override
    public ConfigureOffers clickContinue() throws Exception {
        super.clickContinue();
        return new ConfigureOffers(tool, test, user);
    }

    @Override
    public MyBasket clickContinueExpectingMyBasket() throws Exception {

        super.clickContinueExpectingMyBasket();
        return new MyBasket(tool, test, user);
    }

    @Override
    public MyBasket clickCancel() throws Exception {
        super.clickCancel();
        return new MyBasket(tool, test, user);
    }

    @Override
    public SwapImpact clickContinueExpectingSwapImpact() throws Exception {

        super.clickContinueExpectingSwapImpact();
        return new SwapImpact(tool, test, user);
    }

    @Override
    public MyBasket clickViewBasket() throws Exception {
        super.clickViewBasket();
        return new MyBasket(tool, test, user);
    }
}