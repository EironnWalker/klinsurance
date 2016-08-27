package com.ht.klinsurance.utils.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author feicy
 * @date 2016/8/27
 */
public class MyAuthenticator extends Authenticator {
    //private static final String userName = "klapp@kunlunrisk.com";
    private static final String userName = "feichenyun@126.com";
    //private static final String passWord = "IHv5qBJJ54";
    private static final String passWord = "fei370612";
    // * @author Michael.wu
//* 密码和用户的验证
    public MyAuthenticator() {
        super();
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, passWord);
    }
}
