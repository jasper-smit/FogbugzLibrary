package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.ArticleHeadline;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ArticleHeadlineImpl extends ArticleHeadline {
    private String headline;
    private int articleNr;

    public ArticleHeadlineImpl(String headline, int articleNr) {
        this.headline = headline;
        this.articleNr = articleNr;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getArticleNr() {
        return articleNr;
    }

    public void setArticleNr(int articleNr) {
        this.articleNr = articleNr;
    }
}
