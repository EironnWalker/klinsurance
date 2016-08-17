/**
 * WindowsDomainService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.jingsheng.ldap.service;

public interface WindowsDomainService extends javax.xml.rpc.Service {
    public String getWindowsDomainAddress();

    public WindowsDomain getWindowsDomain() throws javax.xml.rpc.ServiceException;

    public WindowsDomain getWindowsDomain(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
