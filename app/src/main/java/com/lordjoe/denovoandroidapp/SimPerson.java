package com.lordjoe.denovoandroidapp;
/**{ file
 @name Population.java
 @function Main Applet for Overlord work
 @author Steven M. Lewis
 @version 1.0
 @date Mon Mar 10 13:28:03  1997
 @copyright
  ************************
  *  Copyright (c) 1999
  *  Steven M. Lewis
  ************************

 }*/

//        import com.lordjoe.utilities.*;
//        import java.util.Hashtable;
//        import java.io.PrintStream;
//        import java.io.IOException;
//        import java.io.File;
//        import javax.swing.Icon;
//        import javax.swing.ImageIcon;
//        import java.net.URL;
//
//
//public class SimPerson
//{
//    protected static String[] gMaleIconNames;
//    protected static String[] gFemaleIconNames;
//    // Property names
//    public static final String FIRST_NAME_PROPERTY = "firstName";
//    public static final String LAST_NAME_PROPERTY  = "lastName";
//    public static final String MIDDDLE_INITIAL_PROPERTY = "middleInitial";
//    public static final String SEX_PROPERTY = "sex";
//    public static final String ZIP_CODE_PROPERTY = "zipCode";
//    public static final String LOCATION_PROPERTY = "location";
//    public static final String STREET_ADDRESS_PROPERTY = "streetAddress";
//    public static final String PHONE_NUMBER_PROPERTY = "phoneNumber";
//    public static final String EMAIL_PROPERTY = "email";
//    public static final String ICON_PROPERTY = "icon";
//
//    private String     m_FirstName;
//    private String     m_LastName;
//    private Character  m_MiddleInitial;
//    private Integer    m_SSNumber;
//    private Location   m_Location;
//    private Integer    m_ZipCode;
//    private String     m_StreetAddress;
//    private Integer    m_AreaCode;
//    private Integer    m_PhoneNumber;
//    private boolean    m_sex; // true is female
//    private String     m_email;
//    private String     m_IconName;
//    private Icon       m_Icon;
//
//    public SimPerson() {
//    }
//
//    public static SimPerson createPerson()
//    {
//        SimPerson ret = new SimPerson();
//        ret.m_sex = Math.random() > 0.5;
//        ret.m_FirstName     = Population.chooseFirstName(ret.m_sex);
//        ret.m_LastName      = Population.chooseLastName();
//        ret.m_MiddleInitial   = new Character(Population.chooseFirstName().charAt(0));
//        ret.m_PhoneNumber   = new Integer(Population.choosePhoneNumber());
//        ret.m_StreetAddress = Geography.chooseAddress();
//        ret.m_Location      = Geography.chooseLocation();
//        ret.m_AreaCode      = new Integer(ret.m_Location.chooseAreaCode());
//        ret.m_SSNumber      = new Integer(Population.chooseSSNumber());
//        ret.m_email         = createEmailAddress(ret);
//        ret.m_IconName      = chooseIconName(ret.m_sex);
//
//        return(ret);
//    }
//
//    public void write(PrintStream out)
//    {
//        out.println(m_FirstName + " " + m_MiddleInitial + ". " + m_LastName);
//        out.println(m_StreetAddress);
//        out.println(m_Location);
//        out.println( "Phone: (" + m_AreaCode + ") " + Population.formatPhoneNumber(m_PhoneNumber.intValue()));
//        out.println( "SS#: " + Population.formatSSNum(m_SSNumber.intValue()));
//    }
//
//    public String getName() { return(m_FirstName + " " + m_LastName); }
//
//    public String getFirstName() { return(m_FirstName); }
//    public void   setFirstName(String newName) {
//        m_FirstName = newName;
//    }
//
//    public String getLastName() { return(m_LastName); }
//    public void   setLastName(String newName) {
//        m_LastName = newName;
//    }
//
//    public String getStreetAddress() { return(m_LastName); }
//    public void   setStreetAddress(String newName) {
//        m_StreetAddress = newName;
//    }
//
//    public Character getMiddleInitial() { return(m_MiddleInitial); }
//    public void   setMiddleInitial(char newInit) {
//        if(m_MiddleInitial != null && newInit == m_MiddleInitial.charValue())
//            return;
//        m_MiddleInitial = new Character(newInit);
//    }
//    public Integer getSSNumber() { return(m_SSNumber); }
//    public void   setSSNumber(int newNum) {
//        if(m_SSNumber != null && newNum == m_SSNumber.intValue())
//            return;
//        m_SSNumber = new Integer(newNum);
//    }
//
//    public Location getLocation() { return(m_Location); }
//    public void   setLocation(Location newLoc) {
//        m_Location = newLoc;
//    }
//
//    public Integer getZipCode() { return(m_ZipCode); }
//    public void   setZipCode(int newNum) {
//        if(m_ZipCode != null && newNum == m_ZipCode.intValue())
//            return;
//        m_ZipCode = new Integer(newNum);
//    }
//
//    public Integer getAreaCode() { return(m_AreaCode); }
//    public void   setAreaCode(int newNum) {
//        if(m_AreaCode != null && newNum == m_AreaCode.intValue())
//            return;
//        m_AreaCode = new Integer(newNum);
//    }
//
//    public Integer getPhoneNumber() { return(m_PhoneNumber); }
//    public void   setPhoneNumber(int newNum) {
//        if(m_PhoneNumber != null && newNum == m_PhoneNumber.intValue())
//            return;
//        m_PhoneNumber = new Integer(newNum);
//    }
//
//    public String getEMail() { return(m_email); }
//    public void   setEMail(String newMail) {
//        m_email = newMail;
//    }
//    public boolean getSex() { return(m_sex); }
//
//    public Icon getIcon() {
//        if(m_Icon != null)
//            return(m_Icon);
//        if(m_IconName != null) {
//            String IconDirectory = m_sex ? "FemaleImages" : "MaleImages";
//            URL IconUrl = getClass().getResource(IconDirectory + "/" + m_IconName);
//            m_Icon = new ImageIcon(IconUrl);
//            return(m_Icon);
//        }
//        return(null); // give up
//    }
//
//    protected static String createEmailAddress(SimPerson in)
//    {
//        String domain = Population.chooseDomainName();
//        return(createEmailAddress(in,domain));
//    }
//
//    public static String createEmailAddress(SimPerson in,String domain)
//    {
//        return((String)Population.createEmailAddress(in.getFirstName(),in.getLastName(),
//                Util.toString(in.getMiddleInitial().charValue()),domain));
//    }
//
//    public static String chooseIconName(boolean sex)
//    {
//        if(gMaleIconNames == null)
//            initializeIconNames();
//        if(sex)
//            return((String)Util.randomElement(gFemaleIconNames));
//        else
//            return((String)Util.randomElement(gMaleIconNames));
//    }
//
//    protected static synchronized void initializeIconNames()
//    {
//        if(gMaleIconNames != null)
//            return; // already done
//        gMaleIconNames = readIconNames("MaleImages");
//        gFemaleIconNames = readIconNames("FemaleImages");
//    }
//
//    protected static synchronized String[] readIconNames(String DirectoryName)
//    {
//        String[] imageNames = FileUtilities.readInResourceLines(SimPerson.class,DirectoryName +  ".txt");
//        return(imageNames);
//    }
//
//// end class SimPerson
//}
//
