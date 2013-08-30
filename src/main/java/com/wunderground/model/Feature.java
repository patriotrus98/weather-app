package com.wunderground.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/22/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("feature")
public class Feature {
    private String feature;

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
