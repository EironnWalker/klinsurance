/**
 * WinUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.jingsheng.ldap;

public class WinUser  implements java.io.Serializable {
    private String DSCorePropagationData;

    private String MDBUseDefaults;

    private String SAMAccountName;

    private String SAMAccountType;

    private String USNChanged;

    private String USNCreated;

    private String accountExpires;

    private String badPasswordTime;

    private String badPwdCount;

    private String cn;

    private String codePage;

    private String countryCode;

    private String description;

    private String displayName;

    private String distinguishedName;

    private String givenName;

    private String homeMDB;

    private String homeMTA;

    private String instanceType;

    private String lastLogoff;

    private String lastLogon;

    private String lastLogonTimestamp;

    private String legacyExchangeDN;

    private String logonHours;

    private String mail;

    private String mailNickname;

    private String msExchHomeServerName;

    private String msExchPoliciesIncluded;

    private String msExchRecipientDisplayType;

    private String msExchRecipientTypeDetails;

    private String msExchUserAccountControl;

    private String msExchUserCulture;

    private String msExchVersion;

    private String name;

    private String objectCategory;

    private String objectClass;

    private String objectGUID;

    private String primaryGroupID;

    private String proxyAddresses;

    private String pwdLastSet;

    private String showInAddressBook;

    private String sn;

    private String userAccountControl;

    private String userPrincipalName;

    private String whenChanged;

    private String whenCreated;

    public WinUser() {
    }

    public WinUser(
           String DSCorePropagationData,
           String MDBUseDefaults,
           String SAMAccountName,
           String SAMAccountType,
           String USNChanged,
           String USNCreated,
           String accountExpires,
           String badPasswordTime,
           String badPwdCount,
           String cn,
           String codePage,
           String countryCode,
           String description,
           String displayName,
           String distinguishedName,
           String givenName,
           String homeMDB,
           String homeMTA,
           String instanceType,
           String lastLogoff,
           String lastLogon,
           String lastLogonTimestamp,
           String legacyExchangeDN,
           String logonHours,
           String mail,
           String mailNickname,
           String msExchHomeServerName,
           String msExchPoliciesIncluded,
           String msExchRecipientDisplayType,
           String msExchRecipientTypeDetails,
           String msExchUserAccountControl,
           String msExchUserCulture,
           String msExchVersion,
           String name,
           String objectCategory,
           String objectClass,
           String objectGUID,
           String primaryGroupID,
           String proxyAddresses,
           String pwdLastSet,
           String showInAddressBook,
           String sn,
           String userAccountControl,
           String userPrincipalName,
           String whenChanged,
           String whenCreated) {
           this.DSCorePropagationData = DSCorePropagationData;
           this.MDBUseDefaults = MDBUseDefaults;
           this.SAMAccountName = SAMAccountName;
           this.SAMAccountType = SAMAccountType;
           this.USNChanged = USNChanged;
           this.USNCreated = USNCreated;
           this.accountExpires = accountExpires;
           this.badPasswordTime = badPasswordTime;
           this.badPwdCount = badPwdCount;
           this.cn = cn;
           this.codePage = codePage;
           this.countryCode = countryCode;
           this.description = description;
           this.displayName = displayName;
           this.distinguishedName = distinguishedName;
           this.givenName = givenName;
           this.homeMDB = homeMDB;
           this.homeMTA = homeMTA;
           this.instanceType = instanceType;
           this.lastLogoff = lastLogoff;
           this.lastLogon = lastLogon;
           this.lastLogonTimestamp = lastLogonTimestamp;
           this.legacyExchangeDN = legacyExchangeDN;
           this.logonHours = logonHours;
           this.mail = mail;
           this.mailNickname = mailNickname;
           this.msExchHomeServerName = msExchHomeServerName;
           this.msExchPoliciesIncluded = msExchPoliciesIncluded;
           this.msExchRecipientDisplayType = msExchRecipientDisplayType;
           this.msExchRecipientTypeDetails = msExchRecipientTypeDetails;
           this.msExchUserAccountControl = msExchUserAccountControl;
           this.msExchUserCulture = msExchUserCulture;
           this.msExchVersion = msExchVersion;
           this.name = name;
           this.objectCategory = objectCategory;
           this.objectClass = objectClass;
           this.objectGUID = objectGUID;
           this.primaryGroupID = primaryGroupID;
           this.proxyAddresses = proxyAddresses;
           this.pwdLastSet = pwdLastSet;
           this.showInAddressBook = showInAddressBook;
           this.sn = sn;
           this.userAccountControl = userAccountControl;
           this.userPrincipalName = userPrincipalName;
           this.whenChanged = whenChanged;
           this.whenCreated = whenCreated;
    }


    /**
     * Gets the DSCorePropagationData value for this WinUser.
     * 
     * @return DSCorePropagationData
     */
    public String getDSCorePropagationData() {
        return DSCorePropagationData;
    }


    /**
     * Sets the DSCorePropagationData value for this WinUser.
     * 
     * @param DSCorePropagationData
     */
    public void setDSCorePropagationData(String DSCorePropagationData) {
        this.DSCorePropagationData = DSCorePropagationData;
    }


    /**
     * Gets the MDBUseDefaults value for this WinUser.
     * 
     * @return MDBUseDefaults
     */
    public String getMDBUseDefaults() {
        return MDBUseDefaults;
    }


    /**
     * Sets the MDBUseDefaults value for this WinUser.
     * 
     * @param MDBUseDefaults
     */
    public void setMDBUseDefaults(String MDBUseDefaults) {
        this.MDBUseDefaults = MDBUseDefaults;
    }


    /**
     * Gets the SAMAccountName value for this WinUser.
     * 
     * @return SAMAccountName
     */
    public String getSAMAccountName() {
        return SAMAccountName;
    }


    /**
     * Sets the SAMAccountName value for this WinUser.
     * 
     * @param SAMAccountName
     */
    public void setSAMAccountName(String SAMAccountName) {
        this.SAMAccountName = SAMAccountName;
    }


    /**
     * Gets the SAMAccountType value for this WinUser.
     * 
     * @return SAMAccountType
     */
    public String getSAMAccountType() {
        return SAMAccountType;
    }


    /**
     * Sets the SAMAccountType value for this WinUser.
     * 
     * @param SAMAccountType
     */
    public void setSAMAccountType(String SAMAccountType) {
        this.SAMAccountType = SAMAccountType;
    }


    /**
     * Gets the USNChanged value for this WinUser.
     * 
     * @return USNChanged
     */
    public String getUSNChanged() {
        return USNChanged;
    }


    /**
     * Sets the USNChanged value for this WinUser.
     * 
     * @param USNChanged
     */
    public void setUSNChanged(String USNChanged) {
        this.USNChanged = USNChanged;
    }


    /**
     * Gets the USNCreated value for this WinUser.
     * 
     * @return USNCreated
     */
    public String getUSNCreated() {
        return USNCreated;
    }


    /**
     * Sets the USNCreated value for this WinUser.
     * 
     * @param USNCreated
     */
    public void setUSNCreated(String USNCreated) {
        this.USNCreated = USNCreated;
    }


    /**
     * Gets the accountExpires value for this WinUser.
     * 
     * @return accountExpires
     */
    public String getAccountExpires() {
        return accountExpires;
    }


    /**
     * Sets the accountExpires value for this WinUser.
     * 
     * @param accountExpires
     */
    public void setAccountExpires(String accountExpires) {
        this.accountExpires = accountExpires;
    }


    /**
     * Gets the badPasswordTime value for this WinUser.
     * 
     * @return badPasswordTime
     */
    public String getBadPasswordTime() {
        return badPasswordTime;
    }


    /**
     * Sets the badPasswordTime value for this WinUser.
     * 
     * @param badPasswordTime
     */
    public void setBadPasswordTime(String badPasswordTime) {
        this.badPasswordTime = badPasswordTime;
    }


    /**
     * Gets the badPwdCount value for this WinUser.
     * 
     * @return badPwdCount
     */
    public String getBadPwdCount() {
        return badPwdCount;
    }


    /**
     * Sets the badPwdCount value for this WinUser.
     * 
     * @param badPwdCount
     */
    public void setBadPwdCount(String badPwdCount) {
        this.badPwdCount = badPwdCount;
    }


    /**
     * Gets the cn value for this WinUser.
     * 
     * @return cn
     */
    public String getCn() {
        return cn;
    }


    /**
     * Sets the cn value for this WinUser.
     * 
     * @param cn
     */
    public void setCn(String cn) {
        this.cn = cn;
    }


    /**
     * Gets the codePage value for this WinUser.
     * 
     * @return codePage
     */
    public String getCodePage() {
        return codePage;
    }


    /**
     * Sets the codePage value for this WinUser.
     * 
     * @param codePage
     */
    public void setCodePage(String codePage) {
        this.codePage = codePage;
    }


    /**
     * Gets the countryCode value for this WinUser.
     * 
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this WinUser.
     * 
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the description value for this WinUser.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this WinUser.
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets the displayName value for this WinUser.
     * 
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this WinUser.
     * 
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the distinguishedName value for this WinUser.
     * 
     * @return distinguishedName
     */
    public String getDistinguishedName() {
        return distinguishedName;
    }


    /**
     * Sets the distinguishedName value for this WinUser.
     * 
     * @param distinguishedName
     */
    public void setDistinguishedName(String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }


    /**
     * Gets the givenName value for this WinUser.
     * 
     * @return givenName
     */
    public String getGivenName() {
        return givenName;
    }


    /**
     * Sets the givenName value for this WinUser.
     * 
     * @param givenName
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }


    /**
     * Gets the homeMDB value for this WinUser.
     * 
     * @return homeMDB
     */
    public String getHomeMDB() {
        return homeMDB;
    }


    /**
     * Sets the homeMDB value for this WinUser.
     * 
     * @param homeMDB
     */
    public void setHomeMDB(String homeMDB) {
        this.homeMDB = homeMDB;
    }


    /**
     * Gets the homeMTA value for this WinUser.
     * 
     * @return homeMTA
     */
    public String getHomeMTA() {
        return homeMTA;
    }


    /**
     * Sets the homeMTA value for this WinUser.
     * 
     * @param homeMTA
     */
    public void setHomeMTA(String homeMTA) {
        this.homeMTA = homeMTA;
    }


    /**
     * Gets the instanceType value for this WinUser.
     * 
     * @return instanceType
     */
    public String getInstanceType() {
        return instanceType;
    }


    /**
     * Sets the instanceType value for this WinUser.
     * 
     * @param instanceType
     */
    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }


    /**
     * Gets the lastLogoff value for this WinUser.
     * 
     * @return lastLogoff
     */
    public String getLastLogoff() {
        return lastLogoff;
    }


    /**
     * Sets the lastLogoff value for this WinUser.
     * 
     * @param lastLogoff
     */
    public void setLastLogoff(String lastLogoff) {
        this.lastLogoff = lastLogoff;
    }


    /**
     * Gets the lastLogon value for this WinUser.
     * 
     * @return lastLogon
     */
    public String getLastLogon() {
        return lastLogon;
    }


    /**
     * Sets the lastLogon value for this WinUser.
     * 
     * @param lastLogon
     */
    public void setLastLogon(String lastLogon) {
        this.lastLogon = lastLogon;
    }


    /**
     * Gets the lastLogonTimestamp value for this WinUser.
     * 
     * @return lastLogonTimestamp
     */
    public String getLastLogonTimestamp() {
        return lastLogonTimestamp;
    }


    /**
     * Sets the lastLogonTimestamp value for this WinUser.
     * 
     * @param lastLogonTimestamp
     */
    public void setLastLogonTimestamp(String lastLogonTimestamp) {
        this.lastLogonTimestamp = lastLogonTimestamp;
    }


    /**
     * Gets the legacyExchangeDN value for this WinUser.
     * 
     * @return legacyExchangeDN
     */
    public String getLegacyExchangeDN() {
        return legacyExchangeDN;
    }


    /**
     * Sets the legacyExchangeDN value for this WinUser.
     * 
     * @param legacyExchangeDN
     */
    public void setLegacyExchangeDN(String legacyExchangeDN) {
        this.legacyExchangeDN = legacyExchangeDN;
    }


    /**
     * Gets the logonHours value for this WinUser.
     * 
     * @return logonHours
     */
    public String getLogonHours() {
        return logonHours;
    }


    /**
     * Sets the logonHours value for this WinUser.
     * 
     * @param logonHours
     */
    public void setLogonHours(String logonHours) {
        this.logonHours = logonHours;
    }


    /**
     * Gets the mail value for this WinUser.
     * 
     * @return mail
     */
    public String getMail() {
        return mail;
    }


    /**
     * Sets the mail value for this WinUser.
     * 
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }


    /**
     * Gets the mailNickname value for this WinUser.
     * 
     * @return mailNickname
     */
    public String getMailNickname() {
        return mailNickname;
    }


    /**
     * Sets the mailNickname value for this WinUser.
     * 
     * @param mailNickname
     */
    public void setMailNickname(String mailNickname) {
        this.mailNickname = mailNickname;
    }


    /**
     * Gets the msExchHomeServerName value for this WinUser.
     * 
     * @return msExchHomeServerName
     */
    public String getMsExchHomeServerName() {
        return msExchHomeServerName;
    }


    /**
     * Sets the msExchHomeServerName value for this WinUser.
     * 
     * @param msExchHomeServerName
     */
    public void setMsExchHomeServerName(String msExchHomeServerName) {
        this.msExchHomeServerName = msExchHomeServerName;
    }


    /**
     * Gets the msExchPoliciesIncluded value for this WinUser.
     * 
     * @return msExchPoliciesIncluded
     */
    public String getMsExchPoliciesIncluded() {
        return msExchPoliciesIncluded;
    }


    /**
     * Sets the msExchPoliciesIncluded value for this WinUser.
     * 
     * @param msExchPoliciesIncluded
     */
    public void setMsExchPoliciesIncluded(String msExchPoliciesIncluded) {
        this.msExchPoliciesIncluded = msExchPoliciesIncluded;
    }


    /**
     * Gets the msExchRecipientDisplayType value for this WinUser.
     * 
     * @return msExchRecipientDisplayType
     */
    public String getMsExchRecipientDisplayType() {
        return msExchRecipientDisplayType;
    }


    /**
     * Sets the msExchRecipientDisplayType value for this WinUser.
     * 
     * @param msExchRecipientDisplayType
     */
    public void setMsExchRecipientDisplayType(String msExchRecipientDisplayType) {
        this.msExchRecipientDisplayType = msExchRecipientDisplayType;
    }


    /**
     * Gets the msExchRecipientTypeDetails value for this WinUser.
     * 
     * @return msExchRecipientTypeDetails
     */
    public String getMsExchRecipientTypeDetails() {
        return msExchRecipientTypeDetails;
    }


    /**
     * Sets the msExchRecipientTypeDetails value for this WinUser.
     * 
     * @param msExchRecipientTypeDetails
     */
    public void setMsExchRecipientTypeDetails(String msExchRecipientTypeDetails) {
        this.msExchRecipientTypeDetails = msExchRecipientTypeDetails;
    }


    /**
     * Gets the msExchUserAccountControl value for this WinUser.
     * 
     * @return msExchUserAccountControl
     */
    public String getMsExchUserAccountControl() {
        return msExchUserAccountControl;
    }


    /**
     * Sets the msExchUserAccountControl value for this WinUser.
     * 
     * @param msExchUserAccountControl
     */
    public void setMsExchUserAccountControl(String msExchUserAccountControl) {
        this.msExchUserAccountControl = msExchUserAccountControl;
    }


    /**
     * Gets the msExchUserCulture value for this WinUser.
     * 
     * @return msExchUserCulture
     */
    public String getMsExchUserCulture() {
        return msExchUserCulture;
    }


    /**
     * Sets the msExchUserCulture value for this WinUser.
     * 
     * @param msExchUserCulture
     */
    public void setMsExchUserCulture(String msExchUserCulture) {
        this.msExchUserCulture = msExchUserCulture;
    }


    /**
     * Gets the msExchVersion value for this WinUser.
     * 
     * @return msExchVersion
     */
    public String getMsExchVersion() {
        return msExchVersion;
    }


    /**
     * Sets the msExchVersion value for this WinUser.
     * 
     * @param msExchVersion
     */
    public void setMsExchVersion(String msExchVersion) {
        this.msExchVersion = msExchVersion;
    }


    /**
     * Gets the name value for this WinUser.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this WinUser.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the objectCategory value for this WinUser.
     * 
     * @return objectCategory
     */
    public String getObjectCategory() {
        return objectCategory;
    }


    /**
     * Sets the objectCategory value for this WinUser.
     * 
     * @param objectCategory
     */
    public void setObjectCategory(String objectCategory) {
        this.objectCategory = objectCategory;
    }


    /**
     * Gets the objectClass value for this WinUser.
     * 
     * @return objectClass
     */
    public String getObjectClass() {
        return objectClass;
    }


    /**
     * Sets the objectClass value for this WinUser.
     * 
     * @param objectClass
     */
    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }


    /**
     * Gets the objectGUID value for this WinUser.
     * 
     * @return objectGUID
     */
    public String getObjectGUID() {
        return objectGUID;
    }


    /**
     * Sets the objectGUID value for this WinUser.
     * 
     * @param objectGUID
     */
    public void setObjectGUID(String objectGUID) {
        this.objectGUID = objectGUID;
    }


    /**
     * Gets the primaryGroupID value for this WinUser.
     * 
     * @return primaryGroupID
     */
    public String getPrimaryGroupID() {
        return primaryGroupID;
    }


    /**
     * Sets the primaryGroupID value for this WinUser.
     * 
     * @param primaryGroupID
     */
    public void setPrimaryGroupID(String primaryGroupID) {
        this.primaryGroupID = primaryGroupID;
    }


    /**
     * Gets the proxyAddresses value for this WinUser.
     * 
     * @return proxyAddresses
     */
    public String getProxyAddresses() {
        return proxyAddresses;
    }


    /**
     * Sets the proxyAddresses value for this WinUser.
     * 
     * @param proxyAddresses
     */
    public void setProxyAddresses(String proxyAddresses) {
        this.proxyAddresses = proxyAddresses;
    }


    /**
     * Gets the pwdLastSet value for this WinUser.
     * 
     * @return pwdLastSet
     */
    public String getPwdLastSet() {
        return pwdLastSet;
    }


    /**
     * Sets the pwdLastSet value for this WinUser.
     * 
     * @param pwdLastSet
     */
    public void setPwdLastSet(String pwdLastSet) {
        this.pwdLastSet = pwdLastSet;
    }


    /**
     * Gets the showInAddressBook value for this WinUser.
     * 
     * @return showInAddressBook
     */
    public String getShowInAddressBook() {
        return showInAddressBook;
    }


    /**
     * Sets the showInAddressBook value for this WinUser.
     * 
     * @param showInAddressBook
     */
    public void setShowInAddressBook(String showInAddressBook) {
        this.showInAddressBook = showInAddressBook;
    }


    /**
     * Gets the sn value for this WinUser.
     * 
     * @return sn
     */
    public String getSn() {
        return sn;
    }


    /**
     * Sets the sn value for this WinUser.
     * 
     * @param sn
     */
    public void setSn(String sn) {
        this.sn = sn;
    }


    /**
     * Gets the userAccountControl value for this WinUser.
     * 
     * @return userAccountControl
     */
    public String getUserAccountControl() {
        return userAccountControl;
    }


    /**
     * Sets the userAccountControl value for this WinUser.
     * 
     * @param userAccountControl
     */
    public void setUserAccountControl(String userAccountControl) {
        this.userAccountControl = userAccountControl;
    }


    /**
     * Gets the userPrincipalName value for this WinUser.
     * 
     * @return userPrincipalName
     */
    public String getUserPrincipalName() {
        return userPrincipalName;
    }


    /**
     * Sets the userPrincipalName value for this WinUser.
     * 
     * @param userPrincipalName
     */
    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }


    /**
     * Gets the whenChanged value for this WinUser.
     * 
     * @return whenChanged
     */
    public String getWhenChanged() {
        return whenChanged;
    }


    /**
     * Sets the whenChanged value for this WinUser.
     * 
     * @param whenChanged
     */
    public void setWhenChanged(String whenChanged) {
        this.whenChanged = whenChanged;
    }


    /**
     * Gets the whenCreated value for this WinUser.
     * 
     * @return whenCreated
     */
    public String getWhenCreated() {
        return whenCreated;
    }


    /**
     * Sets the whenCreated value for this WinUser.
     * 
     * @param whenCreated
     */
    public void setWhenCreated(String whenCreated) {
        this.whenCreated = whenCreated;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof WinUser)) return false;
        WinUser other = (WinUser) obj;
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
            ((this.MDBUseDefaults==null && other.getMDBUseDefaults()==null) || 
             (this.MDBUseDefaults!=null &&
              this.MDBUseDefaults.equals(other.getMDBUseDefaults()))) &&
            ((this.SAMAccountName==null && other.getSAMAccountName()==null) || 
             (this.SAMAccountName!=null &&
              this.SAMAccountName.equals(other.getSAMAccountName()))) &&
            ((this.SAMAccountType==null && other.getSAMAccountType()==null) || 
             (this.SAMAccountType!=null &&
              this.SAMAccountType.equals(other.getSAMAccountType()))) &&
            ((this.USNChanged==null && other.getUSNChanged()==null) || 
             (this.USNChanged!=null &&
              this.USNChanged.equals(other.getUSNChanged()))) &&
            ((this.USNCreated==null && other.getUSNCreated()==null) || 
             (this.USNCreated!=null &&
              this.USNCreated.equals(other.getUSNCreated()))) &&
            ((this.accountExpires==null && other.getAccountExpires()==null) || 
             (this.accountExpires!=null &&
              this.accountExpires.equals(other.getAccountExpires()))) &&
            ((this.badPasswordTime==null && other.getBadPasswordTime()==null) || 
             (this.badPasswordTime!=null &&
              this.badPasswordTime.equals(other.getBadPasswordTime()))) &&
            ((this.badPwdCount==null && other.getBadPwdCount()==null) || 
             (this.badPwdCount!=null &&
              this.badPwdCount.equals(other.getBadPwdCount()))) &&
            ((this.cn==null && other.getCn()==null) || 
             (this.cn!=null &&
              this.cn.equals(other.getCn()))) &&
            ((this.codePage==null && other.getCodePage()==null) || 
             (this.codePage!=null &&
              this.codePage.equals(other.getCodePage()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.displayName==null && other.getDisplayName()==null) || 
             (this.displayName!=null &&
              this.displayName.equals(other.getDisplayName()))) &&
            ((this.distinguishedName==null && other.getDistinguishedName()==null) || 
             (this.distinguishedName!=null &&
              this.distinguishedName.equals(other.getDistinguishedName()))) &&
            ((this.givenName==null && other.getGivenName()==null) || 
             (this.givenName!=null &&
              this.givenName.equals(other.getGivenName()))) &&
            ((this.homeMDB==null && other.getHomeMDB()==null) || 
             (this.homeMDB!=null &&
              this.homeMDB.equals(other.getHomeMDB()))) &&
            ((this.homeMTA==null && other.getHomeMTA()==null) || 
             (this.homeMTA!=null &&
              this.homeMTA.equals(other.getHomeMTA()))) &&
            ((this.instanceType==null && other.getInstanceType()==null) || 
             (this.instanceType!=null &&
              this.instanceType.equals(other.getInstanceType()))) &&
            ((this.lastLogoff==null && other.getLastLogoff()==null) || 
             (this.lastLogoff!=null &&
              this.lastLogoff.equals(other.getLastLogoff()))) &&
            ((this.lastLogon==null && other.getLastLogon()==null) || 
             (this.lastLogon!=null &&
              this.lastLogon.equals(other.getLastLogon()))) &&
            ((this.lastLogonTimestamp==null && other.getLastLogonTimestamp()==null) || 
             (this.lastLogonTimestamp!=null &&
              this.lastLogonTimestamp.equals(other.getLastLogonTimestamp()))) &&
            ((this.legacyExchangeDN==null && other.getLegacyExchangeDN()==null) || 
             (this.legacyExchangeDN!=null &&
              this.legacyExchangeDN.equals(other.getLegacyExchangeDN()))) &&
            ((this.logonHours==null && other.getLogonHours()==null) || 
             (this.logonHours!=null &&
              this.logonHours.equals(other.getLogonHours()))) &&
            ((this.mail==null && other.getMail()==null) || 
             (this.mail!=null &&
              this.mail.equals(other.getMail()))) &&
            ((this.mailNickname==null && other.getMailNickname()==null) || 
             (this.mailNickname!=null &&
              this.mailNickname.equals(other.getMailNickname()))) &&
            ((this.msExchHomeServerName==null && other.getMsExchHomeServerName()==null) || 
             (this.msExchHomeServerName!=null &&
              this.msExchHomeServerName.equals(other.getMsExchHomeServerName()))) &&
            ((this.msExchPoliciesIncluded==null && other.getMsExchPoliciesIncluded()==null) || 
             (this.msExchPoliciesIncluded!=null &&
              this.msExchPoliciesIncluded.equals(other.getMsExchPoliciesIncluded()))) &&
            ((this.msExchRecipientDisplayType==null && other.getMsExchRecipientDisplayType()==null) || 
             (this.msExchRecipientDisplayType!=null &&
              this.msExchRecipientDisplayType.equals(other.getMsExchRecipientDisplayType()))) &&
            ((this.msExchRecipientTypeDetails==null && other.getMsExchRecipientTypeDetails()==null) || 
             (this.msExchRecipientTypeDetails!=null &&
              this.msExchRecipientTypeDetails.equals(other.getMsExchRecipientTypeDetails()))) &&
            ((this.msExchUserAccountControl==null && other.getMsExchUserAccountControl()==null) || 
             (this.msExchUserAccountControl!=null &&
              this.msExchUserAccountControl.equals(other.getMsExchUserAccountControl()))) &&
            ((this.msExchUserCulture==null && other.getMsExchUserCulture()==null) || 
             (this.msExchUserCulture!=null &&
              this.msExchUserCulture.equals(other.getMsExchUserCulture()))) &&
            ((this.msExchVersion==null && other.getMsExchVersion()==null) || 
             (this.msExchVersion!=null &&
              this.msExchVersion.equals(other.getMsExchVersion()))) &&
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
            ((this.primaryGroupID==null && other.getPrimaryGroupID()==null) || 
             (this.primaryGroupID!=null &&
              this.primaryGroupID.equals(other.getPrimaryGroupID()))) &&
            ((this.proxyAddresses==null && other.getProxyAddresses()==null) || 
             (this.proxyAddresses!=null &&
              this.proxyAddresses.equals(other.getProxyAddresses()))) &&
            ((this.pwdLastSet==null && other.getPwdLastSet()==null) || 
             (this.pwdLastSet!=null &&
              this.pwdLastSet.equals(other.getPwdLastSet()))) &&
            ((this.showInAddressBook==null && other.getShowInAddressBook()==null) || 
             (this.showInAddressBook!=null &&
              this.showInAddressBook.equals(other.getShowInAddressBook()))) &&
            ((this.sn==null && other.getSn()==null) || 
             (this.sn!=null &&
              this.sn.equals(other.getSn()))) &&
            ((this.userAccountControl==null && other.getUserAccountControl()==null) || 
             (this.userAccountControl!=null &&
              this.userAccountControl.equals(other.getUserAccountControl()))) &&
            ((this.userPrincipalName==null && other.getUserPrincipalName()==null) || 
             (this.userPrincipalName!=null &&
              this.userPrincipalName.equals(other.getUserPrincipalName()))) &&
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
        if (getMDBUseDefaults() != null) {
            _hashCode += getMDBUseDefaults().hashCode();
        }
        if (getSAMAccountName() != null) {
            _hashCode += getSAMAccountName().hashCode();
        }
        if (getSAMAccountType() != null) {
            _hashCode += getSAMAccountType().hashCode();
        }
        if (getUSNChanged() != null) {
            _hashCode += getUSNChanged().hashCode();
        }
        if (getUSNCreated() != null) {
            _hashCode += getUSNCreated().hashCode();
        }
        if (getAccountExpires() != null) {
            _hashCode += getAccountExpires().hashCode();
        }
        if (getBadPasswordTime() != null) {
            _hashCode += getBadPasswordTime().hashCode();
        }
        if (getBadPwdCount() != null) {
            _hashCode += getBadPwdCount().hashCode();
        }
        if (getCn() != null) {
            _hashCode += getCn().hashCode();
        }
        if (getCodePage() != null) {
            _hashCode += getCodePage().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDisplayName() != null) {
            _hashCode += getDisplayName().hashCode();
        }
        if (getDistinguishedName() != null) {
            _hashCode += getDistinguishedName().hashCode();
        }
        if (getGivenName() != null) {
            _hashCode += getGivenName().hashCode();
        }
        if (getHomeMDB() != null) {
            _hashCode += getHomeMDB().hashCode();
        }
        if (getHomeMTA() != null) {
            _hashCode += getHomeMTA().hashCode();
        }
        if (getInstanceType() != null) {
            _hashCode += getInstanceType().hashCode();
        }
        if (getLastLogoff() != null) {
            _hashCode += getLastLogoff().hashCode();
        }
        if (getLastLogon() != null) {
            _hashCode += getLastLogon().hashCode();
        }
        if (getLastLogonTimestamp() != null) {
            _hashCode += getLastLogonTimestamp().hashCode();
        }
        if (getLegacyExchangeDN() != null) {
            _hashCode += getLegacyExchangeDN().hashCode();
        }
        if (getLogonHours() != null) {
            _hashCode += getLogonHours().hashCode();
        }
        if (getMail() != null) {
            _hashCode += getMail().hashCode();
        }
        if (getMailNickname() != null) {
            _hashCode += getMailNickname().hashCode();
        }
        if (getMsExchHomeServerName() != null) {
            _hashCode += getMsExchHomeServerName().hashCode();
        }
        if (getMsExchPoliciesIncluded() != null) {
            _hashCode += getMsExchPoliciesIncluded().hashCode();
        }
        if (getMsExchRecipientDisplayType() != null) {
            _hashCode += getMsExchRecipientDisplayType().hashCode();
        }
        if (getMsExchRecipientTypeDetails() != null) {
            _hashCode += getMsExchRecipientTypeDetails().hashCode();
        }
        if (getMsExchUserAccountControl() != null) {
            _hashCode += getMsExchUserAccountControl().hashCode();
        }
        if (getMsExchUserCulture() != null) {
            _hashCode += getMsExchUserCulture().hashCode();
        }
        if (getMsExchVersion() != null) {
            _hashCode += getMsExchVersion().hashCode();
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
        if (getPrimaryGroupID() != null) {
            _hashCode += getPrimaryGroupID().hashCode();
        }
        if (getProxyAddresses() != null) {
            _hashCode += getProxyAddresses().hashCode();
        }
        if (getPwdLastSet() != null) {
            _hashCode += getPwdLastSet().hashCode();
        }
        if (getShowInAddressBook() != null) {
            _hashCode += getShowInAddressBook().hashCode();
        }
        if (getSn() != null) {
            _hashCode += getSn().hashCode();
        }
        if (getUserAccountControl() != null) {
            _hashCode += getUserAccountControl().hashCode();
        }
        if (getUserPrincipalName() != null) {
            _hashCode += getUserPrincipalName().hashCode();
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
        new org.apache.axis.description.TypeDesc(WinUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "WinUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DSCorePropagationData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "DSCorePropagationData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MDBUseDefaults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "MDBUseDefaults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAMAccountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "SAMAccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAMAccountType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "SAMAccountType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USNChanged");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "USNChanged"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USNCreated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "USNCreated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountExpires");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "accountExpires"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("badPasswordTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "badPasswordTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("badPwdCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "badPwdCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "cn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codePage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "codePage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "countryCode"));
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
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "displayName"));
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
        elemField.setFieldName("givenName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "givenName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homeMDB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "homeMDB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homeMTA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "homeMTA"));
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
        elemField.setFieldName("lastLogoff");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "lastLogoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastLogon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "lastLogon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastLogonTimestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "lastLogonTimestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("legacyExchangeDN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "legacyExchangeDN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logonHours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "logonHours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "mail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailNickname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "mailNickname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExchHomeServerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "msExchHomeServerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExchPoliciesIncluded");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "msExchPoliciesIncluded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExchRecipientDisplayType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "msExchRecipientDisplayType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExchRecipientTypeDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "msExchRecipientTypeDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExchUserAccountControl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "msExchUserAccountControl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExchUserCulture");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "msExchUserCulture"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExchVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "msExchVersion"));
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
        elemField.setFieldName("primaryGroupID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "primaryGroupID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proxyAddresses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "proxyAddresses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pwdLastSet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "pwdLastSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showInAddressBook");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "showInAddressBook"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "sn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userAccountControl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "userAccountControl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userPrincipalName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ldap.jingsheng.cn", "userPrincipalName"));
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
