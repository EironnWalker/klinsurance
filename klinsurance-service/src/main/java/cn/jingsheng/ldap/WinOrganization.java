/**
 * WinOrganization.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.jingsheng.ldap;

public class WinOrganization  implements java.io.Serializable {
    private String DSCorePropagationData;

    private String description;

    private String distinguishedName;

    private String instanceType;

    private String name;

    private String objectCategory;

    private String objectClass;

    private String objectGUID;

    private String ou;

    private String whenChanged;

    private String whenCreated;

    public WinOrganization() {
    }

    public WinOrganization(
           String DSCorePropagationData,
           String description,
           String distinguishedName,
           String instanceType,
           String name,
           String objectCategory,
           String objectClass,
           String objectGUID,
           String ou,
           String whenChanged,
           String whenCreated) {
           this.DSCorePropagationData = DSCorePropagationData;
           this.description = description;
           this.distinguishedName = distinguishedName;
           this.instanceType = instanceType;
           this.name = name;
           this.objectCategory = objectCategory;
           this.objectClass = objectClass;
           this.objectGUID = objectGUID;
           this.ou = ou;
           this.whenChanged = whenChanged;
           this.whenCreated = whenCreated;
    }


    /**
     * Gets the DSCorePropagationData value for this WinOrganization.
     * 
     * @return DSCorePropagationData
     */
    public String getDSCorePropagationData() {
        return DSCorePropagationData;
    }


    /**
     * Sets the DSCorePropagationData value for this WinOrganization.
     * 
     * @param DSCorePropagationData
     */
    public void setDSCorePropagationData(String DSCorePropagationData) {
        this.DSCorePropagationData = DSCorePropagationData;
    }


    /**
     * Gets the description value for this WinOrganization.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this WinOrganization.
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets the distinguishedName value for this WinOrganization.
     * 
     * @return distinguishedName
     */
    public String getDistinguishedName() {
        return distinguishedName;
    }


    /**
     * Sets the distinguishedName value for this WinOrganization.
     * 
     * @param distinguishedName
     */
    public void setDistinguishedName(String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }


    /**
     * Gets the instanceType value for this WinOrganization.
     * 
     * @return instanceType
     */
    public String getInstanceType() {
        return instanceType;
    }


    /**
     * Sets the instanceType value for this WinOrganization.
     * 
     * @param instanceType
     */
    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }


    /**
     * Gets the name value for this WinOrganization.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this WinOrganization.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the objectCategory value for this WinOrganization.
     * 
     * @return objectCategory
     */
    public String getObjectCategory() {
        return objectCategory;
    }


    /**
     * Sets the objectCategory value for this WinOrganization.
     * 
     * @param objectCategory
     */
    public void setObjectCategory(String objectCategory) {
        this.objectCategory = objectCategory;
    }


    /**
     * Gets the objectClass value for this WinOrganization.
     * 
     * @return objectClass
     */
    public String getObjectClass() {
        return objectClass;
    }


    /**
     * Sets the objectClass value for this WinOrganization.
     * 
     * @param objectClass
     */
    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }


    /**
     * Gets the objectGUID value for this WinOrganization.
     * 
     * @return objectGUID
     */
    public String getObjectGUID() {
        return objectGUID;
    }


    /**
     * Sets the objectGUID value for this WinOrganization.
     * 
     * @param objectGUID
     */
    public void setObjectGUID(String objectGUID) {
        this.objectGUID = objectGUID;
    }


    /**
     * Gets the ou value for this WinOrganization.
     * 
     * @return ou
     */
    public String getOu() {
        return ou;
    }


    /**
     * Sets the ou value for this WinOrganization.
     * 
     * @param ou
     */
    public void setOu(String ou) {
        this.ou = ou;
    }


    /**
     * Gets the whenChanged value for this WinOrganization.
     * 
     * @return whenChanged
     */
    public String getWhenChanged() {
        return whenChanged;
    }


    /**
     * Sets the whenChanged value for this WinOrganization.
     * 
     * @param whenChanged
     */
    public void setWhenChanged(String whenChanged) {
        this.whenChanged = whenChanged;
    }


    /**
     * Gets the whenCreated value for this WinOrganization.
     * 
     * @return whenCreated
     */
    public String getWhenCreated() {
        return whenCreated;
    }


    /**
     * Sets the whenCreated value for this WinOrganization.
     * 
     * @param whenCreated
     */
    public void setWhenCreated(String whenCreated) {
        this.whenCreated = whenCreated;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof WinOrganization)) return false;
        WinOrganization other = (WinOrganization) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DSCorePropagationData==null && other.getDSCorePropagationData()==null) || 
             (this.DSCorePropagationData!=null &&
              this.DSCorePropagationData.equals(other.getDSCorePropagationData()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.distinguishedName==null && other.getDistinguishedName()==null) || 
             (this.distinguishedName!=null &&
              this.distinguishedName.equals(other.getDistinguishedName()))) &&
            ((this.instanceType==null && other.getInstanceType()==null) || 
             (this.instanceType!=null &&
              this.instanceType.equals(other.getInstanceType()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.objectCategory==null && other.getObjectCategory()==null) || 
             (this.objectCategory!=null &&
              this.objectCategory.equals(other.getObjectCategory()))) &&
            ((this.objectClass==null && other.getObjectClass()==null) || 
             (this.objectClass!=null &&
              this.objectClass.equals(other.getObjectClass()))) &&
            ((this.objectGUID==null && other.getObjectGUID()==null) || 
             (this.objectGUID!=null &&
              this.objectGUID.equals(other.getObjectGUID()))) &&
            ((this.ou==null && other.getOu()==null) || 
             (this.ou!=null &&
              this.ou.equals(other.getOu()))) &&
            ((this.whenChanged==null && other.getWhenChanged()==null) || 
             (this.whenChanged!=null &&
              this.whenChanged.equals(other.getWhenChanged()))) &&
            ((this.whenCreated==null && other.getWhenCreated()==null) || 
             (this.whenCreated!=null &&
              this.whenCreated.equals(other.getWhenCreated())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDSCorePropagationData() != null) {
            _hashCode += getDSCorePropagationData().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDistinguishedName() != null) {
            _hashCode += getDistinguishedName().hashCode();
        }
        if (getInstanceType() != null) {
            _hashCode += getInstanceType().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getObjectCategory() != null) {
            _hashCode += getObjectCategory().hashCode();
        }
        if (getObjectClass() != null) {
            _hashCode += getObjectClass().hashCode();
        }
        if (getObjectGUID() != null) {
            _hashCode += getObjectGUID().hashCode();
        }
        if (getOu() != null) {
            _hashCode += getOu().hashCode();
        }
        if (getWhenChanged() != null) {
            _hashCode += getWhenChanged().hashCode();
        }
        if (getWhenCreated() != null) {
            _hashCode += getWhenCreated().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WinOrganization.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "WinOrganization"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DSCorePropagationData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "DSCorePropagationData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distinguishedName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "distinguishedName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "instanceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "objectCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectClass");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "objectClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectGUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "objectGUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ou");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "ou"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whenChanged");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "whenChanged"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whenCreated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "whenCreated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
