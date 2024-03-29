/**
 * ExchangeMailLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.centric.mail;

public class ExchangeMailLocator extends org.apache.axis.client.Service implements ExchangeMail {

    public ExchangeMailLocator() {
    }


    public ExchangeMailLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ExchangeMailLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ExchangeMailSoap
    private String ExchangeMailSoap_address = "http://192.168.3.163:9005/ExchangeMail.asmx";

    public String getExchangeMailSoapAddress() {
        return ExchangeMailSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String ExchangeMailSoapWSDDServiceName = "ExchangeMailSoap";

    public String getExchangeMailSoapWSDDServiceName() {
        return ExchangeMailSoapWSDDServiceName;
    }

    public void setExchangeMailSoapWSDDServiceName(String name) {
        ExchangeMailSoapWSDDServiceName = name;
    }

    public ExchangeMailSoap getExchangeMailSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ExchangeMailSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getExchangeMailSoap(endpoint);
    }

    public ExchangeMailSoap getExchangeMailSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.centric.mail.ExchangeMailSoapStub _stub = new org.centric.mail.ExchangeMailSoapStub(portAddress, this);
            _stub.setPortName(getExchangeMailSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setExchangeMailSoapEndpointAddress(String address) {
        ExchangeMailSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ExchangeMailSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.centric.mail.ExchangeMailSoapStub _stub = new org.centric.mail.ExchangeMailSoapStub(new java.net.URL(ExchangeMailSoap_address), this);
                _stub.setPortName(getExchangeMailSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("ExchangeMailSoap".equals(inputPortName)) {
            return getExchangeMailSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("mail.exchange", "ExchangeMail");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("mail.exchange", "ExchangeMailSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("ExchangeMailSoap".equals(portName)) {
            setExchangeMailSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
