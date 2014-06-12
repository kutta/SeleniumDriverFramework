/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.PersonIdentificationSearchResultCommon;

public class PersonIdentificationSearchResult extends PersonIdentificationSearchResultCommon {

    public PersonIdentificationSearchResult(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public WorkSpace clickHome() throws Exception {
        super.clickHome();
        return new WorkSpace(tool, test, user);
    }
}
