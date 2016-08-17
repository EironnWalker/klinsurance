/**
 * WindowsDomain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.jingsheng.ldap.service;

public interface WindowsDomain extends java.rmi.Remote {
    public cn.jingsheng.ldap.WinUser login(String username, String password) throws java.rmi.RemoteException;
    public boolean checkLogin(String username, String password) throws java.rmi.RemoteException;
    public cn.jingsheng.ldap.WinUser[] getAllUser() throws java.rmi.RemoteException;
    public cn.jingsheng.ldap.WinOrganization[] getAllOrganization() throws java.rmi.RemoteException;
    public cn.jingsheng.ldap.WinOrganization[] findOrganizationByName(String orgName) throws java.rmi.RemoteException;
    public cn.jingsheng.ldap.WinUser[] findUsersByDN(String ou) throws java.rmi.RemoteException;
    public cn.jingsheng.ldap.WinOrganization[] findSubOrganizationByDN(String dn) throws java.rmi.RemoteException;
}
