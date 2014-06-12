/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RechargeWithVoucherCommon;

public class RechargeWithVoucher extends RechargeWithVoucherCommon {

    public RechargeWithVoucher(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public RechargeSubscriber clickContinue() throws Exception {
        super.clickContinue();
        return new RechargeSubscriber(tool, test, user);
    }
}
