package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CompareDevices extends B2CMenu {

    public CompareDevices(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Compare Devices";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public ChooseYourHandset clickReturnToList() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingCssSelector("input[type='submit'][value='Return to List']");
        return new ChooseYourHandset(tool, test, user);
    }

    public String getDevice1Name() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getTextUsingXPath("//table[@class='listTable']//th[1]");
    }

    public String getDevice2Name() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getTextUsingXPath("//table[@class='listTable']//th[2]");
    }

}
