package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CustomerAcquisitionCustomerDataReviewCommon;

public class CustomerAcquisitionCustomerDataReview extends CustomerAcquisitionCustomerDataReviewCommon {

    public CustomerAcquisitionCustomerDataReview(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public Shopping clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickContinue();
        return new Shopping(tool, test, user);
    }

    // @Override
    // public UpdateAccountContactInformations
    // clickEditCustomerIdentityAndContact() throws Exception {  test.writeInLog(Common.getMethodName());
    //
    // super.clickEditCustomerIdentityAndContact();
    // return new UpdateAccountContactInformations(tool, test, user);
    // }
}
