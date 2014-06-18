package com.comverse.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.HomePageBackOffice;
import com.comverse.css.csr.InventoryAdministration;
import com.comverse.css.csr.TokenAdministration;
import com.comverse.css.csr.UploadToken;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.BOGAdmin;

public class DATA001_UploadOBCTokens extends CSSTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new BOGAdmin();
    }

    @Test
    public void testDATA001_UploadOBCTokens() throws Exception {

        // Make sure OUTBOUND_COMM is enabled before running this test.

        launchCSSApplicationAndSSOLogin();

        HomePageBackOffice homePageBackOffice = new HomePageBackOffice(tool, test, user);
        InventoryAdministration inventoryAdministration = homePageBackOffice.clickBackOffice();
        TokenAdministration tokenAdministration = inventoryAdministration.clickTokenAdministration();
        UploadToken uploadToken = tokenAdministration.clickUpload();

        uploadToken.selectFile("OBCData/Token4CaseCreation.csv");
        tokenAdministration = uploadToken.clickOk();
        uploadToken = tokenAdministration.clickUpload();

        uploadToken.selectFile("OBCData/Token4BasketSummary.csv");
        tokenAdministration = uploadToken.clickOk();

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
