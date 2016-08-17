package com.kunlunrisk.sms;

public class ShortMessagerProxy implements ShortMessager {
  private String _endpoint = null;
  private ShortMessager shortMessager = null;
  
  public ShortMessagerProxy() {
    _initShortMessagerProxy();
  }
  
  public ShortMessagerProxy(String endpoint) {
    _endpoint = endpoint;
    _initShortMessagerProxy();
  }
  
  private void _initShortMessagerProxy() {
    try {
      shortMessager = (new com.kunlunrisk.sms.ShortMessagerServiceLocator()).getShortMessager();
      if (shortMessager != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shortMessager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shortMessager)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shortMessager != null)
      ((javax.xml.rpc.Stub)shortMessager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ShortMessager getShortMessager() {
    if (shortMessager == null)
      _initShortMessagerProxy();
    return shortMessager;
  }
  
  public int send(com.kunlunrisk.sms.model.SmsInBound[] sms) throws java.rmi.RemoteException{
    if (shortMessager == null)
      _initShortMessagerProxy();
    return shortMessager.send(sms);
  }
  
  public int send(com.kunlunrisk.sms.model.SmsInBound sms) throws java.rmi.RemoteException{
    if (shortMessager == null)
      _initShortMessagerProxy();
    return shortMessager.send(sms);
  }
  
  public int send(String phone, String content, String gateway) throws java.rmi.RemoteException{
    if (shortMessager == null)
      _initShortMessagerProxy();
    return shortMessager.send(phone, content, gateway);
  }
  
  public int send(String[] phones, String content, String gateway) throws java.rmi.RemoteException{
    if (shortMessager == null)
      _initShortMessagerProxy();
    return shortMessager.send(phones, content, gateway);
  }
  
  public String[] listGateway() throws java.rmi.RemoteException{
    if (shortMessager == null)
      _initShortMessagerProxy();
    return shortMessager.listGateway();
  }
  
  
}