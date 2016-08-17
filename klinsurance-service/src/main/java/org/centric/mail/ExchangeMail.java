/**
 * ExchangeMail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.centric.mail;

public interface ExchangeMail extends javax.xml.rpc.Service {
    public String getExchangeMailSoapAddress();

    public org.centric.mail.ExchangeMailSoap getExchangeMailSoap() throws javax.xml.rpc.ServiceException;

    public org.centric.mail.ExchangeMailSoap getExchangeMailSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
