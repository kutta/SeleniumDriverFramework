package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewBilledUsageDetailsCommon;

public class ViewBilledUsageDetails extends ViewBilledUsageDetailsCommon {

    public ViewBilledUsageDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewBilledUsage clickBack() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBack();
        return new ViewBilledUsage(tool, test, user);
    }
}
