package com.gemini.account.service;

import com.gemini.account.model.Register;

/**
 * Created by Amence on 2017/2/16.
 */
public interface RegisterService {

    public String AccountNameCheck(String name);

    public String EmailCheck(String email);

    public void addAccount(Register register);

    public String queryAccountByName();

    public String queryAccountEmail();

}
