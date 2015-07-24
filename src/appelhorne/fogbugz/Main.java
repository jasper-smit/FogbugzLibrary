package appelhorne.fogbugz;

import appelhorne.fogbugz.command.ListCategoriesCommand;
import appelhorne.fogbugz.command.ListPeopleCommand;
import appelhorne.fogbugz.command.SearchCommand;

import java.io.FileInputStream;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    static Pattern courseCode = Pattern.compile("[A-Z_\\-\\.0-9]+\\.20[01][0-9]\\-20[01][0-9][A-Z_\\-\\.0-9]*");

    public static void main(String[] args) {

        Matcher matcher = courseCode.matcher(")? (course Ontwerpen - (WNEC1ON10.2010-2011))");
        if(matcher.find()) {
            System.out.println(matcher.group());
        }

        FogBugz fb = null;
        try {
            fb = FogBugz.login("http://support.citesi.nl", "", "");

            indexCases(fb);


        } catch (FogBugzException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fb != null) {
                    fb.logoff();
                }
            } catch (FogBugzException e) {
                e.printStackTrace();
            }
        }
    }

    private static void indexCases(FogBugz fb) {

        for(int caseNr = 41440; caseNr < 41470; caseNr++) {
            try {
                System.out.println(caseNr);
            Case cs = Case.get(fb, caseNr);
                for(Event ev : cs.getEvents()) {
                    //System.out.println(ev.getText());
                    Matcher matcher = courseCode.matcher(ev.getText());
                    if(matcher.find()) {
                        System.out.println("Case " + caseNr + " course " + matcher.group());
                    }
                }

            } catch (FogBugzException e) {
                System.out.println(" Could not process case " + caseNr);
            }
        }
    }
}
