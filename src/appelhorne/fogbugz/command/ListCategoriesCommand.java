package appelhorne.fogbugz.command;

import appelhorne.fogbugz.Category;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.impl.CategoryImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class ListCategoriesCommand extends Command {
    private List<Category> categories = new ArrayList<Category>();

    public ListCategoriesCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listCategories");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//category")) {
            CategoryImpl category = new CategoryImpl(fogbugz);
            category.setCategoryNr(nd.getInt("ixCategory"));
            category.setName(nd.getString("sCategory"));
            category.setPlural(nd.getString("sPlural"));
            category.setDefaultStatusNr(nd.getInt("ixStatusDefault"));
            category.setScheduleItem(nd.getBool("fScheduleItem"));
            categories.add(category);
        }
    }

    public List<Category> getCategories() {
        return categories;
    }
}
