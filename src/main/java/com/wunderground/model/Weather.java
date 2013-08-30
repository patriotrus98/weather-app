package com.wunderground.model;


import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/23/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Weather {

    @Digits(integer = 5, fraction = 0, message = "Zip Code must be numeric and should contain five digits")
    @Range(min = 10000, max = 99999)
    @NotNull
    private Integer zipCode;

    private String cityName;
    private String stateName;
    private String currentTempF;
    private String errorDescription;

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCurrentTempF() {
        return currentTempF;
    }

    public void setCurrentTempF(String currentTempF) {
        this.currentTempF = currentTempF;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "Weather [zipCode=" + zipCode + ", city=" + cityName + ", state="
                + stateName + ", currentTemp=" + currentTempF + "]";
    }
}
