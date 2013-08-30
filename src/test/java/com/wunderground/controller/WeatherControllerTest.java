package com.wunderground.controller;

import com.wunderground.model.Weather;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.ModelAndViewAssert.assertAndReturnModelAttributeOfType;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/29/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class WeatherControllerTest {

    @Autowired
    private ApplicationContext applicationContext;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private RequestMappingHandlerAdapter handlerAdapter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
    }

    @Test
    public void testGet() throws Exception {
        request.setMethod("GET");
        request.setRequestURI("/weather");
        final ModelAndView mav = handle(request, response);
        assertAndReturnModelAttributeOfType(mav, "weather", Weather.class);
    }

    @Test
    public void testPostForCorrectZipCodeFormat() throws Exception {
        request.setMethod("POST");
        request.setRequestURI("/weather/retrieve/xml");
        request.setParameter("zipCode", "94117");
        ModelAndView mav = handle(request, response);
        Weather weather = assertAndReturnModelAttributeOfType(mav, "weather", Weather.class);
        assertEquals(new Integer(94117), weather.getZipCode());
        assertViewName(mav, "WeatherForm");
        BindingResult errors = getBindingResult(mav, "weather");
        assertTrue(null != errors.getFieldError("zipCode") ? errors
                .getFieldError("zipCode").getDefaultMessage() : "",
                !errors.hasErrors());
    }

    @Test
    public void testPostForNullZipCodeFormat() throws Exception {
        request.setMethod("POST");
        request.setRequestURI("/weather/retrieve/xml");

        final BindingResult errors = executePostRequest();
        assertTrue(errors.hasErrors());
        assertEquals("Zip Code may not be null", "may not be null", errors.getFieldError().getDefaultMessage());
    }

    @Test
    public void testPostForInvalidZipCodeFormat() throws Exception {
        request.setMethod("POST");
        request.setRequestURI("/weather/retrieve/xml");
        request.setParameter("zipCode", "abcd");

        final BindingResult errors = executePostRequest();
        assertTrue(errors.hasErrors());
        assertEquals("Invalid Zip Code format. Should be an Integer of length 5",
                "typeMismatch", errors.getFieldError("zipCode").getCode());
    }

    @Test
    public void testPostForZipCodeNotFound() throws Exception {
        request.setMethod("POST");
        request.setRequestURI("/weather/retrieve/xml");
        request.setParameter("zipCode", "11111");

        final BindingResult errors = executePostRequest();
        assertTrue(errors.hasErrors());
        assertEquals("Valid Zip Code format. Zip Code not found",
                "NotFound.weather.zipCode", errors.getFieldError("zipCode").getCode());
    }

    private BindingResult executePostRequest() throws Exception {
        final ModelAndView mav = handle(request, response);
        assertViewName(mav, "WeatherForm");
        return getBindingResult(mav, "weather");
    }

    private BindingResult getBindingResult(ModelAndView mav, String name) {
        BindingResult result = (BindingResult) mav.getModel().get(
                BindingResult.MODEL_KEY_PREFIX + name);
        assertTrue("No BindingResult for attribute: " + name, result != null);
        return result;
    }

    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        final RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(
                RequestMappingHandlerMapping.class);
        final HandlerExecutionChain handler = handlerMapping
                .getHandler(request);
        assertNotNull("No handler found for request, check you request mapping", handler);

        final Object controller = handler.getHandler();
        final HandlerInterceptor[] interceptors = handlerMapping.getHandler(
                request).getInterceptors();
        for (HandlerInterceptor interceptor : interceptors) {
            final boolean carryOn = interceptor.preHandle(request, response,
                    controller);
            if (!carryOn) {
                return null;
            }
        }
        ModelAndView mav = handlerAdapter.handle(request, response, controller);
        return mav;
    }
}
