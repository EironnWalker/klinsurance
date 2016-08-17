package org.centric.mail;

import org.springframework.stereotype.Service;

@Service
public class ExchangeMailSoapProxy implements ExchangeMailSoap {
  private String _endpoint = null;
  private ExchangeMailSoap exchangeMailSoap = null;
  
  public ExchangeMailSoapProxy() {
    _initExchangeMailSoapProxy();
  }
  
  public ExchangeMailSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initExchangeMailSoapProxy();
  }
  
  private void _initExchangeMailSoapProxy() {
    try {
      exchangeMailSoap = (new ExchangeMailLocator()).getExchangeMailSoap();
      if (exchangeMailSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)exchangeMailSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)exchangeMailSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (exchangeMailSoap != null)
      ((javax.xml.rpc.Stub)exchangeMailSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ExchangeMailSoap getExchangeMailSoap() {
    if (exchangeMailSoap == null)
      _initExchangeMailSoapProxy();
    return exchangeMailSoap;
  }
  
  public String getMailList(String username, String password, int count) throws java.rmi.RemoteException{
    if (exchangeMailSoap == null)
      _initExchangeMailSoapProxy();
    return exchangeMailSoap.getMailList(username, password, count);
  }
  
  
}