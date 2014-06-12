package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RegisterPrepaymentCommon;

public class RegisterPrepayment extends RegisterPrepaymentCommon {

    public RegisterPrepayment(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public RegisterPrepaymentConfirm clickConfirm() throws Exception {

        super.clickConfirm();
        return new RegisterPrepaymentConfirm(tool, test, user);
    }
}
