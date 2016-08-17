package cn.jingsheng.ldap.service;

public class WindowsDomainProxy implements WindowsDomain {
  private String _endpoint = null;
  private WindowsDomain windowsDomain = null;
  
  public WindowsDomainProxy() {
    _initWindowsDomainProxy();
  }
  
  public WindowsDomainProxy(String endpoint) {
    _endpoint = endpoint;
    _initWindowsDomainProxy();
  }
  
  private void _initWindowsDomainProxy() {
    try {
      windowsDomain = (new cn.jingsheng.ldap.service.WindowsDomainServiceLocator()).getWindowsDomain();
      if (windowsDomain != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)windowsDomain)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)windowsDomain)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (windowsDomain != null)
      ((javax.xml.rpc.Stub)windowsDomain)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WindowsDomain getWindowsDomain() {
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain;
  }
  
  public cn.jingsheng.ldap.WinUser login(String username, String password) throws java.rmi.RemoteException{
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain.login(username, password);
  }
  
  public boolean checkLogin(String username, String password) throws java.rmi.RemoteException{
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain.checkLogin(username, password);
  }
  
  public cn.jingsheng.ldap.WinUser[] getAllUser() throws java.rmi.RemoteException{
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain.getAllUser();
  }
  
  public cn.jingsheng.ldap.WinOrganization[] getAllOrganization() throws java.rmi.RemoteException{
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain.getAllOrganization();
  }
  
  public cn.jingsheng.ldap.WinOrganization[] findOrganizationByName(String orgName) throws java.rmi.RemoteException{
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain.findOrganizationByName(orgName);
  }
  
  public cn.jingsheng.ldap.WinUser[] findUsersByDN(String ou) throws java.rmi.RemoteException{
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain.findUsersByDN(ou);
  }
  
  public cn.jingsheng.ldap.WinOrganization[] findSubOrganizationByDN(String dn) throws java.rmi.RemoteException{
    if (windowsDomain == null)
      _initWindowsDomainProxy();
    return windowsDomain.findSubOrganizationByDN(dn);
  }
  
  
}