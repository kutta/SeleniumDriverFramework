package com.comverse.data.users;

import com.comverse.common.User;

public class SECAdmin extends User {

    public SECAdmin() throws Exception {
        setRole("SECAdmin");
        setLogin();
        setPassword();
    }
}
