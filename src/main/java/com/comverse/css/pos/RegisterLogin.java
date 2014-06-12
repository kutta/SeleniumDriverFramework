/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import org.openqa.selenium.By;

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

    public void clickRadioButtonTelcoRetailerUser() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@name='roles'])[2]")).click();
    }

    @Override
    public RegisterLogin clickRegisterLoginContinue() throws Exception {

        super.clickRegisterLoginContinue();
        return new RegisterLogin(tool, test, user);
    }

    public void clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
    }
}
