package com.wunderground.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/22/13
 * Time: 8:14 PM
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("response")
@JsonRootName("response")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @XStreamAlias("version")
    @JsonProperty("version")
    private String version;

    @XStreamAlias("termsofService")
    @JsonProperty("termsofService")
    private String termsOfService;

    @XStreamAlias("features")
    @JsonProperty("features")
    private List<Feature> features;

    @XStreamAlias("current_observation")
    @JsonProperty("current_observation")
    private CurrentObservation currentObservation;

    private Error error;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Response [currentObservation=" + currentObservation + "]";
    }
}
