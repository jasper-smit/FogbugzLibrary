package appelhorne.fogbugz.util;

import appelhorne.fogbugz.FogBugzException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class Util {
    //Format 2010-03-11T07:05:26Z
    public static Date parseDate(String in) throws FogBugzException {
        if(in.trim().equals("")) return null;
        //if(true) return new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

            return sdf.parse(in);
        } catch (ParseException e) {
            throw new FogBugzException("Could not parse date " + in, e);
        }
    }
}
