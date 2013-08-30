package com.wunderground.controller;

import com.wunderground.client.RestServiceClient;
import com.wunderground.model.Response;
import com.wunderground.model.Weather;
import com.wunderground.util.WeatherApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/22/13
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    RestServiceClient serviceClient;

    /**
     * Hits the API to get the weather data.
     *
     * @param weather
     * @param result
     * @return
     */
    @RequestMapping(value = "/retrieve/xml", method = RequestMethod.POST)
    public String getWeatherXML(@Valid Weather weather, BindingResult result) {
        if (result.hasErrors()) {
            return "WeatherForm";
        } else {
            ResponseEntity<Response> responseEntity = (ResponseEntity<Response>) serviceClient
                    .getXMLResponse(weather);
            Response weatherResponse = responseEntity.getBody();
            WeatherApplicationUtils.assemble(weatherResponse, weather);

            if (HttpStatus.OK != responseEntity.getStatusCode()
                    || null != weather.getErrorDescription()) {
                result.rejectValue("zipCode", "NotFound.weather.zipCode");
            }
            return "WeatherForm";
        }
    }

    /**
     * Displays the weather form rendered by the view.
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String displayWeatherForm(ModelMap model) {

        model.addAttribute("weather", new Weather());
        return "WeatherForm";
    }
}
