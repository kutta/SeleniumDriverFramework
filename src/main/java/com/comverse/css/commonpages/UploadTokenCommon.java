package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import java.io.File;

public class UploadTokenCommon extends CommonMenu {

    public UploadTokenCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Upload Token";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void selectFile(String filename) throws Exception {  test.writeInLog(Common.getMethodName());

        File file = new File(filename);
        // 
        tool.enterStringUsingId("fileUpload", file.getAbsolutePath());

    }

    public TokensfoundCommon clickOk() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Ok']");

        return new TokensfoundCommon(tool, test, user);
    }
}
