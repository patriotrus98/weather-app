package com.wunderground.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/22/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("image")
public class Image {

    private String url;
    private String title;
    private String link;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
