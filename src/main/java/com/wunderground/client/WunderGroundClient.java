package com.wunderground.client;

import com.wunderground.model.Response;
import com.wunderground.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/23/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("serviceClient")
public class WunderGroundClient implements RestServiceClient {

    /**
     * Communication Channel for weather API.
     */
    @Autowired
    private RestOperations restTemplate;

    /**
     * The base URL of the wunderground web service fetched from the property file.
     */
    @Value("#{wunderGroundClient['url.webservice.xml']}")
    private String weatherServiceXMLUrl;

    @Value("#{wunderGroundClient['url.webservice.apikey']}")
    private String weatherApiKey;

    /**
     * Returns the rest template
     *
     * @return restTemplate
     */
    public RestOperations getRestTemplate() {
        return restTemplate;
    }

    /**
     * Hits the weather service based on the Media type specified and returns the response.
     *
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<Response> getXMLResponse(Object request) {
        ResponseEntity<Response> responseEntity = null;
        Weather weather = null;

        if (request instanceof Weather) {
            weather = (Weather) request;
            List<MediaType> mediaTypes = new ArrayList<MediaType>();
            mediaTypes.add(MediaType.APPLICATION_XML);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(mediaTypes);
            HttpEntity<Weather> httpEntity = new HttpEntity<Weather>(null, headers);

            try {
                System.out.println("Hitting the Weather Service");
                responseEntity = restTemplate.exchange(weatherServiceXMLUrl, HttpMethod.GET, httpEntity,
                        Response.class, weatherApiKey, weather.getZipCode());
            } catch (RuntimeException e) {
                e.printStackTrace();
                weather.setErrorDescription("Weather Service Failed" + e.getMessage());
            }
        }
        return responseEntity;
    }
}
