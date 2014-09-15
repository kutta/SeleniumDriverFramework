package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyProfileInformation extends B2CMenu {

    public ModifyProfileInformation(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Profile Information";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void selectApprovalSequencing(String choice) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + choice + ")");
        tool.selectVisibleTextByID("approval_sequencing_field", choice);

    }

    public ConfirmModifyProfileInformation clickOK() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("okButton");
        return new ConfirmModifyProfileInformation(tool, test, user);

    }
}
