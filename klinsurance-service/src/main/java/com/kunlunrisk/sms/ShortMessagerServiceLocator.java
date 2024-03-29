/**
 * ShortMessagerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.kunlunrisk.sms;

public class ShortMessagerServiceLocator extends org.apache.axis.client.Service implements ShortMessagerService {

    public ShortMessagerServiceLocator() {
    }


    public ShortMessagerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ShortMessagerServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

	// Use to get a proxy class for ShortMessager
	private String ShortMessager_address = "http://video.kunlunrisk.com/smserver/services/ShortMessager";

	public String getShortMessagerAddress() {
		return ShortMessager_address;
	}

	public void setShortMessagerAddress(String addr) {
		this.ShortMessager_address = addr;
	}

    // The WSDD service name defaults to the port name.
    private String ShortMessagerWSDDServiceName = "ShortMessager";

    public String getShortMessagerWSDDServiceName() {
        return ShortMessagerWSDDServiceName;
    }

    public void setShortMessagerWSDDServiceName(String name) {
        ShortMessagerWSDDServiceName = name;
    }

    public ShortMessager getShortMessager() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ShortMessager_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getShortMessager(endpoint);
    }

    public ShortMessager getShortMessager(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.kunlunrisk.sms.ShortMessagerSoapBindingStub _stub = new com.kunlunrisk.sms.ShortMessagerSoapBindingStub(portAddress, this);
            _stub.setPortName(getShortMessagerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setShortMessagerEndpointAddress(String address) {
        ShortMessager_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ShortMessager.class.isAssignableFrom(serviceEndpointInterface)) {
                com.kunlunrisk.sms.ShortMessagerSoapBindingStub _stub = new com.kunlunrisk.sms.ShortMessagerSoapBindingStub(new java.net.URL(ShortMessager_address), this);
                _stub.setPortName(getShortMessagerWSDDServiceName());
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
        if ("ShortMessager".equals(inputPortName)) {
            return getShortMessager();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sms.kunlunrisk.com", "ShortMessagerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sms.kunlunrisk.com", "ShortMessager"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("ShortMessager".equals(portName)) {
            setShortMessagerEndpointAddress(address);
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
