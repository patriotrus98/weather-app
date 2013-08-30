package com.wunderground.util;

import com.wunderground.model.Response;
import com.wunderground.model.Weather;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/23/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Utility Class for the weather application. All utility functions common to the application
 * goes here.
 */
public class WeatherApplicationUtils {

    /**
     * Assembles the XML response fetched from the wunderground API to the Weather model object so as to display
     * in the weather form.
     * @param weatherResponse
     * @param weather
     */
    public static void assemble(Response weatherResponse, Weather weather) {

        if (null != weatherResponse.getError()
                && null != weatherResponse.getError().getDescription()) {
            weather.setErrorDescription(weatherResponse.getError().getDescription());
        } else {
            weather.setCityName(weatherResponse.getCurrentObservation()
                    .getObservationLocation().getCity());
            weather.setStateName(weatherResponse.getCurrentObservation()
                    .getObservationLocation().getState());
            weather.setCurrentTempF(weatherResponse.getCurrentObservation()
                    .getTempF());
        }
    }
}
