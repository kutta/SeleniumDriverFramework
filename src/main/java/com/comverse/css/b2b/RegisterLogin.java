package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RegisterLoginCommon;

public class RegisterLogin extends RegisterLoginCommon {

    public RegisterLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewHierarchy clickOk() throws Exception {

        super.clickOk();
        return new ViewHierarchy(tool, test, user);
    }

    @Override
    public String getTempPasswordFromPage() throws Exception {

        return super.getTempPasswordFromPage();
    }
}
