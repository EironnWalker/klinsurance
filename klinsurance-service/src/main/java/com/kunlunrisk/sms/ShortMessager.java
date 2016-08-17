/**
 * ShortMessager.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.kunlunrisk.sms;

public interface ShortMessager extends java.rmi.Remote {
    public int send(com.kunlunrisk.sms.model.SmsInBound[] sms) throws java.rmi.RemoteException;
    public int send(com.kunlunrisk.sms.model.SmsInBound sms) throws java.rmi.RemoteException;
    public int send(String phone, String content, String gateway) throws java.rmi.RemoteException;
    public int send(String[] phones, String content, String gateway) throws java.rmi.RemoteException;
    public String[] listGateway() throws java.rmi.RemoteException;
}
