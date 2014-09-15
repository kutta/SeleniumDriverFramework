package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddCase extends B2CMenu {

    public AddCase(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Case";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void selectCategory(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName() + " using data (" + value + ")");
        tool.selectVisibleTextByID("categoryId", value);
    }

    public void selectSubCategory(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName() + " using data (" + value + ")");
        tool.selectVisibleTextByID("subCategoryId", value);
    }

    public void enterDescription(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName() + " using data (" + value + ")");
        tool.enterStringUsingId("description", value);
    }

    public void selectSubjectRelativeToProblemSubscriber() throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("isContract");
    }

    public void selectFirstSubscriber() throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName());
        tool.selectByIndexByID("contract", 1);
    }

    public AddCaseReview clickSubmit() throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Submit']");
        return new AddCaseReview(tool, test, user);
    }

    public ListCases clickListCases() throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("smnu_CASE_LIST");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ListCases(tool, test, user);
    }
}
