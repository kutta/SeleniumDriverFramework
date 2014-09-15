/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class DeliveryAddressesCommon extends CommonMenu {

    public DeliveryAddressesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Delivery Addresses";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public String getSelectDeliveryAddressMessage() throws Exception {  test.writeInLog(Common.getMethodName());

        return tool.getTextUsingXPath("//div[3]/div[2]/div/div/span");

    }

    public String getNoDeliveryAddressMessage() throws Exception {  test.writeInLog(Common.getMethodName());

        return tool.getTextUsingXPath("//div[5]/div[2]/div/div/span");

    }

    public String getDeliveryAddressMessageAfterSearch() throws Exception {  test.writeInLog(Common.getMethodName());

        return tool.getTextUsingXPath("//div[5]/div[2]/div/div/span");

    }

    public DeliveryAddressesCommon searchWithWildCard(String wildcard) throws Exception {  test.writeInLog(Common.getMethodName());
        enterSearchString(wildcard);
        tool.clickUsingName("submit");
        return new DeliveryAddressesCommon(tool, test, user);
    }

    public void enterSearchString(String searchString) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingName("searchText", searchString);
    }

    public AddDeliveryAddressCommon clickAdd() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@name='submit'])[2]");
        return new AddDeliveryAddressCommon(tool, test, user);
    }

    public String getSuccessfulAddDelvieryAddressMessage() throws Exception {  test.writeInLog(Common.getMethodName());

        return tool.getTextUsingXPath("//div[3]/div[2]/div/div/span");

    }

    public ModifyDeliveryAddressCommon clickModify() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingLinkText("update");
        return new ModifyDeliveryAddressCommon(tool, test, user);
    }

    public RemoveDeliveryAddressCommon clickRemove() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingID("lnk_REMOVE_0");
        return new RemoveDeliveryAddressCommon(tool, test, user);
    }

    public void clickMakeDefault() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingLinkText("make default");

    }
}
