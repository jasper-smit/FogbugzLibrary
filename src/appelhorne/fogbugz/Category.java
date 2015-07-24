package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public abstract class Category {
    public abstract int getCategoryNr();

    public abstract String getName();

    public abstract String getPlural();

    public abstract Status getDefaultStatus() throws FogBugzException;

    public abstract boolean isScheduleItem();

    public static List<Category> listCategories(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl) fogbugz).getCategories();
    }

    public static Category get(FogBugz fogbugz, int categoryNr) throws FogBugzException {
        for (Category category : listCategories(fogbugz)) {
            if (category.getCategoryNr() == categoryNr) return category;
        }
        return null;
    }

    public static Category getByName(FogBugz fogbugz, String name) throws FogBugzException {
        for (Category category : listCategories(fogbugz)) {
            if (category.getName().equals(name)) return category;
        }
        return null;
    }
}
