/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddCaseConfirmationCommon;

public class AddCaseConfirmation extends AddCaseConfirmationCommon {

    public AddCaseConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AccountDetails clickOk() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickOk();
        return new AccountDetails(tool, test, user);
    }
}
