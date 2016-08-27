package com.ht.klinsurance.utils.email;

import com.ht.klinsurance.common.KlConsts;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author feicy
 * @date 2016/8/27
 */
public class MyAuthenticator extends Authenticator {
    private static final String userName = KlConsts.EMAIL_SEND_EMAIL;
    private static final String passWord =  KlConsts.EMAIL_SEND_PWD;
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
