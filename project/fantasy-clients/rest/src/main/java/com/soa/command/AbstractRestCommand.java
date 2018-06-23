package com.soa.command;

import com.soa.AuthContext;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("unchecked")
public abstract class AbstractRestCommand<R> {

    private final Class<R> type;

    protected AbstractRestCommand(Class<R> type) {
        this.type = type;
        this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(AuthContext.getUsername(), AuthContext.getPassword()));
    }

    protected static final String BASIC_API_URI = "http://127.0.0.1:8080/fantasy/api";

    protected RestTemplate restTemplate = new RestTemplate();

    public abstract R[] getAll();

    protected abstract String getPostfix();

    public R getById(Long id) {
        try {
            URI uri = new URI(BASIC_API_URI + getPostfix() + "/" + id);
            return restTemplate.getForObject(uri, type);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void post(R object) {
        try {
            URI uri = new URI(BASIC_API_URI + getPostfix());
            restTemplate.postForObject(uri, object, String.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
