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

//
//        import com.lordjoe.utilities.*;
//        import java.util.Hashtable;
//        import java.io.*;
//
//
//public class Population
//{
//    protected static Class gMyClass = (new Population()).getClass();
//
//    protected static String[]  gLastNames;
//    protected static String[]  gMaleFirstNames;
//    protected static String[]  gFemaleFirstNames;
//    protected static String[]  gInternetDomains;
//
//    public static String[] getLastNames()
//    {
//        initNames();
//        return(gLastNames);
//    }
//
//    public static String[] getMaleFirstNames()
//    {
//        initNames();
//        return(gMaleFirstNames);
//    }
//
//    public static String[] getFemaleFirstNames()
//    {
//        initNames();
//        return(gFemaleFirstNames);
//    }
//
//    public static String[] getDomainNames()
//    {
//        initNames();
//        return(gInternetDomains);
//    }
//
//    public static String chooseDomainName()
//    {
//        initNames();
//        return(DataUtil.randomString(gInternetDomains));
//    }
//
//
//    public static String chooseFirstName()
//    {
//        initNames();
//        return(chooseFirstName(Math.random() > 0.5));
//    }
//
//    public static String chooseFirstName(boolean sex)
//    {
//        if(sex)
//            return(chooseFemaleFirstName());
//        else
//            return(chooseMaleFirstName());
//    }
//
//    public static String chooseFemaleFirstName()
//    {
//        initNames();
//        return(DataUtil.randomString(gFemaleFirstNames));
//    }
//
//    public static String chooseMaleFirstName()
//    {
//        initNames();
//        return(DataUtil.randomString(gMaleFirstNames));
//    }
//
//    public static String chooseLastName()
//    {
//        initNames();
//        return(DataUtil.randomString(gLastNames));
//    }
//
//    public static String chooseName()
//    {
//        initNames();
//        return(chooseLastName() + ", " + chooseFirstName());
//    }
//
//    /**
//     @param sex - true is female
//     */
//    public static String chooseName(boolean sex)
//    {
//        String FirstName = sex ? chooseFemaleFirstName() : chooseMaleFirstName();
//        return(chooseLastName() + ", " + FirstName);
//    }
//
//    public static int chooseSSNumber()
//    {
//        int test = 0;
//        do {
//            test = (int)(Math.random() * Integer.MAX_VALUE);
//            test = test % 1000000000;
//        }
//        while(test < 99999999);
//        return(test);
//    }
//
//    public static String formatSSNum(int in)
//    {
//        String s = Integer.toString(in);
//        while(s.length() < 9)
//            s = "0" + s;
//        String ret = s.substring(0,3) + "-" + s.substring(3,5) + "-" + s.substring(5);
//        return(ret);
//    }
//
//    public static int choosePhoneNumber()
//    {
//        int[] digits = new int[7];
//        digits[0] = 2 + Util.randomInt(8); // cannot start 0 or 1
//        for(int i = 1; i < 7; i++)
//            digits[i] = Util.randomInt(10);
//        int ret = 0;
//        for(int i = 0; i < 7; i++)
//            ret = 10 * ret + digits[i];
//        return(ret);
//    }
//
//    public static String createEmailAddress(String FirstName,String LastName,String MiddleInitial)
//    {
//        return(createEmailAddress(FirstName,LastName,MiddleInitial,
//                Population.chooseDomainName()));
//    }
//
//    public static String createEmailAddress(String FirstName,String LastName,
//                                            String MiddleInitial,String domain)
//    {
//        int type = Util.randomInt(3);
//        String Name = LastName;
//        switch(type) {
//            case 0 :
//                Name = FirstName + Name;
//                break;
//            case 1 :
//                Name = FirstName.substring(0,1) + MiddleInitial +  Name;
//                break;
//            case 2 :
//                Name = FirstName + "_" +  Name;
//                break;
//        }
//        return(Name + "@" + domain);
//    }
//
//    public static String formatPhoneNumber(int in)
//    {
//        String s = Integer.toString(in);
//        String ret = s.substring(0,3) + "-" + s.substring(3);
//        return(ret);
//    }
//
//
//    protected static void initNames()
//    {
//        if(gLastNames != null)
//            return;
//        doInitNames();
//    }
//
//    protected synchronized static void doInitNames()
//    {
//        if(gLastNames != null)
//            return;
//        gFemaleFirstNames = FileUtilities.readInResourceLines(gMyClass,"FemaleFirstNames.txt");
//        DataUtil.trimStringArray(gFemaleFirstNames);
//        gMaleFirstNames   = FileUtilities.readInResourceLines(gMyClass,"MaleFirstNames.txt");
//        DataUtil.trimStringArray(gMaleFirstNames);
//        String[] LastNames        = FileUtilities.readInResourceLines(gMyClass,"LastNames.txt");
//        DataUtil.trimStringArray(LastNames);
//        gLastNames = LastNames; // make this last so other threads do not think we are done
//
//        String[] Domains        = FileUtilities.readInResourceLines(gMyClass,"Domains.txt");
//        DataUtil.trimStringArray(Domains);
//        gInternetDomains = Domains;
//        //  fixDomains();
//    }
//
//    /**
//     Code to clean up domain names from a list of addresses
//     culled from the net - used once
//
//     protected static void fixDomains()
//     {
//     try {
//     Hashtable used = new Hashtable();
//     String[] data = FileUtilities.readInResourceLines(gMyClass,"Domains1.txt");
//     PrintWriter out = new PrintWriter(new FileOutputStream("Domains.txt"));
//     for(int i = 0 ; i < data.length; i++) {
//     String outDomain = fixDomain(data[i]);
//     if(outDomain.length() > 0 && used.get(outDomain) == null) {
//     used.put(outDomain,outDomain);
//     out.println(outDomain);
//     }
//     }
//     out.close();
//     }
//     catch(IOException ex) { Assertion.fatalException(ex); }
//     }
//
//     protected static String fixDomain(String in)
//     {
//     int index = in.lastIndexOf('@');
//     if(index < 0)
//     return("");
//     String out = in.substring(index + 1);
//     if(out.endsWith(">"))
//     out = out.substring(0,out.length() - 1);
//     return(out);
//     }
//     */
//
//// end class Population
//}
