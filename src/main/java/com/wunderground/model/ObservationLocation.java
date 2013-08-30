package com.wunderground.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/22/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("observation_location")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ObservationLocation {

    private String full;
    private String city;

    @XStreamAlias("state")
    @JsonProperty("state")
    private String state;

    private String country;

    @JsonProperty("country_iso3166")
    @XStreamAlias("country_iso3166")
    private String countryIso;

    private String latitude;
    private String longitude;
    private String elevation;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    @Override
    public String toString() {
        return "ObservationLocation [full=" + full + ", city=" + city
                + ", state=" + state + "]";
    }
}
