package com.wunderground.client;

import com.wunderground.model.Response;
import com.wunderground.model.Weather;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.junit.Test;

import java.io.File;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/29/13
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class WunderGroundClientTest {

    private MockRestServiceServer mockServer;

    @Autowired
    WunderGroundClient serviceClient;

    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(
                (RestTemplate) serviceClient.getRestTemplate());
    }

    @Test
    public void testReturnCorrectResponse() throws Exception {

        final String responseXml = FileUtils.readFileToString(new File("src/test/resources/SampleXMLResponse.xml"));
        Weather request = new Weather();
        request.setZipCode(94117);

        mockServer
                .expect(requestTo("http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/94117.xml"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseXml, MediaType.APPLICATION_XML));

        final ResponseEntity<Response> response = serviceClient.getXMLResponse(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_XML.getSubtype(), response
                .getHeaders().getContentType().getSubtype());
        mockServer.verify();
    }

    @After
    public void tearDown() {
        mockServer = null;
        serviceClient = null;
    }
}
